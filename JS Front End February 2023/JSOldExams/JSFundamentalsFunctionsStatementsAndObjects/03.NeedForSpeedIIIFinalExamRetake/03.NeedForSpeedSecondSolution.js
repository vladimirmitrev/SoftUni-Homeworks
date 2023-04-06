function needForSpeed(input) {
  let numberOfCars = Number(input.shift());

  let carsObj = {};

  for (let index = 0; index < numberOfCars; index++) {
    let [make, mileage, fuel] = input.shift().split("|");

    mileage = parseInt(mileage);
    fuel = parseInt(fuel);

    carsObj[make] = { mileage, fuel };
  }

  while (input[0] !== "Stop") {
    let tokens = input.shift().split(" : ");
    let command = tokens[0];
    let carMake = tokens[1];
    if (command === "Drive") {
      let distance = parseInt(tokens[2]);
      let fuelNeeded = parseInt(tokens[3]);
      if (fuelNeeded > carsObj[carMake].fuel) {
        console.log(`Not enough fuel to make that ride`);
      } else {
        carsObj[carMake].mileage += distance;
        carsObj[carMake].fuel -= fuelNeeded;
        console.log(
          `${carMake} driven for ${distance} kilometers. ${fuelNeeded} liters of fuel consumed.`
        );
        if (carsObj[carMake].mileage >= 100000) {
          delete carsObj[carMake];
          console.log(`Time to sell the ${carMake}!`);
        }
      }
    } else if (command == "Refuel") {
      let fuelAdded = parseInt(tokens[2]);
      let currentFuel = carsObj[carMake].fuel;
      carsObj[carMake].fuel += fuelAdded;
      if (carsObj[carMake].fuel > 75) {
        carsObj[carMake].fuel = 75;
        fuelAdded = 75 - currentFuel;
      }
      console.log(`${carMake} refueled with ${fuelAdded} liters`);

    } else if (command == "Revert") {
      let revertKilometers = parseInt(tokens[2]);
      carsObj[carMake].mileage -= revertKilometers;
      if (carsObj[carMake].mileage < 10000) {
        carsObj[carMake].mileage = 10000;
      } else {
        console.log(
          `${carMake} mileage decreased by ${revertKilometers} kilometers`
        );
      }
    }
  }
  for (const car in carsObj) {
    let mileage = carsObj[car].mileage;
    let fuel = carsObj[car].fuel;
    console.log(`${car} -> Mileage: ${mileage} kms, Fuel in the tank: ${fuel} lt.`)
  }
}

needForSpeed([
  "3",
  "Audi A6|38000|62",
  "Mercedes CLS|11000|35",
  "Volkswagen Passat CC|45678|5",
  "Drive : Audi A6 : 543 : 47",
  "Drive : Mercedes CLS : 94 : 11",
  "Drive : Volkswagen Passat CC : 69 : 8",
  "Refuel : Audi A6 : 50",
  "Revert : Mercedes CLS : 500",
  "Revert : Audi A6 : 30000",
  "Stop",
]);

needForSpeed([
  "4",
  "Lamborghini Veneno|11111|74",
  "Bugatti Veyron|12345|67",
  "Koenigsegg CCXR|67890|12",
  "Aston Martin Valkryie|99900|50",
  "Drive : Koenigsegg CCXR : 382 : 82",
  "Drive : Aston Martin Valkryie : 99 : 23",
  "Drive : Aston Martin Valkryie : 2 : 1",
  "Refuel : Lamborghini Veneno : 40",
  "Revert : Bugatti Veyron : 2000",
  "Stop",
]);
