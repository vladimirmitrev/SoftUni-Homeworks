function parseEmployees(inputArr) {
    let employees = {};

    for (const employee of inputArr) {
      employees[employee] = employee.length;
    }

    for (const key in employees) {
      console.log(`Name: ${key} -- Personal Number: ${employees[key]}`);
    }
  }
  // *** Solution with reduce and functional programming ***

//   Object.entries(
//     inputArr.reduce((data, employee) => {
//       data[employee] = employee.length;
//       return data;
//     }, {})
//   ).forEach(([employee, length]) => {
//     console.log(`Name: ${employee} -- Personal Number: ${length}`);
//   });
// }

parseEmployees([
  "Silas Butler",
  "Adnaan Buckley",
  "Juan Peterson",
  "Brendan Villarreal",
]);
