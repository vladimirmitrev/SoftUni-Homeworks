function revealWords(words, text) {
  let wordsArr = words.split(", ");
  let textArr = text.split(" ");

//   for (let word of wordsArr) {
//     for (let element of textArr) {
//       if (element.includes("*") && element.length === word.length) {
//         text = text.replace(element, word);
//       }
//     }
//   }
  for (let i = 0; i < wordsArr.length; i++) {
    for (let j = 0; j < textArr.length; j++) {
      if (
        textArr[j].length === wordsArr[i].length &&
        textArr[j].includes("*".repeat(wordsArr[i].length))) {
        textArr[j] = wordsArr[i];
      }
    }
  }
  console.log(textArr.join(" "));
}

revealWords(
  "great",
  "softuni is ***** place for learning new programming languages"
);

revealWords(
  "great, learning",
  "softuni is ***** place for ******** new programming languages"
);
