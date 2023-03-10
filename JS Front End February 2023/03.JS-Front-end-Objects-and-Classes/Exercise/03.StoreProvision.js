function storeProvision(stock, delivery) {
  let products = [...stock, ...delivery];
  let store = {};

  for (let index = 0; index < products.length; index++) {
    let entry = products[index];
    if (index % 2 === 0) {
      if (!store.hasOwnProperty(entry)) {
        store[entry] = 0;
      }
    } else {
      let value = Number(entry);
      let previousEntry = products[index - 1];
      store[previousEntry] += value;
    }
  }
  for (const key in store) {
    console.log(`${key} -> ${store[key]}`);
  }
}

storeProvision(
  ["Chips", "5", "CocaCola", "9", "Bananas", "14", "Pasta", "4", "Beer", "2"],
  ["Flour", "44", "Oil", "12", "Pasta", "7", "Tomatoes", "70", "Bananas", "30"]
);

storeProvision(
  ["Salt", "2", "Fanta", "4", "Apple", "14", "Water", "4", "Juice", "5"],
  ["Sugar", "44", "Oil", "12", "Apple", "7", "Tomatoes", "7", "Bananas", "30"]
);
