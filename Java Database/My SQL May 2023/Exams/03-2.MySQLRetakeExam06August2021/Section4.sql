#Section 4: Programmability – 30 pts
# use softuni_game_dev

#10.Find all basic information for a game
DELIMITER $$
CREATE FUNCTION udf_game_info_by_name(game_name VARCHAR(20))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE text_info VARCHAR(255);

    SET text_info :=
            (SELECT CONCAT_WS(' ',
                              'The',
                              g.name,
                              'is developed by a',
                              t.name, 'in an office with an address',
                              a.name) AS 'info'
             FROM games AS g
                      JOIN teams AS t ON t.id = g.team_id
                      JOIN offices AS o ON o.id = t.office_id
                      JOIN addresses AS a ON a.id = o.address_id
             WHERE g.name = game_name);

    RETURN text_info;

END$$

DELIMITER ;
SELECT udf_game_info_by_name('Bitwolf') AS info;

# 11.Update Budget of the Games
DELIMITER $$
CREATE PROCEDURE udp_update_budget(min_game_rating FLOAT)
BEGIN

    UPDATE games AS g
        LEFT JOIN games_categories AS gc ON g.id = gc.game_id
    SET g.budget     = g.budget + 100000,
        release_date = DATE_ADD(g.release_date, INTERVAL 1 YEAR)
    WHERE gc.category_id IS NULL
      AND g.rating > min_game_rating
      AND g.release_date IS NOT NULL;

END$$

DELIMITER ;
CALL udp_update_budget(8);
