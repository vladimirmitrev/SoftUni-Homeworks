function validate() {
  const inputEmail = document.getElementById("email");

  inputEmail.addEventListener("change", isValidEmail);

  function isValidEmail(emailAddress) {
    let regex = /^[a-z]+@[a-z]+\.[a-z]+$/;

    if (!inputEmail.value.match(regex)) {
      inputEmail.classList.add("error");

    } else {
      inputEmail.classList.remove("error");
    }
  }
}
