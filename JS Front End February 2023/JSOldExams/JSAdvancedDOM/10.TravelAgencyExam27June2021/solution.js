window.addEventListener("load", solution);

function solution() {
  const nameInput = document.getElementById("fname");
  const emailInput = document.getElementById("email");
  const phoneInput = document.getElementById("phone");
  const addressInput = document.getElementById("address");
  const postalCodeInput = document.getElementById("code");

  const submitBtn = document.getElementById("submitBTN");

  const infoPreviewContainer = document.getElementById("infoPreview");
  const pageDiv = document.getElementById("block");

  const editBtn = document.getElementById("editBTN");
  const continueBtn = document.getElementById("continueBTN");

  submitBtn.addEventListener("click", submitBtnHandler);

  function submitBtnHandler(e) {
    let name = nameInput.value;
    let email = emailInput.value;
    let phone = phoneInput.value;
    let address = addressInput.value;
    let postalCode = postalCodeInput.value;

    if (!name || !email) {
      return;
    }

    editBtn.disabled = false;
    continueBtn.disabled = false;

    createElement("li", `Full Name: ${name}`, infoPreviewContainer);
    createElement("li", `Email: ${email}`, infoPreviewContainer);
    createElement("li", `Phone Number: ${phone}`, infoPreviewContainer);
    createElement("li", `Address: ${address}`, infoPreviewContainer);
    createElement("li", `Postal Code: ${postalCode}`, infoPreviewContainer);

    submitBtn.disabled = true;

    nameInput.value = "";
    emailInput.value = "";
    phoneInput.value = "";
    addressInput.value = "";
    postalCodeInput.value = "";

    editBtn.addEventListener("click", () => {
      nameInput.value = name;
      emailInput.value = email;
      phoneInput.value = phone;
      addressInput.value = address;
      postalCodeInput.value = postalCode;

      submitBtn.disabled = false;
      editBtn.disabled = true;
      continueBtn.disabled = true;;

      infoPreviewContainer.innerHTML = "";
    });

    continueBtn.addEventListener("click", continueHandler);

    function continueHandler() {
      pageDiv.innerHTML = "";
      createElement("h3", "Thank you for your reservation!", pageDiv);
    }
  }

  function createElement(type, text, parent) {
    let element = document.createElement(type);

    if (text) {
      element.textContent = text;
    }
    if (parent) {
      parent.appendChild(element);
    }

    return element;
  }
}
