#Section 4: Programmability – 30 pts

# 10. Find all players that play on stadium
DELIMITER $$
CREATE FUNCTION udf_stadium_players_count(stadium_name VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE count_of_players INT;

    SET count_of_players := (SELECT COUNT(p.id)
                             FROM players AS p
                                      JOIN teams AS t ON t.id = p.team_id
                                      JOIN stadiums AS s ON s.id = t.stadium_id
                             WHERE s.name = stadium_name);

    RETURN count_of_players;

END$$

DELIMITER ;
SELECT udf_stadium_players_count('Jaxworks') as `count`;
SELECT udf_stadium_players_count('Linklinks') as `count`;

#11.Find good playmaker by teams
DELIMITER $$
CREATE PROCEDURE udp_find_playmaker(min_dribble_points INT, given_team_name VARCHAR(45))
BEGIN
    SELECT CONCAT_WS(' ', p.first_name, p.last_name) AS 'full_name',
           p.age,
           salary,
           dribbling,
           speed,
           te.name                                   AS 'team_name'
    FROM teams AS te
             JOIN players AS p ON te.id = p.team_id
             JOIN skills_data AS sd ON sd.id = p.skills_data_id
    WHERE te.name = given_team_name
      AND sd.dribbling > min_dribble_points
      AND sd.speed > (SELECT AVG(speed) FROM skills_data)
    ORDER BY sd.speed DESC
    LIMIT 1;

#     AND sd.speed > AVG(sd.speed)
END$$

DELIMITER ;
CALL udp_find_playmaker(20, 'Skyble');