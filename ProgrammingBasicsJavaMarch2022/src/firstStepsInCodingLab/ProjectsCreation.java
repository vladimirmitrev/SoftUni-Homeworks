package firstStepsInCodingLab;

import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int countProjects = Integer.parseInt(scanner.nextLine());

        int allHours = countProjects * 3;

        //The architect George will need 12 hours to complete 4 project/s.

//        System.out.println("The architect " +
//                name +
//                " will need " +
//                allHours +
//                " hours to complete " +
//                countProjects +
//                " project/s.");

        System.out.printf("The architect %s will need %d hours to complete %d project/s.%n",
                name, allHours, countProjects);
    }
}
