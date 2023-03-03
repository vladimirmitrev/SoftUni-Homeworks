function charactersInRange(firstChar, secondChar) {
  const getCharAsciiCode = (char) => char.charCodeAt(0);
  let firstCharAscii = getCharAsciiCode(firstChar);
  let secondCharAscii = getCharAsciiCode(secondChar);

  let minAscii = Math.min(firstCharAscii, secondCharAscii);
  let maxAscii = Math.max(firstCharAscii, secondCharAscii);
  let chars = [];

  for (let currentChar = minAscii + 1; currentChar < maxAscii; currentChar++) {
    chars.push(String.fromCharCode(currentChar));
  }
  
  return chars.join(" ");
}

console.log(charactersInRange("a", "d"));
console.log(charactersInRange("#", ":"));
console.log(charactersInRange("C", "#"));

