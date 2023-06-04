#4.Section: Programmability – 30 pts

#15.Get colonists count
DELIMITER $$
CREATE FUNCTION udf_count_colonists_by_destination_planet(planet_name VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE count_of_colonists INT;

    SET count_of_colonists := (SELECT COUNT(c.id)
                               FROM colonists AS c
                                        LEFT JOIN travel_cards AS tc ON c.id = tc.colonist_id
                                        LEFT JOIN journeys AS j ON j.id = tc.journey_id
                                        LEFT JOIN spaceports AS s ON s.id = j.destination_spaceport_id
                                        LEFT JOIN planets AS p ON p.id = s.planet_id
                               WHERE p.name = planet_name);

    RETURN count_of_colonists;

END$$

DELIMITER ;
SELECT p.name, udf_count_colonists_by_destination_planet('Otroyphus') AS count
FROM planets AS p
WHERE p.name = 'Otroyphus';

#16.Modify spaceship
DELIMITER $$
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(
    spaceship_name VARCHAR(50),
    light_speed_rate_increse INT(11))
BEGIN

    IF (SELECT COUNT(ss.id)
        FROM spaceships AS ss
        WHERE ss.name = spaceship_name > 0)
    THEN
        UPDATE spaceships AS ss
        SET ss.light_speed_rate = ss.light_speed_rate + light_speed_rate_increse
        WHERE ss.name = spaceship_name;
    ELSE
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';

    END IF;

END$$

DELIMITER ;
CALL udp_modify_spaceship_light_speed_rate ('Na Pesho koraba', 1914);
SELECT ss.name, ss.light_speed_rate FROM spaceships AS ss WHERE ss.name = 'Na Pesho koraba'

CALL udp_modify_spaceship_light_speed_rate ('USS Templar', 5);
SELECT name, light_speed_rate FROM spaceships WHERE name = 'USS Templar'