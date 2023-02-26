function login(inputArr) {
  let username = inputArr[0];
  let password = username.split("").reverse().join("");

  for (let i = 1; i <= inputArr.length; i++) {
    let currentWord = inputArr[i];
    if (currentWord === password) {
      console.log(`User ${username} logged in.`);
      break;
    } else if (i === 4) {
      console.log(`User ${username} blocked!`);
      break;
    } else {
      if (i >= 5) {
        console.log(`User ${username} blocked!`);
        break;
      }
      console.log(`Incorrect password. Try again.`);
    }
  }
}

login(["Acer", "login", "go", "let me in", "recA"]);
login(["momo", "omom"]);
login(["sunny", "rainy", "cloudy", "sunny", "not sunny"]);
