DROP DATABASE IF EXISTS customer;
CREATE DATABASE customer;
USE customer;

CREATE TABLE customer(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(45),
last_name VARCHAR(45)
);

INSERT INTO customer
VALUES
(1,"Nguyen","A"),
(2,"Nguyen","B"),
(3,"Nguyen","C");

DELIMITER //
CREATE PROCEDURE Insert_Customer(IN first_name VARCHAR(255), IN last_name VARCHAR(255))
BEGIN
    INSERT INTO customer(first_Name,last_Name) VALUES (first_name,last_name);
END//
DELIMITER ;

CALL Insert_Customer("Nguyen","A");