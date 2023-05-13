CREATE DATABASE soft_uni;
use soft_uni;

CREATE TABLE towns (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(47) NOT NULL
);

CREATE TABLE departments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(47) NOT NULL
);

 CREATE TABLE addresses(
 id INT PRIMARY KEY AUTO_INCREMENT,
 address_text VARCHAR(50) NOT NULL,
 town_id INT,
 CONSTRAINT fk_addresses_towns
 FOREIGN KEY (town_id)
 REFERENCES towns(id)
 ); 
 
 CREATE TABLE employees(
  id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(47) NOT NULL,
    middle_name VARCHAR(47) NOT NULL,
    last_name VARCHAR(47) NOT NULL,
    job_title VARCHAR(47) NOT NULL,
    department_id INT NOT NULL,
    hire_date DATE NOT NULL,
    salary DOUBLE (10, 2) NOT NULL,
    address_id INT,
    CONSTRAINT fk_employees_departments
    FOREIGN KEY (department_id)
	REFERENCES departments(id),
    CONSTRAINT fk_employees_addresses
    FOREIGN KEY (address_id)
	REFERENCES addresses(id)
 );
 
 
INSERT INTO towns(`name`)
values
 ("Sofia"), 
 ("Plovdiv"), 
 ("Varna"), 
 ("Burgas");
 
 INSERT INTO addresses (address_text)
 values
 ("Sofia 1000"),
 ("Lovech 65"),
 ("Sliven 34");


INSERT INTO departments(`name`)
values
 ("Engineering"), 
 ("Sales"), 
 ("Marketing"), 
 ("Software Development"),
 ("Quality Assurance");
 
 INSERT INTO employees(first_name,middle_name, last_name,job_title,department_id,hire_date,salary )
 VALUES
 ("Ivan", "Ivanov", "Ivanov", ".NET Developer", 4, "2013/02/01", 3500.00),
 ("Petar", "Petrov", "Petrov", "Senior Engineer", 1, "2004/03/02", 4000.00),
 ("Maria", "Petrova", "Ivanova", "Intern", 5, "2016/08/28", 525.25),
 ("Georgi", "Terziev", "Ivanov", "CEO", 2, "2007/12/09", 3000.00),
 ("Peter", "Pan", "Pan", "Intern", 3, "2016/08/28", 599.88);
 

 -- SELECT NAME FROM towns;
--  SELECT NAME FROM departments;
--  SELECT first_name, middle_name, last_name, job_title, department_id, hire_date, salary FROM employees;

-- SELECT * FROM towns;
-- SELECT * FROM addresses;
-- SELECT * FROM departments;
-- SELECT * FROM employees;

 -- DROP TABLE towns;
--  DROP TABLE addresses;
--  DROP TABLE departments;
--  DROP TABLE employees;

 
 
 
 