function convertToObject(input) {
  let data = JSON.parse(input);

  for (const key in data) {
    console.log(`${key}: ${data[key]}`);
  }
  
// **  Solution with for of **
//   for (const [key, value] of Object.entries(data)) {
//     console.log(`${key}: ${value}`);
//   }

}
convertToObject(`{"name": "George", "age": 40, "town": "Sofia"}`);
