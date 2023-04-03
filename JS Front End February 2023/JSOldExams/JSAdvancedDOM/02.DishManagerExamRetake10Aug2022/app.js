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
  const spanCounter = document.getElementById("progress-count");

  let totalProgress = 0;
  submitBtn.addEventListener("click", submitBtnHandler);

  function submitBtnHandler(event) {
    event.preventDefault();

    firstName = firstNameInput.value;
    lastName = lastNameInput.value;
    age = ageInput.value;
    gender = genderInput.value;
    description = descriptionInput.value;

    if (!firstName || !lastName || !age || !description) {
      return;
    }

    let li = document.createElement("li");
    li.classList.add("each-line");

    let articleEl = createElement("article", null, li);

    createElement("h4", `${firstName} ${lastName}`, articleEl);
    createElement("p", `${gender}, ${age}`, articleEl);
    createElement("p", `Dish description: ${description}`, articleEl);

    let editBtn = createElement("button", "Edit", li, ["edit-btn"]);

    let completeBtn = createElement("button", "Complete", li, ["complete-btn"]);

    inProgressContainer.appendChild(li);

    totalProgress++;
    spanCounter.textContent = totalProgress;

    firstNameInput.value = "";
    lastNameInput.value = "";
    ageInput.value = "";
    descriptionInput.value = "";

    editBtn.addEventListener("click", editBtnHandler);
    completeBtn.addEventListener("click", completeBtnHandler);

    function editBtnHandler(e) {
      e.target.parentNode.remove();
      totalProgress--;
      spanCounter.textContent = totalProgress;

      firstNameInput.value = firstName;
      lastNameInput.value = lastName;
      ageInput.value = age;
      genderInput.value = gender;
      descriptionInput.value = description;
    }

    function completeBtnHandler(e) {
      e.target.parentNode.remove();
      totalProgress--;
      spanCounter.textContent = totalProgress;

      let li = document.createElement("li");
      li.classList.add("each-line");

      let articleEl = createElement("article", null, li);

      createElement("h4", `${firstName} ${lastName}`, articleEl);
      createElement("p", `${gender}, ${age}`, articleEl);
      createElement("p", `Dish description: ${description}`, articleEl);

      finishedContainer.appendChild(li);
      clearBtn.addEventListener("click", () => {
        li.remove();
      });
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
}
