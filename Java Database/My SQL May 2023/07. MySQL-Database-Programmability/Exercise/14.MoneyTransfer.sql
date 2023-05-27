DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4))
BEGIN
    START TRANSACTION;

    IF
       from_account_id = to_account_id OR
       amount <= 0 OR
       amount > (SELECT `balance` FROM `accounts` WHERE `id` = from_account_id) OR
       (SELECT COUNT(`id`) FROM `accounts` WHERE `id` = from_account_id ) <> 1 OR
       (SELECT COUNT(`id`) FROM `accounts` WHERE `id` = to_account_id ) <> 1

        THEN ROLLBACK;
    ELSE
        UPDATE `accounts` SET `balance` = `balance` - amount WHERE `id` = from_account_id;
        UPDATE `accounts` SET `balance` = `balance` + amount WHERE `id` = to_account_id;
        COMMIT;
     END IF;
END$$

set @from_account_id = 5;
set @to_account_id = 6;
set @amount = 100.0;
call usp_transfer_money(
        @from_account_id,
        @to_account_id,
        @amount)