function oddAndEvenSum(number) {

    let oddSum = 0;
    let evenSum = 0;
    const digits = number.toString().split("");


    for (let i = 0; i < digits.length; i++) {
        
        const digit = Number(digits[i]);

        if(digit % 2 == 0) {
            evenSum += digit;
        } else {
            oddSum += digit;
        }
    }

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`)
}

oddAndEvenSum(1000435);
oddAndEvenSum(3495892137259234);