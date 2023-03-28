window.addEventListener("load", solve);

function solve() {
  const carMakeInput = document.getElementById("make");
  const carModelInput = document.getElementById("model");
  const carYearInput = document.getElementById("year");
  const carFuelTypeInput = document.getElementById("fuel");
  const carOriginalCostInput = document.getElementById("original-cost");
  const carSellingPriceInput = document.getElementById("selling-price");
  const tableBody = document.getElementById("table-body");
  const publishBtn = document.getElementById("publish");
  const soldCarsList = document.getElementById("cars-list");
  let soldCars = document.getElementById("profit");  

  let totalProfit = 0;

  publishBtn.addEventListener("click", publishHandler);

  function publishHandler(event) {
    event.preventDefault();

    const carMake = carMakeInput.value;
    const carModel = carModelInput.value;
    const carYear = carYearInput.value;
    const carFuelType = carFuelTypeInput.value;
    const carOriginalCost = carOriginalCostInput.value;
    const carSellingPrice = carSellingPriceInput.value;

    if (
      carMake === "" ||
      carModel === "" ||
      carFuelType === "" ||
      carYear === "" ||
      carOriginalCost === "" ||
      carSellingPrice === "" ||
      carSellingPrice < carOriginalCost
    ) {
      return;
    }

    const tableRow = document.createElement("tr");
    tableRow.setAttribute("class", "row");

    const makeTd = document.createElement("td");
    makeTd.textContent = carMake;

    const modelTd = document.createElement("td");
    modelTd.textContent = carModel;

    const yearTd = document.createElement("td");
    yearTd.textContent = carYear;

    const fuelTd = document.createElement("td");
    fuelTd.textContent = carFuelType;

    const originalCostTd = document.createElement("td");
    originalCostTd.textContent = carOriginalCost;

    const sellingPriceTd = document.createElement("td");
    sellingPriceTd.textContent = carSellingPrice;

    const actionTd = document.createElement("td");

    const editBtn = document.createElement("button");
    editBtn.classList.add("action-btn");
    editBtn.classList.add("edit");
    editBtn.textContent = "Edit";

    const sellBtn = document.createElement("button");
    sellBtn.classList.add("action-btn");
    sellBtn.classList.add("sell");
    sellBtn.textContent = "Sell";

    actionTd.appendChild(editBtn);
    actionTd.appendChild(sellBtn);

    tableRow.appendChild(makeTd);
    tableRow.appendChild(modelTd);
    tableRow.appendChild(yearTd);
    tableRow.appendChild(fuelTd);
    tableRow.appendChild(originalCostTd);
    tableRow.appendChild(sellingPriceTd);
    tableRow.appendChild(actionTd);
    tableBody.appendChild(tableRow);

    carMakeInput.value = "";
    carModelInput.value = "";
    carYearInput.value = "";
    carFuelTypeInput.value = "";
    carOriginalCostInput.value = "";
    carSellingPriceInput.value = "";

    editBtn.addEventListener("click", editHandler);

    sellBtn.addEventListener("click", sellHandler);

    function editHandler(event) {
      carMakeInput.value = carMake;
      carModelInput.value = carModel;
      carYearInput.value = carYear;
      carFuelTypeInput.value = carFuelType;
      carOriginalCostInput.value = carOriginalCost;
      carSellingPriceInput.value = carSellingPrice;

      // event.target.parentElement.parentElement.remove();
      tableRow.remove();
    }

    function sellHandler(event) {

      tableRow.remove();

      // event.target.parentElement.parentElement.remove();

      const sellListLi = document.createElement("li");
      sellListLi.classList.add("each-list");

      const makeSpan = document.createElement("span");
      makeSpan.textContent = carMake + " " + carModel;

      const yearSpan = document.createElement("span");
      yearSpan.textContent = carYear;

      let profitMade = Number(carSellingPrice) - Number(carOriginalCost);
    
      const profitSpan = document.createElement("span");
      profitSpan.textContent = profitMade;

      totalProfit += profitMade;

      soldCars.textContent = totalProfit.toFixed(2);

      sellListLi.appendChild(makeSpan);
      sellListLi.appendChild(yearSpan);
      sellListLi.appendChild(profitSpan);

      soldCarsList.appendChild(sellListLi);
    }
  }
}
