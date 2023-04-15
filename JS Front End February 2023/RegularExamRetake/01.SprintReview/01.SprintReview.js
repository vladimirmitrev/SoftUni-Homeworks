function solve(input) {
  let numberOfPeople = Number(input.shift());

  let peopleObj = {};

  let toDoPoints = 0;
  let inProgressPoints = 0;
  let codeReviewPoints = 0;
  let donePoints = 0;

  for (let index = 0; index < numberOfPeople; index++) {
    let [name, taskId, title, status, points] = input.shift().split(":");

    points = Number(points);

    if (!peopleObj.hasOwnProperty(name)) {
      peopleObj[name] = [];
    }

    peopleObj[name].push({ taskId, title, status, points });
  }

  for (const line of input) {
    let [command, name, taskId, title, status, points] = line.split(":");
    points = Number(points);

    if (!peopleObj.hasOwnProperty(name)) {
      console.log(`Assignee ${name} does not exist on the board!`);
    } else {
      switch (command) {
        case "Add New":
          peopleObj[name].push({ taskId, title, status, points });
          break;
        case "Change Status":
          let currentTaskId = taskId;

          for (const obj of peopleObj[name]) {
            if (currentTaskId !== obj.taskId) {
              console.log(
                `Task with ID ${currentTaskId} does not exist for ${name}!`
              );
              break;
            }
            let newStatus = title;
            obj.status = newStatus;
          }
          break;
        case "Remove Task":
          let index = Number(taskId);
          if (index < 0 || index >= peopleObj[name].length) {
            console.log("Index is out of range!");
            break;
          }
          peopleObj[name].splice(index, 1);
          break;
      }
    }
  }
  let values = Object.values(peopleObj);

  for (const name of values) {
    for (const obj of name) {
      if (obj.status === "ToDo") {
        toDoPoints += obj.points;
      } else if (obj.status === "In Progress") {
        inProgressPoints += obj.points;
      } else if (obj.status === "Code Review") {
        codeReviewPoints += obj.points;
      } else if (obj.status === "Done") {
        donePoints += obj.points;
      }
    }
  }
  console.log(`ToDo: ${toDoPoints}pts`);
  console.log(`In Progress: ${inProgressPoints}pts`);
  console.log(`Code Review: ${codeReviewPoints}pts`);
  console.log(`Done Points: ${donePoints}pts`);

  let totalPoints = toDoPoints + inProgressPoints + codeReviewPoints;

  if (donePoints >= totalPoints) {
    console.log("Sprint was successful!");
  } else {
    console.log("Sprint was unsuccessful...");
  }
}

solve([
  "5",
  "Kiril:BOP-1209:Fix Minor Bug:ToDo:3",
  "Mariya:BOP-1210:Fix Major Bug:In Progress:3",
  "Peter:BOP-1211:POC:Code Review:5",
  "Georgi:BOP-1212:Investigation Task:Done:2",
  "Mariya:BOP-1213:New Account Page:In Progress:13",
  "Add New:Kiril:BOP-1217:Add Info Page:In Progress:5",
  "Change Status:Peter:BOP-1290:ToDo",
  "Remove Task:Mariya:1",
  "Remove Task:Joro:1",
]);

solve([
  "4",
  "Kiril:BOP-1213:Fix Typo:Done:1",
  "Peter:BOP-1214:New Products Page:In Progress:2",
  "Mariya:BOP-1215:Setup Routing:ToDo:8",
  "Georgi:BOP-1216:Add Business Card:Code Review:3",
  "Add New:Sam:BOP-1237:Testing Home Page:Done:3",
  "Change Status:Georgi:BOP-1216:Done",
  "Change Status:Will:BOP-1212:In Progress",
  "Remove Task:Georgi:3",
  "Change Status:Mariya:BOP-1215:Done",
]);
