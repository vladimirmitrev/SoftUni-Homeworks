#4.	Section 4: Programmability – 30 pts
DELIMITER  $$
CREATE FUNCTION udf_client_cards_count(client_name VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE count_of_cards INT;

    SET count_of_cards := (SELECT COUNT(c.id)
                           FROM cards AS c
                                    JOIN bank_accounts AS ba on ba.id = c.bank_account_id
                                    JOIN clients cl on cl.id = ba.client_id
                           WHERE cl.full_name = client_name
                           GROUP BY cl.id);

    RETURN count_of_cards;
END$$

DELIMITER ;
SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM clients c
WHERE c.full_name = 'Baxy David';

#11.Extract Client Info
DELIMITER $$
CREATE PROCEDURE udp_clientinfo(client_name VARCHAR(50))
BEGIN

    SELECT c.full_name, c.age, ba.account_number, CONCAT('$',ba.balance) AS 'account_number'
    FROM clients AS c
    JOIN bank_accounts AS ba ON c.id = ba.client_id
    WHERE c.full_name =  client_name;

END$$

DELIMITER ;
CALL udp_clientinfo('Hunter Wesgate')