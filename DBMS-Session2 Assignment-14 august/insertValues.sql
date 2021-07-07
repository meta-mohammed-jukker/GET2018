INSERT INTO user(emailID, password, userName, gender, type, dateOfBirth) 
VALUES ('mohammed.jukker@storefront.com', 'mohammed', 'Mohammed Jukker', 'm', 'administrator', '2018-08-14');
INSERT INTO user(emailID, password, userName, gender, type, dateOfBirth) 
VALUES ('joseph.john@storefront.com', 'joseph', 'Joseph John', 'm', 'shopper', '2018-08-15');


INSERT INTO userAddress(userID, street, city, state, pincode)
VALUES(1, 'Chetak Road', 'Udaipur', 'Rajasthan', 313001);
INSERT INTO userAddress(userID, street, city, state, pincode)
VALUES(2, 'Vikas Street', 'Jaipur', 'Rajasthan', 313001);

INSERT INTO userContactNumber(userID, contactNumber, contactType)
VALUES(1, '9985645645', 'mobile');
INSERT INTO userContactNumber(userID, contactNumber, contactType)
VALUES(1, '0294-2453384', 'landline');
INSERT INTO userContactNumber(userID, contactNumber, contactType)
VALUES(1, '8534535733', 'mobile');
INSERT INTO userContactNumber(userID, contactNumber, contactType)
VALUES(2, '8105545196', 'mobile');

INSERT INTO product(productName, details, rating, price, stock)
VALUES('Moto G5 S Plus', 'mobile phone', 5.0, 13000.00, 100);
INSERT INTO product(productName, details, rating, price, stock)
VALUES('Fridge', 'electronic', 3.0, 23420.00, 10);

INSERT INTO productImage(productID, imageLocation, alternateName)
VALUES(1, 'C:\Users\Mohammed\Pictures\motoG5SPlus.jpg', 'moto image');

INSERT INTO category(categoryName, details, parentCategoryID)
VALUES('electronics', 'includes all electronics', NULL);
INSERT INTO category(categoryName, details, parentCategoryID)
VALUES('mobiles', 'includes all mobiles', 1);

INSERT INTO categoryProductRelationship(categoryID, productID)
VALUES(2, 1);
INSERT INTO categoryProductRelationship(categoryID, productID)
VALUES(1, 1);
INSERT INTO categoryProductRelationship(categoryID, productID)
VALUES(1, 2);

INSERT INTO orders(userID, orderPlacingDate, totalNumberOfProductsOrdered, overallStatus)
VALUES(2, '2018-08-15', 2, 'not delivered');
INSERT INTO orders(userID, orderPlacingDate, totalNumberOfProductsOrdered, overallStatus)
VALUES(2, '2018-08-16', 3, 'not delivered');

INSERT INTO orderProductRelationship(orderID, productID, numberOfProduct, status)
VALUES(1, 1, 2, 'not delivered');
INSERT INTO orderProductRelationship(orderID, productID, numberOfProduct, status)
VALUES(2, 2, 2, 'not delivered');
INSERT INTO orderProductRelationship(orderID, productID, numberOfProduct, status)
VALUES(2, 1, 1, 'not delivered');
