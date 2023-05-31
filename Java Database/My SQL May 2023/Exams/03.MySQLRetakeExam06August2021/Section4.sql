#Section 4: Programmability – 30 pts

#10.Find all basic information for a game

DELIMITER $$
CREATE FUNCTION udf_game_info_by_name(game_name VARCHAR(20))
    RETURNS TEXT
    DETERMINISTIC
BEGIN
    DECLARE sentence TEXT;

    SET sentence := (SELECT CONCAT_WS(' ', 'The', g.name, 'is developed by a', t.name, 'in an office with an address',
                                      a.name) as 'info'
                     FROM games AS g
                              JOIN teams AS t ON g.team_id = t.id
                              JOIN offices AS o ON o.id = t.office_id
                              JOIN addresses AS a ON a.id = o.address_id
                     WHERE g.name = game_name);

    RETURN sentence;

END$$

#11.Update budget of the games
DELIMITER $$
CREATE PROCEDURE udp_update_budget(min_game_rating FLOAT)
BEGIN

    UPDATE games as g
        LEFT JOIN games_categories AS gc ON g.id = gc.game_id
        LEFT JOIN categories AS  c ON c.id = gc.category_id
    SET g.budget = g.budget + 100000, g.release_date = DATE_ADD(g.release_date, INTERVAL 1 YEAR)
    WHERE c.id IS NULL AND g.rating > min_game_rating AND g.release_date IS NOT NULL;

END$$