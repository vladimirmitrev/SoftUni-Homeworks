#Section 4: Programmability – 30 pts

#10.Find full name of top paid employee by store name
DELIMITER $$
CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))
    RETURNS VARCHAR(50)
    DETERMINISTIC
BEGIN
    DECLARE top_paid_employee_info VARCHAR(50);

    SET top_paid_employee_info := (SELECT CONCAT_WS(' ',
                                                    e.first_name,
                                                    CONCAT(e.middle_name, '.'),
                                                    e.last_name, 'works in store for',
                                                    FLOOR(DATEDIFF(20201018, e.hire_date) / 365),
                                                    'years'
                                              )
                                   FROM employees AS e
                                            JOIN stores AS s ON s.id = e.store_id
                                   WHERE s.name = store_name
                                   ORDER BY e.salary DESC
                                   LIMIT 1);

    RETURN top_paid_employee_info;

END$$

DELIMITER ;
SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';
SELECT udf_top_paid_employee_by_store('Keylex') as 'full_info';

#11. Update product price by address
DELIMITER $$
CREATE PROCEDURE udp_update_product_price(address_name VARCHAR(50))
BEGIN

    UPDATE products AS p
        JOIN products_stores AS ps ON p.id = ps.product_id
        JOIN stores AS s ON s.id = ps.store_id
        JOIN addresses AS a ON a.id = s.address_id
    SET p.price = IF(address_name LIKE '0%', p.price + 100, p.price + 200)
    #SET p.price = IF(LEFT(address_name, 1) = 0, p.price + 100, p.price + 200)
    WHERE a.name = address_name;

END$$


DELIMITER ;
CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price
FROM products
WHERE id = 15;

CALL udp_update_product_price('1 Cody Pass');
SELECT name, price
FROM products
WHERE id = 17;


