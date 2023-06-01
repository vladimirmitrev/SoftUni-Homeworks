#Section 3: Querying – 50 Pts

#05.Users
SELECT username, gender, age
FROM users
ORDER BY age DESC, username;

#06.Extract 5 Most Commented Photos
SELECT p.id,
       p.date      AS date_and_time,
       p.description,
       COUNT(p.id) AS commentsCount
FROM photos AS p
         JOIN comments AS c
              ON p.id = c.photo_id
GROUP BY c.photo_id #,p.id
ORDER BY commentsCount DESC, p.id
LIMIT 5;

#07.Lucky Users
SELECT CONCAT(u.id, ' ', u.username) AS 'id_username',
       u.email
FROM users AS u
         JOIN users_photos AS up ON u.id = up.user_id
         JOIN photos AS p on p.id = up.photo_id
WHERE up.user_id = up.photo_id;

#08.Count Likes and Comments
SELECT p.id,
       (SELECT COUNT(id)
        FROM likes
        WHERE photo_id = p.id) AS likes_count,
       (SELECT COUNT(id)
        FROM comments
        WHERE photo_id = p.id) AS comments_count
FROM photos AS p
ORDER BY likes_count DESC, comments_count DESC, p.id;

#09.The Photo on the Tenth Day of the Month
SELECT CONCAT(SUBSTRING(p.description, 1, 30), '...') AS summary,
       p.date
FROM photos AS p
WHERE DAY(p.date) = 10
ORDER BY p.date DESC;
