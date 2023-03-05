function printDNA(number) {
  let DNA = "ATCGTTAGGG";

  let currentPosition = 0;

  for (let index = 0; index < number; index++) {
    if (index === 0 || currentPosition === 8) {
      currentPosition = 0;
    } else {
      currentPosition += 2;
    }

    if (index === 0 || index % 4 === 0) {
      console.log(`**${DNA[currentPosition] + DNA[currentPosition + 1]}**`);
    } else if (index % 2 === 0) {
      console.log(`${DNA[currentPosition]}----${DNA[currentPosition + 1]}`);
    } else if (index % 1 === 0 || index % 3 === 0) {
      console.log(`*${DNA[currentPosition]}--${DNA[currentPosition + 1]}*`);
    }
  }
}
printDNA(4);
printDNA(10);
