#Question 3
#1
#Display Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT o.orderID, o.orderPlacingDate, SUM(p.price * opr.numberOfProduct) AS orderTotal
FROM orders AS o
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
GROUP BY o.orderID
ORDER BY o.orderPlacingDate DESC
LIMIT 50;

#2
#Display 10 most expensive Orders.
SELECT o.orderID, o.orderPlacingDate, SUM(p.price * opr.numberOfProduct) AS orderTotal
FROM orders AS o
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
GROUP BY o.orderID
ORDER BY orderTotal DESC
LIMIT 10;

#3
#Display all the Orders which are placed more than 10 days old and 
#one or more items from those orders are still not shipped.
SELECT o.orderID, opr.productID
FROM orders AS o
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
WHERE o.orderPlacingDate < DATE_SUB(CURDATE(), INTERVAL 10 DAY) 
AND opr.status NOT IN ('shipped', 'delivered');

#4
#Display list of shoppers which haven't ordered anything since last month.
SELECT userName
FROM user
WHERE type <> 'administrator' AND userID NOT IN (
                                                    SELECT userID
                                                    FROM orders
                                                    WHERE orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 1 MONTH)
                                                );
#5
#Display list of shopper along with orders placed by them in last 15 days.
SELECT u.userID, u.userName, o.orderID, p.productName, opr.numberOfProduct
FROM orders AS o
LEFT JOIN user AS u On o.userID = u.userID
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 15 DAY);

#6
#Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
SELECT p.productName, opr.numberOfProduct
FROM product AS p
LEFT JOIN orderProductRelationship AS opr ON p.productID = opr.productID
WHERE opr.orderID IN (1020) AND opr.status = 'shipped';

#7
#Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
SELECT p.productName, opr.numberOfProduct, o.orderID, o.orderPlacingDate, p.price
FROM product as p
LEFT JOIN orderProductRelationship AS opr ON p.productID = opr.productID
LEFT JOIN orders AS o ON opr.orderID = o.orderID
WHERE p.price BETWEEN 20 AND 50;

#8
#Update first 20 Order items status to “Shipped” which are placed today.
UPDATE orderProductRelationship AS opr
left join orders as o ON opr.orderID = o.orderID
SET status = 'shipped'
WHERE o.orderPlacingDate = CURDATE();
