function attachEvents() {
  const authorInput = document.querySelector(
    "#controls > div:nth-child(1) > input[type=text]"
  );
  const contentInput = document.querySelector(
    "#controls > div:nth-child(2) > input[type=text]"
  );
  const refreshBtn = document.getElementById("refresh");
  const sendBtn = document.getElementById("submit");
  const textArea = document.querySelector("#messages");
  const BASE_URL = "http://localhost:3030/jsonstore/messenger/";

  sendBtn.addEventListener("click", postMessageHandler);
  refreshBtn.addEventListener("click", getMessagesHandler);

  async function postMessageHandler() {
    const author = authorInput.value;
    const content = contentInput.value;
    const httpHeaders = {
      method: "POST",
      body: JSON.stringify({ author, content }),
    };
    try {
      const response = await fetch(BASE_URL, httpHeaders);
      const data = await response.json();
      authorInput.value = "";
      contentInput.value = "";
    } catch (error) {
      console.log(error);
    }
  }

  async function getMessagesHandler() {
    try {
      textArea.textContent = "";
      let output = [];
      const response = await fetch(`${BASE_URL}`);
      const data = await response.json();
      for (const key in data) {
        output.push(`${data[key].author}: ${data[key].content}`);
      }
      textArea.textContent = output.join('\n');
    } catch {
      console.log("error");
    }
  }
}

attachEvents();
