function calculate(inputArr) {
  let evenSum = 0;
  let oddSum = 0;

  for (let i = 0; i < inputArr.length; i++) {

    if (inputArr[i] % 2 === 0) {
      evenSum += inputArr[i];
    } else {
      oddSum += inputArr[i];
    }
  }
  let result = evenSum - oddSum;
  console.log(result);
}

calculate([1,2,3,4,5,6]);
calculate([3,5,7,9]);
calculate([2,4,6,8,10]);
