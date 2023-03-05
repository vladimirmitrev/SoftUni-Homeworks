function numberModification(number) {
  let numberArr = number.toString().split("");
  let sum = 0;
  let modifiedArr = [...numberArr];

  for (const digit of numberArr) {
    sum += Number(digit);
  }

  let average = 0;

  while (average <= 5) {
    average = sum / modifiedArr.length;
    sum += 9;
    if (average > 5) {
        break;
    }
    modifiedArr.push("9");
  }

  console.log(modifiedArr.join(""));
}
numberModification(101);
numberModification(5835);
