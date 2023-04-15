window.addEventListener("load", solve);

function solve() {
  const firstNameInput = document.querySelector("#first-name");
  const lastNameInput = document.querySelector("#last-name");
  const countOfPeopleInput = document.querySelector("#people-count");
  const dateFromInput = document.querySelector("#from-date");
  const numberOfDaysInput = document.querySelector("#days-count");
  const nextBtn = document.querySelector("#next-btn");
  const ticketPreviewContainer = document.querySelector(".ticket-info-list");
  const confirmContainer = document.querySelector(".confirm-ticket");
  const mainElement = document.querySelector("#main");
  const body = document.querySelector("#body");

  nextBtn.addEventListener("click", nextBtnHandler);

  function nextBtnHandler(e) {
    if(e){

      e.preventDefault();
    }
    let firstName = firstNameInput.value;   
    let lastName = lastNameInput.value;
    let countOfPeople = countOfPeopleInput.value;
    let dateFrom = dateFromInput.value;
    let numberOfDays = numberOfDaysInput.value;

    ///check
    if (
      !firstName ||
      !lastName ||
      !countOfPeople ||
      !dateFrom ||
      !numberOfDays
    ) {
      return;
    }

    let li = document.createElement("li");
    li.classList.add("ticket");

    let article = createEl("article", null, li);
    createEl("h3", `Name: ${firstName} ${lastName}`, article);
    createEl("p", `From date: ${dateFrom}`, article);
    createEl("p", `For ${numberOfDays} days`, article);
    createEl("p", `For ${countOfPeople} people`, article);
    let editBtn = createEl("button", "Edit", li, ["edit-btn"]);
    let continueBtn = createEl("button", "Continue", li, ["continue-btn"]);

    ticketPreviewContainer.appendChild(li);

    firstNameInput.value = "";
    lastNameInput.value = "";
    countOfPeopleInput.value = "";
    dateFromInput.value = "";
    numberOfDaysInput.value = "";

    nextBtn.disabled = true;

    editBtn.addEventListener("click", (e)=> {
      e.target.parentNode.parentNode.remove();
      nextBtn.disabled = false;
      firstNameInput.value = firstName;
      lastNameInput.value = lastName;
      countOfPeopleInput.value = countOfPeople;
      dateFromInput.value = dateFrom;
      numberOfDaysInput.value = numberOfDays;
    });

    continueBtn.addEventListener("click", continueHandler);

    // function editHandler(e) {
     
    // }

    function continueHandler(e) {
      e.target.parentNode.parentNode.remove();
      let li = document.createElement("li");
      li.classList.add("confirm-ticket");

      let article = createEl("article", null, li);
      createEl("h3", `Name: ${firstName} ${lastName}`, article);
      createEl("p", `From date: ${dateFrom}`, article);
      createEl("p", `For ${numberOfDays} days`, article);
      createEl("p", `For ${countOfPeople} people`, article);
      let confirmBtn = createEl("button", "Confirm", li, ["confirm-btn"]);
      let cancelBtn = createEl("button", "Cancel", li, ["cancel-btn"]);

      confirmContainer.appendChild(li);
      cancelBtn.addEventListener("click", (e) => {
        e.target.parentNode.parentNode.remove();
        nextBtn.disabled = false;
      });

      confirmBtn.addEventListener("click", (e) => {
        mainElement.remove();
        let finalTitle = createEl("h1", "Thank you, have a nice day!", body);
        finalTitle.setAttribute("id", "thank-you");
        let backBtn = createEl("button", "Back", body);
        backBtn.setAttribute("id", "back-btn");

        backBtn.addEventListener("click", () => {
          window.location.reload();
        });
      });
    }
  }

  function createEl(type, text, parent, classes) {
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
