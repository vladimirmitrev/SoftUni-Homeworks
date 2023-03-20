function search() {
  const searchedTextInput = document.getElementById("searchText");
  const towns = Array.from(document.querySelectorAll("ul li"));
  const searchedText = searchedTextInput.value;
  const result = document.getElementById("result");

  //Clearing the results
  result.textContent = "";

  for (const town of towns) {
    town.style.fontWeight = "";
    town.style.textDecoration = "";
  }
  ////
  let matchesFound = 0;

  for (const town of towns) {
    const searchedTown = town.textContent;

    if (searchedTown.includes(searchedText)) {
      town.style.fontWeight = "bold";
      town.style.textDecoration = "underline";
      matchesFound++;
    }
    result.textContent = `${matchesFound} matches found`;
  }
}
