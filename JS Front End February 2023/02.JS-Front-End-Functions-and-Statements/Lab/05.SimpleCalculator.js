function simpleCalculator(firstNum, secondNum, operation) {

  const add = (a, b) => a + b;
  const subtract = (a, b) => a - b;
  const divide = (a, b) => a / b;
  const multiply = (a, b) => a * b;

  const operationMap = {
    add: add,
    subtract: subtract,
    divide: divide,
    multiply: multiply

  }

  return operationMap[operation](firstNum, secondNum);
}

console.log(simpleCalculator(5, 5, "multiply"));
console.log(simpleCalculator(40, 8, "divide"));
console.log(simpleCalculator(12, 19, "add"));
console.log(simpleCalculator(50, 13, "subtract"));

// Solution with switch //
//   switch (operation) {
//     case "add":
//       return add(firstNum, secondNum);
//       break;
//     case "subtract":
//       return subtract(firstNum, secondNum);
//       break;
//     case "divide":
//       return divide(firstNum, secondNum);
//       break;
//     case "multiply":
//       return multiply(firstNum, secondNum);
//       break;
//     default:
//       return "Invalid operation";
//       break;
//   }



