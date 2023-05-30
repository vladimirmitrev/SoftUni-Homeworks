#Section 3: Querying – 50 pts

#05.Countries
SELECT id, name, continent,	currency
FROM countries
ORDER BY currency DESC, id;

#06.Old movies
SELECT m.id, m.title, mai.runtime, mai.budget, mai.release_date
FROM movies AS m
         JOIN movies_additional_info AS mai ON m.movie_info_id = mai.id
WHERE YEAR(mai.release_date) BETWEEN 1996 AND 1999
ORDER BY mai.runtime, mai.id
LIMIT 20;

#07.Movie casting
SELECT
    CONCAT_WS(' ', first_name, last_name) AS full_name,
    CONCAT(REVERSE(last_name), CHAR_LENGTH(last_name), '@cast.com') AS email,
    2022 - YEAR(a.birthdate)AS age,
    a.height
FROM actors AS a
LEFT JOIN movies_actors AS ma ON a.id = ma.actor_id
WHERE ma.movie_id IS NULL
ORDER BY a.height;

#08.International festival
SELECT c.name, COUNT(m.title) AS 'movies_count'
FROM countries AS c
JOIN movies AS m on c.id = m.country_id
GROUP BY c.name
HAVING movies_count >= 7
ORDER BY c.name DESC;

#09.Rating system
SELECT m.title,
       (CASE
            WHEN mai.rating <= 4 THEN 'poor'
            WHEN mai.rating <= 7 THEN 'good'
            ELSE 'excellent'
           END) AS 'rating',
       IF(mai.has_subtitles = 1, 'english', '-') AS subtitles,
       mai.budget
FROM movies as m
         JOIN movies_additional_info AS mai
              on m.movie_info_id = mai.id
ORDER BY mai.budget DESC;

