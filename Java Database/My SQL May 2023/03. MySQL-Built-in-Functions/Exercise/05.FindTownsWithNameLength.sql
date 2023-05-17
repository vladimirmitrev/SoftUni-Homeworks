SELECT `name`
FROM `towns`
WHERE char_length(`name`) IN (5,6)
ORDER BY `name`;

-- WHERE char_length(`name`) = 5
-- OR char_length(`name`) = 6
