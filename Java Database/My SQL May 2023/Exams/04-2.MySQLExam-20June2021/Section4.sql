#Section 4: Programmability – 30 pts

#10.Find all courses by client’s phone number
DELIMITER $$
CREATE FUNCTION udf_courses_by_client(phone_num VARCHAR(20))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE count_of_courses INT;

    SET count_of_courses := (SELECT COUNT(*) AS 'count'
                             FROM courses as co
                                      JOIN clients AS c ON co.client_id = c.id
                             WHERE c.phone_number = phone_num
                             GROUP BY c.id);

    RETURN count_of_courses;

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
           cl.full_name AS full_names,
           CASE
               WHEN co.bill <= 20 THEN 'Low'
               WHEN co.bill <= 30 THEN 'Medium'
               ELSE 'High'
               END
                        AS level_of_bill,
           ca.make,
           `condition`,
           c.name       AS 'cat_name'
    FROM addresses AS a
             JOIN courses AS co ON a.id = co.from_address_id
             JOIN cars AS ca ON ca.id = co.car_id
             JOIN categories AS c ON c.id = ca.category_id
             JOIN clients AS cl on cl.id = co.client_id
    WHERE a.name = address_name
    ORDER BY ca.make, cl.full_name;

END$$

DELIMITER ;
CALL udp_courses_by_address('700 Monterey Avenue');
CALL udp_courses_by_address('66 Thompson Drive');

