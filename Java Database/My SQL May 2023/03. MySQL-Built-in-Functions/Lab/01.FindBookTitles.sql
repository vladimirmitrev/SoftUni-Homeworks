SELECT `title`
FROM `books`
WHERE SUBSTRING(`title`, 1, 3) = "The";

-- WHERE SUBSTRING(`title` FROM 1 FOR 3) = "The"; 
-- WHERE `title` LIKE "The%";