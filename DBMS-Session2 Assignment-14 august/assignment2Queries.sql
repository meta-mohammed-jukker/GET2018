#Question 2
#1
#Insert sample data in StoreFront tables by using SQL files.
SOURCE C:/Users/Mohammed/Desktop/DBMS/insertValues.sql;

#2
#Display Id, Title, Category Title, Price of the products which are Active and 
#recently added products should be at top.
select * from product;

SELECT p.productID, p.productName, c.categoryName, p.price
FROM product AS p
LEFT JOIN categoryProductRelationship AS cpr ON p.productID = cpr.productID
LEFT JOIN category AS c ON cpr.categoryID = c.categoryID
WHERE p.productState = 'Active'
ORDER BY p.productID DESC;

#3
#Display the list of products which don't have any images.
SELECT p.productID, p.productName, p.details, p.rating, p.price, p.stock
FROM product AS p
WHERE p.productID NOT IN (
                          SELECT productID
                          FROM productImage
                          );
                          
#4
#Display all Id, Title and Parent Category Title for all the Categories listed, 
#sorted by Parent Category Title and then Category Title. 
#(If Category is top category then Parent Category Title column should display “Top Category” as value.)
SELECT c.categoryID, c.categoryName,
IFNULL(pc.categoryName, 'Top Category') AS parentCategoryName
FROM category AS c
LEFT JOIN category AS pc
ON c.parentCategoryId = pc.categoryID
ORDER BY parentCategoryName, categoryID;

#5
#Display Id, Title, Parent Category Title of all the leaf Categories 
#(categories which are not parent of any other category)
SELECT c.categoryID, c.categoryName, p.categoryName
FROM category AS c
LEFT JOIN category AS P ON c.parentCategoryID = P.categoryID
WHERE c.categoryID NOT IN (
                            SELECT parentCategoryID 
                            FROM category 
                            WHERE parentCategoryID IS NOT NULL
                          );

#6
#Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
SELECT p.productName, p.details, p.price
FROM product AS p
WHERE p.productID IN (
                      SELECT pcr.productID
                      FROM categoryProductRelationship AS pcr
                      INNER JOIN category AS c
                      ON pcr.categoryID = c.categoryID
                      WHERE c.categoryName = 'mobiles'
                     );
                     
#7
#Display the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT productName
FROM product
Where stock < 50;

#8
#Increase the Inventory of all the products by 100.
UPDATE product
SET stock = stock + 100;

SELECT * 
FROM product;
