#Section 3: Querying – 50 pts
# USE softuni_taxi;

#05.Cars
SELECT make, model, `condition`
FROM cars
ORDER BY id;

#06.Drivers and Cars
SELECT d.first_name, d.last_name, c.make, c.model, c.mileage
FROM cars AS c
         JOIN cars_drivers AS cd ON c.id = cd.car_id
         JOIN drivers AS d ON d.id = cd.driver_id
WHERE c.mileage IS NOT NULL
ORDER BY c.mileage DESC, d.first_name;

#7.Number of courses for each car
SELECT c.id AS car_id,
       c.make,
       c.mileage,
       COUNT(co.car_id) AS 'count_of_courses',
       ROUND(AVG(co.bill),2) AS 'avg_bill'
FROM cars AS c
    LEFT JOIN courses AS co ON c.id = co.car_id
GROUP BY c.id
HAVING count_of_courses != 2
ORDER BY count_of_courses DESC, c.id;

#08.Regular clients
SELECT cl.full_name,
       COUNT(ca.id) AS 'count_of_cars',
       SUM(co.bill) AS 'total_sum'
FROM clients AS cl
    JOIN courses co on cl.id = co.client_id
    JOIN cars AS ca on ca.id = co.car_id
WHERE cl.full_name LIKE '_a%'
GROUP BY cl.full_name
HAVING count_of_cars > 1
ORDER BY cl.full_name;

#09.Full information of courses
SELECT a.name,
       IF(HOUR(co.start) BETWEEN 6 AND 20,'Day', 'Night') AS 'day_time',
       co.bill,
       cl.full_name,
       ca.make,
       ca.model,
       c.name AS 'category_name'
FROM addresses AS a
    JOIN courses AS co ON a.id = co.from_address_id
    JOIN clients AS cl ON cl.id = co.client_id
    JOIN cars AS ca on ca.id = co.car_id
    JOIN categories c on c.id = ca.category_id
ORDER BY co.id;
