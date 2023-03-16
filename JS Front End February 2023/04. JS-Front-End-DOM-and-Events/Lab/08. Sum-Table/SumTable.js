function sumTable() {
  const prices = Array.from(document.querySelectorAll("td:nth-child(even)"));
  const inputSum = document.getElementById("sum");
  
  let totalSum = 0;

  prices.forEach((price) => (totalSum += Number(price.textContent)));

  inputSum.textContent = totalSum;

//   for (const price of prices) {
//     totalSum = totalSum + Number(price.textContent);
//   }

}
