function solve() {
  const emailInput = document.getElementById("recipientName");
  const titleInput = document.getElementById("title");
  const messageInput = document.getElementById("message");
  const addBtn = document.getElementById("add");
  const resetBtn = document.getElementById("reset");
  const emailListUl = document.getElementById("list");
  const sentListUl = document.querySelector(".sent-list");
  const deleteListUl = document.querySelector(".delete-list");

  addBtn.addEventListener("click", addToListHandler);
  resetBtn.addEventListener("click", resetBtnHandler);

  function resetBtnHandler(e) {
    e.preventDefault();

    emailInput.value = "";
    titleInput.value = "";
    messageInput.value = "";
  }

  function addToListHandler(e) {
    e.preventDefault();

    const email = emailInput.value;
    const title = titleInput.value;
    const message = messageInput.value;

    if (email === "" || title === "" || message === "") {
      return;
    }

    const li = document.createElement("li");

    createEl("h4", `Title: ${title}`, li);
    createEl("h4", `Recipient Name: ${email}`, li);
    createEl("span", message, li);

    const divElement = document.createElement("div");
    divElement.setAttribute("id", "list-action");

    const sendBtn = document.createElement("button");
    sendBtn.setAttribute("id", "send");
    sendBtn.setAttribute("type", "submit");
    sendBtn.textContent = "Send";

    const deleteBtn = document.createElement("button");
    deleteBtn.setAttribute("id", "delete");
    deleteBtn.setAttribute("type", "submit");
    deleteBtn.textContent = "Delete";

    divElement.appendChild(sendBtn);
    divElement.appendChild(deleteBtn);
    li.appendChild(divElement);

    emailListUl.appendChild(li);

    emailInput.value = "";
    titleInput.value = "";
    messageInput.value = "";

    sendBtn.addEventListener("click", sendEmailHandler);

    deleteBtn.addEventListener("click", deleteEmailHandler);

    function deleteEmailHandler(e) {
      li.remove();

      
      const liDelete = document.createElement("li");
      
      createEl("span", `To: ${email}`, liDelete);
      createEl("span", `Title: ${title}`, liDelete);

      deleteListUl.appendChild(liDelete);
    }

    function sendEmailHandler(e) {
      li.remove();
      debugger;
      const liTwo = document.createElement("li");

      const deleteBtnSent = document.createElement("button");
      deleteBtn.setAttribute("type", "submit");
      deleteBtnSent.classList.add("delete");
      deleteBtnSent.textContent = "Delete";

      const emailSpan = document.createElement("span");
      emailSpan.textContent = `To: ${email}`;

      const titleSpan = document.createElement("span");
      titleSpan.textContent = `Title: ${title}`;

      const divElement = document.createElement("div");
      divElement.classList.add("btn");

      divElement.appendChild(deleteBtnSent);
      liTwo.appendChild(emailSpan);
      liTwo.appendChild(titleSpan);
      liTwo.appendChild(divElement);

      sentListUl.appendChild(liTwo);

      deleteBtnSent.addEventListener("click", () => {
        liTwo.remove();

        const liDelete = document.createElement("li");

        createEl("span", `To: ${email}`, liDelete);
        createEl("span", `Title: ${title}`, liDelete);
  
        deleteListUl.appendChild(liDelete);
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

solve();
