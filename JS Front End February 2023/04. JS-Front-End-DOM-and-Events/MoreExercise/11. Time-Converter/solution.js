function attachEventsListeners() {
  const daysBtn = document.querySelector("#daysBtn");
  const hoursBtn = document.querySelector("#hoursBtn");
  const minutesBtn = document.querySelector("#minutesBtn");
  const secondsBtn = document.querySelector("#secondsBtn");

  const days = document.querySelector("#days");
  const hours = document.querySelector("#hours");
  const minutes = document.querySelector("#minutes");
  const seconds = document.querySelector("#seconds");

  daysBtn.addEventListener("click", () => {
    days.value = Number(days.value);
    hours.value = days.value * 24;
    minutes.value = hours.value * 60;
    seconds.value = minutes.value * 60;
  });

  hoursBtn.addEventListener("click", () => {
    hours.value = Number(hours.value);
    days.value = hours.value / 24;
    minutes.value = hours.value * 60;
    seconds.value = minutes.value * 60;
  });

  minutesBtn.addEventListener("click", () => {
    minutes.value = Number(minutes.value);
    hours.value = hours.value / 60;
    days.value = hours.value / 24;
    seconds.value = minutes.value * 60;
  });

  secondsBtn.addEventListener("click", () => {
    seconds.value = Number(seconds.value);
    minutes.value = seconds.value / 60;
    hours.value = minutes.value / 60;
    days.value = hours.value / 24;
  });
}
