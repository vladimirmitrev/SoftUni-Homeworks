function meetingsParser(inputArr) {
  let meetings = {};

  for (const line of inputArr) {
    let [day, name] = line.split(" ");
    if (!meetings.hasOwnProperty(day)) {
      meetings[day] = name;
      console.log(`Scheduled for ${day}`);
    } else {
      console.log(`Conflict on ${day}!`);
    }
  }
  //   let object = Object.entries(meetings);

  //   for (const [key, value] of object) {
  //         console.log(`${key} -> ${value}`)
  //   }


  for (const key in meetings) {
    console.log(`${key} -> ${meetings[key]}`);
  }

}

meetingsParser(["Monday Peter", "Wednesday Bill", "Monday Tim", "Friday Tim"]);
