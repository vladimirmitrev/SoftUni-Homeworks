function solve(input) {
  let numberOfHeroes = Number(input.shift());

  let heroesObj = {};

  for (let index = 0; index < numberOfHeroes; index++) {
    let [hero, healthPoints, manaPoints] = input.shift().split(" ");

    healthPoints = Number(healthPoints);
    manaPoints = Number(manaPoints);
    heroesObj[hero] = { healthPoints, manaPoints };
  }

  while (input[0] !== "End") {
    let tokens = input.shift().split(" - ");
    let command = tokens[0];
    let hero = tokens[1];

    if (command === "CastSpell") {
      let manaNeeded = Number(tokens[2]);
      let spell = tokens[3];
      if (heroesObj[hero].manaPoints >= manaNeeded) {
        heroesObj[hero].manaPoints -= manaNeeded;
        console.log(
          `${hero} has successfully cast ${spell} and now has ${heroesObj[hero].manaPoints} MP!`
        );
      } else {
        console.log(`${hero} does not have enough MP to cast ${spell}!`);
      }
    } else if (command === "TakeDamage") {
      let damage = tokens[2];
      let attacker = tokens[3];
      heroesObj[hero].healthPoints -= damage;
      let leftHealth = heroesObj[hero].healthPoints;
      if (leftHealth > 0) {
        console.log(
          `${hero} was hit for ${damage} HP by ${attacker} and now has ${leftHealth} HP left!`
        );
      } else {
        delete heroesObj[hero];
        console.log(`${hero} has been killed by ${attacker}!`);
      }
    } else if (command === "Recharge") {
      let rechargeAmount = Number(tokens[2]);
      let currentMana = heroesObj[hero].manaPoints;
      heroesObj[hero].manaPoints += rechargeAmount;
      if (heroesObj[hero].manaPoints > 200) {
        heroesObj[hero].manaPoints = 200;
        rechargeAmount = Math.abs(200 - currentMana);
      }
      console.log(`${hero} recharged for ${rechargeAmount} MP!`);
    } else if (command === "Heal") {
      let healingAmount = Number(tokens[2]);
      let currentHealth = heroesObj[hero].healthPoints;
      heroesObj[hero].healthPoints += healingAmount;
      if (heroesObj[hero].healthPoints > 100) {
        heroesObj[hero].healthPoints = 100;
        healingAmount = Math.abs(100 - currentHealth);
      }
      console.log(`${hero} healed for ${healingAmount} HP!`);
    }
  }

  for (const hero in heroesObj) {
    console.log(`${hero}\n  HP: ${heroesObj[hero].healthPoints}\n  MP: ${heroesObj[hero].manaPoints}`);
  }
}

// solve([
//   "2",
//   "Solmyr 85 120",
//   "Kyrre 99 50",
//   "Heal - Solmyr - 10",
//   "Recharge - Solmyr - 50",
//   "TakeDamage - Kyrre - 66 - Orc",
//   "CastSpell - Kyrre - 15 - ViewEarth",
//   "End",
// ]);

solve([
  "4",
  "Adela 90 150",
  "SirMullich 70 40",
  "Ivor 1 111",
  "Tyris 94 61",
  "Heal - SirMullich - 50",
  "Recharge - Adela - 100",
  "CastSpell - Tyris - 1000 - Fireball",
  "TakeDamage - Tyris - 99 - Fireball",
  "TakeDamage - Ivor - 3 - Mosquito",
  "End",
]);
