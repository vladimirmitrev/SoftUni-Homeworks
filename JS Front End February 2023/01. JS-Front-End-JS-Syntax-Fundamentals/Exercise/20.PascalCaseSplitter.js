function pascalCaseSplitter(text) {

  // * Solution One with REGEX *

  let result = text.split(/(?=[A-Z])/);

  console.log(result.join(", "));

  // * Solution Two without REGEX *

  // let output = "";

  // for (const symbol of text) {
  //     const asciiCode = symbol.charCodeAt(0);
  //     if (asciiCode >= 65 && asciiCode <= 90) {
  //         if(output.length > 0) {
  //             output += ", ";
  //         }
  //         output += symbol;
  //     } else {
  //         output += symbol;
  //     }
  // }
  // console.log(output);
}

pascalCaseSplitter("SplitMeIfYouCanHaHaYouCantOrYouCan");
pascalCaseSplitter("HoldTheDoor");
pascalCaseSplitter("ThisIsSoAnnoyingToDo");
