DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
    START TRANSACTION;
        IF (money_amount <= 0) THEN ROLLBACK;
        ELSE
            UPDATE `accounts` SET `balance` = `balance` + money_amount
            WHERE `id` = account_id;
        END IF;
END$$

set @account_id = 1;
set @money_amount = 100.0;
call usp_deposit_money(
        @account_id,
        @money_amount
    );