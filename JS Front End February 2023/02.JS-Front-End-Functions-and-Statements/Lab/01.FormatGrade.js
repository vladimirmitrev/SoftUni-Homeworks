function formatGrade(grade) {

  if (grade >= 5.5) {
    return `Excellent (${gradeToFixed(grade)})`;
  } else if (grade < 5.5 && grade >= 4.5) {
    return `Very good (${gradeToFixed(grade)})`;
  } else if (grade < 4.5 && grade >= 3.5) {
    return `Good (${gradeToFixed(grade)})`;
  } else if (grade < 3.5 && grade >= 3) {
    return `Poor (${gradeToFixed(grade)})`;
  }
  
  return `Fail (2)`;

  function gradeToFixed(grade) {
     return grade.toFixed(2);
  }
}

console.log(formatGrade(3.33));
console.log(formatGrade(4.50));
console.log(formatGrade(2.99));
