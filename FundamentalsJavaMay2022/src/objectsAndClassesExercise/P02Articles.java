package objectsAndClassesExercise;

import java.util.Scanner;

public class P02Articles {
    static class Articles {
        String title;
        String content;
        String author;

        public Articles(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }
        public void edit(String newContent) {
            this.content = newContent;
        }
        public void changeAuthor(String newAuthor) {
            this.author = newAuthor;
        }
        public void rename(String newTitle) {
            this.title = newTitle;
        }

        @Override
        public String toString() {
            return  this.title + " - " + this.content + ": " + this.author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleData = scanner.nextLine();
        String title = articleData.split(", ")[0];
        String content = articleData.split(", ")[1];
        String author = articleData.split(", ")[2];

        Articles articles = new Articles(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
        String commandLine = scanner.nextLine();
        String command = commandLine.split("\\: ")[0];
        String newValue = commandLine.split("\\: ")[1];

        switch (command) {
            case "Edit":
                articles.edit(newValue);
                break;
            case "ChangeAuthor":
                articles.changeAuthor(newValue);
                break;
            case "Rename":
                articles.rename(newValue);
                break;
        }

        }

            System.out.println(articles.toString());

    }
}
