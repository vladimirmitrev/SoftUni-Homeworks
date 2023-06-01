#Section 4: Programmability – 30 Pts

#10.Get User’s Photos Count
DELIMITER $$
CREATE FUNCTION udf_users_photos_count(username VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE photos_count INT;

    SET photos_count := (SELECT COUNT(*)
                         FROM users_photos AS up
                                  JOIN users AS u ON u.id = up.user_id
                         WHERE u.username = username);

    RETURN photos_count;
END$$

# DELIMITER ;
# SELECT udf_users_photos_count('ssantryd') AS photosCount;

#11.Increase User Age
DELIMITER $$
CREATE PROCEDURE udp_modify_user(given_address VARCHAR(30), given_town VARCHAR(30))
BEGIN
    UPDATE users AS u
        JOIN addresses AS a on u.id = a.user_id
    SET u.age = u.age + 10
    WHERE a.address = given_address
      AND a.town = given_town;

END$$

# DELIMITER ;
# CALL udp_modify_user('97 Valley Edge Parkway', 'Divinópolis');
# SELECT u.username, u.email, u.gender, u.age, u.job_title
# FROM users AS u
# WHERE u.username = 'eblagden21';
