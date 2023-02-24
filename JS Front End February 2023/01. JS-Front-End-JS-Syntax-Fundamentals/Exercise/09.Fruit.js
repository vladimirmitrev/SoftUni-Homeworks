function fruit(fruitType, weightInGrams, pricePerKg) {
  let weightInKg = weightInGrams / 1000;
  let moneyNeeded = pricePerKg * weightInKg;

  console.log(`I need $${moneyNeeded.toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${fruitType}.`)
}

fruit("orange", 2500, 1.8);
fruit("apple", 1563, 2.35);
