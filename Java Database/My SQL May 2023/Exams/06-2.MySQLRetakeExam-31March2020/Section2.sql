#Section 2: Data Manipulation Language (DML) – 30 pts
# USE softuni_influencers;

#02.Insert
INSERT INTO addresses(address, town, country, user_id)
SELECT u.username, u.password, u.ip, u.age
FROM users AS u
WHERE u.gender = 'M';

#03.Update
UPDATE addresses AS a
SET a.country = CASE
                    WHEN LEFT(a.country, 1) = 'B' THEN 'Blocked'
                    WHEN LEFT(a.country, 1) = 'T' THEN 'Test'
                    WHEN LEFT(a.country, 1) = 'P' THEN 'In Progress'
                    ELSE ''
    END;

#04.Delete
DELETE a FROM addresses AS a
WHERE a.id % 3 = 0;