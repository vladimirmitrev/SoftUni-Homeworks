function plantDiscovery(inputArr) {
  let numberOfPlants = Number(inputArr.shift());

  let plantsObj = {};

  for (let i = 0; i < numberOfPlants; i++) {
    let [name, rarity] = inputArr.shift().split("<->");

    plantsObj[name] = { rarity, rating: [] };
  }

  while (inputArr[0] !== "Exhibition") {
    let tokens = inputArr.shift().split(": ");
    let command = tokens[0];
    let nameAndDigit = tokens[1].split(" - ")
    let plantName = nameAndDigit[0];
    let digit = Number(nameAndDigit[1]);
    if (plantsObj.hasOwnProperty(plantName)) {
      if (command === "Rate") {
        plantsObj[plantName].rating.push(digit);
      } else if (command === "Update") {
        plantsObj[plantName].rarity = digit;
      } else if (command === "Reset"){
        plantsObj[plantName].rating.length = 0;
      }
    } else {
        console.log("error")
    }
  }
  console.log(`Plants for the exhibition:`);
  for (const key in plantsObj) {
    let rating = plantsObj[key].rating;
    if (rating.length === 0) {
      console.log(`- ${key}; Rarity: ${plantsObj[key].rarity}; Rating: 0.00`);
    } else {
      let averageP = rating.reduce((a, b) => a + b, 0) / rating.length;
      console.log(
        `- ${key}; Rarity: ${plantsObj[key].rarity}; Rating: ${averageP.toFixed(2)}`);
    }
  }
}
//   console.log(`Plants for the exhibition:`);
//   for (const plant of Object.entries(plantsObj)) {
//     let name = plant[0];
//     let rarity = plant[1].rarity;
//     let rating = plant[1].rating;
//     if (rating == 0) {
//       console.log(`- ${name}; Rarity: ${rarity}; Rating: 0.00`);
//     } else {
//       let averageP = rating.reduce((a, b) => a + b, 0) / rating.length;
//       console.log(
//         `- ${name}; Rarity: ${rarity}; Rating: ${averageP.toFixed(2)}`
//       );
//     }
//   }


plantDiscovery([
  "3",
  "Arnoldii<->4",
  "Woodii<->7",
  "Welwitschia<->2",
  "Rate: Woodii - 10",
  "Rate: Welwitschia - 7",
  "Rate: Arnoldii - 3",
  "Rate: Woodii - 5",
  "Update: Woodii - 5",
  "Reset: Arnoldii",
  "Exhibition",
]);

// plantDiscovery([
//   "2",
//   "Candelabra<->10",
//   "Oahu<->10",
//   "Rate: Oahu - 7",
//   "Rate: Candelabra - 6",
//   "Exhibition",
// ]);
