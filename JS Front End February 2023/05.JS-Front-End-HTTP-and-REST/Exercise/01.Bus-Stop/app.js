async function getInfo() {
  const stopIdInput = document.getElementById("stopId");
  const stopNameContainer = document.getElementById("stopName");
  const busesContainer = document.getElementById("buses");
  const BASE_URL = "http://localhost:3030/jsonstore/bus/businfo/";
  let stopId = stopIdInput.value;

  busesContainer.innerHTML = "";

  try {
    const response = await fetch(`${BASE_URL}${stopId}`);
    const busStopInfo = await response.json();
    let { name, buses } = busStopInfo;
    stopNameContainer.textContent = name;

    for (const busId in buses) {
      const li = document.createElement("li");
      li.textContent = `Bus ${busId} arrives in ${buses[busId]} minutes`;
      busesContainer.appendChild(li);
    }
  } catch {
    stopNameContainer.textContent = "Error";
  }
}
