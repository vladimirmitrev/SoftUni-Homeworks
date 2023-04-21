function sprintReview(input) {
  let numberOfStudents = Number(input.shift());
  let studentsObject = {};

  let points = {
    ToDo: 0,
    "In Progress": 0,
    "Code Review": 0,
    Done: 0,
  };

  for (let index = 0; index < numberOfStudents; index++) {
    let tokens = input.shift().split(":");
    let assignee = tokens[0];
    let taskId = tokens[1];
    let title = tokens[2];
    let status = tokens[3];
    let estimatedPoints = Number(tokens[4]);

    if (!studentsObject.hasOwnProperty(assignee)) {
      studentsObject[assignee] = [];
    }
    studentsObject[assignee].push({ taskId, title, status, estimatedPoints });
    points[status] += estimatedPoints;
  }

  for (let line of input) {
    let tokens = line.split(":");
    let command = tokens[0];
    let assignee = tokens[1];

    if (!studentsObject.hasOwnProperty(assignee)) {
      console.log(`Assignee ${assignee} does not exist on the board!`);
    } else {
      if (command === "Add New") {
        let taskId = tokens[2];
        let title = tokens[3];
        let status = tokens[4];
        let estimatedPoints = Number(tokens[5]);
        studentsObject[assignee].push({
          taskId,
          title,
          status,
          estimatedPoints,
        });
        points[status] += estimatedPoints;
      }
      if (command === "Change Status") {
        let currentTaskId = tokens[2];
        let newStatus = tokens[3];

        for (const object of studentsObject[assignee]) {
          if (object.taskId !== currentTaskId) {
            console.log(
              `Task with ID ${currentTaskId} does not exist for ${assignee}!`
            );
          } else {
            points[object.status] -= object.estimatedPoints;
            object.status = newStatus;
            points[newStatus] += object.estimatedPoints;
          }
        }
      } else if (command === "Remove Task") {
        let index = Number(tokens[2]);
        if (index < 0 || index >= studentsObject[assignee].length) {
          console.log("Index is out of range!");
        } else {
          let pointsToRemove = studentsObject[assignee][index].estimatedPoints;
          let currentStatus = studentsObject[assignee][index].status;
          points[currentStatus] -= pointsToRemove;
          studentsObject[assignee].splice(index, 1);
        }
      }
    }
  }
  console.log(`ToDo: ${points["ToDo"]}pts`);
  console.log(`In Progress: ${points["In Progress"]}pts`);
  console.log(`Code Review: ${points["Code Review"]}pts`);
  console.log(`Done Points: ${points["Done"]}pts`);

  let totalOfFirstThree =
    points["ToDo"] + points["In Progress"] + points["Code Review"];

  if (points["Done"] >= totalOfFirstThree) {
    console.log("Sprint was successful!");
  } else {
    console.log("Sprint was unsuccessful...");
  }
}

// sprintReview([
//   "5",
//   "Kiril:BOP-1209:Fix Minor Bug:ToDo:3",
//   "Mariya:BOP-1210:Fix Major Bug:In Progress:3",
//   "Peter:BOP-1211:POC:Code Review:5",
//   "Georgi:BOP-1212:Investigation Task:Done:2",
//   "Mariya:BOP-1213:New Account Page:In Progress:13",
//   "Add New:Kiril:BOP-1217:Add Info Page:In Progress:5",
//   "Change Status:Peter:BOP-1290:ToDo",
//   "Remove Task:Mariya:1",
//   "Remove Task:Joro:1",
// ]);

sprintReview([
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
