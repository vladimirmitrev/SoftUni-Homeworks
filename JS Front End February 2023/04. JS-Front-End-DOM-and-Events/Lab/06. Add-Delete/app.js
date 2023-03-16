function addItem() {
  const ulContainer = document.getElementById("items");
  const inputText = document.getElementById("newItemText");
  const newRow = document.createElement("li");
  const newAnchor = document.createElement("a");

  newRow.textContent = inputText.value;
  newAnchor.textContent = "[Delete]";
  newAnchor.href = "#";
//   newAnchor.setAttribute("href", "#");
  newAnchor.addEventListener("click", deleteHandler);
  newRow.appendChild(newAnchor);
  ulContainer.appendChild(newRow);
  inputText.value = "";

  function deleteHandler(e) {
    const row = e.target.parentElement;
    row.remove();
    // *Other way *
    // const anchor = e.currentTarget;
    // anchor.parentElement.remove();
  }
}
