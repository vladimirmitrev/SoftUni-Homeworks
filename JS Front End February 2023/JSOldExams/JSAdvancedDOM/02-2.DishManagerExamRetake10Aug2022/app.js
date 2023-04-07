window.addEventListener("load", solve);

function solve() {
  const firstNameInput = document.getElementById("first-name");
  const lastNameInput = document.getElementById("last-name");
  const ageInput = document.getElementById("age");
  const genderInput = document.getElementById("genderSelect");
  const descriptionInput = document.getElementById("task");

  const submitBtn = document.getElementById("form-btn");
  const inProgressContainer = document.getElementById("in-progress");
  const finishedContainer = document.getElementById("finished");
  const clearBtn = document.getElementById("clear-btn");
  const dishesInProgressCount = document.getElementById("progress-count");

  let totalInProgress = 0;

  submitBtn.addEventListener("click", submitBtnHandler);

  function submitBtnHandler(event) {
    event.preventDefault();

    let firstName = firstNameInput.value;
    let lastName = lastNameInput.value;
    let age = ageInput.value;
    let gender = genderInput.value;
    let description = descriptionInput.value;

    if (!firstName || !lastName || !age || !description) {
      return;
    }

    let li = createElement("li", null, inProgressContainer, ["each-line"]);

    let articleEl = createElement("article", null, li);
    createElement("h4", `${firstName} ${lastName}`, articleEl);
    createElement("p", `${gender}, ${age}`, articleEl);
    createElement("p", `Dish description: ${description}`, articleEl);

    let editBtn = createElement("button", "Edit", li, ["edit-btn"]);
    let completeBtn = createElement("button", "Mark as complete", li, [
      "complete-btn",
    ]);

    firstNameInput.value = "";
    lastNameInput.value = "";
    ageInput.value = "";
    genderInput.value = "";
    descriptionInput.value = "";

    totalInProgress++;
    dishesInProgressCount.textContent = totalInProgress;

    editBtn.addEventListener("click", editBtnHandler);
    completeBtn.addEventListener("click", completeBtnHandler);

    function editBtnHandler(e) {
      e.target.parentNode.remove();
      totalInProgress--;
      dishesInProgressCount.textContent = totalInProgress;

      firstNameInput.value = firstName;
      lastNameInput.value = lastName;
      ageInput.value = age;
      genderInput.value = gender;
      descriptionInput.value = description;
    }

    function completeBtnHandler(e) {
      e.target.parentNode.remove();
      totalInProgress--;
      dishesInProgressCount.textContent = totalInProgress;

      let li = createElement("li", null, finishedContainer, ["each-line"]);

      let articleEl = createElement("article", null, li);
      createElement("h4", `${firstName} ${lastName}`, articleEl);
      createElement("p", `${gender}, ${age}`, articleEl);
      createElement("p", `Dish description: ${description}`, articleEl);

      clearBtn.addEventListener("click", () => {
        li.remove();
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
