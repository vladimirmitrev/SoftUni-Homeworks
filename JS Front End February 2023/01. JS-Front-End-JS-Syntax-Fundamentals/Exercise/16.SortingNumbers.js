function sortingNumbers(numbers) {
  let sortedNumbers = [...numbers].sort((aNum, bNum) => aNum - bNum);
  let result = [];
  while (sortedNumbers.length > 0) {
    result.push(sortedNumbers.shift());
    result.push(sortedNumbers.pop());
  }
  return result;
}

console.log(sortingNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));
