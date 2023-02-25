function modernTimes(text) {
  //   * Solution One with REGEX* //

  let textArr = text.split(" ");
  let arrToPrint = [];
  for (const word of textArr) {
    if (/^#[a-zA-Z]+$/.test(word)) {
      arrToPrint.push(word.slice(1));
    }
  }
  console.log(arrToPrint.join("\n"));
}
modernTimes("Nowadays everyone uses # to tag a #special word in #socialMedia");
modernTimes(
  "The symbol # is known #variously in English-speaking #regions as the #number sign"
);
// * Solution Two without REGEX * //

//   return text.split(" ")
//             .filter((word) => word.startsWith("#") && containsOnlyLetters(word))
//             .map((word) => word.slice(1))
//             .filter((word) => word != "")
//             .join("\n");
// }

// function containsOnlyLetters(word) {
//     return [...word.toLowerCase()]
//             .slice(1)
//             .map((symbol) => symbol.charCodeAt(0))
//             .every((charCode) => charCode >= 97 && charCode <= 122);
// }

// console.log(modernTimes("Nowadays everyone uses # to tag a #special word in #socialMedia"));
