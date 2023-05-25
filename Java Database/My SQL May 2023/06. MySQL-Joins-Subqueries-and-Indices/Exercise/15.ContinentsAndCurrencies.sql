SELECT 
    `continent_code`,
    `currency_code`,
    COUNT(`currency_code`) AS 'currency_usage'
FROM
    `countries` AS c
GROUP BY `continent_code` , `currency_code`
HAVING COUNT(`country_code`) > 1
    AND `currency_usage` = (SELECT 
        COUNT(*) AS cur
    FROM
        `countries` AS contries
    WHERE
        contries.`continent_code` = c.`continent_code`
    GROUP BY contries.`currency_code`
    ORDER BY cur DESC
    LIMIT 1)
ORDER BY `continent_code` , `currency_code`;