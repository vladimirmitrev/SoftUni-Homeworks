function colorize() {
  const evenRows = Array.from(document.querySelectorAll("tr:nth-child(even)"));

  evenRows.forEach((row) => (row.style.backgroundColor = "Teal"));
  
//   for (const row of evenRows) {
//     row.style.backgroundColor = "Teal";
//   }
}
