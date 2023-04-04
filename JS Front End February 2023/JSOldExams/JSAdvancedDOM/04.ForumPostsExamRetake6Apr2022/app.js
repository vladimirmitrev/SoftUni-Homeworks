window.addEventListener("load", solve);

function solve() {
  const titleInput = document.getElementById("post-title");
  const categoryInput = document.getElementById("post-category");
  const contentInput = document.getElementById("post-content");
  const publishBtn = document.getElementById("publish-btn");

  const reviewListContainer = document.getElementById("review-list");
  const uploadedPostContainer = document.getElementById("published-list");
  const clearBtn = document.getElementById("clear-btn");

  publishBtn.addEventListener("click", publishBtnHandler);

  function publishBtnHandler(e) {
    e.preventDefault();

    let title = titleInput.value;
    let category = categoryInput.value;
    let content = contentInput.value;

    if (!title || !category || !content) {
      return;
    }

    const li = document.createElement("li");
    li.classList.add("rpost");

    const articleEl = createElement("article", null, li);
    createElement("h4", `${title}`, articleEl);
    createElement("p", `Category: ${category}`, articleEl);
    createElement("p", `Content: ${content}`, articleEl);

    const editBtn = createElement("button", "Edit", li, ["action-btn", "edit"]);
    const approveBtn = createElement("button", "Approve", li, ["action-btn", "approve"]);

    reviewListContainer.appendChild(li);

    titleInput.value = "";
    categoryInput.value = "";
    contentInput.value = "";

    editBtn.addEventListener("click", editBtnHandler);

    approveBtn.addEventListener("click", approveBtnHandler);

    clearBtn.addEventListener("click", clearBtnHandler);

    function clearBtnHandler(event) {
      li.remove();
    }

    function approveBtnHandler(event) {
      event.target.parentNode.remove();
      uploadedPostContainer.appendChild(li)
      li.removeChild(editBtn);
      li.removeChild(approveBtn);
      
    }

    function editBtnHandler(event) {
      li.remove();

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
