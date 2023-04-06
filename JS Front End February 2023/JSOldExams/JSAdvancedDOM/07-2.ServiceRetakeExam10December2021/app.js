window.addEventListener("load", solve);

function solve() {
  const typeInput = document.querySelector("#type-product");
  const descriptionInput = document.querySelector("#description");
  const nameInput = document.querySelector("#client-name");
  const phoneInput = document.querySelector("#client-phone");
  const receivedOrdersContainer = document.querySelector("#received-orders");
  const sendBtn = document.querySelector("#right > form > button");
  const completedOrdersContainer = document.querySelector("#completed-orders");
  const clearBtn = document.querySelector(".clear-btn");

  sendBtn.addEventListener("click", sendBtnHandler);

  function sendBtnHandler(event) {
    if (event) {
      event.preventDefault();
    }

    let type = typeInput.value;
    let description = descriptionInput.value;
    let name = nameInput.value;
    let phone = phoneInput.value;

    if (!description || !name || !phone) {
      return;
    }

    let divContainer = createElement("div", null, receivedOrdersContainer, ["container",]);
    createElement("h2", `Product type for repair: ${type}`, divContainer);
    createElement("h3", `Client information: ${name}, ${phone}`, divContainer);
    createElement("h4", `Description of the problem: ${description}`, divContainer);

    let startBtn = createElement("button", "Start repair", divContainer, [
      "start-btn",
    ]);

    let finishBtn = createElement("button", "Finish repair", divContainer, [
      "finish-btn",
    ]);
    finishBtn.setAttribute("disabled", true);

    typeInput.value = "";
    descriptionInput.value = "";
    nameInput.value = "";
    phoneInput.value = "";

    startBtn.addEventListener("click", () => {
      startBtn.setAttribute("disabled", true);
      finishBtn.disabled = false;
    });

    finishBtn.addEventListener("click", finishBtnHandler);

    


    function finishBtnHandler(e) {
        e.target.parentNode.remove();
        let divContainer = createElement("div", null, completedOrdersContainer, ["container"]);
        createElement("h2", `Product type for repair: ${type}`, divContainer);
        createElement("h3", `Client information: ${name}, ${phone}`, divContainer);
        createElement("h4", `Description of the problem: ${description}`, divContainer);
       
        clearBtn.addEventListener("click", (e)=> {
            divContainer.remove();
        });
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
