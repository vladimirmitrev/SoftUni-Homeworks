#Section 4: Programmability – 30 pts

#10.Extract client cards count
DELIMITER $$
CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE total_products INT;

    SET total_products := (SELECT COUNT(*)
                           FROM products AS p
                                    JOIN orders_products AS op ON p.id = op.product_id
                                    JOIN orders AS o ON o.id = op.order_id
                                    JOIN customers AS c ON o.customer_id = c.id
                           WHERE c.first_name = `name`);

    RETURN total_products;

END$$

DELIMITER ;
SELECT c.first_name, c.last_name, udf_customer_products_count('Shirley') as `total_products`
FROM customers c
WHERE c.first_name = 'Shirley';

#11.Reduce price
DELIMITER $$
CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN

    UPDATE products AS p
        JOIN categories AS c ON c.id = p.category_id
        JOIN reviews AS r ON r.id = p.review_id
    SET p.price = p.price * 0.7
    WHERE c.name = category_name
    AND r.rating < 4;

END$$

DELIMITER ;
CALL udp_reduce_price ('Phones and tablets');