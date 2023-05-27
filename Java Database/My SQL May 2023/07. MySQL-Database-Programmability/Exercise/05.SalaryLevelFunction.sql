DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary_to_check DECIMAL (19,4))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
    DECLARE salary_level VARCHAR(10);
    IF salary_to_check < 30000 THEN SET salary_level := 'Low';
        ELSEIF salary_to_check <= 50000 THEN SET salary_level := 'Average';
        ELSE SET salary_level := 'High';
        END IF;
    RETURN salary_level;
END$$

set @salary_to_check = 43300.00;
select ufn_get_salary_level(@salary_to_check);