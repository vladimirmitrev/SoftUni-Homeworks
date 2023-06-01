#Section 3: Querying – 50 pts

#05.Employees
SELECT first_name,
       middle_name,
       last_name,
       salary,
       hire_date
FROM employees
ORDER BY hire_date DESC;

#06.Products with old pictures
SELECT p.name                                         AS product_name,
       p.price,
       p.best_before,
       CONCAT(SUBSTRING(p.description, 1, 10), '...') AS short_description,
       pic.url
FROM products AS p
         JOIN pictures AS pic on pic.id = p.picture_id
WHERE CHAR_LENGTH(p.description) > 100
  AND YEAR(pic.added_on) < 2019
  AND p.price > 20
ORDER BY p.price DESC;

#07.Counts of products in stores and their average
SELECT s.name,
       COUNT(p.id)            AS 'product_count',
       ROUND(AVG(p.price), 2) AS 'avg'
FROM stores as s
         LEFT JOIN products_stores AS ps ON s.id = ps.store_id
         LEFT JOIN products AS p ON p.id = ps.product_id
GROUP BY s.name
ORDER BY product_count DESC, avg DESC, s.id;

#08.Specific employee
SELECT CONCAT_WS(' ', e.first_name, e.last_name) AS 'Full_name',
       s.name                                    AS 'Store_name',
       a.name                                    AS 'address',
       e.salary
FROM employees AS e
         JOIN stores AS s ON s.id = e.store_id
         JOIN addresses AS a ON a.id = s.address_id
WHERE e.salary < 4000
  AND a.name LIKE '%5%'
  AND CHAR_LENGTH(s.name) > 8
  AND e.last_name LIKE '%n';

#09.Find all information of stores
SELECT REVERSE(s.name)                    AS 'reversed_name',
       CONCAT(UPPER(t.name), '-', a.name) AS 'full_address',
       COUNT(e.id)                        AS 'employees_count'
FROM employees AS e
          JOIN stores AS s ON s.id = e.store_id
          JOIN addresses AS a ON s.address_id = a.id
          JOIN towns AS t ON t.id = a.town_id
GROUP BY s.name
ORDER BY full_address;

