#Section 4: Programmability – 30 pts
#USE softuni_taxi;

#10.Find all courses by client’s phone number
DELIMITER $$
CREATE FUNCTION udf_courses_by_client(phone_num VARCHAR(20))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE total_count INT;

    SET total_count := (SELECT COUNT(co.client_id)
                        FROM courses AS co
                                 JOIN clients cl on cl.id = co.client_id
                        WHERE cl.phone_number = phone_num);

    RETURN total_count;

END$$

DELIMITER ;
SELECT udf_courses_by_client('(803) 6386812') as `count`;
SELECT udf_courses_by_client('(831) 1391236') as `count`;
SELECT udf_courses_by_client('(704) 2502909') as `count`;

#11.Full info for address
DELIMITER $$
CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))
BEGIN
    SELECT a.name,
           cl.full_name,
           CASE
               WHEN co.bill <= 20 THEN 'Low'
               WHEN co.bill <= 30 THEN 'Medium'
               ELSE 'High'
               END  AS 'level_of_bill',
           car.make,
           car.`condition`,
           cat.name AS 'cat_name'
    FROM addresses AS a
             JOIN courses co on a.id = co.from_address_id
             JOIN cars car on car.id = co.car_id
             JOIN clients cl on cl.id = co.client_id
             JOIN categories cat on cat.id = car.category_id
    WHERE a.name = address_name
    ORDER BY car.make, cl.full_name;
END$$

DELIMITER ;
CALL udp_courses_by_address('700 Monterey Avenue');
