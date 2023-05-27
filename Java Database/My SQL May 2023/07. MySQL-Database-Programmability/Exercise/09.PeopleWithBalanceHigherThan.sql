DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(total_money DECIMAL(19,4))
BEGIN
    SELECT `first_name`, `last_name` FROM `account_holders` AS ah
        JOIN `accounts` AS a ON ah.`id` = a.`account_holder_id`
    GROUP BY ah.`id`
    HAVING SUM(`balance`) > total_money
    ORDER BY ah.`id`;
END$$

# DELIMITER $$
# CREATE PROCEDURE usp_get_holders_with_balance_higher_than(total_money DECIMAL(19,4))
# BEGIN
#     SELECT `first_name`, `last_name` FROM `account_holders` AS ah
#         LEFT JOIN `accounts` AS a ON ah.`id` = a.`account_holder_id`
#     GROUP BY ah.`first_name`, ah.`last_name`
#     HAVING SUM(`balance`) > total_money;
# END$$

# set @total_money = 7000.0;
# call usp_get_holders_with_balance_higher_than(@total_money);