function solve() {
  const inputText = document.getElementById("text").value;
  const namingConvention = document.getElementById("naming-convention").value;
  const resultSpan = document.getElementById("result");

  let text = inputText.toLowerCase().split(" ");
  let result = "";

  if (namingConvention === "Camel Case") {
    for (let index = 0; index < text.length; index++) {
      if (index === 0) {
        result = text[0];
      } else {
        result += text[index].charAt(0).toUpperCase() + text[index].slice(1);
      }
    }

    resultSpan.textContent = result;
  } else if (namingConvention === "Pascal Case") {
    for (let index = 0; index < text.length; index++) {
      result += text[index].charAt(0).toUpperCase() + text[index].slice(1);
    }

    resultSpan.textContent = result;
  } else {
    resultSpan.textContent = "Error!";
  }

  console.log(result);
}
