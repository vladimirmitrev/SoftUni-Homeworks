window.addEventListener("load", solve);

function solve() {
  const modelInput = document.getElementById("model");
  const yearInput = document.getElementById("year");
  const descriptionInput = document.getElementById("description");
  const priceInput = document.getElementById("price");
  const addBtn = document.getElementById("add");

  const tableBody = document.getElementById("furniture-list");
  
  let totalPrice = 0;

  addBtn.addEventListener("click", addProduct);

  function addProduct(e) {
    e.preventDefault();

    const model = modelInput.value;
    const year = Number(yearInput.value);
    const description = descriptionInput.value;
    const price = Number(priceInput.value);

    if (
      model === "" ||
      year === "" ||
      description === "" ||
      price === "" ||
      year <= 0 ||
      price <= 0
    ) {
      return;
    }

    let infoRow = document.createElement("tr");
    infoRow.classList.add("info");

    let modelTd = document.createElement("td");
    modelTd.textContent = model;

    let priceTd = document.createElement("td");

    priceTd.textContent = price.toFixed(2);

    let actionTd = document.createElement("td");

    let moreBtn = document.createElement("button");
    moreBtn.classList.add("moreBtn");
    moreBtn.textContent = "More Info";

    let buyBtn = document.createElement("button");
    buyBtn.classList.add("buyBtn");
    buyBtn.textContent = "Buy it";

    let hideRow = document.createElement("tr");
    hideRow.classList.add("hide");
    hideRow.style.display = "none";

    let yearTd = document.createElement("td");
    yearTd.textContent = `Year: ${year}`;

    let descriptionTd = document.createElement("td");
    descriptionTd.textContent = `Description: ${description}`;
    descriptionTd.setAttribute("colSpan", 3)

    actionTd.appendChild(moreBtn);
    actionTd.appendChild(buyBtn);

    infoRow.appendChild(modelTd);
    infoRow.appendChild(priceTd);
    infoRow.appendChild(actionTd);

    hideRow.appendChild(yearTd);
    hideRow.appendChild(descriptionTd);

    tableBody.appendChild(infoRow);
    tableBody.appendChild(hideRow);

    modelInput.value = "";
    yearInput.value = "";
    descriptionInput.value = "";
    priceInput.value = "";

    moreBtn.addEventListener("click", () => {
      if (moreBtn.textContent === "More Info") {
        hideRow.style.display = "contents";
        moreBtn.textContent = "Less Info";
      } else {
        hideRow.style.display = "none";
        moreBtn.textContent = "More Info";
      }
    });

    buyBtn.addEventListener("click", (e) => {
      //    tableBody.removeChild(hideRow)
      //    tableBody.removeChild(infoRow);
      hideRow.remove();
      infoRow.remove();

      totalPrice += price;

      const totalProfit = document.querySelector(".total-price");
      totalProfit.textContent = totalPrice.toFixed(2);
    });
  }
}
