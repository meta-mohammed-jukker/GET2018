#Question 2
#1
SOURCE C:/Users/Mohammed/Desktop/DBMS/insertValues.sql;

#2
select * from product;

SELECT p.productID, p.productName, cpr.categoryID, p.price
FROM product AS p, categoryProductRelationship AS cpr
WHERE p.productID = cpr.productID AND p.stock > 0 AND p.stock IS NOT NULL
ORDER BY productID DESC;

#3
SELECT p.productID, p.productName, p.details, p.rating, p.price, p.stock
FROM product AS p
WHERE p.productID NOT IN (
                          SELECT productID
                          FROM productImage
                          );
                          
#4
SELECT c.categoryID, c.categoryName,
IFNULL(pc.categoryName, 'Top Category') AS parentCategoryName
FROM category AS c
LEFT JOIN category AS pc
ON c.parentCategoryId = pc.categoryID;

#5
SELECT c.categoryID, c.categoryName
FROM category AS c
WHERE c.categoryID NOT IN (
                            SELECT parentCategoryID 
                            FROM category 
                            WHERE parentCategoryID IS NOT NULL
                          );

#6
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
SELECT productName
FROM product
Where stock < 50;

#8
UPDATE product
SET stock = stock + 100;

SELECT * 
FROM product;
