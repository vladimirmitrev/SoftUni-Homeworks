function reverse(n, inputArr) {
    let array = [];
    for (let i = 0; i < n; i++) {
        let number = inputArr[i];
        array.push(number);
    }

    let output = '';
    for (let i = array.length -1; i >= 0 ; i--) {
        output += array[i] += ' ';
    }
    output.trimEnd;
    console.log(output);

}

reverse(3, [10, 20, 30, 40, 50]);
reverse(4, [-1, 20, 99, 5]);
reverse(2, [66, 43, 75, 89, 47]);