SELECT * FROM `towns`
-- WHERE `name` REGEXP "^[MmKkBbEe]"
WHERE 
   `name` LIKE "m%"
OR `name` LIKE "k%"
OR `name` LIKE "b%"
OR `name` LIKE "e%"
ORDER BY `name`;