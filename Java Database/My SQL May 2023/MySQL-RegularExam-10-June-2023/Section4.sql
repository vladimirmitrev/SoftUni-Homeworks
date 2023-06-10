#Section 4: Programmability – 30 pts

USE regular_exam;

#10.Average grades
DELIMITER $$
CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
    RETURNS DECIMAL(19, 2)
    DETERMINISTIC
BEGIN

    DECLARE average_grade DECIMAL(19, 2);

    SET average_grade := (SELECT ROUND(AVG(grade), 2)
                          FROM students_courses
                                   JOIN students AS s ON s.id = students_courses.student_id
                                   JOIN courses AS c ON c.id = students_courses.course_id
                          WHERE s.is_graduated = 1
                            AND c.name = course_name);
    RETURN average_grade;
END$$

DELIMITER ;

SELECT c.name, udf_average_alumni_grade_by_course_name('Quantum Physics') as average_alumni_grade
FROM courses c
WHERE c.name = 'Quantum Physics';

#11.Graduate students
DELIMITER $$
CREATE PROCEDURE udp_graduate_all_students_by_year(year_started INT)
BEGIN
    UPDATE students AS s
        JOIN students_courses AS sc ON s.id = sc.student_id
        JOIN courses AS c ON c.id = sc.course_id
    SET s.is_graduated = '1'
    WHERE YEAR(c.start_date) = year_started;
END$$

DELIMITER ;
CALL udp_graduate_all_students_by_year(2017);