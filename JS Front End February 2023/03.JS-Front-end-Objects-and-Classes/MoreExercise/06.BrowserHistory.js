function browserHistory(inputBrowser, inputCommands) {
  for (const command of inputCommands) {
    let currentCommand;
    let currentWebsite;

    if (command !== "Clear History and Cache") {
      [currentCommand, currentWebsite] = command.split(" ");
    } else {
      currentCommand = command;
    }

    if (currentCommand === "Open") {
      inputBrowser["Open Tabs"].push(currentWebsite);
      inputBrowser["Browser Logs"].push(command);

    } else if (currentCommand === "Close") {

      if (inputBrowser["Open Tabs"].includes(currentWebsite)) {
        let websiteIndex = inputBrowser["Open Tabs"].indexOf(currentWebsite);
        inputBrowser["Open Tabs"].splice(websiteIndex, 1);
        inputBrowser["Recently Closed"].push(currentWebsite);
        inputBrowser["Browser Logs"].push(command);
      }
    } else {
      inputBrowser["Open Tabs"] = [];
      inputBrowser["Recently Closed"] = [];
      inputBrowser["Browser Logs"] = [];
    }
  }
  let browserName = inputBrowser["Browser Name"];
  delete inputBrowser["Browser Name"];
  console.log(browserName);
  for (const [key, value] of Object.entries(inputBrowser)) {
    console.log(`${key}: ${value.join(", ")}`);
  }
}
browserHistory(
  {
    "Browser Name": "Google Chrome",
    "Open Tabs": ["Facebook", "YouTube", "Google Translate"],
    "Recently Closed": ["Yahoo", "Gmail"],
    "Browser Logs": [
      "Open YouTube",
      "Open Yahoo",
      "Open Google Translate",
      "Close Yahoo",
      "Open Gmail",
      "Close Gmail",
      "Open Facebook",
    ],
  },
  ["Close Facebook", "Open StackOverFlow", "Open Google"]
);
browserHistory(
  {
    "Browser Name": "Mozilla Firefox",
    "Open Tabs": ["YouTube"],
    "Recently Closed": ["Gmail", "Dropbox"],
    "Browser Logs": [
      "Open Gmail",
      "Close Gmail",
      "Open Dropbox",
      "Open YouTube",
      "Close Dropbox",
    ],
  },
  ["Open Wikipedia", "Clear History and Cache", "Open Twitter"]
);
