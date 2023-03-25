function attachEvents() {
  const personInput = document.getElementById("person");
  const phoneInput = document.getElementById("phone");
  const loadBtn = document.getElementById("btnLoad");
  const createBtn = document.getElementById("btnCreate");
  const phoneBookList = document.getElementById("phonebook");

  const BASE_URL = "http://localhost:3030/jsonstore/phonebook/";

  loadBtn.addEventListener("click", loadContacts);
  createBtn.addEventListener("click", createContact);

  async function loadContacts() {
    try {
      const response = await fetch(`${BASE_URL}`);
      const data = await response.json();
      phoneBookList.innerHTML = "";
      for (const key in data) {
        const li = document.createElement("li");
        let deleteBtn = document.createElement("button");
        deleteBtn.textContent = "Delete";
        deleteBtn.id = data[key]._id;
        deleteBtn.addEventListener("click", deleteContact);
        li.textContent = `${data[key].person}: ${data[key].phone}`;
        li.appendChild(deleteBtn);
        phoneBookList.appendChild(li);
      }
    } catch {
      console.log("Error1");
    }
  }

  async function createContact() {
    try {
      phoneBookList.innerHTML = "";
      const person = personInput.value;
      const phone = phoneInput.value;
      if (person.length > 0 && phone.length > 0) {
        const httpHeaders = {
          method: "POST",
          body: JSON.stringify({ person, phone }),
        };
        const response = await fetch(`${BASE_URL}`, httpHeaders);
        loadContacts();
        personInput.value = "";
        phoneInput.value = "";
      }
    } catch {
      console.log("Error2");
    }
  }

  async function deleteContact(e) {
    try {
      const id = e.currentTarget.id;
    //   const id = this.id;
      const httpHeaders = {
        method: "DELETE",
      };
      const response = await fetch(`${BASE_URL}${id}`, httpHeaders);
      const data = response.json();
      loadContacts();
    } catch {
      console.log("Error3");
    }
  }
}

attachEvents();
