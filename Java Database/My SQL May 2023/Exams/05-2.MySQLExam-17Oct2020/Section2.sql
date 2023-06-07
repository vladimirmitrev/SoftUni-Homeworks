#Section 2: Data Manipulation Language (DML) – 30 pts
#USE softuni_stores;

#02.Insert
INSERT INTO products_stores(product_id, store_id)
SELECT p.id, 1
FROM products AS p
         LEFT JOIN products_stores AS ps ON p.id = ps.product_id
WHERE ps.store_id IS NULL;

#03.Update
UPDATE employees AS e
    JOIN stores AS s ON s.id = e.store_id
SET e.manager_id = 3,
    e.salary     = e.salary - 500
WHERE YEAR(e.hire_date) > 2003
  AND s.name != 'Cardguard'
  AND s.name != 'Veribet';

#04.Delete
DELETE e
FROM employees AS e
WHERE e.manager_id IS NOT NULL
  AND e.salary >= 6000;