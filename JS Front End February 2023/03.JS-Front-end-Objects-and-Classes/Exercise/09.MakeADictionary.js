function makeADictionary(input) {
  let terms = {};

  for (let line of input) {
    line = JSON.parse(line);
    terms[Object.keys(line)] = Object.values(line);
  }

  let sortedTerms = Object.keys(terms).sort((a, b) => a.localeCompare(b));

  for (const key of sortedTerms) {
    console.log(`Term: ${key} => Definition: ${terms[key]}`);
  }
}
makeADictionary([
  '{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
  '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
  '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
  '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
  '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}',
]);
