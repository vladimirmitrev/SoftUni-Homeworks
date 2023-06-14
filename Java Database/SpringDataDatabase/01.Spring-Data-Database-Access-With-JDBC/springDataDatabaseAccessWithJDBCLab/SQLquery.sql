USE diablo;

SELECT u.first_name, u.last_name, COUNT(ug.game_id) AS count
FROM users AS u
         JOIN users_games ug on u.id = ug.user_id
WHERE u.user_name = 'nakov'
GROUP BY u.first_name, u.last_name;

