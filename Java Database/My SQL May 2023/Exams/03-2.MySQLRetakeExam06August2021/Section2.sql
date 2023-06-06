#Section 2: Data Manipulation Language (DML) – 30 pts
#USE softuni_game_dev

#02.Insert
INSERT INTO games(name, rating, budget, team_id)
SELECT REVERSE(LOWER(SUBSTRING(t.name, 2))) AS 'name',
       t.id AS 'rating',
       t.leader_id * 1000 AS 'budget',
       t.id AS 'team_id'
FROM teams AS t
WHERE t.id BETWEEN 1 AND 9;

#03.Update
UPDATE employees AS e
LEFT JOIN teams AS t ON e.id = t.leader_id
SET e.salary = e.salary + 1000
WHERE t.leader_id IS NOT NULL
AND e.age < 40
AND e.salary <= 5000;

#04.Delete
DELETE g FROM games AS g
LEFT JOIN games_categories AS gc ON g.id = gc.game_id
WHERE gc.category_id IS NULL
AND g.release_date IS NULL;

