function addressBookParser(inputArr) {
  let addressBook = {};

  for (const line of inputArr) {
    let [name, address] = line.split(":");
    addressBook[name] = address;
  }

  let sortedAddressBook = Object.entries(addressBook);

  sortedAddressBook.sort((aName, bName) => aName[0].localeCompare(bName[0]));

  for (const [key, value] of sortedAddressBook) {
    console.log(`${key} -> ${value}`);
  }
}

addressBookParser([
  "Tim:Doe Crossing",
  "Bill:Nelson Place",
  "Peter:Carlyle Ave",
  "Bill:Ornery Rd",
]);
addressBookParser([
  "Bob:Huxley Rd",
  "John:Milwaukee Crossing",
  "Peter:Fordem Ave",
  "Bob:Redwing Ave",
  "George:Mesta Crossing",
  "Ted:Gateway Way",
  "Bill:Gateway Way",
  "John:Grover Rd",
  "Peter:Huxley Rd",
  "Jeff:Gateway Way",
  "Jeff:Huxley Rd",
]);
