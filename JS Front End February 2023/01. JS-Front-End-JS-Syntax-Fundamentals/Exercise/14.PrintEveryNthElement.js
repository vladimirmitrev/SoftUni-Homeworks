function printNthElement(stringArr, step) {
  let modifiedArr = [];

  for (let i = 0; i < stringArr.length; i += step) {
    modifiedArr.push(stringArr[i]);
  }
  return modifiedArr;
}
console.log(printNthElement(["5", "20", "31", "4", "20"], 2));
console.log(printNthElement(["dsa", "asd", "test", "tset"], 2));
console.log(printNthElement(["1", "2", "3", "4", "5"], 6));

