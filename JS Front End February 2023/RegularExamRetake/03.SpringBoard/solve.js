// TODO:
function attachEvents() {
  const loadBoardBtn = document.querySelector("#load-board-btn");
  const toDoSectionContainer = document.querySelector("#todo-section > .task-list");
  const inProgressContainer = document.querySelector("#in-progress-section > .task-list");
  const codeReviewContainer = document.querySelector("#code-review-section > .task-list");
  const doneSectionContainer = document.querySelector("#done-section > .task-list");
  const titleInput = document.querySelector("#title");
  const descriptionInput = document.querySelector("#description");
  const addTaskBtn = document.querySelector("#create-task-btn");
  const BASE_URL = "http://localhost:3030/jsonstore/tasks/";

  loadBoardBtn.addEventListener("click", loadBoardHandler);

  addTaskBtn.addEventListener("click", addTaskHandler);

  async function addTaskHandler(e) {
    try {
      let title = titleInput.value;
      let description = descriptionInput.value;
      let status = "ToDo";
      let data = { title, description, status };

      let httpMethod = {
        method: "POST",
        body: JSON.stringify(data),
      };

      await fetch(BASE_URL, httpMethod);

      titleInput.value = "";
      descriptionInput.value = "";

      loadBoardHandler();
    } catch {
      console.log("Error in adding task");
    }
  }

  async function loadBoardHandler(e) {

    toDoSectionContainer.innerHTML = "";
    inProgressContainer.innerHTML = "";
    codeReviewContainer.innerHTML = "";
    doneSectionContainer.innerHTML = "";

    try {
      let response = await fetch(BASE_URL);
      let boardData = await response.json();

      for (const key in boardData) {
        let { title, description, status, _id } = boardData[key];

        let li = document.createElement("li");
        li.setAttribute("class", "task");
        let h3 = createElement("h3", title, li);
        let p = createElement("p", description, li);
        let moveBtn = createElement("button", "", li);
        moveBtn.id = _id;

        if (status === "ToDo") {
          moveBtn.textContent = "Move to In Progress";
        //   moveBtn.id = _id;
          toDoSectionContainer.appendChild(li);
        } else if (status === "In Progress") {
          moveBtn.textContent = "Move to Code Review";
        //   moveBtn.id = _id;
          inProgressContainer.appendChild(li);
        } else if (status === "Code Review") {
          moveBtn.textContent = "Move to Done";
        //   moveBtn.id = _id;
          codeReviewContainer.appendChild(li);
        } else if (status === "Done") {
          moveBtn.textContent = "Close";
        //   moveBtn.id = _id;
          doneSectionContainer.appendChild(li);
        }

        moveBtn.addEventListener("click", moveBtnHandler);

        async function moveBtnHandler(e) {
          let id = e.target.id;

          let data = { title, description, status, _id };

          if (moveBtn.textContent === "Move to In Progress") {
            data.status = "In Progress";
          } else if (moveBtn.textContent === "Move to Code Review") {
            data.status = "Code Review";
          } else if (moveBtn.textContent === "Move to Done") {
            data.status = "Done";
          } else if (moveBtn.textContent === "Close") {
            await fetch(BASE_URL + id, { method: "DELETE" });
            loadBoardHandler();
            return;
          }
          let httpMethod = {
            method: "PATCH",
            body: JSON.stringify(data),
          };

          await fetch(BASE_URL + id, httpMethod);

          loadBoardHandler();
        }
      }
    } catch {
      console.log("Error in loading and moving tasks");
    }
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

attachEvents();
