#Section 2: Data Manipulation Language (DML) – 30 pts
# USE softuni_bank;

#02.Insert
INSERT INTO cards(card_number, card_status, bank_account_id)
SELECT REVERSE(cl.full_name),
       'Active',
       cl.id
FROM clients AS cl
WHERE cl.id BETWEEN 191 AND 200;

#03.Update
UPDATE employees_clients
SET employee_id = (SELECT *
                   FROM (SELECT employee_id
                         FROM employees_clients
                         GROUP BY employee_id
                         ORDER BY COUNT(client_id), employee_id
                         LIMIT 1) AS s)
WHERE client_id = employee_id;

#04.Delete
DELETE e
FROM employees AS e
         LEFT JOIN employees_clients ec on e.id = ec.employee_id
WHERE ec.client_id IS NULL;