function attachEvents() {
  const firstNameInput = document.querySelector(
    "#form > div.inputs > input[type=text]:nth-child(1)"
  );
  const LastNameInput = document.querySelector(
    "#form > div.inputs > input[type=text]:nth-child(2)"
  );
  const facultyNumberInput = document.querySelector(
    "#form > div.inputs > input[type=text]:nth-child(3)"
  );
  const gradeInput = document.querySelector(
    "#form > div.inputs > input[type=text]:nth-child(4)"
  ); //Number?
  const tableBody = document.querySelector("tbody");
  const BASE_URL = "http://localhost:3030/jsonstore/collections/students";
  const submitBtn = document.getElementById("submit");

  loadStudents();

  submitBtn.addEventListener("click", createStudent);

  async function loadStudents() {
    try {
      const response = await fetch(`${BASE_URL}`);
      const studentsData = await response.json();

      for (const key in studentsData) {
        let tr = document.createElement("tr");
        let tdFirstName = document.createElement("td");
        tdFirstName.textContent = studentsData[key].firstName;
        let tdLastName = document.createElement("td");
        tdLastName.textContent = studentsData[key].lastName;
        let tdFacNumber = document.createElement("td");
        tdFacNumber.textContent = studentsData[key].facultyNumber;
        let tdGrade = document.createElement("td");
        tdGrade.textContent = studentsData[key].grade;

        tr.appendChild(tdFirstName);
        tr.appendChild(tdLastName);
        tr.appendChild(tdFacNumber);
        tr.appendChild(tdGrade);
        tableBody.appendChild(tr);
      }
    } catch {
      console.log("Error1");
    }
  }
  debugger;
  async function createStudent() {
    const firstName = firstNameInput.value;
    const lastName = LastNameInput.value;
    const facultyNumber = facultyNumberInput.value;
    const grade = gradeInput.value;
    
    try {
      if (
        firstName.length > 0 &&
        lastName.length > 0 &&
        facultyNumber.length > 0 &&
        grade.length > 0
      ) {
        const httpHeaders = {
          method: "POST",
          body: JSON.stringify({ firstName, lastName, facultyNumber, grade }),
        };
        const response = await fetch(`${BASE_URL}`, httpHeaders);
        tableBody.innerHTML = "";
        loadStudents();
        firstNameInput.value = "";
        LastNameInput.value = "";
        facultyNumberInput.value = "";
        gradeInput.value = "";
      }
    } catch (e) {
      console.log("Error2");
    }
  }
}

attachEvents();
