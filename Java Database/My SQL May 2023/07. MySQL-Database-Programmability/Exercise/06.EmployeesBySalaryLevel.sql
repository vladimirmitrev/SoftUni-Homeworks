DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(10))
BEGIN
    SELECT `first_name`, `last_name` FROM `employees`
        WHERE ufn_get_salary_level(`salary`) = salary_level
    ORDER BY `first_name` DESC, `last_name` DESC;
END$$

set @salary_level = 'High';
call usp_get_employees_by_salary_level(@salary_level);