CREATE DATABASE storeFront;
USE storeFront;

#Question 1
#Part 1
CREATE TABLE user
(
    userID INT NOT NULL AUTO_INCREMENT,
    emailID VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    userName VARCHAR(50) NOT NULL,
    gender CHAR(1),
    type CHAR(15) NOT NULL,
    dateOfBirth DATE NOT NULL,
    PRIMARY KEY (userID),
    UNIQUE (emailID)
);

CREATE TABLE userAddress
(
    userID INT NOT NULL,
    street VARCHAR(50),
    city VARCHAR(50),
    state VARCHAR(50),
    pincode INT,
    FOREIGN KEY (userID)
    REFERENCES user(userID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE userContactNumber
(
    userID INT NOT NULL,
    contactNumber VARCHAR(15) NOT NULL,
    contactType CHAR(10) NOT NULL,
    FOREIGN KEY (userID)
    REFERENCES user(userID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE product
(
    productID INT NOT NULL AUTO_INCREMENT,
    productName VARCHAR(50) NOT NULL,
    details VARCHAR(100),
    rating FLOAT,
    price FLOAT,
    stock INT,
    PRIMARY KEY (productID)
);

CREATE TABLE productImage
(
    imageID INT NOT NULL AUTO_INCREMENT,
    productID INT NOT NULL,
    imageLocation VARCHAR(50) NOT NULL,
    alternateName VARCHAR(50),
    PRIMARY KEY (imageID),
    FOREIGN KEY (productID)
    REFERENCES product(productID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE category
(
    categoryID INT NOT NULL AUTO_INCREMENT,
    categoryName VARCHAR(50) NOT NULL,
    details VARCHAR(100),
    parentCategoryID INT,
    PRIMARY KEY (categoryID),
    FOREIGN KEY (parentCategoryID)
    REFERENCES category(categoryID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE categoryProductRelationship
(
    categoryID INT NOT NULL,
    productID INT NOT NULL,
    FOREIGN KEY (categoryID)
    REFERENCES category(categoryID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    FOREIGN KEY (productID)
    REFERENCES product(productID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE orders
(
    orderID INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    orderPlacingDate DATE NOT NULL,
    totalNumberOfProductsOrdered INT NOT NULL,
    overallStatus CHAR(50) NOT NULL,
    PRIMARY KEY (orderID),
    FOREIGN KEY (userID)
    REFERENCES user(userID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE orderProductRelationship
(
    orderID INT NOT NULL,
    productID INT NOT NULL, 
    numberOfProduct INT NOT NULL,
    status CHAR(50) NOT NULL,
    FOREIGN KEY (orderID)
    REFERENCES orders(orderID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    FOREIGN KEY (productID)
    REFERENCES product(productID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

#Part 2

DROP TABLE productImage;
DROP TABLE categoryProductRelationship;
DROP TABLE orderProductRelationship;
DROP TABLE product;

SHOW TABLES;

#Part 3

CREATE TABLE product
(
    productID INT NOT NULL AUTO_INCREMENT,
    productName VARCHAR(50) NOT NULL,
    details VARCHAR(100),
    rating FLOAT,
    price FLOAT,
    stock INT,
    PRIMARY KEY (productID)
);

CREATE TABLE productImage
(
    imageID INT NOT NULL AUTO_INCREMENT,
    productID INT NOT NULL,
    imageLocation VARCHAR(50) NOT NULL,
    alternateName VARCHAR(50),
    PRIMARY KEY (imageID),
    FOREIGN KEY (productID)
    REFERENCES product(productID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE categoryProductRelationship
(
    categoryID INT NOT NULL,
    productID INT NOT NULL,
    FOREIGN KEY (categoryID)
    REFERENCES category(categoryID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    FOREIGN KEY (productID)
    REFERENCES product(productID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE orderProductRelationship
(
    orderID INT NOT NULL,
    productID INT NOT NULL, 
    numberOfProduct INT NOT NULL,
    status CHAR(50) NOT NULL,
    FOREIGN KEY (orderID)
    REFERENCES orders(orderID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    FOREIGN KEY (productID)
    REFERENCES product(productID)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

SHOW TABLES;