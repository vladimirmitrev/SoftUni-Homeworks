/// *** Solution with async functions ***

async function loadRepos() {
	const username = document.getElementById("username");
	const usernameValue = username.value;
	const repos = document.getElementById("repos");
	const url = `https://api.github.com/users/${usernameValue}/repos`;
  
	repos.innerHTML = "";
  
	try {
	  const response = await fetch(url);
	  if (response.ok) {
		const data = await response.json();
		data.forEach((repo) => {
		  const li = document.createElement("li");
		  const hrefEl = document.createElement("a");
		  hrefEl.textContent = `${repo.full_name}`;
		  hrefEl.setAttribute("href", repo.html_url);
		  li.appendChild(hrefEl);
		  repos.appendChild(li);
		});
	  } else {
		throw new Error(`Error ${response.status}`);
	  }
  
	} catch (error) {
	  const li = document.createElement("li");
	  li.textContent = `${error.message}`;
  
	  repos.appendChild(li);
	}
  }
  

// function loadRepos() {
// 	const username = document.getElementById("username");
// 	const usernameValue = username.value;
// 	const repos = document.getElementById("repos");
// 	const url = `https://api.github.com/users/${usernameValue}/repos`;

// 	repos.innerHTML = "";
//   //   repos.textContent = "";

// 	fetch(url)
// 	  .then((response) => response.json())
// 	  .then((data) => {
// 		data.forEach((repo) => {
// 		  const li = document.createElement("li");
// 		  const hrefEl = document.createElement("a");
// 		  hrefEl.textContent = `${repo.full_name}`;
// 		  hrefEl.setAttribute("href", repo.html_url);
// 		  li.appendChild(hrefEl);
// 		  repos.appendChild(li);
// 		});
// 	  })
// 	  .catch((error) => {
// 		  const li = document.createElement("li");
// 		  li.textContent = `${error.message}`;

// 		  repos.appendChild(li);

// 	  });
//   }

/// *** Solution with correct error message ***

// function loadRepos() {
// 	const username = document.getElementById("username").value;
// 	const reposList = document.getElementById("repos");

// 	reposList.innerHTML = "";

// 	fetch(`https://api.github.com/users/${username}/repos`)
// 	  .then(response => {
// 		if (response.ok) {
// 		  return response.json();
// 		} else {
// 		  throw new Error(`Error ${response.status}`);
// 		}
// 	  })
// 	  .then(repos => {
// 		repos.forEach(repo => {
// 		  const listItem = document.createElement("li");
// 		  const link = document.createElement("a");
// 		  link.href = repo.html_url;
// 		  link.textContent = repo.full_name;
// 		  listItem.appendChild(link);
// 		  reposList.appendChild(listItem);
// 		});
// 	  })
// 	  .catch(error => {
// 		const listItem = document.createElement("li");
// 		listItem.textContent = `Error: ${error.message}`;
// 		reposList.appendChild(listItem);
// 	  });
//   }
