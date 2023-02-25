function roadRadar(currentSpeed, area) {
  let speedingType;
  let currentSpeeding = 0;
  let areaLimit = 0;
  let isUnderLimit = true;

  switch (area) {
    case "motorway": {
      areaLimit = 130;
      if (currentSpeed <= 130) {
        isUnderLimit = true;
      } else {
        currentSpeeding = currentSpeed - 130;
        isUnderLimit = false;
      }
      break;
    }
    case "interstate": {
      areaLimit = 90;
      if (currentSpeed <= 90) {
        isUnderLimit = true;
      } else {
        currentSpeeding = currentSpeed - 90;
        isUnderLimit = false;
      }
      break;
    }

    case "city": {
      areaLimit = 50;
      if (currentSpeed <= 50) {
        isUnderLimit = true;
      } else {
        currentSpeeding = currentSpeed - 50;
        isUnderLimit = false;
      }
      break;
    }
    case "residential": {
      areaLimit = 20;
      if (currentSpeed <= 20) {
        isUnderLimit = true;
      } else {
        currentSpeeding = currentSpeed - 20;
        isUnderLimit = false;
      }
      break;
    }
  }

  if (currentSpeeding <= 20) {
    speedingType = "speeding";
  } else if (currentSpeed > 20 && currentSpeeding <= 40) {
    speedingType = "excessive speeding";
  } else {
    speedingType = "reckless driving";
  }

  if (isUnderLimit) {
    console.log(`Driving ${currentSpeed} km/h in a ${areaLimit} zone`);
  } else {
    console.log(
      `The speed is ${currentSpeeding} km/h faster than the allowed speed of ${areaLimit} - ${speedingType}`
    );
  }
}

roadRadar(40, "city");
roadRadar(21, "residential");
roadRadar(120, "interstate");
