#4.	Section 4: Programmability – 30

# use online_electronics

#10.Extract client cards count
DELIMITER $$
CREATE FUNCTION udf_customer_products_count(received_name VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE total_products INT;

    SET total_products := (
        SELECT COUNT(p.id)
            FROM products AS p
            LEFT JOIN orders_products AS op ON p.id = op.product_id
            LEFT JOIN orders AS o ON o.id = op.order_id
            LEFT JOIN customers AS c ON c.id = o.customer_id
            WHERE c.first_name = received_name
        );

    RETURN total_products;

END$$

DELIMITER ;
SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as `total_products` FROM customers c
WHERE c.first_name = 'Shirley';

#11.Reduce price
DELIMITER $$
CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN

    UPDATE products AS p
    JOIN reviews AS r ON r.id = p.review_id
    JOIN categories AS c ON c.id = p.category_id
    SET p.price = p.price * 0.7
    WHERE r.rating < 4
    AND c.name = category_name;

END$$

CALL udp_reduce_price ('Phones and tablets');

