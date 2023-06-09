#Section 3: Querying – 50 pts
USE softuni_bank;

#05.Clients
SELECT id, full_name
FROM clients
ORDER BY id;

#06.Newbies
SELECT e.id,
       CONCAT(e.first_name, ' ', e.last_name),
       CONCAT('$', e.salary),
       started_on
FROM employees AS e
WHERE e.salary >= 100000
  AND YEAR(e.started_on) > 2017
ORDER BY e.salary DESC, e.id;

#07.Cards against Humanity
SELECT c.id,
       CONCAT_WS(' ', c.card_number, ':', cl.full_name)
FROM cards AS c
         JOIN bank_accounts ba on ba.id = c.bank_account_id
         JOIN clients cl on cl.id = ba.client_id
ORDER BY c.id DESC;

#08.Top 5 Employees
SELECT CONCAT_WS(' ', e.first_name, e.last_name),
       e.started_on,
       COUNT(ec.client_id) AS 'count_of_clients'
FROM employees AS e
         LEFT JOIN employees_clients ec on e.id = ec.employee_id
GROUP BY e.id
ORDER BY count_of_clients DESC, e.id
LIMIT 5;

#09.Branch cards
SELECT b.name,
       COUNT(ca.card_number) AS 'count_of_cards'
FROM branches AS b
         LEFT JOIN employees AS e ON b.id = e.branch_id
         LEFT JOIN employees_clients AS ec ON e.id = ec.employee_id
         LEFT JOIN clients AS c ON c.id = ec.client_id
         LEFT JOIN bank_accounts AS ba ON c.id = ba.client_id
         LEFT JOIN cards AS ca ON ba.id = ca.bank_account_id
GROUP BY b.name
ORDER BY count_of_cards DESC, b.name;

