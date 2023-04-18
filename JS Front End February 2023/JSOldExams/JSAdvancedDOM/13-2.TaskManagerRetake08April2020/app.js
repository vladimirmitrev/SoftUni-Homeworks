function solve() {
  const orangeSection = document.querySelector(
    "body > main > div > section:nth-child(2) > div:nth-child(2)"
  );
  const yellowSection = document.querySelector("#in-progress");
  const greenSection = document.querySelector(
    "body > main > div > section:nth-child(4) > div:nth-child(2)"
  );
  const addBtn = document.querySelector("#add");
  const taskInput = document.querySelector("#task");
  const descriptionInput = document.querySelector("#description");
  const dateInput = document.querySelector("#date");

  addBtn.addEventListener("click", addBtnHandler);

  function addBtnHandler(e) {
    e.preventDefault();

    let task = taskInput.value;
    let description = descriptionInput.value;
    let date = dateInput.value;

    if (!task || !description || !date) {
      return;
    }

    let articleEl = createElement("article");
    createElement("h3", `${task}`, articleEl);
    createElement("p", `Description: ${description}`, articleEl);
    createElement("p", `Due Date: ${date}`, articleEl);
    let buttonsDiv = createElement("div", "", articleEl, ["flex"]);
    let startBtn = createElement("button", "Start", buttonsDiv, ["green"]);
    let deleteBtn = createElement("button", "Delete", buttonsDiv, ["red"]);

    orangeSection.appendChild(articleEl);

    taskInput.value = "";
    descriptionInput.value = "";
    dateInput.value = "";

    startBtn.addEventListener("click", startBtnHandler);

    deleteBtn.addEventListener("click", () => {
      articleEl.remove();
    });

    function startBtnHandler(e) {
      buttonsDiv.removeChild(startBtn);
      let finishBtn = createElement("button", "Finish", buttonsDiv, ["orange"]);
      yellowSection.appendChild(articleEl);

      finishBtn.addEventListener("click", () => {
        let removeBtn = document.querySelector(".flex");
        articleEl.removeChild(removeBtn);
        greenSection.appendChild(articleEl);
        
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
