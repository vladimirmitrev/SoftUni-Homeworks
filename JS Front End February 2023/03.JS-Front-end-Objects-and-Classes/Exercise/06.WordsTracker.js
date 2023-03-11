function wordTracker(inputArr) {
  let wordsToTrack = inputArr.shift().split(" ");

  let words = {};

  for (const word of wordsToTrack) {
    let count = inputArr.filter((w) => w === word).length;
    words[word] = count;
  }

  let sortedWords = Object.entries(words).sort((aWord, bWord) => {
    let [_aName, aCount] = aWord;
    let [_bName, bCount] = bWord;

    return bCount - aCount;
  });

  for (const [word, count] of sortedWords) {
    console.log(`${word} - ${count}`);
  }
}

wordTracker([
  "this sentence",
  "In",
  "this",
  "sentence",
  "you",
  "have",
  "to",
  "count",
  "the",
  "occurrences",
  "of",
  "the",
  "words",
  "this",
  "and",
  "sentence",
  "because",
  "this",
  "is",
  "your",
  "task",
]);
wordTracker([
  "is the",
  "first",
  "sentence",
  "Here",
  "is",
  "another",
  "the",
  "And",
  "finally",
  "the",
  "the",
  "sentence",
]);
