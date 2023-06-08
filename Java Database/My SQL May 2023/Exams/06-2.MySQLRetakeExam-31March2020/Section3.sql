#Section 3: Querying – 50 pts
# USE softuni_influencers;

#05.Users
SELECT u.username, u.gender, u.age
FROM users AS u
ORDER BY u.age DESC, u.username;

#06.Extract 5 most commented photos
SELECT p.id,
       p.date,
       p.description,
       COUNT(c.photo_id) AS 'commentsCount'
FROM photos AS p
         JOIN comments AS c ON p.id = c.photo_id
GROUP BY p.id
ORDER BY commentsCount DESC, p.id
LIMIT 5;

#07.Lucky users
SELECT CONCAT(u.id, ' ', u.username) AS id_username,
       u.email
FROM users AS u
         JOIN users_photos up on u.id = up.user_id
WHERE up.user_id = up.photo_id
ORDER BY u.id;

#08.Count likes and comments
SELECT p.id                             AS 'photo_id',
       (SELECT COUNT(id)
        FROM likes
        WHERE p.id = likes.photo_id)    AS 'likes_count',
       (SELECT COUNT(id)
        FROM comments
        WHERE p.id = comments.photo_id) AS 'comments_count'
FROM photos AS p
ORDER BY likes_count DESC, comments_count DESC, p.id;

#09.The photo on the tenth day of the month
SELECT CONCAT(SUBSTRING(p.description, 1, 30), '...') AS 'summary',
       p.date
FROM photos AS p
WHERE DAY(p.date) = '10'
ORDER BY p.date DESC;
