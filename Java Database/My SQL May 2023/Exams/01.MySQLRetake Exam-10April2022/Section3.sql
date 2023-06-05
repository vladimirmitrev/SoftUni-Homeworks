#Section 3: Querying – 50 pts

#05.Countries
SELECT *
FROM countries
ORDER BY currency DESC, id;

#06.Old Movies
SELECT ma.id,
       m.title,
       ma.runtime,
       ma.budget,
       ma.release_date
FROM movies_additional_info AS ma
         JOIN movies m on ma.id = m.movie_info_id
WHERE YEAR(ma.release_date) BETWEEN 1996 AND 1999
ORDER BY ma.runtime, ma.id
LIMIT 20;

#07.Movie casting
SELECT CONCAT_WS(' ', a.first_name, a.last_name),
       CONCAT(REVERSE(a.last_name), CHAR_LENGTH(a.last_name), '@cast.com') AS 'email',
       2022 - YEAR(a.birthdate)                                            AS 'age',
       a.height
FROM actors AS a
         LEFT JOIN movies_actors AS ma ON a.id = ma.actor_id
WHERE ma.movie_id IS NULL
ORDER BY a.height;

#08.International festival
SELECT c.name, COUNT(m.country_id) AS 'movies_count'
FROM countries AS c
         JOIN movies AS m ON c.id = m.country_id
GROUP BY c.name
HAVING movies_count >= 7
ORDER BY c.name DESC;

#09.Rating system
SELECT m.title,
       CASE
           WHEN mai.rating <= 4 THEN 'poor'
           WHEN mai.rating <= 7 THEN 'good'
           WHEN mai.rating > 7 THEN 'excellent'
           END                                   AS 'rating',
       IF(mai.has_subtitles = 1, 'english', '-') AS 'subtitles',
       mai.budget
FROM movies AS m
         JOIN movies_additional_info AS mai
             ON mai.id = m.movie_info_id
ORDER BY mai.budget DESC;

