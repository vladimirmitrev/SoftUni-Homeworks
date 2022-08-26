package methodsExercise;

import java.util.Scanner;

public class P07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int [][] nMatrix = printMatrix(n);

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.printf("%d ", nMatrix[i][j]);
            }
            System.out.println();
            
        }

    }

    private static int[][] printMatrix (int n) {
        int[][] resultMatrix = new int[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                resultMatrix[i][j] = n;
            }
        }
        return resultMatrix;
    }
}