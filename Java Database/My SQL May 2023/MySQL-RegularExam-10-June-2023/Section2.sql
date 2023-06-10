#Section 2: Data Manipulation Language (DML) – 30 pts

# USE regular_exam;


#02.Insert
INSERT INTO courses(name, duration_hours, start_date, teacher_name, description, university_id)
SELECT CONCAT(teacher_name, ' ', 'course'),
       CHAR_LENGTH(name) / 10,
       ADDDATE(start_date, INTERVAL 5 DAY),
       REVERSE(teacher_name),
       CONCAT('Course ', teacher_name, REVERSE(description)),
       DAY(start_date)
FROM courses
WHERE id <= 5;

#03.Update
UPDATE universities AS u
SET u.tuition_fee = u.tuition_fee + 300
WHERE u.id BETWEEN 5 AND 12;

#04.Delete
DELETE u FROM universities AS u
WHERE u.number_of_staff IS NULL;