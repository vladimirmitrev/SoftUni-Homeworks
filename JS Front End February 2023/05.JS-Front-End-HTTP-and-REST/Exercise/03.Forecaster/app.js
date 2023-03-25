function attachEvents() {
  const locationInput = document.getElementById("location");
  const getWeatherBtn = document.getElementById("submit");
  const forecastDisplay = document.getElementById("forecast");
  const todayForecastDiv = document.getElementById("current");
  const upcomingForecastDiv = document.getElementById("upcoming");
  const BASE_URL = "http://localhost:3030/jsonstore/forecaster/";
  let location = locationInput.textContent;
  let forecastCode = "";
  const iconsCodes = {
    Sunny: "&#x2600", // ☀
    "Partly sunny": "&#x26C5", // ⛅
    Overcast: "&#x2601", // ☁
    Rain: "&#x2614", // ☂
    Degrees: "&#176", // °
  };
  getWeatherBtn.addEventListener("click", getWeather);

  async function getWeather(event) {
    try {
      const response = await fetch(`${BASE_URL}locations`);
      const currentLocations = await response.json();
      for (const key in currentLocations) {
        if (locationInput.value === currentLocations[key].name) {
          forecastCode = currentLocations[key].code;
          getTodayForecast();
          getThreeDayForecast();
        }
      }
    } catch (err) {
      forecastDisplay.style.display = "block";
      let li = document.createElement("li");
      li.textContent = "Error";
      todayForecastDiv.appendChild(li);
    }
  }
  async function getThreeDayForecast() {
    debugger;
    try {
      const response = await fetch(`${BASE_URL}upcoming/${forecastCode}`);
      const upcomingForecast = await response.json();

      let forecastInfoDiv = document.createElement("div");
      forecastInfoDiv.classList.add("forecast-info");

      upcomingForecast.forecast.forEach((element) => {
        let { condition, high, low } = element;

        let upcomingForecastSpan = document.createElement("span");
        upcomingForecastSpan.classList.add("upcoming");

        let symbolSpan = document.createElement("span");
        symbolSpan.classList.add("symbol");
        symbolSpan.innerHTML = `${iconsCodes[condition]}`;

        let degreesSpan = document.createElement("span");
        degreesSpan.classList.add("forecast-data");
        degreesSpan.innerHTML = `${low}${iconsCodes["Degrees"]}/${high}${iconsCodes["Degrees"]}`;

        let conditionSpan = document.createElement("span");
        conditionSpan.classList.add("forecast-data");
        conditionSpan.textContent = condition;

        upcomingForecastSpan.appendChild(symbolSpan);
        upcomingForecastSpan.appendChild(degreesSpan);
        upcomingForecastSpan.appendChild(conditionSpan);
        forecastInfoDiv.appendChild(upcomingForecastSpan);
        upcomingForecastDiv.appendChild(forecastInfoDiv);
      });
    } catch (err) {
      console.log(err);
    }
  }

  async function getTodayForecast() {
    try {
      const response = await fetch(`${BASE_URL}today/${forecastCode}`);
      const currentForecast = await response.json();

      let { forecast, name } = currentForecast;
      // *** With variables and for in loop ***
      //   let condition = "";
      //   let high = "";
      //   let low = "";
      //   for (const _key in forecast) {
      //     condition = forecast.condition;
      //     high = forecast.high;
      //     low = forecast.low;
      //   }
      /// *** With destructuring ***
      let { condition, high, low } = forecast;

      forecastDisplay.style.display = "block";

      let divForecast = document.createElement("div");
      divForecast.classList.add("forecasts");

      let symbolSpan = document.createElement("span");
      symbolSpan.classList.add("condition", "symbol");
      symbolSpan.innerHTML = `${iconsCodes[condition]}`;

      let conditionParentSpan = document.createElement("span");
      conditionParentSpan.classList.add("condition");

      let nameSpan = document.createElement("span");
      nameSpan.classList.add("forecast-data");
      nameSpan.textContent = name;

      let degreesSpan = document.createElement("span");
      degreesSpan.classList.add("forecast-data");
      degreesSpan.innerHTML = `${low}${iconsCodes["Degrees"]}/${high}${iconsCodes["Degrees"]}`;

      let conditionSpan = document.createElement("span");
      conditionSpan.classList.add("forecast-data");
      conditionSpan.textContent = condition;

      divForecast.appendChild(symbolSpan);
      divForecast.appendChild(conditionParentSpan);
      conditionParentSpan.appendChild(nameSpan);
      conditionParentSpan.appendChild(degreesSpan);
      conditionParentSpan.appendChild(conditionSpan);
      todayForecastDiv.appendChild(divForecast);
    } catch (err) {
      console.log(err);
    }
  }
}
attachEvents();
