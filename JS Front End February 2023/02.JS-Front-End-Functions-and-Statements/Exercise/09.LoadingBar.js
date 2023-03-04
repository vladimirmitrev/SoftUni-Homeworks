function loadingBar(number) {
  let repeatingTimes = number / 10;
  let percentsDone = "%".repeat(repeatingTimes);
  let dots = ".".repeat(10 - repeatingTimes);

  if (number === 100) {
    console.log("100% Complete!");
    console.log(`[${percentsDone}]`);
  } else {
    console.log(`${number}% [${percentsDone}${dots}]`)
    console.log("Still loading...");
  }
}

loadingBar(30);
loadingBar(50);
loadingBar(100);
