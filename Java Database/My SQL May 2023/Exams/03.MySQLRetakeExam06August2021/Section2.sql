#Section 2: Data Manipulation Language (DML) – 30 pts

#02.Insert
INSERT INTO games (name, rating, budget, team_id)
SELECT (REVERSE(LOWER(SUBSTRING(t.name, 2)))) AS 'name',
t.id as 'rating',
 t.leader_id * 1000 AS 'budget',
 t.id AS 'team_id'
FROM teams as t
WHERE t.id BETWEEN 1 AND 9;

#03.Update
UPDATE employees AS e
JOIN teams t on e.id = t.leader_id
SET salary = salary + 1000
WHERE e.age < 40 AND e.salary <= 5000;

#04.Delete
DELETE g FROM games as g
LEFT JOIN games_categories gc on g.id = gc.game_id
WHERE g.release_date IS NULL AND gc.category_id IS NULL;