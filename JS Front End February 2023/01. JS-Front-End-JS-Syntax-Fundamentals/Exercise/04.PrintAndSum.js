function printAndSum(startIndex, endIndex) {
    let sum = 0;
    let numbersArr = [];
    for (let i = startIndex; i <= endIndex; i++) {
        numbersArr.push(i);
        sum += i;
    }
    console.log(numbersArr.join(" "));
    console.log(`Sum: ${sum}`)
}

printAndSum(5, 10);
printAndSum(0, 26);
