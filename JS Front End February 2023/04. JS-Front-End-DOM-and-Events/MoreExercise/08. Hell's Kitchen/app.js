function solve() {
  document.querySelector("#btnSend").addEventListener("click", onClick);
  const input = document.querySelector("textarea");
  let bestRestaurants = document.querySelector("#bestRestaurant > p");
  let workers = document.querySelector("#workers > p");
  bestRestaurants.textContent = "";
  workers.textContent = "";
  let restaurantInfo = {};

  function findBestRestaurant() {
    let bestRestaurant = null;
    let bestSum = null;

    for (let restaurant in restaurantInfo) {
      const salary = Object.values(restaurantInfo[restaurant]).map(Number);
      const averageSalary =
        salary.reduce((sum, num) => sum + num, 0) / salary.length;
      if (bestSum === null || averageSalary > bestSum) {
        bestSum = averageSalary;
        bestRestaurant = restaurant;
      }
    }
    return bestRestaurant;
  }
  
  function createWorkers(restaurant, workers) {
   workers.split(", ").map((el) => {
     let [name, salary] = el.split(" ");
     restaurantInfo[restaurant][name] = Number(salary);
   });
 }

  function onClick() {
    let listArray = Array.from(JSON.parse(input.value));

    listArray.forEach((el) => {
      let [name, workers] = el.split(" - ");
      if (!restaurantInfo.hasOwnProperty(name)) {
        restaurantInfo[name] = {};
      }
      createWorkers(name, workers);
    });

    const bestCurrentRestaurant = findBestRestaurant();
    const salary = Object.values(restaurantInfo[bestCurrentRestaurant]).map(
      Number
    );

    bestRestaurants.textContent = `Name: ${bestCurrentRestaurant} Average Salary: ${(
      salary.reduce((sum, num) => sum + num, 0) / salary.length
    ).toFixed(2)} Best Salary: ${Math.max(...salary).toFixed(2)}`;

    let sortedWorkers = Object.entries(restaurantInfo[bestCurrentRestaurant])
      .sort((a, b) => b[1] - a[1])
      .reduce((obj, [key, value]) => ({ ...obj, [key]: value }), {});

    for (const key in sortedWorkers) {
      workers.textContent += `Name: ${key} With Salary: ${sortedWorkers[key]} `;
    }
  }
}
