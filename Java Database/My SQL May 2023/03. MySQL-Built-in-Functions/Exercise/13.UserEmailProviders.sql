SELECT `user_name`, SUBSTRING(`email`, locate("@", `email`) +1)
AS `email provider`
FROM `users`
ORDER BY `email provider`, `user_name`;