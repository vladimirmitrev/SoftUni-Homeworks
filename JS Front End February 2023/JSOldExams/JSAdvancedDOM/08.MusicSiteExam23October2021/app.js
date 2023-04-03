window.addEventListener("load", solve);

function solve() {
  const allInputs = Array.from(document.querySelectorAll(".container-text input"));
  const addBtn = document.querySelector("#add-btn");
  const allHitsContainer = document.querySelector(".all-hits-container");
  const savedHitsContainer = document.querySelector(".saved-container");

  const likesParagraph = document.querySelector(" #total-likes > div > p");

  let totalLikes = 0;

  let [genreInput, nameInput, authorInput, dateInput] = allInputs;

  addBtn.addEventListener("click", addBtnHandler);

  function addBtnHandler(event) {
    event.preventDefault();
    const allInputsFilled = allInputs.every((input) => input.value !== "");

    if (!allInputsFilled) {
      return;
    }

    let genre = genreInput.value;
    let name = nameInput.value;
    let author = authorInput.value;
    let date = dateInput.value;

    const hitsInfoDiv = document.createElement("div");
    hitsInfoDiv.classList.add("hits-info");

    const img = document.createElement("img");
    img.src = "./static/img/img.png";
    hitsInfoDiv.appendChild(img);

    createElement("h2", `Genre: ${genre}`, hitsInfoDiv);
    createElement("h2", `Name: ${name}`, hitsInfoDiv);
    createElement("h2", `Author: ${author}`, hitsInfoDiv);
    createElement("h3", `Date: ${date}`, hitsInfoDiv);

    const saveBtn = createElement("button", "Save song", hitsInfoDiv, ["save-btn"]);
    const likeBtn = createElement("button", "Like song", hitsInfoDiv, ["like-btn"]);
    const deleteBtn = createElement("button", "Delete", hitsInfoDiv, ["delete-btn"]);

    allHitsContainer.appendChild(hitsInfoDiv);

    clearAllInputs();

    likeBtn.addEventListener("click", likeBtnHandler);

    saveBtn.addEventListener("click", saveBtnHandler);

    deleteBtn.addEventListener("click", deleteBtnHandler);

    function deleteBtnHandler(e) {
        hitsInfoDiv.remove();
    }

    function saveBtnHandler(e) {
      savedHitsContainer.appendChild(hitsInfoDiv);
      hitsInfoDiv.removeChild(likeBtn);
      hitsInfoDiv.removeChild(saveBtn);
    }

    function likeBtnHandler(e) {
      likeBtn.disabled = true;
      totalLikes++;
      likesParagraph.textContent = `Total Likes: ${totalLikes}`;
    }
  }
  function clearAllInputs() {
    allInputs.forEach((input) => (input.value = ""));
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
