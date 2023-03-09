function solve(inputArr) {
  class Song {
    constructor(type, name, time) {
      this.type = type;
      this.name = name;
      this.time = time;
    }
  }

  let countOfSongs = inputArr.shift();
  let typeSong = inputArr.pop();
  let songs = [];

  for (let index = 0; index < countOfSongs; index++) {
    let [type, name, time] = inputArr[index].split("_");
    let song = new Song(type, name, time);
    songs.push(song);
  }

  if (typeSong === "all") {
    songs.forEach((song) => console.log(song.name));
  } else {
    let filtered = songs.filter((song) => song.type === typeSong);
    filtered.forEach((s) => console.log(s.name));
  }
}
solve([
  3,
  "favorite_DownTown_3:14",
  "favorite_Kiss_4:16",
  "favorite_Smooth Criminal_4:01",
  "favorite",
]);

solve([
  4,
  "favorite_DownTown_3:14",
  "listenLater_Andalouse_3:24",
  "favorite_In To The Night_3:58",
  "favorite_Live It Up_3:48",
  "listenLater",
]);

solve([2, "like_Replay_3:15", "ban_Photoshop_3:48", "all"]);
