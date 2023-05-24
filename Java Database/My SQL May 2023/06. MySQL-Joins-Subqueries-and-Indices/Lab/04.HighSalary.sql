SELECT 
    COUNT(`first_name`) AS 'count'
FROM
    `employees`
WHERE
    `salary` > (SELECT 
            AVG(`salary`)
        FROM
            `employees`);