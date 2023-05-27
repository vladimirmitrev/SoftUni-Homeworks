DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_to_search VARCHAR(50))
BEGIN
    SELECT `first_name`, `last_name` FROM `employees` AS e
        JOIN `addresses` AS a USING (`address_id`)
        JOIN `towns` AS t USING (`town_id`)
        WHERE t.`name` = town_to_search
    ORDER BY `first_name`, `last_name`, `employee_id`;
END$$

set @town_to_search = 'Sofia';
call usp_get_employees_from_town(@town_to_search);