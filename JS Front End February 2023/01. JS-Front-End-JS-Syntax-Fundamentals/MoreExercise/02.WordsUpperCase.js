function wordsUpperCase(text) {
  let regex = /\b\w+\b/g;

  let result = [];

  let matches = text.matchAll(regex);

  for (const match of matches) {
    result.push(match[0].toUpperCase());
  }

  console.log(result.join(", "));
}

wordsUpperCase("Hi, how are you?");
wordsUpperCase("hello");
