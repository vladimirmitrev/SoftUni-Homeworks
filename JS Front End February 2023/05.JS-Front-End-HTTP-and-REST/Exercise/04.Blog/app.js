function attachEvents() {
  const loadBtn = document.getElementById("btnLoadPosts");
  const viewBtn = document.getElementById("btnViewPost");
  const postSelections = document.getElementById("posts");
  const postTitle = document.getElementById("post-title");
  const postParagraph = document.getElementById("post-body");
  const commentsUl = document.getElementById("post-comments");

  const postURL = "http://localhost:3030/jsonstore/blog/posts";
  const commentsURL = "http://localhost:3030/jsonstore/blog/comments";

  let postObject = {};

  loadBtn.addEventListener("click", getPosts);

  viewBtn.addEventListener("click", viewPost);

  async function getPosts() {
    const postResponse = await fetch(postURL);
    const postsData = await postResponse.json();
    debugger;
    // postSelections.innerHTML = "";
    for (const post in postsData) {
      let option = document.createElement("option");
      option.textContent = postsData[post].title;
      let title = postsData[post].title;
      option.setAttribute("value", title);
      postSelections.appendChild(option);
      postObject[title] = {
        postId: postsData[post].id,
        content: postsData[post].body,
      };
    }
  }
  async function viewPost() {
    debugger;
    const commentsRes = await fetch(commentsURL);
    const commentsData = await commentsRes.json();
    // postSelections.innerHTML = "";
    const selectedOption = postSelections.options[postSelections.selectedIndex];

    postTitle.textContent = selectedOption.text;
    postParagraph.textContent = postObject[selectedOption.text].content;

    for (const comment in commentsData) {
      if (
        commentsData[comment].postId === postObject[selectedOption.text].postId
      ) {
        let li = document.createElement("li");
        li.textContent = commentsData[comment].text;
        commentsUl.appendChild(li);
      }
    }
  }
}
attachEvents();
