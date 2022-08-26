package exam6and7April2019;

import java.util.Scanner;

public class P05_MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int movieCount = Integer.parseInt(scanner.nextLine());

        double hightestRating = 0;
        double lowestRating = 11;
        String highestRatingName = "";
        String lowestRatingName = "";
        double totalMovieRating = 0;


        for (int i = 1; i <= movieCount ; i++) {

            String movieName = scanner.nextLine();
            double movieRating = Double.parseDouble(scanner.nextLine());
            totalMovieRating += movieRating;

            if (movieRating > hightestRating) {
                    hightestRating = movieRating;
                    highestRatingName = movieName;
                }

            if (movieRating < lowestRating) {
                lowestRating = movieRating;
                lowestRatingName = movieName;
            }

        }
        double averageRating = totalMovieRating / movieCount;

        System.out.printf("%s is with highest rating: %.1f%n", highestRatingName, hightestRating);
        System.out.printf("%s is with lowest rating: %.1f%n", lowestRatingName, lowestRating);
        System.out.printf("Average rating: %.1f", averageRating);
    }
}
