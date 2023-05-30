#Section 4: Programmability – 30 pts

#10. History movies
DELIMITER $$
CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE history_movies_count INT;

    SET history_movies_count := (
        SELECT COUNT(*) AS 'history_movies'
        FROM actors as a
        JOIN movies_actors AS ma on a.id = ma.actor_id
        JOIN genres_movies AS gm USING(movie_id)
        JOIN genres AS g on gm.genre_id = g.id
        WHERE g.name = 'History'
          AND full_name = CONCAT(a.first_name, ' ', a.last_name)
    );

    RETURN history_movies_count;

END $$
# SELECT udf_actor_history_movies_count('Stephan Lundberg') AS 'history_movies';
# SELECT udf_actor_history_movies_count('Jared Di Batista') AS 'history_movies';

#11.Movie awards
DELIMITER $$
CREATE PROCEDURE udp_award_movie(movie_title VARCHAR(50))
BEGIN

    UPDATE actors AS a
    JOIN movies_actors AS ma ON a.id = ma.actor_id
    JOIN movies AS m ON ma.movie_id = m.id
    SET a.awards = a.awards + 1
    WHERE m.title = movie_title;

END$$

# CALL udp_award_movie('Tea For Two');





