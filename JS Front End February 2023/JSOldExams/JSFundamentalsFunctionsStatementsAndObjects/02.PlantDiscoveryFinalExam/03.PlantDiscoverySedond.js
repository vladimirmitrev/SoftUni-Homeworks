function plantDiscovery(input) {
  let numberOfPlants = Number(input.shift());

  let plantsObj = {};

  for (let index = 0; index < numberOfPlants; index++) {
    let [plantName, rarity] = input.shift().split("<->");
    let ratings = [];
    plantsObj[plantName] = { rarity, ratings };
  }

  while (input[0] !== "Exhibition") {
    let tokens = input.shift().split(": ");
    let command = tokens[0];
    let plantItems = tokens[1].split(" - ");
    let plantName = plantItems[0];
    let plantDigit = Number(plantItems[1]);

    if (command === "Rate" && plantsObj.hasOwnProperty(plantName)) {
      plantsObj[plantName].ratings.push(plantDigit);
    } else if (command === "Update" && plantsObj.hasOwnProperty(plantName)) {
      plantsObj[plantName].rarity = plantDigit;
    } else if (command === "Reset" && plantsObj.hasOwnProperty(plantName)) {
      plantsObj[plantName].ratings = [];
    } else {
      console.log("error");
    }
  }
  console.log("Plants for the exhibition:")
  for (const plant in plantsObj) {
    let rating = plantsObj[plant].ratings;
    if(rating.length === 0) {
        console.log(`- ${plant}; Rarity: ${plantsObj[plant].rarity}; Rating: 0.00`)
    } else {
        let averageR = rating.reduce((a, b) => a + b, 0) / rating.length;
        console.log(`- ${plant}; Rarity: ${plantsObj[plant].rarity}; Rating: ${averageR.toFixed(2)}`)
    }
  }
}

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

plantDiscovery(["2",
"Candelabra<->10",
"Oahu<->10",
"Rate: Oahu - 7",
"Rate: Candelabra - 6",
"Exhibition"]);
