function multiplicationTable(number) {

    for (let multiplication = 1; multiplication <= 10; multiplication++) {
        let result = 0;
        result = number * multiplication;
        console.log(`${number} X ${multiplication} = ${result}`)
    }
}

multiplicationTable(5);
multiplicationTable(2);