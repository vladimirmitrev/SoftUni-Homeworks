

DELIMITER $$
CREATE PROCEDURE udp_total_amount_of_books_the_author_has_written(
    IN author_first_name VARCHAR(50),
    IN author_last_name VARCHAR(50),
    OUT total_copies INT)

BEGIN

    SELECT COUNT(*)
    INTO total_copies
    FROM books AS b
             JOIN authors a on a.id = b.author_id
    WHERE a.first_name = author_first_name
      AND a.last_name = author_last_name;

END$$

SELECT COUNT(*) AS total_books
FROM books AS b
         JOIN authors a on a.id = b.author_id
WHERE a.first_name = 'Amanda'
  AND a.last_name = 'Rice';


SELECT COUNT(b.id) AS total_books
FROM books AS b
         JOIN authors a on a.id = b.author_id
WHERE a.first_name = 'Roger'
  AND a.last_name = 'Porter';
