function solve() {
  const addBtns = Array.from(document.querySelectorAll(".add-product"));
  const checkOutBtn = document.querySelector(".checkout");
  const textArea = document.querySelector("textarea");

  let [cart, totalPrice] = [[], 0];
  let listSet = new Set();

  addBtns.forEach((btn) => btn.addEventListener("click", addProduct));

  checkOutBtn.addEventListener("click", checkOut);

  function addProduct(e) {
    let product = e.target.parentElement.parentElement;
    let productName = product.querySelector(".product-title").textContent;
    let productPrice = Number(
      product.querySelector(".product-line-price").textContent
    );
    addToCart(productName, productPrice);

    
  }

  function addToCart(name, price) {
    cart.push({ name: name, price: price });
    listSet.add(name);
    totalPrice += price;
    textArea.value += `Added ${name} for ${price.toFixed(2)} to the cart.\n`;

  }

  function checkOut() {
   let finalList = [];

   for (const item of listSet) {
      finalList.push(item);
   }

    textArea.value += `You bought ${finalList.join(", ")} for ${totalPrice.toFixed(2)}.`;

    addBtns.forEach((b) => b.disabled = true);

    checkOutBtn.disabled = true;
  }
}
