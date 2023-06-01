#Section 2: Data Manipulation Language (DML) – 30 pts

#02.Insert
INSERT INTO products_stores(product_id, store_id)
SELECT p.id, '1'
FROM products AS p
         LEFT JOIN products_stores ps on p.id = ps.product_id
WHERE ps.store_id IS NULL;

#03.Update
UPDATE employees as e
    JOIN stores AS s on s.id = e.store_id
SET e.manager_id = 3,
    e.salary     = e.salary - 500
WHERE YEAR(e.hire_date) > 2003
  AND s.id NOT IN (5, 14);

#04.Delete
DELETE
FROM employees
WHERE manager_id IS NOT NULL
  AND salary >= 6000;