window.addEventListener("load", solve);

function solve() {
  const makeInput = document.querySelector("#make");
  const modelInput = document.querySelector("#model");
  const yearInput = document.querySelector("#year");
  const fuelInput = document.querySelector("#fuel");
  const originalCostInput = document.querySelector("#original-cost");
  const sellingPriceInput = document.querySelector("#selling-price");
  const publishBtn = document.querySelector("#publish");
  const tableBody = document.querySelector("#table-body");
  const soldCarList = document.querySelector("#cars-list");
  const profitElement = document.querySelector("#profit");

  let totalProfit = 0;

  publishBtn.addEventListener("click", publishBtnHandler);

  function publishBtnHandler(event) {
    event.preventDefault();

    let make = makeInput.value;
    let model = modelInput.value;
    let year = yearInput.value;
    let fuel = fuelInput.value;
    let originalCost = Number(originalCostInput.value);
    let sellingPrice = Number(sellingPriceInput.value);

    if (
      !make ||
      !model ||
      !year ||
      !fuel ||
      !originalCost ||
      !sellingPrice ||
      originalCost > sellingPrice
    ) {
      return;
    }

    const tableRow = createElement("tr", null, tableBody, ["row"]);
    createElement("td", `${make}`, tableRow);
    createElement("td", `${model}`, tableRow);
    createElement("td", `${year}`, tableRow);
    createElement("td", `${fuel}`, tableRow);
    createElement("td", `${originalCost}`, tableRow);
    createElement("td", `${sellingPrice}`, tableRow);

    let buttonsTd = createElement("td", null, tableRow);
    let editBtn = createElement("button", "Edit", tableRow, [
      "action-btn",
      "edit",
    ]);
    let sellBtn = createElement("button", "Sell", tableRow, [
      "action-btn",
      "sell",
    ]);

    makeInput.value = "";
    modelInput.value = "";
    yearInput.value = "";
    fuelInput.value = "";
    originalCostInput.value = "";
    sellingPriceInput.value = "";

    editBtn.addEventListener("click", editBtnHandler);

    sellBtn.addEventListener("click", sellBtnHandler);

    function sellBtnHandler(){
      debugger
      tableRow.remove();
      let profitMade = sellingPrice - originalCost;
      let li = createElement("li", null, soldCarList, ["each-list"]);
      createElement("span", `${make} ${model}`, li);
      createElement("span", `${year}`, li);
      createElement("span", `${profitMade}`, li);

      totalProfit += profitMade;
      profitElement.textContent = `${totalProfit.toFixed(2)}`;

    }

    function editBtnHandler() {
      tableRow.remove();

      makeInput.value = make
      modelInput.value = model;
      yearInput.value = year;
      fuelInput.value = fuel;
      originalCostInput.value = originalCost;
      sellingPriceInput.value = sellingPrice;
    }
  }
  function createElement(type, text, parent, classes) {
    let element = document.createElement(type);

    if (text) {
      element.textContent = text;
    }
    if (parent) {
      parent.appendChild(element);
    }

    if (classes) {
      element.classList.add(...classes);
    }
    return element;
  }
}
