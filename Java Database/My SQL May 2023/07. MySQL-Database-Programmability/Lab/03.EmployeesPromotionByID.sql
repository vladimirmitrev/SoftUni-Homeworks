DELIMITER $$

CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
DECLARE count_by_id INT;
START TRANSACTION;
SET count_by_id := (
	SELECT COUNT(*) FROM `employees`
	WHERE `employee_id` = id);

UPDATE `employees`
SET `salary` = `salary` * 1.05
WHERE `employee_id` = id;
IF(count_by_id < 1) THEN
ROLLBACK;
ELSE
COMMIT;
END IF;
    
END$$

CALL usp_raise_salary_by_id(3)$$

-- CREATE PROCEDURE usp_raise_salary_by_id(id int)
-- BEGIN
-- START TRANSACTION;
-- IF((SELECT count(employee_id) FROM employees WHERE employee_id
-- like id)<>1) THEN
-- ROLLBACK;
-- ELSE
-- UPDATE employees AS e SET salary = salary + salary*0.05
-- WHERE e.employee_id = id;
-- END IF;
-- END
    