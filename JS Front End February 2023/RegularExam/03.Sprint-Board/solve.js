// TODO:
function attachEvents() {
  const loadBoardBtn = document.querySelector("#load-board-btn");
  const BASE_URL = "http://localhost:3030/jsonstore/tasks/";

  const toDoSection = document.querySelector("#todo-section > ul");
  const inProgressSection = document.querySelector("#in-progress-section > ul");
  const reviewSection = document.querySelector("#code-review-section > ul");
  const doneSection = document.querySelector("#done-section > ul");
  let toDoBtnText = "Move to In Progress";
  let inProgressBtnText = "Move to Code Review";
  let codeReviewBtnText = "Move to Done";
  let doneBtnText = "Close";

  const addTaskBtn = document.querySelector("#create-task-btn");
  const titleInput = document.querySelector("#title");
  const descriptionInput = document.querySelector("#description");

  loadBoardBtn.addEventListener("click", loadBoardBtnHandler);

  addTaskBtn.addEventListener("click", addTaskBtnHandler);

  async function addTaskBtnHandler(e) {
    e.preventDefault();

    let title = titleInput.value;
    let description = descriptionInput.value;
    let status = "ToDo";

    let httpMethod = {
      method: "POST",
      body: JSON.stringify({ title, description, status }),
    };

    await fetch(BASE_URL, httpMethod);

    titleInput.value = "";
    descriptionInput.value = "";

    loadBoardBtnHandler();
  }

  async function loadBoardBtnHandler(e) {
    // e.preventDefault();
    debugger;

    toDoSection.innerHTML = "";
    reviewSection.innerHTML = "";
    doneSection.innerHTML = "";
    inProgressSection.innerHTML = "";

    let response = await fetch(BASE_URL);
    let boardData = await response.json();

    for (const key in boardData) {
      let { title, description, status, _id } = boardData[key];


      if (status === "ToDo") {
        
        let li = document.createElement("li");
        li.classList.add("task");
        let h3 = document.createElement("h3");
        h3.textContent = title;
        let p = document.createElement("p");
        p.textContent = description;
        li.appendChild(h3);
        li.appendChild(p);
        let toDoBtn = document.createElement("button");
        toDoBtn.textContent = "Move to In Progress";
        toDoBtn.id = _id;
        li.appendChild(toDoBtn);
        toDoSection.appendChild(li);
        toDoBtn.addEventListener("click", async (e) => {
            e.target.parentNode.remove();

            let newStatus = "In Progress";
            let id = e.target.id;

            let httpMethod = {
                method: "PATCH",
                body: JSON.stringify({title, description, status: newStatus})
            }

            await fetch(BASE_URL+id, httpMethod);
                        
          inProgressSection.appendChild(li);

          loadBoardBtnHandler();
          
        });

      } else if (status === "In Progress") {
        let li = document.createElement("li");
        li.classList.add("task");
        let h3 = document.createElement("h3");
        h3.textContent = title;
        let p = document.createElement("p");
        p.textContent = description;
        li.appendChild(h3);
        li.appendChild(p);
        let inProgressBtn = document.createElement("button");
        inProgressBtn.textContent = "Move to Code Review";
        inProgressBtn.id = _id;
        li.appendChild(inProgressBtn);
        inProgressSection.appendChild(li);
        inProgressBtn.addEventListener("click", async (e)=> {
            debugger
            e.target.parentNode.remove();

            let newStatus = "Code Review";
            let id = e.target.id;

            let httpMethod = {
                method: "PATCH",
                body: JSON.stringify({title, description, status: newStatus})
            }

            await fetch(BASE_URL+id, httpMethod);
                        
          reviewSection.appendChild(li);

          loadBoardBtnHandler();
        })
      } else if (status === "Code Review") {
        let li = document.createElement("li");
        li.classList.add("task");
        let h3 = document.createElement("h3");
        h3.textContent = title;
        let p = document.createElement("p");
        p.textContent = description;
        li.appendChild(h3);
        li.appendChild(p);
        let codeReviewBtn = document.createElement("button");
        codeReviewBtn.textContent = "Move to Done";
        codeReviewBtn.id = _id;
        li.appendChild(codeReviewBtn);
        reviewSection.appendChild(li);
        codeReviewBtn.addEventListener("click", async (e)=> {
            debugger
            e.target.parentNode.remove();

            let newStatus = "Done";
            let id = e.target.id;

            let httpMethod = {
                method: "PATCH",
                body: JSON.stringify({title, description, status: newStatus})
            }

            await fetch(BASE_URL+id, httpMethod);
                        
            doneSection.appendChild(li);

          loadBoardBtnHandler();
        });
      } else if (status === "Done") {
        let li = document.createElement("li");
        li.classList.add("task");
        let h3 = document.createElement("h3");
        h3.textContent = title;
        let p = document.createElement("p");
        p.textContent = description;
        li.appendChild(h3);
        li.appendChild(p);
        let doneBtn = document.createElement("button");
        doneBtn.textContent = "Close";
        doneBtn.id = _id;
        li.appendChild(doneBtn);
        doneSection.appendChild(li);
        doneBtn.addEventListener("click", async(e)=> {
            e.target.parentNode.remove();

            let id = e.target.id;
            let httpMethod = {
                method: "DELETE",

            }

            await fetch(BASE_URL+id, httpMethod);
                        
        //   reviewSection.appendChild(li);

          loadBoardBtnHandler();


        });
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
}

attachEvents();
