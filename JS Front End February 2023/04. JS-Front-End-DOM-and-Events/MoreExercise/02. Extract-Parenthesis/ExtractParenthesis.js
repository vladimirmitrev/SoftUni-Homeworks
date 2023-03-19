function extract(content) {
  const element = document.getElementById(content);
  let contentText = element.textContent;
  let pattern = /(?<=\()[A-Za-z\s]+(?=\))/gm;
  let matchWords = contentText.match(pattern);

  return matchWords.join("; ");
}

// function extract(content) {
//     const string = document.querySelector(`#${content}`)
//    return  string.textContent.match(/\((.*?)\)/g).map(x => x.slice(1, -1)).join('; ')
// }
