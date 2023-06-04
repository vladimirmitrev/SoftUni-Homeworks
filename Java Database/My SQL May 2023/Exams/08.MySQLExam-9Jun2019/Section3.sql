#3.	Section 3: Querying – 50 pts

# 05.Clients
SELECT id, full_name
FROM clients
ORDER BY id;


#06.Newbies
SELECT id,
       CONCAT(first_name, ' ', last_name) AS full_name,
       CONCAT('$', salary)                AS 'salary',
       started_on
FROM employees
WHERE salary > 100000
  AND started_on >= '2018-01-01'
ORDER BY salary DESC, id


#07.Cards against Humanity
SELECT c.id, CONCAT_WS(' ', c.card_number, ':', cl.full_name) AS card_token
FROM cards AS c
         JOIN bank_accounts AS ba ON ba.id = c.bank_account_id
         JOIN clients AS cl ON cl.id = ba.client_id
ORDER BY c.id DESC;


#08.Top 5 Employees
SELECT CONCAT_WS(' ', e.first_name, e.last_name), e.started_on, COUNT(ec.client_id) AS 'count_of_clients'
FROM employees AS e
         JOIN employees_clients AS ec ON e.id = ec.employee_id
GROUP BY e.id
ORDER BY count_of_clients DESC, e.id
LIMIT 5;

#09.Branch cards
SELECT b.name, COUNT(ca.id) AS 'count_of_cards'
FROM branches AS b
         LEFT JOIN employees AS e ON b.id = e.branch_id
         LEFT JOIN employees_clients AS ec ON e.id = ec.employee_id
         LEFT JOIN clients AS c ON c.id = ec.client_id
         LEFT JOIN bank_accounts AS ba ON c.id = ba.client_id
         LEFT JOIN cards AS ca ON ba.id = ca.bank_account_id
GROUP BY b.name
ORDER BY count_of_cards DESC, b.name;




