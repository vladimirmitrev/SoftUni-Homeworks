function solve() {
  const inputNumber = document.getElementById("input");
  const selectMenuTo = document.getElementById("selectMenuTo");
  const convertBtn = document.querySelector("button");
  const result = document.querySelector("#result");

  convertBtn.addEventListener("click", convertHandler);
  const binaryOption = document.createElement("option");
  binaryOption.value = "binary";
  binaryOption.textContent = "Binary";

  const hexadecimalOption = document.createElement("option");
  hexadecimalOption.value = "hexadecimal";
  hexadecimalOption.textContent = "Hexadecimal";

  selectMenuTo.appendChild(binaryOption);
  selectMenuTo.appendChild(hexadecimalOption);


  function convertHandler() {
    let [number, selectedOption] = [Number(inputNumber.value), selectMenuTo.value];
    // const selectedIndex = selectMenuTo.selectedIndex;
    // const selectedOption = selectMenuTo.options[selectedIndex].value;
    // let number = Number(inputNumber.value)
    if (selectedOption === "binary") {
      result.value = number.toString(2);
    } else if (selectedOption === "hexadecimal") {
      result.value = number.toString(16).toUpperCase();
    //   console.log(result.value);
    }
  }
}
