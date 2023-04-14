window.addEventListener("load", solve);

function solve() {
  const titleInput = document.getElementById("title");
  const descriptionInput = document.getElementById("description");
  const labelInput = document.getElementById("label");
  const pointsInput = document.getElementById("points");
  const assigneeInput = document.getElementById("assignee");
  const taskIdInput = document.getElementById("task-id");

  const createBtn = document.getElementById("create-task-btn");
  const deleteBtn = document.getElementById("delete-task-btn");
  const tasksSectionContainer = document.getElementById("tasks-section");
  deleteBtn.disabled = true;
  let totalPointsElement = document.getElementById("total-sprint-points");

  createBtn.addEventListener("click", createBtnHandler);
  let currentTaskNumber = 0;
  let totalPoints = 0;
  let currentLabel = "";

  const iconsCodes = {
    Feature: " &#8865",
    "Low Priority Bug": "&#9737",
    "High Priority Bug": "&#9888",
  };

  function createBtnHandler(event) {
    event.preventDefault();

    let title = titleInput.value;
    let description = descriptionInput.value;
    let label = labelInput.value;
    let points = Number(pointsInput.value);
    let assignee = assigneeInput.value;
    totalPoints += points;
    currentTaskNumber++;
    taskIdInput.textContent = currentTaskNumber;
    totalPointsElement.textContent = `Total Points ${totalPoints}pts`;

    if (!title || !description || !label || !points || !assignee) {
      return;
    }

    let articleEl = createElement("article", null, tasksSectionContainer, [
      "task-card",
    ]);
    articleEl.setAttribute("id", `task-${currentTaskNumber}`);

    if (labelInput.value === "Feature") {
      currentLabel = labelInput.value;

      let divIcons = createElement("div", ``, articleEl, [
        "task-card-label",
        "feature",
      ]);
      divIcons.innerHTML = `${label} ${iconsCodes[label]}`;
    } else if (labelInput.value === "Low Priority Bug") {
      let divIcons = createElement("div", `${label}`, articleEl, [
        "task-card-label",
        "low-priority",
      ]);
      divIcons.innerHTML = `${label} ${iconsCodes[label]}`;
    } else if (labelInput.value === "High Priority Bug") {
      let divIcons = createElement(
        "div",
        `${label} ${iconsCodes[label]}`,
        articleEl,
        ["task-card-label", "high-priority"]
      );
      divIcons.innerHTML = `${label} ${iconsCodes[label]}`;
    }
    createElement("h3", `${title}`, articleEl, ["task-card-title"]);
    createElement("p", `${description}`, articleEl, ["task-card-description"]);
    createElement("div", `Estimated at ${points} pts`, articleEl, [
      "task-card-points",
    ]);
    createElement("div", `Assigned to: ${assignee}`, articleEl, [
      "task-card-assignee",
    ]);

    let buttonActionDiv = createElement("div", null, articleEl, [
      "task-card-actions",
    ]);
    let deleteBtnAction = createElement("button", "Delete", buttonActionDiv);

    titleInput.value = "";
    descriptionInput.value = "";
    labelInput.value = "";
    pointsInput.value = "";
    assigneeInput.value = "";

    deleteBtnAction.addEventListener("click", deleteBtnActionHandler);

    function deleteBtnActionHandler(e) {
      e.preventDefault();
      titleInput.value = title;
      descriptionInput.value = description;
      labelInput.value = label;
      pointsInput.value = points;
      assigneeInput.value = assignee;

      deleteBtn.disabled = false;

      createBtn.disabled = true;
      titleInput.disabled = true;
      descriptionInput.disabled = true;
      labelInput.disabled = true;
      pointsInput.disabled = true;
      assigneeInput.disabled = true;

      deleteBtn.addEventListener("click", () => {
        debugger;
        articleEl.remove();
        totalPoints -= Number(pointsInput.value);
        totalPointsElement.textContent = `Total Points ${totalPoints}pts`;
        titleInput.value = "";
        descriptionInput.value = "";
        labelInput.value = "";
        pointsInput.value = "";
        assigneeInput.value = "";

        createBtn.disabled = false;
        titleInput.disabled = false;
        descriptionInput.disabled = false;
        labelInput.disabled = false;
        pointsInput.disabled = false;
        assigneeInput.disabled = false;

        deleteBtn.disabled = true;

        createBtn.disabled = false;
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
