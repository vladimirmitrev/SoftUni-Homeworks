#Section 4: Programmability – 30 pts

#10.Extract bill
DELIMITER $$
CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))
    RETURNS DECIMAL(19, 2)
    DETERMINISTIC
BEGIN
    DECLARE total_price DECIMAL(19, 2);

    SET total_price := (SELECT SUM(p.price)
                        FROM clients AS c
                                 JOIN orders_clients AS oc ON c.id = oc.client_id
                                 JOIN orders AS o ON o.id = oc.order_id
                                 JOIN orders_products AS op ON o.id = op.order_id
                                 JOIN products AS p ON p.id = op.product_id
                        WHERE CONCAT(c.first_name, ' ', c.last_name) = full_name
                        );

    RETURN total_price;

END$$

DELIMITER ;
SELECT c.first_name,c.last_name, udf_client_bill('Silvio Blyth') as 'bill' FROM clients c
WHERE c.first_name = 'Silvio' AND c.last_name= 'Blyth';

#11.Happy hour
DELIMITER $$
CREATE PROCEDURE udp_happy_hour(product_type VARCHAR(50))
BEGIN
    UPDATE products AS p
    SET p.price = p.price * 0.8
    WHERE p.price >= 10 AND p.type = product_type;

END$$

DELIMITER ;
CALL udp_happy_hour ('Whiskey');