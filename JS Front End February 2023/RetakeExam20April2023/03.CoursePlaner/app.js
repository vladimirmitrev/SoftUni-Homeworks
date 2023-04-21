function solve() {
  const titleInput = document.getElementById("course-name");
  const typeInput = document.getElementById("course-type");
  const descriptionInput = document.getElementById("description");
  const teacherInput = document.getElementById("teacher-name");

  const loadBtn = document.getElementById("load-course");
  const BASE_URL = "http://localhost:3030/jsonstore/tasks/";
  const courseInProgressContainer = document.getElementById("list");

  const addBtn = document.getElementById("add-course");
  const editFormBtn = document.getElementById("edit-course");

  loadBtn.addEventListener("click", loadAllTaskHandler);

  addBtn.addEventListener("click", addTaskHandler);

  loadAllTaskHandler();

  async function loadAllTaskHandler(e) {
    // e.preventDefault();

    courseInProgressContainer.innerHTML = "";

    let response = await fetch(BASE_URL);
    let tasksData = await response.json();

    for (const key in tasksData) {
      let { title, type, description, teacher, _id } = tasksData[key];

      let divContainer = createElement("div", "", courseInProgressContainer, [
        "container",
      ]);
      createElement("h2", `${title}`, divContainer);
      createElement("h3", `${teacher}`, divContainer);
      createElement("h3", `${type}`, divContainer);
      createElement("h4", `${description}`, divContainer);

      let editBtn = createElement("button", "Edit Course", divContainer, ["edit-btn",]);
      editBtn.id = _id;
      let finishBtn = createElement("button", "Finish Course", divContainer, ["finish-btn",]);
      finishBtn.id = _id;

      finishBtn.addEventListener("click", async (e) => {
        let id = e.target.id;

        await fetch(`${BASE_URL}${id}`, { method: "DELETE" });

        loadAllTaskHandler();
      });

      editBtn.addEventListener("click", (event) => {
        titleInput.value = title;
        typeInput.value = type;
        descriptionInput.value = description;
        teacherInput.value = teacher;

        addBtn.disabled = true;
        editFormBtn.disabled = false;

        event.target.parentNode.remove();

        editFormBtn.addEventListener("click", async (e) => {
          if (e) {
            e.preventDefault();
          }

          let id = event.target.id;

          let title = titleInput.value;
          let type = typeInput.value;
          let description = descriptionInput.value;
          let teacher = teacherInput.value;

          let httpMethod = {
            method: "PUT",
            body: JSON.stringify({ title, type, description, teacher, _id: id }),
          };

          await fetch(`${BASE_URL}${id}`, httpMethod);

          location.reload();

          resetInputs();

          loadAllTaskHandler();
        });
      });
    }
  }

  async function addTaskHandler(e) {
    if (e) {
      e.preventDefault();
    }

    let title = titleInput.value;
    let type = typeInput.value;
    let description = descriptionInput.value;
    let teacher = teacherInput.value;

    let httpMethod = {
      method: "POST",
      body: JSON.stringify({ title, type, description, teacher }),
    };

    await fetch(BASE_URL, httpMethod);

    resetInputs();

    loadAllTaskHandler();
  }

  function resetInputs() {
    titleInput.value = "";
    typeInput.value = "";
    descriptionInput.value = "";
    teacherInput.value = "";
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

solve();
