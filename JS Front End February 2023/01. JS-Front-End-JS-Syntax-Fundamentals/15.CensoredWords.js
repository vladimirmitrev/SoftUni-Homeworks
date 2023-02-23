function censorWords(text, wordToCensor) {
  while (text.includes(wordToCensor)) {
    text = text.replace(wordToCensor, "*".repeat(wordToCensor.length));
  }
  console.log(text);
}

censorWords("A small sentence with some words", "small");
censorWords("Find the hidden word", "hidden");
