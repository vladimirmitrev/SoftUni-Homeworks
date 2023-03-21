window.addEventListener("load", solve);

function solve() {
  const firstNameInput = document.getElementById("first-name");
  const lastNameInput = document.getElementById("last-name");
  const ageInput = document.getElementById("age");
  const titleInput = document.getElementById("story-title");
  const genreInput = document.getElementById("genre");
  const storyInput = document.getElementById("story");
  let preview = document.getElementById("preview-list");
  let main = document.getElementById("main");
  const publishBtn = document.getElementById("form-btn");

  publishBtn.addEventListener("click", publishInfo);

  function publishInfo(event) {
    event.preventDefault();

    if (
      firstNameInput.value === "" ||
      lastNameInput.value === "" ||
      ageInput.value === "" ||
      titleInput.value === "" ||
      storyInput.value === ""
    ) {
      return;
    }

    let li = document.createElement("li");
    li.className = "story-info";
    let article = document.createElement("article");

    let name = document.createElement("h4");
    name.textContent = `Name: ${firstNameInput.value} ${lastNameInput.value}`;
    let age = document.createElement("p");
    age.textContent = `Age: ${ageInput.value}`;
    let title = document.createElement("p");
    title.textContent = `Title: ${titleInput.value}`;
    let genre = document.createElement("p");
    genre.textContent = `Genre: ${genreInput.value}`;
    let story = document.createElement("p");
    story.textContent = `${storyInput.value}`;

    let saveBtn = document.createElement("button");
    saveBtn.className = "save-btn";
    saveBtn.textContent = "Save Story";

    let editBtn = document.createElement("button");
    editBtn.className = "edit-btn";
    editBtn.textContent = "Edit Story";

    let deleteBtn = document.createElement("button");
    deleteBtn.className = "delete-btn";
    deleteBtn.textContent = "Delete Story";

    article.appendChild(name);
    article.appendChild(age);
    article.appendChild(title);
    article.appendChild(genre);
    article.appendChild(story);

    li.appendChild(article);
    li.appendChild(saveBtn);
    li.appendChild(editBtn);
    li.appendChild(deleteBtn);

    preview.appendChild(li);

    let editFirstName = firstNameInput.value;
    let editLastName = lastNameInput.value;
    let editAge = ageInput.value;
    let editTitle = titleInput.value;
    let editStory = storyInput.value;

    firstNameInput.value = "";
    lastNameInput.value = "";
    ageInput.value = "";
    titleInput.value = "";
    storyInput.value = "";

    publishBtn.disabled = true;

    editBtn.addEventListener("click", editFunction);

    deleteBtn.addEventListener("click", deleteFunction);

    saveBtn.addEventListener("click", saveFunction);

    function editFunction() {
      firstNameInput.value = editFirstName;
      lastNameInput.value = editLastName;
      ageInput.value = editAge;
      titleInput.value = editTitle;
      storyInput.value = editStory;

      li.remove();
      publishBtn.disabled = false;
    }

    function saveFunction() {
      let main = document.getElementById("main");
      let leftElement = document.querySelector(".form-wrapper");
      let rightElement = document.querySelector("#side-wrapper");
      leftElement.remove();
      rightElement.remove();
      let finalTitle = document.createElement("h1");
      finalTitle.textContent = "Your scary story is saved!";
      main.appendChild(finalTitle);
    }

    function deleteFunction() {
      li.remove();
      publishBtn.disabled = false;
    }
  }
}
