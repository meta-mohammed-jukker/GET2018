#Question 3
#1
SELECT o.orderID, o.orderPlacingDate, SUM(p.price * opr.numberOfProduct) AS orderTotal
FROM orders AS o
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
GROUP BY o.orderID
ORDER BY o.orderPlacingDate DESC
LIMIT 50;

#2
SELECT o.orderID, o.orderPlacingDate, SUM(p.price * opr.numberOfProduct) AS orderTotal
FROM orders AS o
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
GROUP BY o.orderID
ORDER BY orderTotal DESC
LIMIT 10;

#3
SELECT o.orderID, opr.productID
FROM orders AS o
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
WHERE o.orderPlacingDate < DATE_SUB(CURDATE(), INTERVAL 10 DAY) AND opr.status NOT IN ('shipped', 'delivered');

#4
SELECT userName
FROM orders AS o
LEFT JOIN user AS u On o.userID = u.userID
WHERE o.orderPlacingDate < DATE_SUB(CURDATE(), INTERVAL 1 MONTH);

#5
SELECT u.userID, u.userName, o.orderID, p.productName, opr.numberOfProduct
FROM orders AS o
LEFT JOIN user AS u On o.userID = u.userID
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 15 DAY);

#6
SELECT p.productName, opr.numberOfProduct
FROM product AS p
LEFT JOIN orderProductRelationship AS opr ON p.productID = opr.productID
WHERE opr.orderID IN (1020) AND opr.status = 'shipped';

#7
SELECT p.productName, opr.numberOfProduct, o.orderID, o.orderPlacingDate, p.price
FROM product as p
LEFT JOIN orderProductRelationship AS opr ON p.productID = opr.productID
LEFT JOIN orders AS o ON opr.orderID = o.orderID
WHERE p.price BETWEEN 20 AND 50;

#8
UPDATE orderProductRelationship AS opr
left join orders as o ON opr.orderID = o.orderID
SET status = 'shipped'
WHERE o.orderPlacingDate = CURDATE() 
limit 10;