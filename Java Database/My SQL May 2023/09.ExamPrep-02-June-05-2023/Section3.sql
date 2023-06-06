#3.	Section 3: Querying – 50 pts
# USE online_electronics

#05.Categories
SELECT *
FROM categories
ORDER BY `name` DESC;

#06.Quantity
SELECT p.id,
       p.brand_id,
       p.name,
       p.quantity_in_stock
FROM products AS p
WHERE p.price > 1000
AND p.quantity_in_stock < 30
ORDER BY p.quantity_in_stock, p.id;

#07.Review
SELECT *
FROM reviews AS r
WHERE r.content LIKE 'My%'
AND CHAR_LENGTH(r.content) > 61
ORDER BY r.rating DESC;

#08.First customers
SELECT CONCAT_WS(' ', c.first_name, c.last_name) AS 'full_name',
       c.address,
       o.order_datetime
FROM customers AS c
         JOIN orders AS o ON c.id = o.customer_id
WHERE YEAR(o.order_datetime) <= 2018
ORDER BY full_name DESC;

#09.Best categories
SELECT COUNT(p.id) AS 'items_count',
       c.name,
       SUM(p.quantity_in_stock) AS 'total_quantity'
FROM categories AS c
JOIN products AS p ON c.id = p.category_id
GROUP BY c.name
ORDER BY items_count DESC, total_quantity
LIMIT 5;