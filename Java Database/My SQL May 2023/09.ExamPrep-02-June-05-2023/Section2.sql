#2.	Section 2: Data Manipulation Language (DML) – 30 pts
# use online_electronics

#02.Insert
INSERT INTO reviews (content, rating, picture_url, published_at)
SELECT SUBSTRING(p.description, 1, 15),
       p.price / 8,
       REVERSE(p.name),
       '2010-10-10'
FROM products AS p
WHERE p.id >= 5;

#03.Update
UPDATE products AS p
SET p.quantity_in_stock = p.quantity_in_stock - 5
WHERE p.quantity_in_stock BETWEEN 60 AND 70;

#04.Delete
DELETE c FROM customers AS c
LEFT JOIN orders AS o ON c.id = o.customer_id
WHERE o.customer_id IS NULL;


