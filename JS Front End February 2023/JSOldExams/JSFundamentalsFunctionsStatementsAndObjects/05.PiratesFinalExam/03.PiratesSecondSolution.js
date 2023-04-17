function pirates(input) {
  let citiesObj = {};

  while (input[0] !== "Sail") {
    let [city, population, gold] = input.shift().split("||");

    population = Number(population);
    gold = Number(gold);

    if (!citiesObj.hasOwnProperty(city)) {
      citiesObj[city] = { population, gold };
    } else {
      citiesObj[city].population += population;
      citiesObj[city].gold += gold;
    }
  }

  input.shift();

  while (input[0] !== "End") {
    let tokens = input.shift().split("=>");
    let command = tokens[0];
    let city = tokens[1];

    if (command === "Plunder") {
      let people = Number(tokens[2]);
      let goldStolen = Number(tokens[3]);
      citiesObj[city].gold -= goldStolen;
      citiesObj[city].population -= people;
      console.log(
        `${city} plundered! ${goldStolen} gold stolen, ${people} citizens killed.`
      );

      if (citiesObj[city].gold <= 0 || citiesObj[city].population <= 0) {
        delete citiesObj[city];
        console.log(`${city} has been wiped off the map!`);
      }
    } else if (command === "Prosper") {
      let goldToAdd = Number(tokens[2]);

      if (goldToAdd < 0) {
        console.log("Gold added cannot be a negative number!");
      } else {
        citiesObj[city].gold += goldToAdd;
        let newGold = citiesObj[city].gold;
        console.log(
          `${goldToAdd} gold added to the city treasury. ${city} now has ${newGold} gold.`
        );
      }
    }
  }

  let townsLeft = Object.keys(citiesObj).length;

  if(townsLeft === 0) {
    console.log("Ahoy, Captain! All targets have been plundered and destroyed!")
  } else {
    console.log(`Ahoy, Captain! There are ${townsLeft} wealthy settlements to go to:`);
    for (const city in citiesObj) {
        console.log(`${city} -> Population: ${citiesObj[city].population} citizens, Gold: ${citiesObj[city].gold} kg`)
    }
  }

}

// pirates([
//   "Tortuga||345000||1250",
//   "Santo Domingo||240000||630",
//   "Havana||410000||1100",
//   "Sail",
//   "Plunder=>Tortuga=>75000=>380",
//   "Prosper=>Santo Domingo=>180",
//   "End",
// ]);

pirates([
  "Nassau||95000||1000",
  "San Juan||930000||1250",
  "Campeche||270000||690",
  "Port Royal||320000||1000",
  "Port Royal||100000||2000",
  "Sail",
  "Prosper=>Port Royal=>-200",
  "Plunder=>Nassau=>94000=>750",
  "Plunder=>Nassau=>1000=>150",
  "Plunder=>Campeche=>150000=>690",
  "End",
]);
