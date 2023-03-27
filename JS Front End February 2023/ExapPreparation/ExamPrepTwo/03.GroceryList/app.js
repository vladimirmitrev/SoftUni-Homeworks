const addBtn = document.getElementById("add-product");
const updateFormBtn = document.getElementById("update-product");
const loadAllBtn = document.querySelector("#load-product");
const tableBody = document.getElementById("tbody");

const productInput = document.getElementById("product");
const countInput = document.getElementById("count");
const priceInput = document.getElementById("price");

const BASE_URL = "http://localhost:3030/jsonstore/grocery/";

// let allCurrentProducts = {};
// let editProductId = null; 

loadAllBtn.addEventListener("click", loadAllHandler);

async function loadAllHandler(event) {
  if (event) {
    event.preventDefault();
  }

  tableBody.innerHTML = "";
  const response = await fetch(BASE_URL);
  const productsObj = await response.json();
//   allCurrentProducts = productsObj;
  for (const key in productsObj) {
    let { product, count, price, _id } = productsObj[key];

    let tableRow = document.createElement("tr");

    let productName = document.createElement("td");
    productName.classList.add("name");
    productName.textContent = product;

    let productCount = document.createElement("td");
    productCount.classList.add("count-product");
    productCount.textContent = count;

    let productPrice = document.createElement("td");
    productPrice.classList.add("product-price");
    productPrice.textContent = price;

    let actionTd = document.createElement("td");
    actionTd.classList.add("btn");

    let updateBtn = document.createElement("button");
    updateBtn.classList.add("update");
    updateBtn.textContent = "Update";
    // updateBtn.id = _id;
    updateBtn.addEventListener("click", updateProductHandler);

    let deleteBtn = document.createElement("button");
    deleteBtn.classList.add("delete");
    deleteBtn.textContent = "Delete";
    deleteBtn.id = _id;
    deleteBtn.addEventListener("click", deleteProductHandler);

    actionTd.appendChild(updateBtn);
    actionTd.appendChild(deleteBtn);

    tableRow.appendChild(productName);
    tableRow.appendChild(productCount);
    tableRow.appendChild(productPrice);
    tableRow.appendChild(actionTd);

    tableBody.appendChild(tableRow);

    function updateProductHandler(e) {
      e.preventDefault();

      productInput.value = product;
      countInput.value = count;
      priceInput.value = price;
      updateFormBtn.disabled = false;
      addBtn.disabled = true;

       

      updateFormBtn.addEventListener("click", updateFormBtnHandler);

      async function updateFormBtnHandler() {
        // Blocking to update product if input is empty
        if (
            productInput.value === "" ||
            countInput.value === "" ||
            priceInput.value === ""
          ) {
            return;
          }

        let id = _id;

        let editedProduct = productInput.value;
        let editedCount = countInput.value;
        let editedPrice = priceInput.value;

        let data = {
          product: editedProduct,
          count: editedCount,
          price: editedPrice,
        };
        let httpHandlers = {
          method: "PATCH",

          body: JSON.stringify(data),
        };

        await fetch(BASE_URL + id, httpHandlers);

        productInput.value = "";
        countInput.value = "";
        priceInput.value = "";

        updateFormBtn.disabled = true;
        addBtn.disabled = false;

        loadAllHandler();
      }
    }
  }
}

addBtn.addEventListener("click", addProductHandler);

async function addProductHandler(e) {
  e.preventDefault();

  let product = productInput.value;
  let count = countInput.value;
  let price = priceInput.value;

  // Block adding products without name, count or price

    if (product === "" || count === "" || price === "") {
      return;
    }

  let httpHandlers = {
    method: "POST",
    body: JSON.stringify({ product, count, price }),
  };

  await fetch(BASE_URL, httpHandlers);

  productInput.value = "";
  countInput.value = "";
  priceInput.value = "";

  loadAllHandler();
}

async function deleteProductHandler(e) {
  let id = this.id;

  let httpHandlers = {
    method: "DELETE",
  };

  const response = await fetch(BASE_URL + id, httpHandlers);

  loadAllHandler();
}
