# SECTION Section 2: Data Manipulation Language (DML) – 30 pts

#02.Insert
INSERT INTO coaches (first_name, last_name, salary, coach_level) (
    SELECT p.first_name, p.last_name, p.salary, char_length(p.first_name) AS 'coach_level'
    FROM players as p
    WHERE p.age >= 45
);

#03.Update
UPDATE coaches AS c
JOIN players_coaches pc on c.id = pc.coach_id
SET c.coach_level = c.coach_level + 1
WHERE c.first_name LIKE 'A%';

#04.Delete
DELETE FROM players AS p
WHERE p.age >= 45;
