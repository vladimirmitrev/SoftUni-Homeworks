function solve(firstNum, secondNum, thirdNum) {
  let result;

  if (firstNum > secondNum && firstNum > thirdNum) {
    result = firstNum;
  } else if (secondNum > firstNum && secondNum > thirdNum) {
    result = secondNum;
  } else {
    result = thirdNum;
  }

  console.log(`The largest number is ${result}.`);
}

solve(20, 18, 19);
solve(14, 22, 16);
solve(14, 22);
