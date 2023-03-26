function attachEvents() {
  const loadBtn = document.getElementById("loadBooks");
  const booksContainer = document.querySelector("table > tbody");
  const submitBtn = document.querySelector("#form > button");
  const [titleInput, authorInput] = Array.from(
    document.querySelectorAll("#form > input")
  );
  let formHeader = document.querySelector("#form > h3");
  let editBookId = "";
  const BASE_URL = "http://localhost:3030/jsonstore/collections/books/";

  let allBooks = {}; //for the test for checking all books

  loadBtn.addEventListener("click", loadBooks);
  submitBtn.addEventListener("click", addBook);

  async function loadBooks() {
    try {
      booksContainer.innerHTML = "";

      const response = await fetch(BASE_URL);
      const booksData = await response.json();
      
      allBooks = booksData; ////for the test for checking all books

      for (const bookId in booksData) {

        const tableRow = document.createElement("tr");
        const titleTd = document.createElement("td");
        titleTd.textContent = booksData[bookId].title;
        const authorTd = document.createElement("td");
        authorTd.textContent = booksData[bookId].author;
        const actionTd = document.createElement("td");
        const editBtn = document.createElement("button");
        editBtn.textContent = "Edit";
        const deleteBtn = document.createElement("button");
        deleteBtn.textContent = "Delete";
        deleteBtn.id = bookId;

        editBtn.addEventListener("click", () => {
          formHeader.textContent = "Edit FORM";
          editBookId = bookId;
          submitBtn.textContent = "Save";
          titleInput.value = booksData[bookId].title;
          authorInput.value = booksData[bookId].author;
        });

        deleteBtn.addEventListener("click", deleteBook);

        actionTd.appendChild(editBtn);
        actionTd.appendChild(deleteBtn);
        tableRow.appendChild(titleTd);
        tableRow.appendChild(authorTd);
        tableRow.appendChild(actionTd);
        booksContainer.appendChild(tableRow);
      }
    } catch {
      console.log("Error");
    }
  }

  async function addBook() {
    try {
      const title = titleInput.value;
      const author = authorInput.value;
      if (title !== "" && author !== "") {
        const httpHeaders = {
          method: "POST",
          body: JSON.stringify({ author, title }),
        };
        let url = BASE_URL;

        if (formHeader.textContent === "Edit FORM") {
          httpHeaders.method = "PUT";
          url += editBookId;
        }

        const response = await fetch(url, httpHeaders);
        loadBooks();
        
        if (formHeader.textContent === "Edit FORM") {
          formHeader.textContent = "FORM";
          submitBtn.textContent = "Submit";
        }

        titleInput.value = "";
        authorInput.value = "";
      }
    } catch {
      console.log("Error");
    }
  }

  async function deleteBook(e) {
    try {
      const bookId = e.currentTarget.id;
      // const bookId = e.target.id;         
      // const bookId = this.id;           

      let url = BASE_URL + bookId;

      const httpHeaders = {
        method: "DELETE",
      };
      const response = await fetch(url, httpHeaders);
      loadBooks();
    } catch {
      console.log("Error");
    }
  }
}
attachEvents();
