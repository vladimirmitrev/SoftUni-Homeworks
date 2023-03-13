function catalogue(inputArr) {
  let groups = {};

  for (const product of inputArr) {
    let [name, price] = product.split(" : ");
    if (!groups.hasOwnProperty(name[0])) {
      groups[name[0]] = [];
    }
    groups[name[0]].push({ name, price: Number(price) });
  }
  let sortedGroups = Object.keys(groups).sort((a, b) => a.localeCompare(b));

  for (let i = 0; i < sortedGroups.length; i++) {
    console.log(sortedGroups[i]);
    groups[sortedGroups[i]]
      .sort((productA, productB) =>
        productA.name.localeCompare(productB.name)
      )
      .forEach((product) => {
        console.log(`  ${product.name}: ${product.price}`);
      });
  }

  // for (const product in sortedProducts) {
  //    console.log(product);
  //    console.log(`  ${product}: ${sortedProducts[product]}`);
  // }
}

catalogue([
  "Appricot : 20.4",
  "Fridge : 1500",
  "TV : 1499",
  "Deodorant : 10",
  "Boiler : 300",
  "Apple : 1.25",
  "Anti-Bug Spray : 15",
  "T-Shirt : 10",
]);
