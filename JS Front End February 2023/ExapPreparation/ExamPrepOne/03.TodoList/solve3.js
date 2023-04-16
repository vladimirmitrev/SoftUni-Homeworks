// TODO
function attachEvents() {
  const loadAllBtn = document.querySelector("#load-button");
  const addTaskBtn = document.querySelector("#add-button");
  const input = document.querySelector("#title");
  const taskListContainer = document.querySelector("#todo-list");
  const BASE_URL = "http://localhost:3030/jsonstore/tasks/";

  loadAllBtn.addEventListener("click", loadAllHandler);

  addTaskBtn.addEventListener("click", addTaskHandler);

  async function loadAllHandler(event) {
    if (event) {
      event.preventDefault();
    }

    taskListContainer.innerHTML = "";

    let response = await fetch(BASE_URL);
    let tasksData = await response.json();

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

      li.append(span, removeBtn, editBtn);
      taskListContainer.appendChild(li);

      removeBtn.addEventListener("click", removeTaskHandler);

      editBtn.addEventListener("click", editTaskHandler);

      function editTaskHandler(e) {

        li.removeChild(span);
        li.removeChild(editBtn);

        let editInput = document.createElement("input");
        editInput.value = name;
        li.prepend(editInput);

        let submitBtn = document.createElement("button");
        submitBtn.textContent = "Submit";
        li.appendChild(submitBtn);

        submitBtn.addEventListener("click", async()=> {
            let id = e.target.id;
            let name = editInput.value;

            let httpMethod = {
                method: "PATCH", 
                body: JSON.stringify({name})
            }

            await fetch(`${BASE_URL}${id}`, httpMethod);

            loadAllHandler();
        });
      }

      
    }
  }

  async function addTaskHandler(event) {
    if(event) {
        event.preventDefault();
    }
    let name = input.value;

    let httpMethod = {
        method: 'POST',
        body: JSON.stringify({name}),
    }
    await fetch (BASE_URL, httpMethod);

    input.value = "";

    loadAllHandler();
  }

  async function removeTaskHandler(e) {
    let id = e.target.id;

    await fetch(`${BASE_URL}${id}`, {method: "DELETE"});

    loadAllHandler();
  }
}

attachEvents();
