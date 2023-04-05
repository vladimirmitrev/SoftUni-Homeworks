function groceryList() {
  const productInput = document.getElementById("product");
  const countInput = document.getElementById("count");
  const priceInput = document.getElementById("price");
  const BASE_URL = "http://localhost:3030/jsonstore/grocery/";
  const tableBody = document.getElementById("tbody");

  const loadAllBtn = document.getElementById("load-product");
  const addBtn = document.getElementById("add-product");
  const updateProductBtn = document.getElementById("update-product");

  addBtn.addEventListener("click", addProductHandler);
  loadAllBtn.addEventListener("click", loadAllProducts);


  loadAllProducts(); //load all products after refresh

  async function loadAllProducts(e) {
    if (e) {
      e.preventDefault();
    }
    const response = await fetch(BASE_URL);
    const productsData = await response.json();

    tableBody.innerHTML = "";

    for (const key in productsData) {
      let { product, count, price, _id } = productsData[key];

      let tableRow = createElement("tr", null, tableBody);
      createElement("td", `${product}`, tableRow, ["name"]);
      createElement("td", `${count}`, tableRow, ["count-product"]);
      createElement("td", `${price}`, tableRow, ["product-price"]);
      let buttonsTd = createElement("td", null, tableRow, ["btn"]);
      let updateBtn = createElement("button", "Update", buttonsTd, ["update"]);
      updateBtn.id = _id;

      let deleteBtn = createElement("button", "Delete", buttonsTd, ["delete"]);
      deleteBtn.id = _id;

      deleteBtn.addEventListener("click", deleteBtnHandler);

      updateBtn.addEventListener("click", updateBtnHandler);

      function updateBtnHandler(e) {
        let id = this.id;
        productInput.value = product;
        countInput.value = count;
        priceInput.value = price;

        updateProductBtn.disabled = false;
        addBtn.disabled = true;

        updateProductBtn.addEventListener("click", updateProductBtnHandler);

        async function updateProductBtnHandler(e) {
          if (e) {
            e.preventDefault();
          }

          let editedProduct = productInput.value;
          let editedCount = countInput.value;
          let editedPrice = priceInput.value;

          let data = { product: editedProduct, count: editedCount, price: editedPrice };

          let httpHandler = {
            method: "PATCH",
            body: JSON.stringify(data),
          };

          await fetch(`${BASE_URL}${id}`, httpHandler);

          productInput.value = "";
          countInput.value = "";
          priceInput.value = "";

          updateProductBtn.disabled = true;
          addBtn.disabled = false;

          document.location.reload(); //to refresh site after "PATCH" 
                                    //so if you update another product
                                    //it's not gonna take the same
                                    // product name, count and price twice


        loadAllProducts();
          
        }
      }
    }
  }

  async function addProductHandler(e) {
    if (e) {
      e.preventDefault();
    }

    let product = productInput.value;
    let count = countInput.value;
    let price = priceInput.value;

    let httpHandler = {
      method: "POST",
      body: JSON.stringify({ product, count, price }),
    };
    await fetch(BASE_URL, httpHandler);

    productInput.value = "";
    countInput.value = "";
    priceInput.value = "";

    loadAllProducts();
  }

  async function deleteBtnHandler(e) {
    let id = e.target.id;

    let httpHandler = {
      method: "DELETE",
    };

    await fetch(`${BASE_URL}${id}`, httpHandler);

    loadAllProducts();
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

groceryList();
