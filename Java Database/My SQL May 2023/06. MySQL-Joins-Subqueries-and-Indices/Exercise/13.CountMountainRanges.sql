SELECT mc.`country_code`, COUNT(`mountain_range`) AS 'mountain_range'
FROM `mountains` AS m
JOIN `mountains_countries` AS mc ON m.`id` = mc.`mountain_id`
GROUP BY mc.`country_code`
HAVING mc.`country_code` IN ("BG", "RU", "US")
ORDER BY `mountain_range` DESC;