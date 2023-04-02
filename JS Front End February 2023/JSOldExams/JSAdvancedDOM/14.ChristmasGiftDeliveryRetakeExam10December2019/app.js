function solution() {
  const input = document.querySelector(".card > div > input[type=text]");
  const addBtn = document.querySelector(".card > div > button");

  const listOfGiftsContainer = document.querySelector(
    ".container > section:nth-child(2) > ul"
  );
  const sentGiftsContainer = document.querySelector(
    ".container > section:nth-child(3) > ul"
  );
  const discardedGiftsContainer = document.querySelector(
    ".container > section:nth-child(4) > ul"
  );

  addBtn.addEventListener("click", addBtnHandler);

  listElements = [];
  debugger;
  function addBtnHandler(e) {
    let giftName = input.value;

    listOfGiftsContainer.innerHTML = "";

    listElements.push(giftName);
    let sorted = listElements.sort();

    listOfGiftsContainer.innerHTML = "";

    for (const el of sorted) {
      let li = document.createElement("li");
      li.classList.add("gift");
      li.textContent = el;

      let sendBtn = createEl("button", "Send", li, null, "sendButton");
      let discardBtn = createEl("button", "Discard", li, null, "discardButton");
      listOfGiftsContainer.appendChild(li);

      sendBtn.addEventListener("click", sendBtnHandler);

      function sendBtnHandler(e) {
        let currentLi = e.target.parentNode;
        let index = listElements.indexOf(currentLi);

        listElements.splice(index, 1);
        sentGiftsContainer.appendChild(li);

        sendBtn.remove();
        discardBtn.remove();
      }
      discardBtn.addEventListener("click", discardBtnHandler);
      function discardBtnHandler(e) {
        let currentLi = e.target.parentNode;
        let index = listElements.indexOf(currentLi);

        listElements.splice(index, 1);
        discardedGiftsContainer.appendChild(li);

        sendBtn.remove();
        discardBtn.remove();
      }
    }

    input.value = "";
  }

  function createEl(type, text, parent, classes, id) {
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
    if (id) {
      element.setAttribute("id", id);
    }
    return element;
  }
}
