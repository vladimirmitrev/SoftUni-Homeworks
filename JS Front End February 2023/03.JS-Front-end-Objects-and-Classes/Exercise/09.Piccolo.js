function piccolo(inputArr) {
  /// *** Solution with Set ***
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
      let sortedNumbers = Array.from(parkedCars).sort((aNum, bNum) =>
        aNum.localeCompare(bNum)
      );

      sortedNumbers.forEach((element) => {
        console.log(element);
      });
    }
}
  /// *** Solution with array ***
//   let parkedCars = [];

//   for (const line of inputArr) {
//     let command = line.split(", ")[0];
//     let number = line.split(", ")[1];

//     if (command === "IN" && !parkedCars.includes(number)) {
//       parkedCars.push(number);
//     } else if (command === "OUT" && !parkedCars.includes(number)) {
//       let index = parkedCars.indexOf(number);
//       parkedCars.splice(index, 1);
//     }
//   }

//   if (parkedCars.length === 0) {
//     console.log("Parking Lot is Empty");
//   } else {
//     console.log();
//     let sortedNumbers = parkedCars.sort((aNum, bNum) =>
//       aNum.localeCompare(bNum)
//     );

//     sortedNumbers.forEach((element) => {
//       console.log(element);
//     });
//   }


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
