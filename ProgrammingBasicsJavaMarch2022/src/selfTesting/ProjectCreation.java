package selfTesting;

import java.util.Scanner;

public class ProjectCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int projects = Integer.parseInt(scanner.nextLine());
        int hours = 3 * projects;

        System.out.printf("The architect %s will need %d hours, to complete %d projects.",name, hours, projects);


    }

}
