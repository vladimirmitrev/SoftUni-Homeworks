function calculations(firstNum, secondNum, thirdNum) {
  const sum = (a, b) => a + b;
  const subtract = (mySum, num) => mySum - num;

  return subtract(sum(firstNum, secondNum), thirdNum);
}
//    *  Solution with arrow function *
//
// const calculations = (firstNum, secondNum, thirdNum) => {
//   const sum = (a, b) => a + b;
//   const subtract = (mySum, num) => mySum - num;

//   return subtract(sum(firstNum, secondNum), thirdNum);
// }

console.log(calculations(23, 6, 10));
console.log(calculations(1, 17, 30));
console.log(calculations(42, 58, 100));
