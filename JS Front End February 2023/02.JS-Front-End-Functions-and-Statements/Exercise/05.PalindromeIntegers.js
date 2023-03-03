function palindromeIntegers(numbers) {

    numbers
    .forEach((num) => {
        console.log(isPalindrome(num))
    });

    function isPalindrome(num) {
        let reversed = Number([...num.toString()].reverse().join(""));

        return num === reversed;
    }
}

palindromeIntegers([123,323,421,121]);
palindromeIntegers([32,2,232,1010]);

// Solution with functional // 

// (numbers) => numbers
//             .map((num) => Number([...num.toString()].reverse().join("")) === num)
//             .join("\n");