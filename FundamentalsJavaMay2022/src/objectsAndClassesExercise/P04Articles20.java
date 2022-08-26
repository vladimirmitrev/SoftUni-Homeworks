package objectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Articles20 {
    static class Articles {
        String title;
        String content;
        String author;

        public Articles(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString() {
            return  this.title + " - " + this.content + ": " + this.author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Articles> articlesList = new ArrayList<>();
            for (int i = 1; i <= n ; i++) {
                String command = scanner.nextLine();
                String title = command.split(", ")[0];
                String content = command.split(", ")[1];
                String author = command.split(", ")[2];

                Articles articles = new Articles(title, content, author);
                articlesList.add(articles);

                if (command.equals("title") || command.equals("content") || command.equals("author")) {
                    break;
                }
            }

        for (Articles article : articlesList ) {
            System.out.println(article);
        }
    }
}
