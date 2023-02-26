function gladiatorExpenses(
  lostFights,
  helmetPrice,
  swordPrice,
  shieldPrice,
  armorPrice
) {
  let brokenHelmets = 0;
  let brokenSwords = 0;
  let brokenShields = 0;
  let brokenArmors = 0;

  for (let currentFight = 1; currentFight <= lostFights; currentFight++) {
    if (currentFight % 2 === 0) {
      brokenHelmets++;
    }
    if (currentFight % 3 === 0) {
      brokenSwords++;
    }
    if (currentFight % 6 === 0) {
      brokenShields++;
    }
    if (currentFight % 12 === 0) {
      brokenArmors++;
    }
  }

  let helmetExpenses = brokenHelmets * helmetPrice;
  let swordExpenses = brokenSwords * swordPrice;
  let shieldExpenses = brokenShields * shieldPrice;
  let armorExpenses = brokenArmors * armorPrice;

  let totalExpenses =
    helmetExpenses + swordExpenses + shieldExpenses + armorExpenses;

  console.log(`Gladiator expenses: ${totalExpenses.toFixed(2)} aureus`);
}

gladiatorExpenses(7, 2, 3, 4, 5);
gladiatorExpenses(23, 12.5, 21.5, 40, 200);
