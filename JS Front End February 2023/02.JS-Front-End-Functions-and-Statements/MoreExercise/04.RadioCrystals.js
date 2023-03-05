function radioCrystals(input) {
  let targetThickness = input[0];
  let chunksArr = [...input];

  for (let index = 1; index < chunksArr.length; index++) {
    let currentChunk = chunksArr[index];

    let cuts = 0;
    let laps = 0;
    let grinds = 0;
    let etch = 0;

    console.log(`Processing chunk ${currentChunk} microns`);

    while (currentChunk !== targetThickness) {
      while (currentChunk / 4 >= targetThickness) {
        currentChunk /= 4;
        cuts++;
      }

      if (cuts > 0) {
        console.log(`Cut x${cuts}`);
        console.log("Transporting and washing");
        currentChunk = Math.floor(currentChunk);
      }

      while (currentChunk * 0.8 >= targetThickness) {
        currentChunk *= 0.8;
        laps++;
      }

      if (laps > 0) {
        console.log(`Lap x${laps}`);
        console.log("Transporting and washing");
        currentChunk = Math.floor(currentChunk);
      }

      while (currentChunk - 20 >= targetThickness) {
        currentChunk -= 20;
        grinds++;
      }

      if (grinds > 0) {
        console.log(`Grind x${grinds}`);
        console.log("Transporting and washing");
        currentChunk = Math.floor(currentChunk);
      }

      while (currentChunk - 2 >= targetThickness - 1) {
        currentChunk -= 2;
        etch++;
      }

      if (etch > 0) {
        console.log(`Etch x${etch}`);
        console.log("Transporting and washing");
        currentChunk = Math.floor(currentChunk);
      }

      if (currentChunk < targetThickness) {
        currentChunk += 1;
        console.log("X-ray x1");
      }
      console.log(`Finished crystal ${currentChunk} microns`);
    }
  }
}

radioCrystals([1375, 50000]);
radioCrystals([1000, 4000, 8100]);
