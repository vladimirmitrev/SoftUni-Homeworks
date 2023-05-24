SELECT 
    e.`employee_id`,
    CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'full_name',
    d.`department_id`,
    d.`name`
FROM
    `employees` AS e
        JOIN
    `departments` AS d ON d.`manager_id` = e.`employee_id`
ORDER BY e.`employee_id`
LIMIT 5;
 