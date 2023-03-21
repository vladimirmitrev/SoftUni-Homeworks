function thePianist(input) {
  let initialPiecesCount = Number(input.shift());

  let initialPieces = {};

  for (let i = 0; i < initialPiecesCount; i++) {
    let [piece, composer, tone] = input.shift().split("|");

    initialPieces[piece] = { composer, tone };
  }

  for (const line of input) {
    let tokens = line.split("|");
    let command = tokens.shift();

    if (command === "Add") {
      let [piece, composer, tone] = tokens;
      if (!initialPieces.hasOwnProperty(piece)) {
        initialPieces[piece] = { composer, tone };
        console.log(
          `${piece} by ${composer} in ${tone} added to the collection!"`
        );
      } else {
        console.log(`${piece} is already in the collection!`);
      }
    } else if (command === "Remove") {
      let piece = tokens.shift();

      if (initialPieces.hasOwnProperty(piece)) {
        delete initialPieces[piece];
        console.log(`Successfully removed ${piece}!`);
      } else {
        console.log(
          `Invalid operation! ${piece} does not exist in the collection.`
        );
      }
    } else if (command === "ChangeKey") {
      let [piece, tone] = tokens;
      if (initialPieces.hasOwnProperty(piece)) {
        initialPieces[piece].tone = tone;
        console.log(`Changed the key of ${piece} to ${tone}!`);
      } else {
        console.log(
          `Invalid operation! ${piece} does not exist in the collection.`
        );
      }
    }
  }

  let entries = Object.entries(initialPieces);

  for (const [piece, info] of entries) {
    console.log(`${piece} -> Composer: ${info.composer}, Key: ${info.tone}`);
  }
}

// thePianist([
//   "3",
//   "Fur Elise|Beethoven|A Minor",
//   "Moonlight Sonata|Beethoven|C# Minor",
//   "Clair de Lune|Debussy|C# Minor",
//   "Add|Sonata No.2|Chopin|B Minor",
//   "Add|Hungarian Rhapsody No.2|Liszt|C# Minor",
//   "Add|Fur Elise|Beethoven|C# Minor",
//   "Remove|Clair de Lune",
//   "ChangeKey|Moonlight Sonata|C# Major",
//   "Stop",
// ]);

thePianist([
    '4',
    'Eine kleine Nachtmusik|Mozart|G Major',
    'La Campanella|Liszt|G# Minor',
    'The Marriage of Figaro|Mozart|G Major',
    'Hungarian Dance No.5|Brahms|G Minor',
    'Add|Spring|Vivaldi|E Major',
    'Remove|The Marriage of Figaro',
    'Remove|Turkish March',
    'ChangeKey|Spring|C Major',
    'Add|Nocturne|Chopin|C# Minor',
    'Stop'
  ]
  )