#2.	Section 2: Data Manipulation Language (DML) – 30 pts
# use royal_bank;

#02.Insert
INSERT INTO cards (card_number, card_status, bank_account_id)
SELECT REVERSE(cl.full_name), 'Active', cl.id
FROM clients as cl
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

SELECT COUNT(employee_id)
FROM employees_clients
WHERE employee_id = client_id;

#04.Delete
DELETE e
FROM employees AS e
         LEFT JOIN employees_clients AS ec ON e.id = ec.employee_id
WHERE ec.client_id IS NULL;



# SELECT * FROM clients
# JOIN employees_clients ec on clients.id = ec.client_id
# JOIN employees e on e.id = ec.employee_id
