window.addEventListener("load", solve);

function solve() {
  const firstNameInput = document.querySelector("#first-name");
  const lastNameInput = document.querySelector("#last-name");
  const ageInput = document.querySelector("#age");
  const titleInput = document.querySelector("#story-title");
  const genreInput = document.querySelector("#genre");
  const textInput = document.querySelector("#story");
  const main = document.querySelector("#main");

  const publishBtn = document.querySelector("#form-btn");
  const previewContainer = document.querySelector("#preview-list");

  publishBtn.addEventListener("click", publishBtnHandler);

  function publishBtnHandler(event) {
    event.preventDefault();

    let firstName = firstNameInput.value;
    let lastName = lastNameInput.value;
    let age = ageInput.value;
    let title = titleInput.value;
    let genre = genreInput.value;
    let text = textInput.value;

    if (!firstName || !lastName || !age || !title || !text) {
      return;
    }

    let li = createElement("li", null, previewContainer, ["story-info"]);
    let articleEl = createElement("article", null, li);
    createElement("h4", `Name: ${firstName} ${lastName}`, articleEl);
    createElement("p", `Age: ${age}`, articleEl);
    createElement("p", `Title: ${title}`, articleEl);
    createElement("p", `Genre: ${genre}`, articleEl);
    createElement("p", `${text}`, articleEl);

    let saveBtn = createElement("button", "Save Story", li, ["save-btn"]);
    let editBtn = createElement("button", "Edit Story", li, ["edit-btn"]);
    let deleteBtn = createElement("button", "Delete Story", li, ["delete-btn"]);

    publishBtn.disabled = true;

    firstNameInput.value = "";
    lastNameInput.value = "";
    ageInput.value = "";
    titleInput.value = "";
    genreInput.value = "";
    textInput.value = "";

    editBtn.addEventListener("click", editBtnHandler);
    saveBtn.addEventListener("click", saveBtnHandler);
    deleteBtn.addEventListener("click", deleteBtnHandler);

    function saveBtnHandler(e) {
      main.innerHTML = "";
      createElement("h1", "Your scary story is saved!", main);

    }
    function deleteBtnHandler(e) {
      e.target.parentNode.remove();
      publishBtn.disabled = false;
    }
 
    function editBtnHandler(e) {
      e.target.parentNode.remove();

      firstNameInput.value = firstName;
      lastNameInput.value = lastName;
      ageInput.value = age;
      titleInput.value = title;
      genreInput.value = genre;
      textInput.value = text;

      publishBtn.disabled = false
      // saveBtn.disabled = true;
      // editBtn.disabled = true;
      // deleteBtn.disabled = true;
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
