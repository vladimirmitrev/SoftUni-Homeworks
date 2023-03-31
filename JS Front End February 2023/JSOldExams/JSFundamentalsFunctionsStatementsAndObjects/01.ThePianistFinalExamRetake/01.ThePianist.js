function thePianist(input) {
  let numberOfPieces = Number(input.shift());

  let piecesObj = {};

  for (let index = 0; index < numberOfPieces; index++) {
    let [piece, composer, tone] = input.shift().split("|");

    piecesObj[piece] = { composer, tone };
  }

  while (input[0] !== "Stop") {
    if (input[0] === "Stop") {
      break;
    }
    let line = input.shift().split("|");
    let command = line[0];
    let piece = line[1];
    let composer = line[2];
    let tone = line[3];

    switch (command) {
      case "Add":
        if (piecesObj.hasOwnProperty(piece)) {
          console.log(`${piece} is already in the collection!`);
        } else {
          piecesObj[piece] = {composer, tone };
          console.log(
            `${piece} by ${composer} in ${tone} added to the collection!`
          );
        }
        break;

      case "Remove":
        if (piecesObj.hasOwnProperty(piece)) {
          delete piecesObj[piece];
          console.log(`Successfully removed ${piece}!`);
        } else {
          console.log(
            `Invalid operation! ${piece} does not exist in the collection.`
          );
        }
        break;

      case "ChangeKey":
        let newTone = line[2];
        if (piecesObj.hasOwnProperty(piece)) {
          piecesObj[piece].tone = newTone;
          console.log(`Changed the key of ${piece} to ${newTone}!`);
        } else {
          console.log(
            `Invalid operation! ${piece} does not exist in the collection.`
          );
        }
        break;
    }
  }

  for (const piece in piecesObj) {
      console.log(`${piece} -> Composer: ${piecesObj[piece].composer}, Key: ${piecesObj[piece].tone}`)
  }
} 

thePianist([
  "3",
  "Fur Elise|Beethoven|A Minor",
  "Moonlight Sonata|Beethoven|C# Minor",
  "Clair de Lune|Debussy|C# Minor",
  "Add|Sonata No.2|Chopin|B Minor",
  "Add|Hungarian Rhapsody No.2|Liszt|C# Minor",
  "Add|Fur Elise|Beethoven|C# Minor",
  "Remove|Clair de Lune",
  "ChangeKey|Moonlight Sonata|C# Major",
  "Stop",
]);
