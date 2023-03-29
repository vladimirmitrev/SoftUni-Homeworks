function solution() {
  const main = document.querySelector("#main");

  const listUrl = "http://localhost:3030/jsonstore/advanced/articles/list/";
  const detailsUrl =
    "http://localhost:3030/jsonstore/advanced/articles/details/";

  getArticleList();

  async function getArticleList(e) {
    const response = await fetch(listUrl);
    const dataList = await response.json();
    debugger;
    for (const key in dataList) {
      let { _id, title } = dataList[key];

      const response = await fetch(detailsUrl + _id);
      const detailsData = await response.json();

      const divAccordion = document.createElement("div");
      divAccordion.classList.add("accordion");

      const divHead = document.createElement("div");
      divHead.classList.add("head");

      const extraDiv = document.createElement("div");
      extraDiv.classList.add("extra");

      const spanTitle = document.createElement("span");
      spanTitle.textContent = title;

      const btn = document.createElement("button");
      btn.classList.add("button");
      btn.setAttribute("id", _id);
      btn.textContent = "More";
      btn.id = _id;

      const paragraph = document.createElement("p");
      paragraph.textContent = detailsData.content;

      divHead.appendChild(spanTitle);
      divHead.appendChild(btn);
      extraDiv.appendChild(paragraph);
      divAccordion.appendChild(divHead);
      divAccordion.appendChild(extraDiv);
      main.appendChild(divAccordion);

      extraDiv.style.display = "none";

      btn.addEventListener("click", () => {
        if (btn.textContent === "More") {
          btn.textContent = "Less";
          extraDiv.style.display = "block";
        } else {
          btn.textContent = "More";
          extraDiv.style.display = "none";
        }
      });
    }
  }
}
