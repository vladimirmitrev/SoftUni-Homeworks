function attachGradientEvents() {
  const gradient = document.querySelector("#gradient");
  const result = document.querySelector("#result");

  gradient.addEventListener("mousemove", showPercentage);
  gradient.addEventListener("mouseout", hidePercentage);

  function showPercentage(event) {
    const x = event.offsetX;
    const width = gradient.clientWidth;
    const percentage = Math.floor((x / width) * 100);
    result.textContent = `${percentage}\%`;
  }

  function hidePercentage() {
    result.style.display = "none";
  }
}
