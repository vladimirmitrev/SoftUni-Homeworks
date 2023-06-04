#2.	Section: Data Manipulation Language (DML) – 30 pts

#02.Insert
INSERT INTO travel_cards(card_number, job_during_journey, colonist_id, journey_id)
    (SELECT IF(c.birth_date > '1980-01-01',
               CONCAT(YEAR(c.birth_date), DAY(c.birth_date), LEFT(c.ucn, 4)),
               CONCAT(YEAR(c.birth_date), MONTH(c.birth_date), RIGHT(c.ucn, 4))),
            CASE
                WHEN c.id % 2 = 0 THEN 'Pilot'
                WHEN c.id % 3 = 0 THEN 'Cook'
                ELSE 'Engineer'
                END,
            c.id,
            SUBSTRING(c.ucn, 1, 1)
     FROM colonists AS c
     WHERE c.id BETWEEN 96 AND 100);

# SELECT *
# FROM travel_cards
#
# WHERE id > 95;

#03.Update
UPDATE journeys
SET purpose =
    CASE
        WHEN id % 2 = 0 THEN 'Medical'
        WHEN id % 3 = 0 THEN 'Technical'
        WHEN id % 5 = 0 THEN 'Educational'
        WHEN id % 7 = 0 THEN 'Military'
        END
WHERE id % 2 = 0 OR id % 3 = 0 OR id % 5 = 0 OR id % 7 = 0;

#04.Delete
DELETE c FROM colonists AS c
LEFT JOIN travel_cards AS tc ON c.id = tc.colonist_id
WHERE tc.journey_id IS NULL