function degustationParty(input) {
  let guestsObj = {};
  let unLikedMeals = 0;

  while (input[0] !== "Stop") {
    let tokens = input.shift().split("-");
    let command = tokens[0];
    let name = tokens[1];
    let food = tokens[2];

    if (command === "Like") {
      if (!guestsObj.hasOwnProperty(name)) {
        guestsObj[name] = [];
      }
      if (!guestsObj[name].includes(food)) {
        guestsObj[name].push(food);
      }
    } else if (command === "Dislike") {
      if (!guestsObj.hasOwnProperty(name)) {
        console.log(`${name} is not at the party.`);
      } else {
        if (!guestsObj[name].includes(food)) {
          console.log(
            `${name} doesn't have the ${food} in his/her collection.`
          );
        } else {
          let index = guestsObj[name].indexOf(food);
          guestsObj[name].splice(index, 1);
          console.log(`${name} doesn't like the ${food}.`)
          unLikedMeals++;
        }
      }
    }
  }
  for (const name in guestsObj) {
    console.log(`${name}: ${guestsObj[name].join(", ")}`);
  }
  console.log(`Unliked meals: ${unLikedMeals}`);
}

degustationParty([
  "Like-Krisi-shrimps",
  "Like-Krisi-soup",
  "Like-Penelope-dessert",
  "Like-Misho-salad",
  "Stop",
]);

degustationParty([
  "Like-Krisi-shrimps",
  "Dislike-Vili-carp",
  "Dislike-Krisi-salad",
  "Stop",
]);

degustationParty(["Like-Katy-fish", "Dislike-Katy-fish", "Stop"]);
