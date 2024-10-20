CREATE TABLE logs(
     `log_id`   INT PRIMARY KEY AUTO_INCREMENT,
     account_id INT            NOT NULL,
     old_sum    DECIMAL(19, 4) NOT NULL,
     new_sum    DECIMAL(19, 4) NOT NULL
);

CREATE TRIGGER tr_logs_account
    AFTER UPDATE
    ON `accounts`
    FOR EACH ROW
BEGIN
    INSERT INTO `logs` (`account_id`, `old_sum`, `new_sum`)
    VALUES(OLD.`id`, OLD.`balance`, NEW.`balance`);
END;

CREATE TABLE notification_emails
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `recipient` INT NOT NULL,
    `subject` VARCHAR(100) NOT NULL,
    `body` VARCHAR(100)
);

DELIMITER $$
CREATE TRIGGER tr_notification_emails
    AFTER INSERT
    ON `logs`
    FOR EACH ROW
    BEGIN

        INSERT INTO `notification_emails` (`recipient`, `subject`, `body`)
            VALUES (
                    NEW.`account_id`,
                    CONCAT('Balance change for account:', ' ', NEW.`account_id`),
                    CONCAT_WS(' ', 'On', NOW(), 'your balance was changed from', NEW.`old_sum`, 'to', NEW.`new_sum`,'.')
                   );
END$$