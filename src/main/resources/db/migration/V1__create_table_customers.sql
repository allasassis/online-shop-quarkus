CREATE TABLE IF NOT EXISTS customers (

       id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       email VARCHAR(255),
       birthdate DATE,
       street VARCHAR(255),
       number INT,
       city VARCHAR(255),
       state VARCHAR(255),
       zipCode INT,
       country VARCHAR(255)

);