window.addEventListener("load", solve);

function solve() {
  const titleInput = document.getElementById("task-title");
  const categoryInput = document.getElementById("task-category");
  const contentInput = document.getElementById("task-content");
  const reviewListContainer = document.getElementById("review-list");
  const publishedListContainer = document.getElementById("published-list");
  const publishBtn = document.getElementById("publish-btn");

  publishBtn.addEventListener("click", publishBtnHandler);

  function publishBtnHandler(e) {
    e.preventDefault();

    let title = titleInput.value;
    let category = categoryInput.value;
    let content = contentInput.value;

    if (!title || !category || !content) {
      return;
    }

    let li = createElement("li", "", reviewListContainer, ["rpost"]);
    let articleEl = createElement("article", "", li);
    createElement("h4", `${title}`, articleEl);
    createElement("p", `Category: ${category}`, articleEl);
    createElement("p", `Content: ${content}`, articleEl);

    let editBtn = createElement("button", "Edit", li, ["action-btn", "edit"]);
    let postBtn = createElement("button", "Post", li, ["action-btn", "post"]);

    titleInput.value = "";
    categoryInput.value = "";
    contentInput.value = "";

    editBtn.addEventListener("click", editTaskHandler);

    postBtn.addEventListener("click", postBtnHandler);

    function postBtnHandler(event) {
      event.target.parentNode.remove();

      let li = createElement("li", "", publishedListContainer, ["rpost"]);
      let articleEl = createElement("article", "", li);
      createElement("h4", `${title}`, articleEl);
      createElement("p", `Category: ${category}`, articleEl);
      createElement("p", `Content: ${content}`, articleEl);
    }

    function editTaskHandler(event) {
      event.target.parentNode.remove();

      titleInput.value = title;
      categoryInput.value = category;
      contentInput.value = content;
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
