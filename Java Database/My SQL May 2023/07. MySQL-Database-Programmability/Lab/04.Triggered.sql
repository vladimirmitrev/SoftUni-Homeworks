DELIMITER $$

CREATE TABLE deleted_employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50) NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    department_id VARCHAR(50) NOT NULL,
    salary DECIMAL(19,4) NOT NULL
)$$

CREATE TRIGGER tr_deleted_employees
AFTER DELETE
ON `employees`
FOR EACH ROW
BEGIN
	INSERT INTO `deleted_employees`(
    `first_name`,
    `last_name`,
    `middle_name`,
    `job_title`,
    `department_id`,
    `salary`)
    VALUES (
    OLD.`first_name`,
    OLD.`last_name`,
    OLD.`middle_name`,
    OLD.`job_title`,
    OLD.`department_id`,
    OLD.`salary`);
    
END$$

DELETE FROM `employees`
WHERE `employee_id` = 2$$

