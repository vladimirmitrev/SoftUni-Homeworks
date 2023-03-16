function addItem() {
  const ulContainer = document.getElementById("items");
  const inputText = document.getElementById("newItemText");
  const newRow = document.createElement("li");

  newRow.textContent = inputText.value;
  ulContainer.appendChild(newRow);
  inputText.value = "";
}
