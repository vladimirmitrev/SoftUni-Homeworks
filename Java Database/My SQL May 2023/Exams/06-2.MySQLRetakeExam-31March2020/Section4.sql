#Section 4: Programmability – 30 pts
# USE softuni_influencers;

# 10.Get user’s photos count
DELIMITER $$
CREATE FUNCTION udf_users_photos_count(received_username VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE photos_count INT;

    SET photos_count := (SELECT COUNT(p.id)
                         FROM photos AS p
                                  LEFT JOIN users_photos AS up ON p.id = up.photo_id
                                  LEFT JOIN users AS u ON up.user_id = u.id
                         WHERE u.username = received_username);

    RETURN photos_count;

END$$

DELIMITER ;
SELECT udf_users_photos_count('ssantryd') AS photosCount;

#11 Increase user age
DELIMITER $$
CREATE PROCEDURE udp_modify_user(received_address VARCHAR(30), received_town VARCHAR(30))
BEGIN

    UPDATE users AS u
        LEFT JOIN addresses AS a ON u.id = a.user_id
    SET u.age = u.age + 10
    WHERE a.address = received_address
      AND a.town = received_town;

END$$

DELIMITER ;

CALL udp_modify_user ('97 Valley Edge Parkway', 'Divinópolis');
SELECT u.username, u.email,u.gender,u.age,u.job_title FROM users AS u
WHERE u.username = 'eblagden21';
