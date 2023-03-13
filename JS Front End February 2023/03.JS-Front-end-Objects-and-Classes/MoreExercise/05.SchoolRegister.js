function schoolRegister(inputArr) {
  let allStudentsInfo = {};

  for (let i = 0; i < inputArr.length; i++) {
    const allInfoPerStudent = inputArr[i]
      .split(", ")
      .join(" ")
      .split(": ")
      .join(" ")
      .split(" ");

    const studentName = allInfoPerStudent[2];
    const studentGrade = Number(allInfoPerStudent[4]) + 1;
    const studentAverage = Number(allInfoPerStudent[10]);

    if (!allStudentsInfo.hasOwnProperty(studentGrade)) {
      allStudentsInfo[studentGrade] = [];
    }

    if (studentAverage >= 3) {
      allStudentsInfo[studentGrade].push({ studentName, studentAverage });
    }
  }
  for (const [grade, studentsGrades] of Object.entries(allStudentsInfo)) {
    let gradesSum = 0;
    let gradesLength = 0; 
    let studentsArr = [];
    for (const student of studentsGrades) {
      gradesLength++;
      gradesSum += student["studentAverage"];
      studentsArr.push(student["studentName"]);
    }
    if (allStudentsInfo[grade].length > 0) {
      console.log(`${grade} Grade`);
      console.log(`List of students: ${studentsArr.join(", ")}`);
      console.log(
        `Average annual score from last year: ${(
          gradesSum / gradesLength
        ).toFixed(2)}\n`
      );
    }
  }
}

schoolRegister([
  "Student name: Mark, Grade: 8, Graduated with an average score: 4.75",
  "Student name: Ethan, Grade: 9, Graduated with an average score: 5.66",
  "Student name: George, Grade: 8, Graduated with an average score: 2.83",
  "Student name: Steven, Grade: 10, Graduated with an average score: 4.20",
  "Student name: Joey, Grade: 9, Graduated with an average score: 4.90",
  "Student name: Angus, Grade: 11, Graduated with an average score: 2.90",
  "Student name: Bob, Grade: 11, Graduated with an average score: 5.15",
  "Student name: Daryl, Grade: 8, Graduated with an average score: 5.95",
  "Student name: Bill, Grade: 9, Graduated with an average score: 6.00",
  "Student name: Philip, Grade: 10, Graduated with an average score: 5.05",
  "Student name: Peter, Grade: 11, Graduated with an average score: 4.88",
  "Student name: Gavin, Grade: 10, Graduated with an average score: 4.00",
]);
