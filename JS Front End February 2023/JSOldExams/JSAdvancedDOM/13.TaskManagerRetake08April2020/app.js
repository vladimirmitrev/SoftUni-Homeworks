function solve() {
  const taskInput = document.getElementById("task");
  const descriptionInput = document.getElementById("description");
  const dateInput = document.getElementById("date");
  const addBtn = document.getElementById("add");
  const openSectionDiv = document.querySelector(
    "body > main > div > section:nth-child(2) > div:nth-child(2)"
  );
  const inProgressSectionDiv = document.querySelector("#in-progress");

  const completeSectionDiv = document.querySelector(
    "body > main > div > section:nth-child(4) > div:nth-child(2)"
  );

  addBtn.addEventListener("click", addTaskHandler);

  function addTaskHandler(event) {
    event.preventDefault();

    const task = taskInput.value;
    const description = descriptionInput.value;
    const dueDate = dateInput.value;

    if (task === "" || description === "" || dueDate === "") {
      return;
    }

    let articleEl = createEl("article");
    createEl("h3", `${task}`, articleEl);
    createEl("p", `Description: ${description}`, articleEl);
    createEl("p", `Due Date: ${dueDate}`, articleEl);
    let buttonsDiv = createEl("div", null, articleEl, ["flex"]);
    let startBtn = createEl("button", "Start", buttonsDiv, ["green"]);
    let deleteBtn = createEl("button", "Delete", buttonsDiv, ["red"]);

    openSectionDiv.appendChild(articleEl);

    taskInput.value = "";
    descriptionInput.value = "";
    dateInput.value = "";

    startBtn.addEventListener("click", startTaskHandler);

    deleteBtn.addEventListener("click", deleteTaskHandler);

    function deleteTaskHandler(event) {
      let parent = event.target.parentNode.parentNode.remove();
      parent.remove();
    //   articleEl.remove();
    }

    function startTaskHandler(event) {
      let parent = event.target.parentNode.parentNode;
      parent.remove();

      let articleEl = createEl("article");
      createEl("h3", `${task}`, articleEl);
      createEl("p", `Description: ${description}`, articleEl);
      createEl("p", `Due Date: ${dueDate}`, articleEl);
      let buttonsDiv = createEl("div", null, articleEl, ["flex"]);
      let deleteBtnProgress = createEl("button", "Delete", buttonsDiv, ["red"]);
      let finishBtn = createEl("button", "Finish", buttonsDiv, ["orange"]);

      inProgressSectionDiv.appendChild(articleEl);

      deleteBtnProgress.addEventListener("click", deleteBtnProgressHandler);

      finishBtn.addEventListener("click", finishTaskHandler);

      function deleteBtnProgressHandler(event) {
        let parent = event.target.parentNode.parentNode;
        parent.remove();
        // articleEl.remove();
      }

      function finishTaskHandler(event) {
        let parent = event.target.parentNode.parentNode;
        parent.remove();

        let articleEl = createEl("article");
        createEl("h3", `${task}`, articleEl);
        createEl("p", `Description: ${description}`, articleEl);
        createEl("p", `Due Date: ${dueDate}`, articleEl);

        completeSectionDiv.appendChild(articleEl);
      }
    }
  }
  function createEl(type, text, parent, classes) {
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
