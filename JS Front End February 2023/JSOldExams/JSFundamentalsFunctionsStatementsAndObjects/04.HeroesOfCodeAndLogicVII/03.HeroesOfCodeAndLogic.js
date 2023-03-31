function heroes(input) {
  let numberOfHeroes = Number(input.shift());

  let herosObj = {};

  for (let index = 0; index < numberOfHeroes; index++) {
    let [name, hitPoints, manaSpell] = input.shift().split(" ");

    hitPoints = Number(hitPoints);
    manaSpell = Number(manaSpell);

    herosObj[name] = { hitPoints, manaSpell };
  }

  while (input[0] !== "End") {
    if (input[0] === "End") {
      break;
    }
    //-	a hero can have a maximum of 100 HP and 200 MP
    let tokens = input.shift().split(" - ");
    let command = tokens[0];
    let heroName = tokens[1];

    if (command === "CastSpell") {
      let mpNeeded = Number(tokens[2]);
      let spellName = tokens[3];
      let manaLeft = herosObj[heroName].manaSpell;
      if (manaLeft >= mpNeeded) {
        manaLeft -= mpNeeded;
        console.log(
          `${heroName} has successfully cast ${spellName} and now has ${manaLeft} MP!"`
        );
        herosObj[heroName].manaSpell = manaLeft;
      } else {
        console.log(`${heroName} does not have enough MP to cast ${spellName}!`);
      }
    } else if (command === "TakeDamage") {
      let damage = Number(tokens[2]);
      let attacker = tokens[3];
      herosObj[heroName].hitPoints -= damage;
      if (herosObj[heroName].hitPoints <= 0) {
        delete herosObj[heroName];
        console.log(`${heroName} has been killed by ${attacker}!`);
      } else {
        let currentHp = herosObj[heroName].hitPoints;
        console.log(
          `${heroName} was hit for ${damage} HP by ${attacker} and now has ${currentHp} HP left!`
        );
      }
    } else if (command === "Recharge") {
      let amount = Number(tokens[2]);
      let currentMana = herosObj[heroName].manaSpell;
      herosObj[heroName].manaSpell += amount;
      if (herosObj[heroName].manaSpell > 200) {
        herosObj[heroName].manaSpell = 200;
        console.log(`${heroName} recharged for ${200 - currentMana} MP!`);
      } else {
        console.log(`${heroName} recharged for ${amount} MP!`);
      }
    } else if (command === "Heal") {
      let amount = Number(tokens[2]);
      let currentHitPoints = herosObj[heroName].hitPoints;
      herosObj[heroName].hitPoints += amount;
      if (herosObj[heroName].hitPoints > 100) {
        herosObj[heroName].hitPoints = 100;
        console.log(`${heroName} healed for ${100 - currentHitPoints} HP!`);
      } else {
        console.log(`${heroName} healed for ${amount} HP!`);
      }
    }
  }
  for (const key in herosObj) {
    console.log(`${key}\n  HP: ${herosObj[key].hitPoints}\n  MP: ${herosObj[key].manaSpell}`);
  }
}

heroes([
  "2",
  "Solmyr 85 120",
  "Kyrre 99 50",
  "Heal - Solmyr - 10",
  "Recharge - Solmyr - 50",
  "TakeDamage - Kyrre - 66 - Orc",
  "CastSpell - Kyrre - 15 - ViewEarth",
  "End",
]);

// heroes(["4",
//     "Adela 90 150",
//     "SirMullich 70 40",
//     "Ivor 1 111",
//     "Tyris 94 61",
//     "Heal - SirMullich - 50",
//     "Recharge - Adela - 100",
//     "CastSpell - Tyris - 1000 - Fireball",
//     "TakeDamage - Tyris - 99 - Fireball",
//     "TakeDamage - Ivor - 3 - Mosquito",
//     "End"
//     ])
