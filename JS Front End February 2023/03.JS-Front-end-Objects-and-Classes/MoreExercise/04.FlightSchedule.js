function flightSchedule(inputArr) {
  const [flightsArr, changedFlights, flightStatus] = inputArr;

  let flights = {};
  for (let i = 0; i < flightsArr.length; i++) {
    let currentFlight = flightsArr[i].split(" ");
    const flightNumber = currentFlight[0];
    flights[flightNumber] = {
      Destination: currentFlight[1],
      Status: "Ready to fly",
    };
  }
  for (let i = 0; i < changedFlights.length; i++) {
    let [flightNumber, status] = changedFlights[i].split(" ");

    if (status === "Cancelled" && flights.hasOwnProperty(flightNumber)) {
      flights[flightNumber].Status = status;
    }
  }
  let status = flightStatus.join(" ");
  const filteredFlights = Object.keys(flights).filter(
    (key) => flights[key].Status === status 
  );

  for (let index = 0; index < filteredFlights.length; index++) {
    console.log(flights[filteredFlights[index]]);
  }
}
flightSchedule([
  [
    "WN269 Delaware",
    "FL2269 Oregon",
    "WN498 Las Vegas",
    "WN3145 Ohio",
    "WN612 Alabama",
    "WN4010 New York",
    "WN1173 California",
    "DL2120 Texas",
    "KL5744 Illinois",
    "WN678 Pennsylvania",
  ],
  [
    "DL2120 Cancelled",
    "WN612 Cancelled",
    "WN1173 Cancelled",
    "SK330 Cancelled",
  ],
  ["Ready to fly"],
]);
