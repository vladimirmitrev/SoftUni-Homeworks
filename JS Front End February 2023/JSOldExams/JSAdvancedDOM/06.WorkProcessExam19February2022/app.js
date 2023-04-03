function solve() {
  const firstNameInput = document.querySelector("#fname");
  const lastNameInput = document.querySelector("#lname");
  const emailInput = document.querySelector("#email");
  const birthDateInput = document.querySelector("#birth");
  const positionInput = document.querySelector("#position");
  const salaryInput = document.querySelector("#salary");

  const hireWorkerBtn = document.querySelector("#add-worker");

  const tableBody = document.querySelector("#tbody");
  const sumElement = document.querySelector("#sum");

  let totalBudget = 0;

  hireWorkerBtn.addEventListener("click", hireWorkerBtnHandler);

  function hireWorkerBtnHandler(e) {
    e.preventDefault();

    let firstName = firstNameInput.value;
    let lastName = lastNameInput.value;
    let email = emailInput.value;
    let birthDate = birthDateInput.value;
    let position = positionInput.value;
    let salary = Number(salaryInput.value);

    if (
      !firstName ||
      !lastName ||
      !email ||
      !birthDate ||
      !position ||
      !salary
    ) {
      return;
    }

    let tableRow = document.createElement("tr");

    createElement("td", `${firstName}`, tableRow);
    createElement("td", `${lastName}`, tableRow);
    createElement("td", `${email}`, tableRow);
    createElement("td", `${birthDate}`, tableRow);
    createElement("td", `${position}`, tableRow);
    createElement("td", `${salary}`, tableRow);

    let tdAction = createElement("td", null, tableRow);
    let firedBtn = createElement("button", "Fired", tdAction, ["fired"]);
    let editBtn = createElement("button", "Edit", tdAction, ["edit"]);

    tableBody.appendChild(tableRow);

    totalBudget += salary;
    sumElement.textContent = totalBudget.toFixed(2);

    firstNameInput.value = "";
    lastNameInput.value = "";
    emailInput.value = "";
    birthDateInput.value = "";
    positionInput.value = "";
    salaryInput.value = "";

    editBtn.addEventListener("click", editBtnHandler);

    firedBtn.addEventListener("click", firedBtnHandler);

    function editBtnHandler(e) {
      tableRow.remove();

      totalBudget -= salary;
      sumElement.textContent = totalBudget.toFixed(2);

      firstNameInput.value = firstName;
      lastNameInput.value = lastName;
      emailInput.value = email;
      birthDateInput.value = birthDate;
      positionInput.value = position;
      salaryInput.value = salary;
    }

    function firedBtnHandler(e) {
      tableRow.remove();

      totalBudget -= salary;
      sumElement.textContent = totalBudget.toFixed(2);
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
solve();
