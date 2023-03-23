async function loadCommits() {
  const BASE_URL = "https://api.github.com/repos/";
  const username = document.getElementById("username");
  const repo = document.getElementById("repo");
  const commits = document.getElementById("commits");
  const usernameValue = username.value;
  const repoValue = repo.value;

  const allCommits = await fetch(`${BASE_URL}${usernameValue}/${repoValue}/commits`);
  try {
    // const allCommits = await fetch(`${BASE_URL}${usernameValue}/${repoValue}/commits`);
    const data = await allCommits.json();

    data.forEach(({ commit }) => {
      const li = document.createElement("li");
      li.textContent = `${commit.author.name}: ${commit.message}`;
      commits.appendChild(li);
      console.log(allCommits.status)
      console.log(allCommits);
    });

    // With for of loop
    // for (const {commit} of data) {
    //     const li = document.createElement("li");
    //   li.textContent = `${commit.author.name}: ${commit.message}`;
    //   commits.appendChild(li);
    // }

  } catch (error) {
    const li = document.createElement("li");
    li.textContent = `Error: ${allCommits.status} (Not Found)`
    commits.appendChild(li);
  }
}
