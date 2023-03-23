function shoppingList(input) {
  let cart = input.shift().split("!");
  input.pop();

  for (const line of input) {
    let [command, item, newItem] = line.split(" ");

    if (command === "Urgent") {
      if (!cart.includes(item)) {
        cart.unshift(item);
      }
    } else if (command === "Unnecessary") {
      if (cart.includes(item)) {
        removeItem(item);
      }
    } else if (command === "Correct") {
      if (cart.includes(item)) {
        cart[cart.indexOf(item)] = newItem;
      }
    } else if (command === "Rearrange") {
      if (cart.includes(item)) {
        removeItem(item);
        cart.push(item);
      }
    }
  }

  function removeItem(item) {
    cart.splice(cart.indexOf(item), 1);
  }
  console.log(cart.join(", "));
}

shoppingList([
  "Milk!Pepper!Salt!Water!Banana",
  "Urgent Salt",
  "Unnecessary Grapes",
  "Correct Pepper Onion",
  "Rearrange Grapes",
  "Correct Tomatoes Potatoes",
  "Go Shopping!",
]);

shoppingList([
  "Tomatoes!Potatoes!Bread",
  "Unnecessary Milk",
  "Urgent Tomatoes",
  "Go Shopping!",
]);
