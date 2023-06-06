#Section 3: Querying – 50 pts
#USE softuni_game_dev

#05.Employees
SELECT first_name,
       last_name,
       age,
       salary,
       happiness_level
FROM employees
ORDER BY salary, id;

#06.Addresses of the teams
SELECT t.name AS 'team_name',
       a.name AS 'address_name',
       CHAR_LENGTH(a.name)
FROM teams AS t
         JOIN offices AS o ON o.id = t.office_id
         JOIN addresses AS a ON a.id = o.address_id
WHERE o.website IS NOT NULL
ORDER BY t.name, a.name;

#07.Categories Info
SELECT c.name,
       COUNT(g.id)   AS 'games_count',
       ROUND(AVG(g.budget), 2),
       MAX(g.rating) AS 'max_rating'
FROM categories AS c
         JOIN games_categories AS gc ON c.id = gc.category_id
         JOIN games AS g ON g.id = gc.game_id
GROUP BY c.id
HAVING max_rating >= 9.5
ORDER BY games_count DESC, c.name;

#08.Games of 2022
SELECT g.name,
       g.release_date,
       CONCAT(SUBSTRING(g.description, 1, 10), '...') AS 'summary',
       CASE
           WHEN MONTH(g.release_date) IN (1, 2, 3) THEN 'Q1'
           WHEN MONTH(g.release_date) IN (4, 5, 6) THEN 'Q2'
           WHEN MONTH(g.release_date) IN (7, 8, 9) THEN 'Q3'
           WHEN MONTH(g.release_date) IN (10, 11, 12) THEN 'Q4'
           END                                        AS 'quarter',
       t.name                                         AS 'team_name'
FROM games AS g
         JOIN teams AS t ON t.id = g.team_id
WHERE YEAR(g.release_date) = 2022
  AND RIGHT(g.name, 1) = '2'
  AND MONTH(g.release_date) IN (2, 4, 6, 8, 10, 12)
ORDER BY quarter;

#09.Full info for games
SELECT g.name,
       IF(g.budget < 50000, 'Normal budget', 'Insufficient budget') AS 'budget_level',
       t.name AS 'team_name',
       a.name AS 'address_name '
FROM games AS g
         LEFT JOIN games_categories AS gc ON g.id = gc.game_id
         JOIN teams AS t ON t.id = g.team_id
         JOIN offices AS o ON o.id = t.office_id
         JOIN addresses AS a ON a.id = o.address_id
WHERE gc.category_id IS NULL
  AND g.release_date IS NULL
ORDER BY g.name;
