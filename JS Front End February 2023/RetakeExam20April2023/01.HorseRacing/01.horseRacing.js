function horseRacing(input) {
  let horsesArr = input.shift().split("|");

  while (input[0] !== "Finish") {
    let tokens = input.shift().split(" ");
    let command = tokens[0];

    if (command === "Retake") {
      let overtakingHorse = tokens[1];
      let overtakenHorse = tokens[2];
      let overtakingIndex = horsesArr.indexOf(overtakingHorse);
      let overtakenIndex = horsesArr.indexOf(overtakenHorse);
      if (overtakingIndex < overtakenIndex) {
          horsesArr.splice(overtakingIndex, 1, overtakenHorse);
          horsesArr.splice(overtakenIndex, 1, overtakingHorse);
          //   [horsesArr[overTakingIndex], horsesArr[overTakenIndex]] = [horsesArr[overTakenIndex], horsesArr[overTakingIndex]];
          
        console.log(`${overtakingHorse} retakes ${overtakenHorse}.`);
      }
    } else if (command === "Trouble") {
      let horseName = tokens[1];
      let horseIndex = horsesArr.indexOf(horseName);
      
      if (horseIndex > 0) {
        horsesArr.splice(horseIndex, 1);
        horsesArr.splice(horseIndex - 1, 0, horseName);

        console.log(`Trouble for ${horseName} - drops one position.`);
      }
    } else if (command === "Rage") {
      let horseName = tokens[1];
      let horseIndex = horsesArr.indexOf(horseName);

      if (horseIndex === horsesArr.length - 1) {
        horseIndex = horsesArr.length - 1;

      } else if (horseIndex === horsesArr.length - 2) {
        horsesArr.splice(horseIndex, 1);
        horsesArr.splice((horseIndex + 1), 0, horseName);

      } else {
        let newIndex = horseIndex + 2;
        horsesArr.splice(horseIndex, 1);
        horsesArr.splice(newIndex, 0, horseName);
      }

      console.log(`${horseName} rages 2 positions ahead.`);

    } else if (command === "Miracle") {
      let lastHorse = horsesArr.shift();
      horsesArr.push(lastHorse);

      console.log(`What a miracle - ${lastHorse} becomes first.`);
    }
  }

  let winner = horsesArr[horsesArr.length - 1];

  console.log(horsesArr.join("->"));
  console.log(`The winner is: ${winner}`);
}

horseRacing([
  "Bella|Alexia|Sugar",
  "Retake Alexia Sugar",
  "Rage Bella",
  "Trouble Bella",
  "Finish",
]);

horseRacing(['Onyx|Domino|Sugar|Fiona',
'Trouble Onyx',
'Retake Onyx Sugar',
'Rage Domino',
'Miracle',
'Finish']);

horseRacing(['Fancy|Lilly',
'Retake Lilly Fancy',
'Trouble Lilly',
'Trouble Lilly',
'Finish',
'Rage Lilly']);
