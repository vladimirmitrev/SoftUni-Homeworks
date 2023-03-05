function pointsValidation([x1, y1, x2, y2]) {
    let firstDistance = Math.sqrt(x1 ** 2 + y1 ** 2);
    let secondDistance = Math.sqrt(x2 ** 2 + y2 ** 2);
    let thirdDistance = Math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2);
  
    if (Number.isInteger(firstDistance)) {
      console.log(`{${x1}, ${y1}} to {0, 0} is valid`);
    } else {
      console.log(`{${x1}, ${y1}} to {0, 0} is invalid`);
    }
  
    if (Number.isInteger(secondDistance)) {
      console.log(`{${x2}, ${y2}} to {0, 0} is valid`);
    } else {
      console.log(`{${x2}, ${y2}} to {0, 0} is invalid`);
    }
  
    if (Number.isInteger(thirdDistance)) {
      console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`);
    } else {
      console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);
    }
  }

  pointsValidation([3, 0, 0, 4]);
  pointsValidation([2, 1, 1, 1]);