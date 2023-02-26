function spiceMustFlow(startingSpice) {
  let totalSpice = 0;
  let workersEat = 26;
  let currentSpice = startingSpice;
  let totalDays = 0;

  while (currentSpice >= 100) {
    totalDays++;
    totalSpice = totalSpice + currentSpice - workersEat;
    currentSpice -= 10;
  }
  if (totalSpice >= workersEat) {
    totalSpice -= workersEat;
  }
  console.log(totalDays);
  console.log(totalSpice);
}
spiceMustFlow(111);
spiceMustFlow(450);
