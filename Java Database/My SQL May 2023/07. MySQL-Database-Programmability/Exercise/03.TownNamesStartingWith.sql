DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(word_to_start_with VARCHAR(50))
BEGIN
    SELECT `name` FROM `towns`
    WHERE `name` LIKE CONCAT(word_to_start_with,'%')
    ORDER BY  `name`;
END$$

set @word_to_start_with = 'Sofia';
call usp_get_towns_starting_with(@word_to_start_with);
