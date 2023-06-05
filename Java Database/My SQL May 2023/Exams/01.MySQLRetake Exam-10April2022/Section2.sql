#Section 2: Data Manipulation Language (DML) – 30 pts

#02.Insert
INSERT INTO actors(first_name, last_name, birthdate,
                   height, awards, country_id)
    (SELECT REVERSE(first_name),
            REVERSE(last_name),
            DATE_SUB(birthdate, INTERVAL 2 DAY),
            height + 10,
            country_id,
            3
     FROM actors
     WHERE id <= 10);

#03.Update
UPDATE movies_additional_info AS ma
SET ma.runtime = ma.runtime - 10
WHERE ma.id BETWEEN 15 AND 25;

#04.Delete
DELETE c FROM countries AS c
LEFT JOIN movies AS m ON c.id = m.country_id
WHERE m.country_id IS NULL;

