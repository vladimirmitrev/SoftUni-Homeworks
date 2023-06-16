USE minions_db;

SELECT v.name, COUNT(DISTINCT mv.minion_id) AS minions_count
FROM villains AS v
JOIN minions_villains mv on v.id = mv.villain_id
GROUP BY v.id
HAVING minions_count > 15
ORDER BY minions_count DESC;

SELECT v.name, m.name, m.age FROM villains AS v
JOIN minions_villains mv on v.id = mv.villain_id
JOIN minions m on m.id = mv.minion_id
WHERE v.id = 1;

SELECT m.name, m.age
FROM minions AS m
JOIN minions_villains mv on m.id = mv.minion_id
WHERE mv.villain_id = ?;

SELECT name FROM villains WHERE id = ?;

INSERT INTO villains(name)
VALUES (?)


UPDATE towns
SET name = UPPER(name)
WHERE country = ?;

DELETE FROM villains
WHERE id = ?;

DELETE
FROM minions_villains
WHERE villain_id = ?;

SELECT COUNT(minion_id) FROM minions_villains
WHERE villain_id = 1;

SELECT COUNT(minion_id) AS 'minions_count'
                        FROM minions_villains
                        WHERE villain_id = ?;


UPDATE minions AS m
SET m.age = m.age + 1, m.name = LOWER(m.name)
WHERE m.id = ?;

DELIMITER $$
CREATE PROCEDURE usp_get_older(inputId int)
BEGIN
    UPDATE minions
        SET age = age + 1
    WHERE id = inputId;
END $$





