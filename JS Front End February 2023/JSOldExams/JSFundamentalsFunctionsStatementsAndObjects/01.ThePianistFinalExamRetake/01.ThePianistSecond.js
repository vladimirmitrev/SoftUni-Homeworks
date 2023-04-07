function thePianist(input) {
  let numberOfPieces = Number(input.shift());

  let piecesObj = {};

  for (let index = 0; index < numberOfPieces; index++) {
    let [piece, composer, tone] = input.shift().split("|");

    piecesObj[piece] = { composer, tone };
  }

  while (input[0] !== "Stop") {
    let tokens = input.shift().split("|");
    let command = tokens[0];
    let piece = tokens[1];
    let composer = tokens[2];
    let tone = tokens[3];

    if (command === "Add") {
      if (!piecesObj.hasOwnProperty(piece)) {
        piecesObj[piece] = { composer, tone };
        console.log(`${piece} by ${composer} in ${tone} added to the collection!`);
      } else {
        console.log(`${piece} is already in the collection!`);
      }
    } else if (command === "Remove") {
        if(piecesObj.hasOwnProperty(piece)) {
            delete piecesObj[piece];
            console.log(`Successfully removed ${piece}!`)
        } else {
            console.log(`Invalid operation! ${piece} does not exist in the collection.`)
        }
    } else if (command === "ChangeKey") {
        let newTone = tokens[2];
        if(piecesObj.hasOwnProperty(piece)) {
            piecesObj[piece].tone = newTone;
            console.log(`Changed the key of ${piece} to ${newTone}!`)
        } else {
            console.log(`Invalid operation! ${piece} does not exist in the collection.`)
        }
    }
  }

  for (const piece in piecesObj) {
        let composer = piecesObj[piece].composer;
        let tone = piecesObj[piece].tone;
        console.log(`${piece} -> Composer: ${composer}, Key: ${tone}`)
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

// thePianist([
//   "4",
//   "Eine kleine Nachtmusik|Mozart|G Major",
//   "La Campanella|Liszt|G# Minor",
//   "The Marriage of Figaro|Mozart|G Major",
//   "Hungarian Dance No.5|Brahms|G Minor",
//   "Add|Spring|Vivaldi|E Major",
//   "Remove|The Marriage of Figaro",
//   "Remove|Turkish March",
//   "ChangeKey|Spring|C Major",
//   "Add|Nocturne|Chopin|C# Minor",
//   "Stop",
// ]);
