window.addEventListener("load", solution);

function solution() {
  const nameInput = document.getElementById("fname");
  const emailInput = document.getElementById("email");
  const phoneInput = document.getElementById("phone");
  const addressInput = document.getElementById("address");
  const postalCodeInput = document.getElementById("code");

  const submitBtn = document.getElementById("submitBTN");

  const previewContainer = document.getElementById("infoPreview");
  const editBtn = document.getElementById("editBTN");
  const continueBtn = document.getElementById("continueBTN");
  const blockDiv = document.getElementById("block");

  submitBtn.addEventListener("click", submitBtnHandler);

  function submitBtnHandler(e) {
    // e.preventDefault();

    let name = nameInput.value;
    let email = emailInput.value;
    let phone = phoneInput.value;
    let address = addressInput.value;
    let postalCode = postalCodeInput.value;

    if (!name || !email) {
      return;
    }

    submitBtn.disabled = true;
    editBtn.disabled = false;
    continueBtn.disabled = false;

    createElement("li", `Full Name: ${name}`, previewContainer);
    createElement("li", `Email: ${email}`, previewContainer);
    createElement("li", `Phone Number: ${phone}`, previewContainer);
    createElement("li", `Address: ${address}`, previewContainer);
    createElement("li", `Postal Code: ${postalCode}`, previewContainer);

    nameInput.value = "";
    emailInput.value = "";
    phoneInput.value = "";
    addressInput.value = "";
    postalCodeInput.value = "";

    editBtn.addEventListener("click", editBtnHandler);

    function editBtnHandler() {
      previewContainer.innerHTML = "";

      nameInput.value = name;
      emailInput.value = email;
      phoneInput.value = phone;
      addressInput.value = address;
      postalCodeInput.value = postalCode;

      submitBtn.disabled = false;
      editBtn.disabled = true;
      continueBtn.disabled = true;
    }
  }
  continueBtn.addEventListener("click", () => {
    blockDiv.innerHTML = "";
    createElement("h3", "Thank you for your reservation!", blockDiv);
  });

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
