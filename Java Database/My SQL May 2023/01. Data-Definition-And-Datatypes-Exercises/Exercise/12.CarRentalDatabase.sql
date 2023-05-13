create database car_rental;
use car_rental;

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(20) NOT NULL,
    daily_rate DOUBLE(10 , 2 ) NOT NULL,
    weekly_rate DOUBLE(10 , 2 ),
    monthly_rate DOUBLE(10 , 2 ),
    weekend_rate DOUBLE(10 , 2 )
);

INSERT INTO categories(category, daily_rate) 
VALUES
("car", 15.5),
("van", 22.5),
("truck", 33.5);

CREATE TABLE cars (
    id INT PRIMARY KEY AUTO_INCREMENT,
    plate_number VARCHAR(20) NOT NULL,
    make VARCHAR(20) NOT NULL,
    model VARCHAR(20) NOT NULL,
    car_year YEAR,
    category_id INT,
    doors INT,
    picture BLOB,
    car_condition VARCHAR(20),
    available boolean NOT NULL
--     FOREIGN KEY (category_id)
-- 	REFERENCES categories(id)
);

INSERT INTO cars(plate_number, make, model, available)
VALUES
("E 4114 MK", "Porsche", "Cayenne", true),
("CB 4848 TC", "Mercedes", "E550", false),
("B 0555 CH", "Hummer", "H3", true);


CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(47) NOT NULL,
    last_name VARCHAR(47) NOT NULL,
    title VARCHAR(47) NOT NULL,
    notes TEXT
);

INSERT INTO employees (first_name, last_name, title)
VALUES
("George", "Ivanov", "director"),
("Ivan", "Borisov", "salesman"),
("Maria", "Jivkova", "driver");


CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    driver_licence_number INT NOT NULL,
    full_name VARCHAR(47) NOT NULL,
    address VARCHAR(47) NOT NULL,
    city VARCHAR(47) NOT NULL,
    zip_code INT NOT NULL,
    notes TEXT
);

INSERT INTO customers(driver_licence_number,full_name,address,city,zip_code)
VALUES
(612361373, "Boris Mitrev", "Vitosha 5", "Sofia", 1000),
(665786788, "Vasil Mahleliev", "Elenovo 67", "Blagoevgrad", 2700),
(699334533, "Petya Ivanova", "Pirin 7", "Plovdiv", 4000);


CREATE TABLE rental_orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    customer_id INT,
    car_id INT,
    car_condition VARCHAR(20) NOT NULL,
    tank_level VARCHAR(30) NOT NULL,
    kilometrage_start INT NOT NULL,
    kilometrage_end INT NOT NULL,
    total_kilometrage INT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    total_days INT,
    rate_applied DOUBLE(10 , 2 ) NOT NULL,
    tax_rate DOUBLE(10 , 2 ),
    order_status VARCHAR(20),
    notes TEXT
    -- FOREIGN KEY (employee_id)
-- 	REFERENCES employees(id),
--     FOREIGN KEY (customer_id)
-- 	REFERENCES customers(id),
-- 	FOREIGN KEY (car_id)
-- 	REFERENCES cars(id) 
);

INSERT INTO rental_orders(car_condition,tank_level,kilometrage_start,kilometrage_end, start_date,end_date, rate_applied ) 
VALUES
("great", "full", 43000,50000, "2022-12-22 00:00:00", "2022-12-27 10:00:00", 22.5),
("mint", "half", 190000,210000, "2023-03-02 09:00:00", "2023-03-27 16:00:00", 12.5),
("bad", "empty", 400000,410000, "2023-05-01 12:00:00", "2023-05-11 22:00:00", 6.5);



SELECT * FROM categories;
DROP TABLE categories;

SELECT * FROM cars;
DROP TABLE cars;

SELECT * FROM employees;
DROP TABLE employees;

SELECT * FROM customers;
DROP TABLE customers;

SELECT * FROM rental_orders;
DROP TABLE rental_orders;





