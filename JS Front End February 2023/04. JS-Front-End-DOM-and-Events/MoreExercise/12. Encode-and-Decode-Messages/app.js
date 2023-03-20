function encodeAndDecodeMessages() {
  const [encodeBtn, decodeBtn] = Array.from(
    document.querySelectorAll("button")
  );
  let [sendText, receivedText] = Array.from(
    document.querySelectorAll("textarea")
  );

  encodeBtn.addEventListener("click", encodeMessage);

  decodeBtn.addEventListener("click", decodeMessage);

  function encodeMessage() {
    let output = "";
    for (const symbol of sendText.value) {
      output += String.fromCharCode(symbol.charCodeAt(0) + 1);
    }
    sendText.value = "";
    receivedText.value = output;
    return receivedText;
  }

  function decodeMessage() {
    let output = "";
    for (const symbol of receivedText.value) {
      output += String.fromCharCode(symbol.charCodeAt(0) - 1);
    }
    receivedText.value = output;
    return receivedText
  }
}
