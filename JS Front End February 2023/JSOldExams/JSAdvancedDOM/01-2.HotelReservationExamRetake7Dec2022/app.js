window.addEventListener("load", solve);

function solve() {
  const firstNameInput = document.getElementById("first-name");
  const lastNameInput = document.getElementById("last-name");
  const dateInInput = document.getElementById("date-in");
  const dateOutInput = document.getElementById("date-out");
  const peopleCountInput = document.getElementById("people-count");
  const nextBtn = document.getElementById("next-btn");

  const reservationInfContainer = document.querySelector(".info-list");
  const confirmInfoContainer = document.querySelector(".confirm-list");
  const verification = document.querySelector("#verification");

  nextBtn.addEventListener("click", nextBtnHandler);

  function nextBtnHandler(e) {
    e.preventDefault();

    let firstName = firstNameInput.value;
    let lastName = lastNameInput.value;
    let dateIn = dateInInput.value;
    let dateOut = dateOutInput.value;
    let peopleCount = peopleCountInput.value;

    if (
      !firstName ||
      !lastName ||
      !dateIn ||
      !dateOut ||
      !peopleCount ||
      dateIn > dateOut
    ) {
      return;
    }

    let li = document.createElement('li');
    li.setAttribute("class", "reservation-content")


    let articleEl = createElement("article", null, li);
    createElement("h3", `Name: ${firstName} ${lastName}`, articleEl);
    createElement("p", `From date: ${dateIn}`, articleEl);
    createElement("p", `To date: ${dateOut}`, articleEl);
    createElement("p", `For ${peopleCount} people`, articleEl);

    let editBtn = createElement("button", "Edit", li, ["edit-btn"]);
    let continueBtn = createElement("button", "Continue", li, ["continue-btn"]);

    reservationInfContainer.appendChild(li);

    nextBtn.disabled = true;

    firstNameInput.value = "";
    lastNameInput.value = "";
    dateInInput.value = "";
    dateOutInput.value = "";
    peopleCountInput.value = "";

    editBtn.addEventListener("click", editBtnHandler);

    continueBtn.addEventListener("click", continueBtnHandler);


    function editBtnHandler(event) {
        event.target.parentNode.remove();
    //   li.remove();

      firstNameInput.value = firstName;
      lastNameInput.value = lastName;
      dateInInput.value = dateIn;
      dateOutInput.value = dateOut;
      peopleCountInput.value = peopleCount;
      nextBtn.disabled = false;
    }

    function continueBtnHandler(event) {
        confirmInfoContainer.appendChild(li);
        editBtn.remove();
        continueBtn.remove();

        let confirmBtn = createElement("button", "Confirm", li, ["confirm-btn"]);
        let cancelBtn = createElement("button", "Cancel", li, ["cancel-btn"]);

        confirmBtn.addEventListener("click", (event) => {
            event.target.parentNode.remove();
            nextBtn.disabled = false;
            verification.setAttribute("class", "reservation-confirmed");
            verification.textContent = "Confirmed.";
        });

        cancelBtn.addEventListener("click", (event) => {
            event.target.parentNode.remove();
            nextBtn.disabled = false;
            verification.setAttribute("class", "reservation-cancelled");
            verification.textContent = "Cancelled.";
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
