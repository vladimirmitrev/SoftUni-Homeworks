function shoppingList(input) {

  let productsArr = input.shift().split("!");
  
  for (const line of input) {
      let tokens = line.split(" ");
      let command = tokens[0];
      let product = tokens[1];
      if (command === "Urgent" && !productsArr.includes(product)) {
          productsArr.unshift(product);
        } else if (command === "Unnecessary" && productsArr.includes(product)) {
            productsArr.splice(productsArr.indexOf(product), 1);
        } else if (command === "Correct" && productsArr.includes(product)) {
            let newName = tokens[2];
            productsArr[productsArr.indexOf(product)] = newName;
        } else if (command === "Rearrange" && productsArr.includes(product)) {
            productsArr.splice(productsArr.indexOf(product), 1);
            productsArr.push(product);
        }
    }
    console.log(productsArr.join(', '));
}

shoppingList([
  "Tomatoes!Potatoes!Bread",
  "Unnecessary Milk",
  "Urgent Tomatoes",
  "Go Shopping!",
]);

shoppingList([
  "Milk!Pepper!Salt!Water!Banana",
  "Urgent Salt",
  "Unnecessary Grapes",
  "Correct Pepper Onion",
  "Rearrange Grapes",
  "Correct Tomatoes Potatoes",
  "Go Shopping!",
]);
