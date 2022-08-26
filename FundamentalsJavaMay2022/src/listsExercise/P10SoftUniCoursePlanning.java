package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", "))
                            .collect(Collectors.toList());

        String command = scanner.nextLine();


        while(!command.equals("course start")) {
            String lessonTitle = command.split(":")[1];

            if(command.contains("Add")) {
                if(!lessons.contains(lessonTitle)){
                    lessons.add(lessonTitle);
                }

            } else if (command.contains("Insert")) {
                int indexToSwitch = Integer.parseInt(command.split(":")[2]);
                if (!lessons.contains(lessonTitle)) {
                    lessons.add(indexToSwitch, lessonTitle);
                }
            } else if (command.contains("Remove") && lessons.contains(lessonTitle))  {
                lessons.remove(lessonTitle);

            } else if (command.contains("Swap")) {
                String lessonTitle2 = command.split(":") [2];

                if (lessons.contains(lessonTitle) && lessons.contains(lessonTitle2)) {
                    int lesson1Index = lessons.indexOf(lessonTitle);
                    int lesson2Index = lessons.indexOf(lessonTitle2);
                    lessons.set(lesson1Index, lessonTitle2);
                    lessons.set(lesson2Index, lessonTitle);

                    String exOne = lessonTitle + "-Exercise";
                    String exTwo = lessonTitle2 + "-Exercise";

                    if(lessons.contains(exOne)) {
                        lessons.remove(lessons.indexOf(exOne));
                        lessons.add(lessons.indexOf(lessonTitle)+ 1, exOne);
                    }
                    if(lessons.contains(exTwo)) {
                        lessons.remove(lessons.indexOf(exTwo));
                        lessons.add(lessons.indexOf(lessonTitle2) + 1, exTwo);
                    }

                }
            } else if (command.contains("Exercise")) {
                String exercise = lessonTitle + "-Exercise";
                int index = lessons.indexOf(lessonTitle);
                if (lessons.contains(lessonTitle)) {
                    if(index == lessons.size()- 1) {
                        lessons.add(index + 1, exercise);
                    } else if (!lessons.get(index + 1).equals(exercise)) {
                        lessons.add(index + 1, exercise);
                    }
                } else {
                    lessons.add(lessonTitle);
                    lessons.add(exercise);
                }
            }



            command = scanner.nextLine();
        }
        printList(lessons);
    }

    public static void printList (List<String> lessons) {
        int count = 1;
        for (String lesson : lessons) {
            System.out.println(count + "." + lesson);
            count++;
        }

    }
}

