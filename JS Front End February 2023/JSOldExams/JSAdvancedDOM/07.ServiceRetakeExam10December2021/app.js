window.addEventListener("load", solve);

function solve() {
  const productTypeInput = document.getElementById("type-product");
  const descriptionInput = document.getElementById("description");
  const clientNameInput = document.getElementById("client-name");
  const clientPhoneInput = document.getElementById("client-phone");
  const sendBtn = document.querySelector("#right > form > button");

  const receivedOrdersSection = document.getElementById("received-orders");
  const completedOrdersSection = document.getElementById("completed-orders");
  const clearBtn = document.querySelector(".clear-btn")
  
  sendBtn.addEventListener("click", sendHandler);

  function sendHandler(event) {
    event.preventDefault();

    const productType = productTypeInput.value;
    const description = descriptionInput.value;
    const clientName = clientNameInput.value;
    const clientPhone = clientPhoneInput.value;

    if (description === "" || clientName === "" || clientPhone === "" || productType === "") {
      return;
    }

    productTypeInput.value = "";
    descriptionInput.value = "";
    clientNameInput.value = "";
    clientPhoneInput.value = "";


    const receivedDiv = document.createElement("div");
    receivedDiv.setAttribute("class", "container");

    createEl("h2", `Product type for repair: ${productType}`, receivedDiv);
    createEl("h3",`Client information: ${clientName}, ${clientPhone}`,receivedDiv);
    createEl("h4", `Description of the problem: ${description}`, receivedDiv);

    const startBtn = document.createElement("button");
    startBtn.setAttribute("class", "start-btn");
    startBtn.textContent = "Start repair";

    const finishBtn = document.createElement("button");
    finishBtn.setAttribute("class", "finish-btn");
    finishBtn.textContent = "Finish repair";
    finishBtn.disabled = true;

    receivedDiv.appendChild(startBtn);
    receivedDiv.appendChild(finishBtn);

    receivedOrdersSection.appendChild(receivedDiv);

    startBtn.addEventListener("click", finishBtnEnable);

    function finishBtnEnable() {
      startBtn.disabled = true;
      finishBtn.disabled = false;
      
    }

    finishBtn.addEventListener("click", finishBtnHandler);

    function finishBtnHandler() {

        receivedDiv.remove();

        const completedDiv = document.createElement("div");
        completedDiv.setAttribute("class", "container");

        createEl("h2", `Product type for repair: ${productType}`, completedDiv);
        createEl("h3",`Client information: ${clientName}, ${clientPhone}`,completedDiv);
        createEl("h4", `Description of the problem: ${description}`, completedDiv);

        completedOrdersSection.appendChild(completedDiv);


        clearBtn.addEventListener("click", () => {
            completedDiv.remove();
        });
    }
  }
  function createEl(type, text, parent) {
    let element = document.createElement(type);
    element.textContent = text;
    if (parent) {
      parent.appendChild(element);
    }
  }
}


