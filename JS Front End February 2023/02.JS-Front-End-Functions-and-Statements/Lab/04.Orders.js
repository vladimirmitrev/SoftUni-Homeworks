function orders(product, qty) {
  let result = 0;

  switch (product) {
    case "coffee":
      result = qty * 1.5;
      break;
    case "water":
      result = qty * 1;
      break;
    case "coke":
      result = qty * 1.4;
      break;
    case "snacks":
      result = qty * 2;
      break;

    default:
      console.log("Invalid product");
      break;
  }
  console.log(result.toFixed(2));
}

orders("coffee", 2);
orders("water", 5);

