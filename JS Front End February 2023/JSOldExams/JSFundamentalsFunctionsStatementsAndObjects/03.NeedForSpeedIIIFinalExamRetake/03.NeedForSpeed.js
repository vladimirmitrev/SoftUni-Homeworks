function needForSpeed(input) {
  let numberOfCars = Number(input.shift());

  let carsObj = {};

  for (let index = 0; index < numberOfCars; index++) {
    let [make, mileage, fuel] = input.shift().split("|");

    mileage = Number(mileage);
    fuel = Number(fuel);

    carsObj[make] = { mileage, fuel };
  }

  for (let inputLine of input) {
    if (inputLine === "Stop") {
      break;
    }
    let tokens = inputLine.split(" : ");
    let command = tokens[0];
    let carMake = tokens[1];
    let mileageInput = Number(tokens[2]);
    let fuelInput = Number(tokens[3]);

    if (command === "Drive") {
      if (carsObj[carMake].fuel < fuelInput) {
        console.log("Not enough fuel to make that ride");
      } else {
        carsObj[carMake].fuel -= fuelInput;
        carsObj[carMake].mileage += mileageInput;
        console.log(`${carMake} driven for ${mileageInput} kilometers. ${fuelInput} liters of fuel consumed.`)
        if (carsObj[carMake].mileage >= 100000) {
          delete carsObj[carMake];
          console.log(`Time to sell the ${carMake}!`);
        }
      }
    } else if (command === "Refuel") {
        let fuelInput = Number(tokens[2]);
        let currentFuelInCar = carsObj[carMake].fuel;
      carsObj[carMake].fuel += fuelInput;
      if (carsObj[carMake].fuel >= 75) {
        carsObj[carMake].fuel = 75;
        console.log(`${carMake} refueled with ${75 - currentFuelInCar} liters`);
      } else {
        console.log(`${carMake} refueled with ${fuelInput} liters`);
      }
    } else if (command === "Revert") {
      carsObj[carMake].mileage -= mileageInput;
      if (carsObj[carMake].mileage >= 10000) {
        console.log(`${carMake} mileage decreased by ${mileageInput} kilometers`);
      } else {
        carsObj[carMake].mileage = 10000;
      }
    }
    
  }

  for (const key in carsObj) {
    console.log(`${key} -> Mileage: ${carsObj[key].mileage} kms, Fuel in the tank: ${carsObj[key].fuel} lt.`)
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


// needForSpeed([
//     '4',
//     'Lamborghini Veneno|11111|74',
//     'Bugatti Veyron|12345|67',
//     'Koenigsegg CCXR|67890|12',
//     'Aston Martin Valkryie|99900|50',
//     'Drive : Koenigsegg CCXR : 382 : 82',
//     'Drive : Aston Martin Valkryie : 99 : 23',
//     'Drive : Aston Martin Valkryie : 2 : 1',
//     'Refuel : Lamborghini Veneno : 40',
//     'Revert : Bugatti Veyron : 2000',
//     'Stop'
//   ]  
//   )