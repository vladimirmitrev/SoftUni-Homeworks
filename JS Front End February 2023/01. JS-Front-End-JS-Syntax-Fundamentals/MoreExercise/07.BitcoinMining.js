function bitcoinMining(numbersArr) {
  let totalMoneyLeva = 0;
  let days = 0;
  let dayOfPurchase = 0;
  let totalBitcoins = 0;
  let bitcoinPrice = 11949.16;
  let goldPrice = 67.51;

  for (let i = 0; i < numbersArr.length; i++) {
    days++;
    let goldAmount = Number(numbersArr[i]);

    if (days % 3 == 0) {
      goldAmount = goldAmount * 0.7;
    }

    totalMoneyLeva += goldAmount * goldPrice;

    while (totalMoneyLeva >= bitcoinPrice) {
      totalMoneyLeva -= bitcoinPrice;
      totalBitcoins++;
      if (totalBitcoins === 1) {
        dayOfPurchase = days;
      }
    }
  }
  console.log(`Bought bitcoins: ${totalBitcoins}`);

  if (totalBitcoins > 0) {
    console.log(`Day of the first purchased bitcoin: ${dayOfPurchase}`);
  }

  console.log(`Left money: ${totalMoneyLeva.toFixed(2)} lv.`);
}

bitcoinMining([100, 200, 300]);
bitcoinMining([50, 100]);
bitcoinMining([3124.15, 504.212, 2511.124]);
