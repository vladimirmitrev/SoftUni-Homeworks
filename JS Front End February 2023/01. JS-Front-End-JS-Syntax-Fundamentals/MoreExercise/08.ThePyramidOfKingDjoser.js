function thePyramidOfKing(base, increment) {
  let stone = 0;
  let marble = 0;
  let lapisLazuli = 0;
  let gold = 0;
  let height = 0;

  for (let i = base; i >= increment; i -= 2) {
    if (base === 2 || base === 1) {
      gold += base * base * increment;
      height++;
      break;
    }
    height++;
    let stoneNeeded = (base - 2) ** 2;
    if (height % 5 === 0) {
      lapisLazuli += (base * base - stoneNeeded) * increment;
    } else {
      marble += (base * base - stoneNeeded) * increment;
    }
    base -= 2;
    stone += stoneNeeded * increment;
  }

  console.log(`Stone required: ${Math.ceil(stone)}`);
  console.log(`Marble required: ${Math.ceil(marble)}`);
  console.log(`Lapis Lazuli required: ${Math.ceil(lapisLazuli)}`);
  console.log(`Gold required: ${Math.ceil(gold)}`);
  console.log(`Final pyramid height: ${Math.floor(height * increment)}`);
}

thePyramidOfKing(11, 1);
thePyramidOfKing(11, 0.75);
thePyramidOfKing(12, 1);
thePyramidOfKing(23, 0.5);
