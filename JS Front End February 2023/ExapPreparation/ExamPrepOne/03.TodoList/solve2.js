// TODO
function attachEvents() {
  const addBtn = document.querySelector("#add-button");
  const loadAllBtn = document.querySelector("#load-button");
  const nameInput = document.querySelector("#title");
  const toDoListContainer = document.querySelector("#todo-list");
  const BASE_URL = "http://localhost:3030/jsonstore/tasks/";

  addBtn.addEventListener("click", addTaskHandler);
  loadAllBtn.addEventListener("click", loadAllTaskHandler);

  async function loadAllTaskHandler(event) {
    try {
      if (event) {
        event.preventDefault();
      }
      toDoListContainer.innerHTML = "";
      let response = await fetch(BASE_URL);
      let tasksDataObj = await response.json();
      for (const key in tasksDataObj) {
        let { name, _id } = tasksDataObj[key];

        let li = document.createElement("li");
        li.id = _id;

        let span = document.createElement("span");
        span.textContent = name;

        let removeBtn = document.createElement("button");
        removeBtn.textContent = "Remove";
        removeBtn.id = _id;

        let editBtn = document.createElement("button");
        editBtn.textContent = "Edit";

        li.appendChild(span);
        li.appendChild(removeBtn);
        li.appendChild(editBtn);

        toDoListContainer.appendChild(li);

        removeBtn.addEventListener("click", removeTaskHandler);

        editBtn.addEventListener("click", editTaskHandler);

        function editTaskHandler(e) {
          let editInput = document.createElement("input");
          editInput.value = span.textContent;
          let submitBtn = document.createElement("button");
          submitBtn.textContent = "Submit";
          span.remove();
          editBtn.remove();
          li.prepend(editInput);
          li.appendChild(submitBtn);

          submitBtn.addEventListener("click", submitBtnHandler);

          async function submitBtnHandler(event) {
            let id = event.target.parentNode.id;
            let name = editInput.value;

            let httpMethod = {
              method: "PATCH",
              body: JSON.stringify({ name }),
            };

            await fetch(`${BASE_URL}${id}`, httpMethod);

            loadAllTaskHandler();
          }
        }
      }
    } catch {
      console.log("Error in loading task handler");
    }
  }

  async function removeTaskHandler(event) {
    try {
      let id = event.target.id;

      let httpMethod = {
        method: "DELETE",
      };

      await fetch(`${BASE_URL}${id}`, httpMethod);

      loadAllTaskHandler();
    } catch {
      console.log("Error in remove task handler");
    }
  }

  async function addTaskHandler(event) {
    if (event) {
      event.preventDefault();
    }
    try {
      let name = nameInput.value;

      let httpMethod = {
        method: "POST",
        body: JSON.stringify({ name }),
      };
      await fetch(BASE_URL, httpMethod);

      nameInput.value = "";
      loadAllTaskHandler();
    } catch {
      console.log("Error in add function");
    }
  }
}

attachEvents();
