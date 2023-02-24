function sumDigits(number) {
  let sum = 0;
  let numberAsString = number.toString();

  for (const num of numberAsString) {
    sum += Number(num);
  }
  // while(number > 0) {
  //     let lastDigit = number % 10;
  //     sum += lastDigit;
  //     number = Math.floor(number / 10);
  // }

  console.log(sum);
}

sumDigits(245678);
sumDigits(97561);
sumDigits(543);
