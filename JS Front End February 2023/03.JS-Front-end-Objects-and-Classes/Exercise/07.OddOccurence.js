function oddOccurrence(input) {
  const toLowerCaseArr = input.toLowerCase().split(" ");

  let oddWords = {};

  for (let i = 0; i < toLowerCaseArr.length; i++) {
    let currentWord = toLowerCaseArr[i];

    if (oddWords.hasOwnProperty(currentWord)) {
      oddWords[currentWord]++;
    } else {
      oddWords[currentWord] = 1;
    }
  }

  let filteredOddWords = Object.keys(oddWords).filter(
    (key) => oddWords[key] % 2 !== 0
  );

  console.log(filteredOddWords.join(" "));
}
// *** Different Solution ***

//   toLowerCaseArr.forEach(word => {
//     oddOccurrence[word] = (oddOccurrence[word] || 0) + 1;
//   });

//   const oddWords = Object.keys(oddOccurrence).filter(word => oddOccurrence[word] % 2 !== 0);

//   let result = "";

//   for (const word of oddWords) {
//    result += word + " ";
//   }
//   console.log(result);
oddOccurrence("Java C# Php PHP Java PhP 3 C# 3 1 5 C#");
oddOccurrence("Cake IS SWEET is Soft CAKE sweet Food");
