package examPreparation022022;

import java.util.Scanner;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[matrixSize][matrixSize];

        int sapperRow = 0;
        int sapperCol = 0;
        int bombCounter = 0;
        for (int i = 0; i < matrixSize; i++) {
            char[] arr = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = arr;
            for (int j = 0; j < arr.length; j++) {
                char currentChar = arr[j];
                if (currentChar == 's') {
                    sapperRow = i;
                    sapperCol = j;
                } else if (currentChar == 'B') {
                    bombCounter++;
                }
                matrix[i][j] = currentChar;
            }
        }

        int bombFound = 0;
        for (int i = 0; i < commands.length; i++) {
            String commandName = commands[i];
            switch (commandName) {
                case "up":
                    if(sapperRow > 0) {
                        sapperRow -= 1;
                    }
                    break;
                case "down":
                    if(sapperRow < matrixSize - 1) {
                        sapperRow += 1;
                    }
                    break;
                case "left":
                    if(sapperCol > 0) {
                        sapperCol -= 1;
                    }
                    break;
                case "right":
                    if(sapperCol < matrixSize -1 ) {
                        sapperCol += 1;
                    }
                    break;
            }
            if(matrix[sapperRow][sapperCol] == 'B') {
                System.out.println("You found a bomb!");
                matrix[sapperRow][sapperCol] = '+';
                bombFound++;
                if(bombFound == bombCounter) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[sapperRow][sapperCol] == 'e') {
                System.out.printf("END! %d bombs left on the field", bombCounter - bombFound);
                return;
            }
        }

       // printMatrix(matrixSize,matrix);

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",
                bombCounter - bombFound, sapperRow, sapperCol);


    }

//    private static void printMatrix(int matrixSize2, char[][] matrix2) {
//        for (int i = 0; i < matrixSize2; i++) {
//            for (int j = 0; j < matrixSize2; j++) {
//                System.out.print(matrix2[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//        for (int i = 0; i < matrixSize; i++) {
//            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" "))
//                    .map(e -> e.charAt(0))
//                    .collect(Collectors.toList());
//            for (int j = 0; j < characterList.size(); j++) {
//                char currentChar = characterList.get(j);
//                if (currentChar == 's') {
//                    sapperRow = i;
//                    sapperCol = j;
//                } else if (currentChar == 'B') {
//                    bombCounter++;
//                }
//                matrix[i][j] = currentChar;
//            }

//        }

//        for (int i = 0; i < matrixSize; i++) {
//            for (int j = 0; j < matrixSize; j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
}

