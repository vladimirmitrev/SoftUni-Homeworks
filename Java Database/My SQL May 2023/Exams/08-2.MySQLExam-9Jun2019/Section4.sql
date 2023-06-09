#Section 4: Programmability – 30 pts
# USE softuni_bank;

#10.Extract client cards count
DELIMITER $$
CREATE FUNCTION udf_client_cards_count(client_name VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN

    DECLARE count_of_cards INT;

    SET count_of_cards := (SELECT COUNT(ca.card_number)
                           FROM cards AS ca
                                    JOIN bank_accounts AS ba ON ba.id = ca.bank_account_id
                                    JOIN clients AS cl ON cl.id = ba.client_id
                           WHERE cl.full_name = client_name);

    RETURN count_of_cards;

END$$

DELIMITER ;
SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards`
FROM clients c
WHERE c.full_name = 'Baxy David';

#11.Extract Client Info
DELIMITER $$
CREATE PROCEDURE udp_clientinfo(client_name VARCHAR(30))
BEGIN
    SELECT cl.full_name,
           cl.age,
           ba.account_number,
           CONCAT('$', ba.balance) AS 'balance'
    FROM clients AS cl
             JOIN bank_accounts AS ba ON cl.id = ba.client_id
    WHERE cl.full_name = client_name;

END$$

DELIMITER ;

CALL udp_clientinfo('Hunter Wesgate');