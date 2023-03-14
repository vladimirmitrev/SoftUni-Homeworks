function sequences(inputArr) {
  let arraysSet = new Set();

  inputArr.forEach((element) => {
    let parsedArr = JSON.parse(element);
    let sortedArr = parsedArr.sort((a, b) => b - a);
    let newArr = JSON.stringify(sortedArr);
    arraysSet.add(newArr);
  });

  let result = [];

  for (const array of inputArr) {
    let currentArray = JSON.parse(array).sort((a, b) => b - a);
    if (arraysSet.has(JSON.stringify(currentArray))) {
      result.push(currentArray);
      arraysSet.delete(JSON.stringify(currentArray));
    }
  }
  result
  .sort((a, b) => a.length - b.length)
  .forEach((arr) => console.log(`[${arr.join(", ")}]`));
}

sequences([
  "[-3, -2, -1, 0, 1, 2, 3, 4]",
  "[10, 1, -17, 0, 2, 13]",
  "[4, -3, 3, -2, 2, -1, 1, 0]",
]);
sequences([
  "[7.14, 7.180, 7.339, 80.099]",
  "[7.339, 80.0990, 7.140000, 7.18]",
  "[7.339, 7.180, 7.14, 80.099]",
]);
