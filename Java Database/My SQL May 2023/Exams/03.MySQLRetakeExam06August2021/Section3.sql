#Section 3: Querying – 50 pts

#05.Employees
SELECT first_name, last_name, age, salary, happiness_level
FROM employees
ORDER BY salary, id;

#06.Addresses of the teams
SELECT t.name AS 'team_name', a.name 'address_name', char_length(a.name) AS 'count_of_characters'
FROM teams AS t
JOIN offices AS o ON t.office_id = o.id
JOIN addresses AS a ON a.id = o.address_id
WHERE o.website IS NOT NULL
ORDER BY t.name, a.name;

#07.Categories Info
SELECT c.name AS 'name', COUNT(gc.category_id) AS 'games_count', ROUND(AVG(g.budget),2), MAX(g.rating) AS 'max_rating'
FROM categories as c
JOIN games_categories AS gc ON c.id = gc.category_id
JOIN games AS g ON g.id = gc.game_id
GROUP BY gc.category_id
HAVING max_rating >= 9.5
ORDER BY games_count DESC, `name`;

#08.Games of 2022
SELECT g.name,
       g.release_date,
       CONCAT(SUBSTRING(g.description, 1, 10), '...') AS 'summary',
       CASE
           WHEN MONTH(g.release_date) < 4 THEN 'Q1'
           WHEN MONTH(g.release_date) < 7 THEN 'Q2'
           WHEN MONTH(g.release_date) < 10 THEN 'Q3'
           ELSE 'Q4'
           END AS 'quarter',
       t.name                          AS 'team_name'

FROM games AS g
         JOIN teams AS t ON g.team_id = t.id
WHERE YEAR(g.release_date) = 2022 AND
      MONTH(g.release_date) IN (2,4,6,8,10,12) AND
      g.name LIKE '%2'
ORDER BY quarter;

#09.Full info for games
SELECT g.name,
       IF(g.budget < 50000, 'Normal budget', 'Insufficient budget') AS 'budget_level',
       t.name AS 'team_name',
       a.name AS 'address_name'
FROM games as g
LEFT JOIN games_categories AS gc ON g.id = gc.game_id
LEFT JOIN categories AS c ON gc.category_id = c.id
JOIN teams AS t ON g.team_id = t.id
JOIN offices AS o ON t.office_id = o.id
JOIN addresses AS a ON a.id = o.address_id
WHERE g.release_date IS NULL AND c.id IS NULL
ORDER BY g.name;

