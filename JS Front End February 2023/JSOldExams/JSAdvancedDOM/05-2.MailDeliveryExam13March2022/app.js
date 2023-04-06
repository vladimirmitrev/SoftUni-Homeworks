function solve() {
  const emailInput = document.getElementById("recipientName");
  const titleInput = document.getElementById("title");
  const textInput = document.getElementById("message");
  const addBtn = document.getElementById("add");
  const resetBtn = document.getElementById("reset");
  const mailListContainer = document.getElementById("list");
  const sentMailsContainer = document.querySelector(".sent-list");
  const deletedMailsContainer = document.querySelector(".delete-list");

  addBtn.addEventListener("click", addBtnHandler);
  resetBtn.addEventListener("click", resetBtnHandler);

  function resetBtnHandler(event) {
    event.preventDefault();
    resetInputs();
  }

  function addBtnHandler(event) {
    event.preventDefault();

    let email = emailInput.value;
    let title = titleInput.value;
    let text = textInput.value;

    if (!email || !title || !text) {
      return;
    }

    let li = createElement("li", null, mailListContainer);

    createElement("h4", `Title: ${title}`, li);
    createElement("h4", `Recipient Name: ${email}`, li);
    createElement("span", `${text}`, li);

    let buttonsDiv = createElement("div", null, li);
    buttonsDiv.setAttribute("id", "list-action");

    let sendBtn = createElement("button", "Send", buttonsDiv);
    sendBtn.setAttribute("type", "submit");
    sendBtn.setAttribute("id", "send");

    let deleteBtn = createElement("button", "Delete", buttonsDiv);
    deleteBtn.setAttribute("type", "submit");
    deleteBtn.setAttribute("id", "delete");

    resetInputs();

    sendBtn.addEventListener("click", sendBtnHandler);

    deleteBtn.addEventListener("click", deleteBtnHandler);

    function deleteBtnHandler(event) {
      event.preventDefault();
      event.target.parentNode.parentNode.remove();
      let li = createElement("li", null, deletedMailsContainer);
      createElement("span", `To: ${email}`, li);
      createElement("span", `Title: ${title}`, li);
    }

    function sendBtnHandler(event) {
      event.preventDefault();
      event.target.parentNode.parentNode.remove();

      let li = createElement("li", null, sentMailsContainer);
      createElement("span", `To: ${email}`, li);
      createElement("span", `Title: ${title}`, li);
      let buttonDiv = createElement("div", null, li, ["btn"]);
      let deleteBtnInSent = createElement("button", "Delete", buttonDiv, [
        "delete",
      ]);
      deleteBtnInSent.setAttribute("type", "submit");

      deleteBtnInSent.addEventListener("click", (event) => {
        event.preventDefault();
        event.target.parentNode.parentNode.remove();
        let li = createElement("li", null, deletedMailsContainer);
        createElement("span", `To: ${email}`, li);
        createElement("span", `Title: ${title}`, li);
      });
    }
  }

  function resetInputs() {
    emailInput.value = "";
    titleInput.value = "";
    textInput.value = "";
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
solve();
