function extractText() {
  const liItems = Array.from(document.getElementsByTagName("li"));
  const result = document.getElementById("result");

  liItems.forEach((li) => {
    result.textContent += li.textContent + "\n";
  });
}
