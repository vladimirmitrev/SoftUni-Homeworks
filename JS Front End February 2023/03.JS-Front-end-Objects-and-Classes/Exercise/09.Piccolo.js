function piccolo(inputArr) {
  let parkedCars = new Set();

  for (const line of inputArr) {
    let command = line.split(", ")[0];
    let number = line.split(", ")[1];

    if (command === "IN") {
      parkedCars.add(number);
    } else {
      delete parkedCars.delete(number);
    }
  }

  if (parkedCars.size === 0) {
    console.log("Parking Lot is Empty");
  } else {
    console.log();
    let sortedNumbers = Array.from(parkedCars).sort();

    sortedNumbers.forEach((element) => {
      console.log(element);
    });
  }
}

piccolo([
  "IN, CA2844AA",
  "IN, CA1234TA",
  "OUT, CA2844AA",
  "IN, CA9999TT",
  "IN, CA2866HI",
  "OUT, CA1234TA",
  "IN, CA2844AA",
  "OUT, CA2866HI",
  "IN, CA9876HH",
  "IN, CA2822UU",
]);
piccolo(["IN, CA2844AA", "IN, CA1234TA", "OUT, CA2844AA", "OUT, CA1234TA"]);
