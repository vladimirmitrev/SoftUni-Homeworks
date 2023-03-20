function generateReport() {
  const checkedFields = Array.from(
    document.querySelectorAll("thead > tr > th > input")
  );
  const tableRows = Array.from(document.querySelectorAll("tbody > tr"));
  const output = document.querySelector("#output");

  let checkBoxArr = [];
  let objArr = [];

  for (let i = 0; i < checkedFields.length; i++) {
    let checkBox = checkedFields[i];
    if (checkBox.checked) {
      checkBoxArr.push([i, checkBox.name]);
    }
  }

  for (const row of tableRows) {
    let personObj = {};
    let tds = row.children;
    for (const checkBox of checkBoxArr) {
      personObj[checkBox[1]] = tds[checkBox[0]].textContent;
    }
    objArr.push(personObj);
  }

  objArr = JSON.stringify(objArr);
  output.value = objArr;
}
