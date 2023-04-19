function solve(input) {
  let guestObj = {};
  let unlikedMeals = 0;

  while (input[0] !== "Stop") {
    let tokens = input.shift().split("-");
    let command = tokens[0];
    let name = tokens[1];
    let food = tokens[2];

    if (command === "Like") {
      if (!guestObj.hasOwnProperty(name)) {
        guestObj[name] = [];
      }
      if (!guestObj[name].includes(food)) {
        guestObj[name].push(food);
      }
    } else if (command === "Dislike") {
      if (!guestObj.hasOwnProperty(name)) {
        console.log(`${name} is not at the party.`);
      } else {
        if (!guestObj[name].includes(food)) {
          console.log(
            `${name} doesn't have the ${food} in his/her collection.`
          );
        } else {
          let index = guestObj[name].indexOf(food);
          guestObj[name].splice(index, 1);
          unlikedMeals++;
          console.log(`${name} doesn't like the ${food}.`);
        }
      }
    }
  }

  for (const key in guestObj) {
    console.log(`${key}: ${guestObj[key].join(", ")}`);
  }
  console.log(`Unliked meals: ${unlikedMeals}`);
}

solve([
  "Like-Krisi-shrimps",
  "Like-Krisi-soup",
  "Like-Penelope-dessert",
  "Like-Krisi-soup",
  "Like-Misho-salad",
  "Stop",
]);

solve([
  "Like-Krisi-shrimps",
  "Dislike-Vili-carp",
  "Dislike-Krisi-salad",
  "Stop",
]);

solve(["Like-Katy-fish", "Dislike-Katy-fish", "Stop"]);
