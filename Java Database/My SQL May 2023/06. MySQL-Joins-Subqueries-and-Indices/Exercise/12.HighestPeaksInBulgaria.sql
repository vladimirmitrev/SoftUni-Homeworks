SELECT mc.`country_code`, m.`mountain_range`, p.`peak_name`, p.`elevation`
FROM `peaks` AS p
JOIN `mountains` AS m ON p.`mountain_id` = m.`id`
JOIN `mountains_countries` as mc ON m.`id` = mc.`mountain_id`
WHERE mc.`country_code` = "BG" AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;
