function listOfNames(inputNames) {
    // * Solution with functional *
    return [...inputNames]
    .sort((aName, bName) => aName.localeCompare(bName))
    .map((name, index) => `${index + 1}.${name}`)
    .join("\n");

    //* Solution with for loop *
//   let sortedNames = [...inputNames].sort((aName, bName) => aName.localeCompare(bName));
  
//   for (let index = 0; index < sortedNames.length; index++) {
//         console.log(`${index + 1}.${sortedNames[index]}`)
//   }
}
console.log(listOfNames(["John", "Bob", "Christina", "Ema"]));
