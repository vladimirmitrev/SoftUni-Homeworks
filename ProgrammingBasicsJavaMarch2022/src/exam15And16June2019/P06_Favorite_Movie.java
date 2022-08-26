package exam15And16June2019;

import java.util.Scanner;

public class P06_Favorite_Movie {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();

        int moviesCount = 0;
        String bestMovie = "";
        int bestSum = 0;



        while (!movie.equals("STOP")) {

            int sum = 0;
            moviesCount++;
            if (moviesCount >= 7) {
                System.out.printf("The limit is reached.%n");
                break;
            }
            for (int i = 0; i < movie.length(); i++) {
                int name = movie.charAt(i);


                if (name >= 'A' && name <= 'Z') {
                    sum +=  movie.charAt(i) - movie.length();

                } else if (name >= 'a' && name <= 'z') {
                    sum += movie.charAt(i) - (movie.length() * 2);

                } else {
                    sum += name;
                }

            }
            if (sum > bestSum) {
                bestSum = sum;
                bestMovie = movie;
            }

            movie = scanner.nextLine();

        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.", bestMovie, bestSum);
    }
}
