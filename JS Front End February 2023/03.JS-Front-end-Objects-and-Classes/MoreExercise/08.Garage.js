function garageParser(inputArr) {
  let garage = {};

  for (const line of inputArr) {
    let [garageNum, carInfo] = line.split(" - ");

    if (!garage.hasOwnProperty(garageNum)) {
      garage[garageNum] = [];
    }

    let carSpecs = carInfo.split(", ").map((info) => info.split(": "));

    let carObj = {};

    for (const [key, value] of carSpecs) {
      carObj[key] = value;
    }
    garage[garageNum].push(carObj);
  }

  for (const garageNum of Object.keys(garage)) {
    console.log(`Garage № ${garageNum}`);
    for (const car of garage[garageNum]) {
      let carInfo = Object.entries(car)
        .map(([key, value]) => `${key} - ${value}`)
        .join(", ");
      console.log(`--- ${carInfo}`);
    }
  }
  // for (const key in garage) {
  //   console.log(`Garage № ${key}`);
  //   let carInfo = garage[key].carObj;
  //   for (const car of carObj) {
  //     let property = [];
  //     for (const prop in car) {
  //       property.push(`${prop} = ${car[prop]}`);
  //     }
  //     console.log(`--- ${property.join(", ")}`);
  //   }
  // }
}

garageParser([
  "1 - color: blue, fuel type: diesel",
  "1 - color: red, manufacture: Audi",
  "2 - fuel type: petrol",
  "4 - color: dark blue, fuel type: diesel, manufacture: Fiat",
]);
