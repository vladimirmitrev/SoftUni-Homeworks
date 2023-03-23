window.addEventListener("load", solve);

function solve() {
  const genre = document.getElementById("genre");
  const name = document.getElementById("name");
  const author = document.getElementById("author");
  const date = document.getElementById("date");
  const addBtn = document.getElementById("add-btn");
  const allHitsContainer = document.querySelector(
    "#all-hits > .all-hits-container"
  );
  const savedContainer = document.querySelector(
    "#saved-hits > .saved-container"
  );
  const totalLikes = document.querySelector("#total-likes > .likes > p");
  let totalLikeCount = 0;
  
  addBtn.addEventListener("click", addSong);

  function addSong(event) {
    event.preventDefault();

    if (
      genre.value === "" ||
      name.value === "" ||
      author.value === "" ||
      date.value === ""
    ) {
      return;
    }

    let divHitsInfo = document.createElement("div");
    divHitsInfo.classList.add("hits-info");

    let img = document.createElement("img");
    img.src = "./static/img/img.png";

    let genreElement = document.createElement("h2");
    genreElement.textContent = `Genre: ${genre.value}`;

    let nameElement = document.createElement("h2");
    nameElement.textContent = `Name: ${name.value}`;

    let authorElement = document.createElement("h2");
    authorElement.textContent = `Author: ${author.value}`;

    let dateElement = document.createElement("h3");
    dateElement.textContent = `Date: ${date.value}`;

    let saveBtn = document.createElement("button");
    saveBtn.classList.add("save-btn");
    saveBtn.textContent = "Save song";

    let likeBtn = document.createElement("button");
    likeBtn.classList.add("like-btn");
    likeBtn.textContent = "Like song";

    let deleteBtn = document.createElement("button");
    deleteBtn.classList.add("delete-btn");
    deleteBtn.textContent = "Delete";

    divHitsInfo.appendChild(img);
    divHitsInfo.appendChild(genreElement);
    divHitsInfo.appendChild(nameElement);
    divHitsInfo.appendChild(authorElement);
    divHitsInfo.appendChild(dateElement);
    divHitsInfo.appendChild(saveBtn);
    divHitsInfo.appendChild(likeBtn);
    divHitsInfo.appendChild(deleteBtn);

    allHitsContainer.appendChild(divHitsInfo);

    genre.value = "";
    name.value = "";
    author.value = "";
    date.value = "";

    likeBtn.addEventListener("click", likeSong);

    function likeSong(event) {
      event.preventDefault();
      totalLikeCount++;
      totalLikes.textContent = `Total Likes: ${totalLikeCount}`;
      likeBtn.disabled = true;
    }

    saveBtn.addEventListener("click", saveSong);

    function saveSong(event) {
      event.preventDefault();
      savedContainer.appendChild(divHitsInfo);
      divHitsInfo.removeChild(saveBtn);
      divHitsInfo.removeChild(likeBtn);
    }

    deleteBtn.addEventListener("click", deleteSong);

    function deleteSong(event) {
      event.preventDefault();
      deleteBtn.parentElement.remove();
    }
  }
}
