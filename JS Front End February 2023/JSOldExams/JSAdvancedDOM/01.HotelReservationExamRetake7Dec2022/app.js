window.addEventListener("load", solve);

function solve() {
  const firstNameInput = document.getElementById("first-name");
  const lastNameInput = document.getElementById("last-name");
  const dateInInput = document.getElementById("date-in");
  const dateOutInput = document.getElementById("date-out");
  const peopleCountInput = document.getElementById("people-count");
  const nextButton = document.getElementById("next-btn");
  const infoListUl = document.querySelector(".info-list");
  const confirmListUl = document.querySelector(".confirm-list");
  const verificationOne = document.getElementById("verification");

  nextButton.addEventListener("click", nextButtonHandler);

  function nextButtonHandler(event) {
    event.preventDefault();

    const firstName = firstNameInput.value;
    const lastName = lastNameInput.value;
    const dateIn = dateInInput.value;
    const dateOut = dateOutInput.value;
    const peopleCount = peopleCountInput.value;

    if (
      firstNameInput.value === "" ||
      lastNameInput.value === "" ||
      peopleCountInput.value === "" ||
      dateInInput.value === "" ||
      dateOutInput.value === "" ||
      dateOutInput.value < dateInInput.value
    ) {
      return;
    }

    let li = document.createElement("li");
    li.classList.add("reservation-content");

    let article = document.createElement("article");

    let name = document.createElement("h3");
    name.textContent = `Name: ${firstName} ${lastName}`;

    let dateInParagraph = document.createElement("p");
    dateInParagraph.textContent = `From date: ${dateIn}`;

    let dateOutParagraph = document.createElement("p");
    dateOutParagraph.textContent = `To date: ${dateOut}`;

    let peopleCountParagraph = document.createElement("p");
    peopleCountParagraph.textContent = `For ${peopleCount} people`;

    let editBtn = document.createElement("button");
    editBtn.classList.add("edit-btn");
    editBtn.textContent = "Edit";
    editBtn.disabled = false;

    let continueBtn = document.createElement("button");
    continueBtn.classList.add("continue-btn");
    continueBtn.textContent = "Continue";
    continueBtn.disabled = false;

    article.appendChild(name);
    article.appendChild(dateInParagraph);
    article.appendChild(dateOutParagraph);
    article.appendChild(peopleCountParagraph);

    li.appendChild(article);
    li.appendChild(editBtn);
    li.appendChild(continueBtn);

    infoListUl.appendChild(li);

    firstNameInput.value = "";
    lastNameInput.value = "";
    dateInInput.value = "";
    dateOutInput.value = "";
    peopleCountInput.value = "";

    nextButton.disabled = true;

    editBtn.addEventListener("click", editBtnHandler);

    function editBtnHandler(event) {

      nextButton.disabled = false;

      firstNameInput.value = firstName;
      lastNameInput.value = lastName;
      dateInInput.value = dateIn;
      dateOutInput.value = dateOut;
      peopleCountInput.value = peopleCount;

      infoListUl.innerHTML = "";
    }

    continueBtn.addEventListener("click", continueBtnHandler);

    function continueBtnHandler(event) {

      confirmListUl.appendChild(li);
    //   confirmListUl.innerHTML = infoListUl.innerHTML;
      
      infoListUl.innerHTML = "";

      let confirmBtn = document.querySelector(
        ".edit-btn"
      );
      confirmBtn.setAttribute("class", "confirm-btn");
      confirmBtn.textContent = "Confirm";
      confirmBtn.disabled = false;

      let cancelBtn = document.querySelector(
        ".continue-btn"
      );
      cancelBtn.setAttribute("class", "cancel-btn");
      cancelBtn.textContent = "Cancel";

      confirmBtn.addEventListener("click", confirmHandler);

      cancelBtn.addEventListener("click", cancelHandler);

      function confirmHandler(event) {

        confirmListUl.innerHTML = "";
        nextButton.disabled = false;

        verificationOne.setAttribute("class", "reservation-confirmed");
        verificationOne.textContent = "Confirmed.";

      }

      function cancelHandler(event) {

        confirmListUl.innerHTML = "";
        nextButton.disabled = false;

        verificationOne.setAttribute("class", "reservation-cancelled");
        verificationOne.textContent = "Cancelled.";

      }
    }
  }
}
