function cooking(numberAsString, ...operations) {
  let numberAsInt = Number(numberAsString);

  operations.forEach((operation) => {
    switch (operation) {
      case "chop":
        numberAsInt /= 2;
        break;

      case "dice":
        numberAsInt = Math.sqrt(numberAsInt);
        break;

      case "spice":
        numberAsInt++;
        break;

      case "bake":
        numberAsInt *= 3;
        break;

      case "fillet":
        numberAsInt -= numberAsInt * 0.2;
        break;
    }
    console.log(numberAsInt);
  });
}

cooking("32", "chop", "chop", "chop", "chop", "chop");
cooking("9", "dice", "spice", "chop", "bake", "fillet");
