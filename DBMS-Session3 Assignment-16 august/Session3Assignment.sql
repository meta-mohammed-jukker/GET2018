#Question 2
#1
#Display the list of products (Id, Title, Count of Categories) 
#which fall in more than one Categories.
SELECT p.productID, p.productName, COUNT(cpr.productID) AS categoryCount
FROM product AS p
LEFT JOIN categoryProductRelationship AS cpr ON p.productID = cpr.productID 
GROUP BY cpr.productID
HAVING COUNT(cpr.productID) > 1;

#2
#Display Count of products as per price range
SELECT pr.priceRange,COUNT(*) AS ProductCount 
FROM(SELECT CASE
       WHEN price>0 AND price<100 THEN '0-100'
       WHEN price>100 AND price<500 THEN '100-500'
       ELSE 'Above 500' END AS priceRange
   FROM product) pr
GROUP BY pr.priceRange;

#3
#Display the Categories along with number of products under each category
SELECT c.categoryName, COUNT(*) AS productCount
FROM category AS c
LEFT JOIN categoryProductRelationship AS cpr ON c.categoryID = cpr.categoryID 
GROUP BY cpr.categoryID;

#Question 3
#1
#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT u.userID, u.userName, u.emailID, u.dateOfBirth, COUNT(o.userID) AS orderCount
FROM user AS u
LEFT JOIN orders AS o ON u.userID = o.userID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 30 DAY) 
GROUP BY o.userID;

#2
#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.userID, u.userName, u.emailID, SUM(p.price * opr.numberOfProduct) AS orderTotal
FROM user AS u
LEFT JOIN orders AS o ON u.userID = o.userID
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 30 DAY) 
GROUP BY u.userID
ORDER BY orderTotal DESC
LIMIT 10;

#3
#Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT p.productName, SUM(opr.numberOfProduct) AS productCount
FROM product as p
LEFT JOIN orderProductRelationship AS opr ON p.productID = opr.productID
LEFT JOIN orders AS o ON opr.orderID = o.orderID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 60 DAY) 
GROUP BY p.productID
ORDER BY productCount DESC
LIMIT 20;

#4
#Display Monthly sales revenue of the StoreFront for last 6 months. 
#It should display each month’s sale.
SELECT MONTHNAME(o.orderPlacingDate) AS monthName, SUM(p.price * opr.numberOfProduct) AS orderTotal
FROM orders AS o
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 6 MONTH) 
GROUP BY MONTH(o.orderPlacingDate);

#5
#Mark the products as Inactive which are not ordered in last 90 days.
ALTER TABLE product
ADD productState CHAR(10) DEFAULT 'Active'
AFTER details;

UPDATE product AS p
SET p.productState = "Active";

UPDATE product AS p
LEFT JOIN orderProductRelationship AS opr ON p.productID = opr.productID
LEFT JOIN orders AS o ON opr.orderID = o.orderID
SET p.productState = "Inactive"
WHERE o.orderPlacingDate < DATE_SUB(CURDATE(), INTERVAL 90 DAY)
AND p.productID Not IN(
                        SELECT productID
                        FROM orderProductRelationship AS opr
                        LEFT JOIN orders AS o ON opr.orderID = o.orderID
                        WHERE o.orderPlacingDate >= DATE_SUB(CURDATE(), INTERVAL 90 DAY)
                       );
                       
#6
#Given a category search keyword, display all the Products present in this category/categories. 
SELECT p.productName
FROM product AS p
LEFT JOIN categoryProductRelationship AS cpr ON p.productID = cpr.productID
LEFT JOIN category AS c ON cpr.categoryID = c.categoryID
WHERE c.categoryName IN ('electronics');

#7
#Display top 10 Items which were cancelled most.
SELECT productID, COUNT(*) AS canceledCount
FROM orderProductRelationship
WHERE status = 'canceled'
GROUP BY productID
ORDER BY canceledCount DESC
LIMIT 10;

#Question 4
#Create appropriate tables and relationships for the same and write a SQL
#query for that returns a Resultset containing Zip Code, City Names and
#States ordered by State Name and City Name.
CREATE TABLE zipcode
(
    zipcode INT NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    PRIMARY KEY(zipcode)
);

INSERT INTO zipcode VALUES
(313001, 'Udaipur', 'Rajasthan'),
(302019, 'Jaipur', 'Rajasthan'),
(302020, 'Jaipur', 'Rajasthan'), 
(302021, 'Jaipur', 'Rajasthan');

SELECT zipcode, city, state
FROM zipcode
ORDER BY state, city;

#Question 5
#1
#Create a view displaying the order information 
#(Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
#with latest ordered items should be displayed first for last 60 days.
CREATE VIEW orderInformation
AS
SELECT o.orderID, p.productID, p.productName, opr.numberOfProduct, p.price, 
       u.userName, u.emailID, o.orderPlacingDate, opr.status
FROM orders AS o
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
LEFT JOIN user AS u ON o.userID = u.userID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 60 DAY)
ORDER BY o.orderPlacingDate DESC;

SELECT * FROM orderInformation;

#2
#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT DISTINCT productName
FROM orderInformation
WHERE status = 'shipped';

#3
#Use the above view to display the top 5 most selling products.
Select productName, SUM(numberOfProduct) AS productSold
FROM orderInformation
GROUP BY productID
ORDER BY productSold DESC
LIMIT 5;
