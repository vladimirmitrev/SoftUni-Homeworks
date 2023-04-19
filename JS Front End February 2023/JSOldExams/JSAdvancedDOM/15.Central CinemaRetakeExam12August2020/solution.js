function solve() {
  const nameInput = document.querySelector(
    "#container > input[type=text]:nth-child(1)"
  );
  const hallInput = document.querySelector(
    "#container > input[type=text]:nth-child(2)"
  );
  const priceInput = document.querySelector(
    "#container > input[type=text]:nth-child(3)"
  );
  const onScreenBtn = document.querySelector("#container > button");
  const moviesContainer = document.querySelector("#movies > ul");
  const archiveContainer = document.querySelector("#archive > ul");
  const clearBtn = document.querySelector("#archive > button");

  onScreenBtn.addEventListener("click", onScreenHandler);

  clearBtn.addEventListener("click", () => {
    archiveContainer.innerHTML = "";
  });

  function onScreenHandler(e) {
    e.preventDefault();

    let name = nameInput.value;
    let hall = hallInput.value;
    let price = Number(priceInput.value);

    if (!name || !hall || !price || isNaN(priceInput.value)) {
      alert("Fill all inputs and price should be a number!");
      return;
    }

    nameInput.value = "";
    hallInput.value = "";
    priceInput.value = "";

    let li = createElement("li", "", moviesContainer);
    createElement("span", `${name}`, li);
    createElement("strong", `Hall: ${hall}`, li);

    let div = createElement("div", "", li);
    createElement("strong", `${price.toFixed(2)}`, div);
    let inputPlaceholder = createElement("input", "", div);
    inputPlaceholder.setAttribute("placeholder", "Tickets sold");

    let archiveBtn = createElement("button", "Archive", div);

    archiveBtn.addEventListener("click", (e) => {
   
      if (!Number(inputPlaceholder.value)){
        alert("check input");
        return;
      }
      let currentPrice = inputPlaceholder.value;
      let totalPriceForMovie = currentPrice * price;
      e.target.parentNode.parentNode.remove();

      let li = createElement("li", "", archiveContainer);
      createElement("span", `${name}`, li);
      createElement("strong", `Total amount: ${totalPriceForMovie.toFixed(2)}`,li);
      let deleteBtn = createElement("button", "Delete", li);

      deleteBtn.addEventListener("click", (e) => {
        e.target.parentNode.remove();
      });
    });
  }
  function createElement(type, text, parent) {
    let element = document.createElement(type);

    if (text) {
      element.textContent = text;
    }
    if (parent) {
      parent.appendChild(element);
    }

    return element;
  }
}
