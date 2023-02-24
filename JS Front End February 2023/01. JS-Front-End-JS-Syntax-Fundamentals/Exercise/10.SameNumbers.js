function sameNumbers(number) {
  let numberAsString = number.toString();
  let numberArr = numberAsString.split("");
  let currentNum = numberArr[0];
  let isSame = true;
  let sum = 0;

  for (const num of numberArr) {
    if (num === currentNum) {
      isSame = true;
    } else {
      isSame = false;
    }

    sum += Number(num);
  }

  console.log(isSame);
  console.log(sum);
}

sameNumbers(2222222);
sameNumbers(1234);
