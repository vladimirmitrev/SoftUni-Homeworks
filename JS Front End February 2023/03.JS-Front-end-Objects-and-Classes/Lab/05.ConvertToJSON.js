function convertToJSON(name, lastName, hairColor) {
    
  let object = {
    name,
    lastName,
    hairColor,
  };

  console.log(JSON.stringify(object));
}
convertToJSON("George", "Jones", "Brown");
