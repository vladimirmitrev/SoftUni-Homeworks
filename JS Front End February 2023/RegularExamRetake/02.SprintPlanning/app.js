window.addEventListener("load", solve);

function solve() {
  const tasksSectionContainer = document.getElementById("tasks-section");
  const titleInput = document.getElementById("title");
  const descriptionInput = document.getElementById("description");
  const labelInput = document.getElementById("label");
  const pointsInput = document.getElementById("points");
  const assigneeInput = document.getElementById("assignee");
  const createTaskBtn = document.getElementById("create-task-btn");
  const deleteTaskBtn = document.getElementById("delete-task-btn");
const totalPointsElement = document.getElementById("total-sprint-points");
  createTaskBtn.addEventListener("click", createTaskBtnHandler);

  let taskCounter = 0;
  let totalPoints = 0;

  let icons = {
    Feature: "&#8865",
    "Low Priority Bug": "&#9737",
    "High Priority Bug": "&#9888",
  };

  function createTaskBtnHandler(e) {
    e.preventDefault();

    let title = titleInput.value;
    let description = descriptionInput.value;
    let label = labelInput.value;
    let points = Number(pointsInput.value);
    let assignee = assigneeInput.value;

    if (!title || !description || !label || !points || !assignee) {
      return;
    }
    taskCounter++;
    totalPoints += points;
    totalPointsElement.textContent = `Total Points ${totalPoints}pts`;
    resetInputs();

    let articleEl = createElement("article", null, tasksSectionContainer, [
      "task-card",
    ]);
    articleEl.setAttribute("id", `task-${taskCounter}`);
    if(label === "Feature") {
       let divWithIcon =  createElement("div", null, articleEl, ["task-card-label", "feature"]);
    //    divWithIcon.innerHTML = `${label} ${"&#8865"}`;
       divWithIcon.innerHTML = `${label} ${icons[label]}`;
    } else if(label === "Low Priority Bug") {
        let divWithIcon =  createElement("div", null, articleEl, ["task-card-label", "low-priority"]);
    //    divWithIcon.innerHTML = `${label} ${"&#9737"}`;
        divWithIcon.innerHTML = `${label} ${icons[label]}`;
    } else if(label === "High Priority Bug") {
        let divWithIcon =  createElement("div", null, articleEl, ["task-card-label", "high-priority"]);
    //    divWithIcon.innerHTML = `${label} ${"&#9888"}`;
       divWithIcon.innerHTML = `${label} ${icons[label]}`;
    }
    createElement("h3", `${title}`, articleEl, ["task-card-title"]);
    createElement("p", `${description}`, articleEl, ["task-card-description"]);
    createElement("div", `Estimated at ${points} pts`, articleEl, ["task-card-points"]);
    createElement("div", `Assigned to: ${assignee}`, articleEl, ["task-card-assignee"]);

    let actionDiv = createElement("div", null, articleEl, ["task-card-actions"]);
    let deleteBtn = createElement("button", "Delete", actionDiv);

    deleteBtn.addEventListener("click", deleteBtnHandler);


    function deleteBtnHandler(e) {
        titleInput.value = title;
        descriptionInput.value = description;
        labelInput.value = label;
        pointsInput.value = points;
        assigneeInput.value = assignee;

        createTaskBtn.disabled = true;
        deleteTaskBtn.disabled = false;

        titleInput.disabled = true;
        descriptionInput.disabled = true;
        labelInput.disabled = true;
        pointsInput.disabled = true;
        assigneeInput.disabled = true;

        deleteTaskBtn.addEventListener("click", ()=> {
            e.target.parentNode.parentNode.remove();

            totalPoints -= pointsInput.value;
            totalPointsElement.textContent = `Total Points ${totalPoints}pts`;

            createTaskBtn.disabled = false;
            deleteTaskBtn.disabled = true;
            resetInputs();
        });
    }
  }

  function resetInputs() {
    titleInput.value = "";
    descriptionInput.value = "";
    labelInput.value = "";
    pointsInput.value = "";
    assigneeInput.value = "";

    titleInput.disabled = false;
    descriptionInput.disabled = false;
    labelInput.disabled = false;
    pointsInput.disabled = false;
    assigneeInput.disabled = false;
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
