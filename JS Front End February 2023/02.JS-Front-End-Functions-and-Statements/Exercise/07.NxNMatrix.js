function fillMatrix(n) {

    new Array(n).fill(new Array(n).fill(n)).forEach(row => console.log(row.join(" ")));
}

fillMatrix(3);
fillMatrix(7);
fillMatrix(2);