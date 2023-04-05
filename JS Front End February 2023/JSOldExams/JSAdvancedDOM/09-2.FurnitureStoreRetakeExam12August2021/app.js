window.addEventListener('load', solve);

function solve() {
    const modelInput = document.getElementById("model");
    const yearInput = document.getElementById("year");
    const descriptionInput = document.getElementById("description");
    const priceInput = document.getElementById("price");
    const addBtn = document.getElementById("add");
    const tableBody = document.getElementById("furniture-list");
    const totalPriceTd = document.querySelector(".total-price");
    
    let totalPrice = 0;

    addBtn.addEventListener("click", addBtnHandler);


    function addBtnHandler(e) {
        e.preventDefault();

        let model = modelInput.value;
        let year = Number(yearInput.value);
        let description = descriptionInput.value;
        let price = Number(priceInput.value);

        if(!model || !description || year < 0 || price < 0) {
            alert("Fill all inputs correct!")
            return;
        }

       

        let infoRow = createElement("tr", null, tableBody, ["info"]);
        createElement("td", `${model}`, infoRow);
        createElement("td", `${price.toFixed(2)}`, infoRow);
        let buttonsTd = createElement("td", null, infoRow);
        let moreBtn = createElement("button", "More Info", buttonsTd, ["moreBtn"]);
        let buyBtn = createElement("button", "Buy it", buttonsTd, ["buyBtn"]);

        let hideRow = createElement("tr", null, tableBody, ["hide"]);
        createElement("td", `Year: ${year}`, hideRow);
        let tdColspan = createElement("td", `Description: ${description}`, hideRow);
        tdColspan.setAttribute("colspan", "3");


        modelInput.value = "";
        yearInput.value = "";
        descriptionInput.value = "";
        priceInput.value = "";

        moreBtn.addEventListener("click", moreBtnHandler);

        buyBtn.addEventListener("click", buyBtnHandler);

        function moreBtnHandler() {
            if(moreBtn.textContent === "More Info") {
                hideRow.style.display = "contents";
                moreBtn.textContent = "Less Info";
            } else {
                hideRow.style.display = "none";
                moreBtn.textContent = "More Info";
            }
        }

        function buyBtnHandler() {
            // tableBody.removeChild(infoRow);
            // tableBody.removeChild(hideRow);
            infoRow.remove();
            hideRow.remove();
            totalPrice += price;
            totalPriceTd.textContent = totalPrice.toFixed(2);
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
