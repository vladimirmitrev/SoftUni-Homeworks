function lockedProfile() {
  const main = document.getElementById("main");

  const BASE_URL = "http://localhost:3030/jsonstore/advanced/profiles";

  loadProfiles();

  let numberOfUser = 0;

  async function loadProfiles() {
    main.innerHTML = "";

    const response = await fetch(BASE_URL);
    const profilesData = await response.json();

    for (const key in profilesData) {
      const { _id, username, email, age } = profilesData[key];

      numberOfUser++;

      const profileDiv = document.createElement("div");
      profileDiv.classList.add("profile");

      const picture = document.createElement("img");
      picture.src = `./iconProfile2.png`;
      picture.classList.add("userIcon");

      const lockLabel = document.createElement("label");
      lockLabel.textContent = "Lock";

      const lockRadio = document.createElement("input");
      lockRadio.type = "radio";
      lockRadio.name = `user${numberOfUser}Locked`;
      lockRadio.value = "lock";
      lockRadio.checked = true;

      const unlockLabel = document.createElement("label");
      unlockLabel.textContent = "Unlock";

      const unlockRadio = document.createElement("input");
      unlockRadio.type = "radio";
      unlockRadio.name = `user${numberOfUser}Locked`;
      unlockRadio.value = "unlock";
      unlockRadio.checked = false;

      const br = document.createElement("br");

      const hr = document.createElement("hr");

      const userLabel = document.createElement("label");
      userLabel.textContent = "Username";

      const usernameInput = document.createElement("input");
      usernameInput.type = "text";
      usernameInput.name = `user${numberOfUser}Username`;
      usernameInput.value = `${username}`;
      usernameInput.disabled = true;
      usernameInput.readOnly = true;

      const moreInfoDiv = document.createElement("div");
      moreInfoDiv.setAttribute("id", `user${numberOfUser}HiddenFields`);

      const emailLabel = document.createElement("label");
      emailLabel.textContent = "Email:";

      const emailInput = document.createElement("input");
      emailInput.type = "email";
      emailInput.name = `user${numberOfUser}Email`;
      emailInput.value = email;
      emailInput.disabled = true;
      emailInput.readOnly = true;

      const ageLabel = document.createElement("label");
      ageLabel.textContent = "Age::";

      const ageInput = document.createElement("input");
      ageInput.type = "email";
      ageInput.name = `user${numberOfUser}Age`;
      ageInput.value = age;
      ageInput.disabled = true;
      ageInput.readOnly = true;

      const showMoreBtn = document.createElement("button");
      showMoreBtn.textContent = "Show More";

      moreInfoDiv.appendChild(hr);
      moreInfoDiv.appendChild(emailLabel);
      moreInfoDiv.appendChild(emailInput);
      moreInfoDiv.appendChild(ageLabel);
      moreInfoDiv.appendChild(ageInput);

      profileDiv.appendChild(picture);
      profileDiv.appendChild(lockLabel);
      profileDiv.appendChild(lockRadio);
      profileDiv.appendChild(unlockLabel);
      profileDiv.appendChild(unlockRadio);
      profileDiv.appendChild(br);
      profileDiv.appendChild(hr);
      profileDiv.appendChild(userLabel);
      profileDiv.appendChild(usernameInput);

      profileDiv.appendChild(moreInfoDiv);

      profileDiv.appendChild(showMoreBtn);

      main.appendChild(profileDiv);

      moreInfoDiv.style.display = "none";

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
  }
}
