#Section 3: Querying – 50 pts

#05.Categories
SELECT c.id, c.name
FROM categories AS c
ORDER BY c.name DESC;

#06.Quantity
SELECT p.id, p.brand_id, p.name, p.quantity_in_stock
FROM products AS p
WHERE p.price > 1000
  AND p.quantity_in_stock < 30
ORDER BY p.quantity_in_stock, p.id;

#07.Review
SELECT r.id, r.content, r.rating, r.picture_url, r.published_at
FROM reviews AS r
WHERE LEFT(r.content, 2) = 'My'
  AND CHAR_LENGTH(r.content) > 61
ORDER BY r.rating DESC;

#08.First customers
SELECT CONCAT(c.first_name, ' ', c.last_name) AS full_name,
       c.address,
       o.order_datetime                       AS order_date
FROM customers AS c
         JOIN orders AS o ON c.id = o.customer_id
WHERE YEAR(o.order_datetime) <= 2018
ORDER BY c.first_name DESC;

#09.	Best categories
SELECT COUNT(*) AS items_count,
       c.name,
       SUM(p.quantity_in_stock) AS total_quantity
FROM products AS p
    JOIN categories AS c
ON p.category_id = c.id
GROUP BY c.name
ORDER BY items_count DESC , total_quantity
LIMIT 5;
