function stringSubstring(inputWord, text) {
    // * Solution One * //
//     return text.toLowerCase()
//     .split(" ")
//     .some((word) => word === inputWord.toLowerCase()) ? inputWord : `${inputWord} not found!`
// }

//     * Solution Two *
  let toLowerCaseWord = inputWord.toLowerCase();
  let textArr = text.split(" ");

  for (const word of textArr) {
    if (word.toLowerCase() === toLowerCaseWord) {
      return inputWord;
    }
  }
  return `${inputWord} not found!`;
}

console.log(
  stringSubstring("javascript", "JavaScript is the best programming language")
);
console.log(
  stringSubstring("python", "JavaScript is the best programming language")
);
