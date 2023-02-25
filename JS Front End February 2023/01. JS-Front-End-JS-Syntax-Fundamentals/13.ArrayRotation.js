function arrayRotation(numberArr, countOfRotations) {

    for (let i = 1; i <= countOfRotations; i++) {
        let firstNum = numberArr.shift();
        numberArr.push(firstNum);
    }
    console.log(numberArr.join(" "));

}

arrayRotation([51, 47, 32, 61, 21], 2);
arrayRotation([32, 21, 61, 1], 4);
arrayRotation([2, 4, 15, 31], 5);