SELECT `name`, date_format(`start`, "%Y-%m-%d")
AS `start`
FROM `games`
WHERE YEAR(`start`) IN (2011,2012)
ORDER BY `start`
LIMIT 50;