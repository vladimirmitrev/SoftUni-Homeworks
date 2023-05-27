DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
   SELECT CONCAT(`first_name`, ' ', `last_name`) AS 'full_name'
   FROM `account_holders`
       ORDER BY `first_name`, `last_name`;
END$$

call usp_get_holders_full_name();