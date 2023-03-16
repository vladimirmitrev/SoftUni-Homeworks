function focused() {
  const elements = Array.from(document.querySelectorAll("div input"));

  elements.forEach((el) => {
    el.addEventListener("focus", addFocus),
    el.addEventListener("blur", removeFocus);
  });

  function addFocus(e) {
    e.target.parentElement.classList.add("focused");
  }
  function removeFocus(e) {
    e.target.parentElement.classList.remove("focused");
  }
}
