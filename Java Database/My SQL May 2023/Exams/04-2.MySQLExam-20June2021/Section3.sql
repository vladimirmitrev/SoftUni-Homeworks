#Section 3: Querying – 50 pts

#05.Cars
SELECT make, model, `condition`
FROM cars
ORDER BY id;

#06.Drivers and Cars
SELECT d.first_name, d.last_name, c.make, c.model, c.mileage
FROM drivers AS d
         JOIN cars_drivers AS cd ON d.id = cd.driver_id
         JOIN cars AS c ON c.id = cd.car_id
WHERE c.mileage IS NOT NULL
ORDER BY c.mileage DESC, d.first_name;

#07.Number of courses for each car
SELECT c.id                   AS car_id,
       c.make,
       c.mileage,
       COUNT(car_id)          AS count_of_courses,
       ROUND(AVG(co.bill), 2) AS avg_bill
FROM cars AS c
         LEFT JOIN courses AS co ON c.id = co.car_id
GROUP BY c.id
HAVING count_of_courses != 2
ORDER BY count_of_courses DESC, c.id;

#08.Regular clients
SELECT c.full_name,
       COUNT(ca.id) AS count_of_cars,
       SUM(co.bill) AS total_sum
FROM clients AS c
         JOIN courses AS co ON c.id = co.client_id
         JOIN cars AS ca ON ca.id = co.car_id
WHERE c.full_name LIKE '_a%'
GROUP BY c.full_name
HAVING count_of_cars > 1
ORDER BY c.full_name;

#09.Full information of courses
SELECT a.name,
       IF(HOUR(co.start) BETWEEN 6 AND 20, 'Day', 'Night') AS day_time,
       co.bill,
       cl.full_name,
       ca.make,
       ca.model,
       c.name                                              AS 'category_name'
FROM addresses AS a
         JOIN courses AS co ON a.id = co.from_address_id
         JOIN cars AS ca ON co.car_id = ca.id
         JOIN categories AS c ON c.id = ca.category_id
         JOIN clients AS cl on co.client_id = cl.id
ORDER BY co.id;




