function inventory(inputArr) {
  let heroes = [];

  for (const line of inputArr) {
    let [name, level, items] = line.split(" / ");
    level = Number(level);
    heroes.push({name, level, items});   
  }

  let sortedHeroes = heroes.sort((heroA, heroB) => heroA.level - heroB.level);

  
  sortedHeroes.forEach(hero => {
      console.log(`Hero: ${hero.name}`)
      console.log(`level => ${hero.level}`)
      console.log(`items => ${hero.items}`)
    });
}
//          *** Print with for of loop ***
//
//   for (const {name, level, items} of sortedHeroes) {
//     console.log(`Hero: ${name}`)
//     console.log(`level => ${level}`)
//     console.log(`items => ${items}`)
//   }

inventory([
  "Isacc / 25 / Apple, GravityGun",
  "Derek / 12 / BarrelVest, DestructionSword",
  "Hes / 1 / Desolator, Sentinel, Antara",
]);

inventory([
    'Batman / 2 / Banana, Gun',
    'Superman / 18 / Sword',
    'Poppy / 28 / Sentinel, Antara'
    ]
    )
