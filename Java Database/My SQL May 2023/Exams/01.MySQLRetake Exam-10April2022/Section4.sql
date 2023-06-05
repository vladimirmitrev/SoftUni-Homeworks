#Section 4: Programmability – 30 pts

#10. History movies
DELIMITER $$
CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE total_history_movies INT;

    SET total_history_movies := (SELECT COUNT(*) AS 'history_movies'
                                 FROM movies AS m
                                          JOIN genres_movies AS gm ON m.id = gm.movie_id
                                          JOIN genres AS g ON g.id = gm.genre_id
                                          JOIN movies_actors AS ma ON m.id = ma.movie_id
                                          JOIN actors AS a ON a.id = ma.actor_id
                                 WHERE g.name = 'History'
                                   AND CONCAT_WS(' ', a.first_name, a.last_name) = full_name);

    RETURN total_history_movies;

END$$

DELIMITER ;
SELECT udf_actor_history_movies_count('Stephan Lundberg') AS 'history_movies';

#11.Movie awards
DELIMITER $$
CREATE PROCEDURE udp_award_movie(movie_title VARCHAR(50))
BEGIN

    UPDATE actors AS a
        JOIN movies_actors AS ma ON a.id = ma.actor_id
        JOIN movies AS m ON m.id = ma.movie_id
    SET a.awards = a.awards + 1
    WHERE m.title = movie_title;

END$$

DELIMITER ;
CALL udp_award_movie('Tea For Two');
