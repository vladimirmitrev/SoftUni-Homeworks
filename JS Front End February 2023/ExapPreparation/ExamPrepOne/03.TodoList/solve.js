function attachEvents() {
  const loadBtn = document.getElementById("load-button");
  const addBtn = document.getElementById("add-button");
  const toDoListContainer = document.getElementById("todo-list");
  const titleInput = document.getElementById("title");
  debugger;
  const BASE_URL = "http://localhost:3030/jsonstore/tasks/";

  // let allTasks = {};

  // loadTasksHandler();

  loadBtn.addEventListener("click", loadTasksHandler);

  async function loadTasksHandler(event) {
    if (event) {
      event.preventDefault();
    }
    try {
      toDoListContainer.innerHTML = "";
      const response = await fetch(`${BASE_URL}`);
      const tasksData = await response.json();
      allTasks = tasksData;

      for (const key in tasksData) {
        let { name, _id } = tasksData[key];

        let li = document.createElement("li");

        let span = document.createElement("span");
        span.textContent = name;

        let removeBtn = document.createElement("button");
        removeBtn.textContent = "Remove";
        removeBtn.id = _id;

        let editBtn = document.createElement("button");
        editBtn.textContent = "Edit";
        editBtn.id = _id;

        li.appendChild(span);
        li.appendChild(removeBtn);
        li.appendChild(editBtn);
        toDoListContainer.appendChild(li);

        removeBtn.addEventListener("click", removeTaskHandler);

        editBtn.addEventListener("click", editHandler);

        function editHandler() {
          editBtn.textContent = "Submit";
          let editInput = document.createElement("input");
          editInput.id = key;
          editInput.value = name;
          li.removeChild(span);
          li.insertBefore(editInput, li.firstChild);

          editBtn.addEventListener("click", submitHandler);

          async function submitHandler() {
            editBtn.textContent = "Edit";
            let name = editInput.value;
            let id = _id;

            const httpHandlers = {
              method: "PATCH",
              body: JSON.stringify({ name }),
            };

            const response = await fetch(BASE_URL + id, httpHandlers);

            li.removeChild(editInput);
            li.insertBefore(span, li.firstChild);

            loadTasksHandler();
          }
        }
      }
    } catch {
      console.log("Error");
    }
  }

  addBtn.addEventListener("click", addTaskHandler);

  async function addTaskHandler(e) {
    e.preventDefault();

    let name = titleInput.value;

    try {
      if (name.length > 0) {
        const httpHandlers = {
          method: "POST",
          body: JSON.stringify({ name }),
        };
        let url = BASE_URL;

        const response = await fetch(`${url}`, httpHandlers);

        loadTasksHandler();
        titleInput.value = "";
      }
    } catch {
      console.log("Error");
    }
  }
  async function removeTaskHandler(e) {
    try {
      let id = this.id;
      let url = BASE_URL + id;
      let httpHandlers = {
        method: "DELETE",
      };
      const response = await fetch(url, httpHandlers);
      loadTasksHandler();
    } catch {
      console.log("Error");
    }
  }
}

attachEvents();
