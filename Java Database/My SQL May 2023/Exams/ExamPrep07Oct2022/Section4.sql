#Section 4: Programmability – 30 pts

#10. Find all players that play on stadium
DELIMITER $$
CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN

  RETURN ( SELECT COUNT(p.id)
        FROM players AS p
        JOIN teams AS t on t.id = p.team_id
        RIGHT JOIN stadiums AS s on s.id = t.stadium_id
        WHERE s.name = stadium_name
        GROUP BY s.id);
END$$

DELIMITER ;
SELECT udf_stadium_players_count ('Jaxworks') as `count`;
SELECT udf_stadium_players_count ('Linklinks') as `count`;


# DELIMITER $$
# CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30))
#     RETURNS INT
#     DETERMINISTIC
# BEGIN
#
#     RETURN ( SELECT COUNT(p.id)
#               FROM players AS p
#               JOIN teams t on t.id = p.team_id
#               RIGHT JOIN stadiums s on s.id = t.stadium_id
#               GROUP BY s.name
#               HAVING s.name = stadium_name);

                ## My solution ^:)
#
# END$$

#11. Find good playmaker by teams
DELIMITER $$
CREATE PROCEDURE udp_find_playmaker(min_dribble_points INT, team_name VARCHAR(45))
BEGIN

    SELECT
        CONCAT_WS(' ', p.first_name, p.last_name) AS 'full_name',
        p.age,
        p.salary,
        sd.dribbling,
        sd.speed,
        t.name AS 'team_name'
    FROM players AS p
    JOIN skills_data AS sd
        ON sd.id = p.skills_data_id
    JOIN teams AS t on t.id = p.team_id
    WHERE sd.dribbling > min_dribble_points AND
          t.name = team_name AND
          sd.speed > (SELECT AVG(speed) FROM skills_data)
    ORDER BY sd.speed DESC
    LIMIT 1;

END$$

DELIMITER ;
CALL udp_find_playmaker (20, 'Skyble');
