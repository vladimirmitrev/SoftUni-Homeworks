function addItem() {
  const dropDownMenu = document.getElementById("menu");
  const newItemTextInput = document.getElementById("newItemText");
  const newItemValueInput = document.getElementById("newItemValue");

  const newItemText = newItemTextInput.value;
  const newItemValue = newItemValueInput.value;

  const option = document.createElement("option");

  option.textContent = newItemText;
  option.value = newItemValue;

  dropDownMenu.appendChild(option);

  newItemTextInput.value = "";
  newItemValueInput.value = "";
}
