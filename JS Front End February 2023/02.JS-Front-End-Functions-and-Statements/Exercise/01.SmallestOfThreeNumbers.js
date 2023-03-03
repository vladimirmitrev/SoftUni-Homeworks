function findSmallestNumber(firstNum, secondNum, thirdNum) {
  let min = Math.min(firstNum, secondNum, thirdNum);

  return min;
}

// const findSmallestNumber = (firstNum, secondNum, thirdNum) =>  Math.min(firstNum, secondNum, thirdNum);

console.log(findSmallestNumber(2, 5, 3));
console.log(findSmallestNumber(600, 342, 123));
console.log(findSmallestNumber(25, 21, 4));
console.log(findSmallestNumber(2, 2, 2));
