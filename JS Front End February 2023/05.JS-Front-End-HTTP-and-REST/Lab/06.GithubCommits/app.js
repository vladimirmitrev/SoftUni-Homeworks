async function loadCommits() {
  const BASE_URL = "https://api.github.com/repos/";
  const username = document.getElementById("username");
  const repo = document.getElementById("repo");
  const commits = document.getElementById("commits");
  const usernameValue = username.value;
  const repoValue = repo.value;

  try {
    const allCommits = await fetch(`${BASE_URL}${usernameValue}/${repoValue}/commits`);
    const data = await allCommits.json();

    data.forEach(({ commit }) => {
      const li = document.createElement("li");
      li.textContent = `${commit.author.name}: ${commit.message}`;
      commits.appendChild(li);
    });

    // With for of loop
    // for (const {commit} of data) {
    //     const li = document.createElement("li");
    //   li.textContent = `${commit.author.name}: ${commit.message}`;
    //   commits.appendChild(li);
    // }

  } catch (error) {
    const li = document.createElement("li");
    li.textContent = `Error: ${error.status} (Not Found)`
    commits.appendChild(li);
  }
}
