create database gamebar;
use gamebar;

create table employees(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(47) NOT NULL,
last_name VARCHAR(47) NOT NULL
);

create table categories(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(47) NOT NULL
);

create table products(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(47) NOT NULL,
category_id INT NOT NULL
);