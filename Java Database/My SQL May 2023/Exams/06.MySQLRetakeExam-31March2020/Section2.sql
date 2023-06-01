#Section 2: Data Manipulation Language (DML) – 30 Pts

#02.Insert
INSERT INTO addresses(address, town, country, user_id)
SELECT u.username, u.password, u.id, u.age
FROM users AS u
WHERE u.gender = 'M';

#03.Update
UPDATE addresses
SET country =
        CASE
            WHEN LEFT(country, 1) = 'B' THEN 'Blocked'
            WHEN LEFT(country, 1) = 'T' THEN 'Test'
            WHEN LEFT(country, 1) = 'P' THEN 'In Progress'
            ELSE 'NULL'
            END;

#04.Delete
DELETE FROM addresses AS a
WHERE a.id % 3 = 0;

# SELECT count(*) FROM addresses
# WHERE id BETWEEN 1 and 100;


