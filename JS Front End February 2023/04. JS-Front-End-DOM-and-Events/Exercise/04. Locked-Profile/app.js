function lockedProfile() {
  const buttons = Array.from(document.getElementsByTagName("button"));

  buttons.forEach((button) => {
    button.addEventListener("click", toggle);
  });

  function toggle(e) {
    const btn = e.currentTarget;
    const currentProfile = btn.parentElement;
    const childrenElements = Array.from(currentProfile.children);
    const unLockedRadioInput = childrenElements[4];
    const infoToShow = childrenElements[9];

    if (unLockedRadioInput.checked) {
      if (btn.textContent === "Show more") {
        infoToShow.style.display = "block";
        btn.textContent = "Hide it";
      } else {
        infoToShow.style.display = "none";
        btn.textContent = "Show more";
      }
    }
  }
}
