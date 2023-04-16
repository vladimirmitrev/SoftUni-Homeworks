function solve() {
  const sumSpan = document.querySelector("#sum");
  const firstNameInput = document.querySelector("#fname");
  const lastNameInput = document.querySelector("#lname");
  const emailInput = document.querySelector("#email");
  const birthDateInput = document.querySelector("#birth");
  const positionInput = document.querySelector("#position");
  const salaryInput = document.querySelector("#salary");
  const addBtn = document.querySelector("#add-worker");
  const tableBody = document.querySelector("#tbody");

  let totalSum = 0;

  addBtn.addEventListener("click", addBtnHandler);

  function addBtnHandler(event) {
    event.preventDefault();

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

    let tableRow = createElement("tr", "", tableBody);
    createElement("td", `${firstName}`, tableRow);
    createElement("td", `${lastName}`, tableRow);
    createElement("td", `${email}`, tableRow);
    createElement("td", `${birthDate}`, tableRow);
    createElement("td", `${position}`, tableRow);
    createElement("td", `${salary}`, tableRow);
    let buttonsTd = createElement("td", "", tableRow);
    let firedBtn = createElement("button", "Fired", buttonsTd, ["fired"]);
    let editBtn = createElement("button", "Edit", buttonsTd, ["edit"]);

    totalSum += salary;

    sumSpan.textContent = totalSum.toFixed(2);

    firstNameInput.value = "";
    lastNameInput.value = "";
    emailInput.value = "";
    birthDateInput.value = "";
    positionInput.value = "";
    salaryInput.value = "";

    editBtn.addEventListener("click", editBtnHandler);
    firedBtn.addEventListener("click", firedBtnHandler);

    function firedBtnHandler(e) {
      e.target.parentNode.parentNode.remove();
      totalSum -= salary;
      sumSpan.textContent = totalSum.toFixed(2);
    }

    function editBtnHandler(e) {
      e.target.parentNode.parentNode.remove();

      firstNameInput.value = firstName;
      lastNameInput.value = lastName;
      emailInput.value = email;
      birthDateInput.value = birthDate;
      positionInput.value = position;
      salaryInput.value = salary;

      totalSum -= salary;
      sumSpan.textContent = totalSum.toFixed(2);
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
