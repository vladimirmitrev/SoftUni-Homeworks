#Section 3: Querying – 50 pts

#05.Clients
SELECT *
FROM clients AS c
ORDER BY c.birthdate DESC, c.id DESC;

#06.Birthdate
SELECT first_name, last_name, birthdate, review
FROM clients
WHERE card IS NULL
  AND YEAR(birthdate) BETWEEN 1978 AND 1993
ORDER BY last_name DESC, id DESC
LIMIT 5;

#07.Accounts
SELECT CONCAT(w.last_name, w.first_name, CHAR_LENGTH(w.first_name), 'Restaurant') AS 'username',
       REVERSE(SUBSTRING(w.email, 2, 12))                                         AS 'password'
FROM waiters as w
WHERE w.salary IS NOT NULL
ORDER BY password DESC;

#08.Top from menu
SELECT p.id, p.name, COUNT(op.product_id) AS 'count'
FROM products AS p
         JOIN orders_products AS op ON p.id = op.product_id
GROUP BY p.id
HAVING count >= 5
ORDER BY count DESC, p.name;

#09.Availability
SELECT t.id                AS table_id,
       t.capacity,
       COUNT(oc.client_id) AS 'count_clients',
       CASE
           WHEN t.capacity > COUNT(oc.client_id) THEN 'Free seats'
           WHEN t.capacity = COUNT(oc.client_id) THEN 'Full'
           ELSE 'Extra seats'
           END
FROM tables AS t
         JOIN orders AS o ON t.id = o.table_id
         JOIN orders_clients AS oc ON o.id = oc.order_id
WHERE t.floor = 1
GROUP BY o.table_id
ORDER BY table_id DESC;




