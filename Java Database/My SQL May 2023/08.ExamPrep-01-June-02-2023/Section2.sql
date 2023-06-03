#Section 2: Data Manipulation Language (DML) – 30 pts

#02.Insert
INSERT INTO products (name, type, price)
SELECT CONCAT(w.last_name, ' ', 'specialty'),
       'Cocktail',
       ROUND(CEIL(w.salary * 0.01))
    FROM waiters as w
WHERE w.id > 6;

#03.Update
UPDATE orders as o
SET o.table_id = o.table_id - 1
WHERE o.id BETWEEN 12 AND 23;

#04.Delete
DELETE w FROM waiters as w
LEFT JOIN orders AS o ON w.id = o.waiter_id
WHERE o.waiter_id IS NULL;
