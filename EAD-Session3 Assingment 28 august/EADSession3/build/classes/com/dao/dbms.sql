create database workplace;

CREATE TABLE employee
(
    employeeID INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50),
    emailID VARCHAR(50) NOT NULL,
    age SMALLINT NOT NULL,
    PRIMARY KEY (employeeID),
    UNIQUE (emailID)
);

select * from employee;

select * from employee WHERE firstName like '%mo%' OR lastName like '%mo%';