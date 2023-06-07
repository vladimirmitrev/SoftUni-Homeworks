#Section 2: Data Manipulation Language (DML) – 30 pts

#02.Insert
INSERT INTO clients (full_name, phone_number)
SELECT CONCAT_WS(' ', first_name, last_name),
       CONCAT('(088) 9999', (id * 2))
FROM drivers
WHERE id BETWEEN 10 AND 20;



#03.Update
UPDATE cars AS c
SET c.`condition` = 'C'
WHERE (c.mileage >= 800000 OR c.mileage IS NULL)
  AND c.year <= 2010
  AND c.make != 'Mercedes';

#04.Delete
DELETE c
FROM clients as c
         LEFT JOIN courses AS co ON c.id = co.client_id
WHERE co.client_id IS NULL
  AND CHAR_LENGTH(c.full_name) > 3;


