SELECT `first_name`, `last_name`, `department_id`
FROM `employees` AS current_employee
WHERE `salary` > (
			SELECT AVG(`salary`) FROM `employees`AS other_employees
			WHERE current_employee.`department_id` = other_employees.`department_id`
)
ORDER BY `department_id`, `employee_id`
LIMIT 10;
            
		