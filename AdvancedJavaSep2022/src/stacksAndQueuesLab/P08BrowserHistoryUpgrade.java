package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class    P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String currentURL = "blank";

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if(command.equals("back")) {
                if(!history.isEmpty()) {
                    currentURL = history.pop();
                    forward.push(currentURL);
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }

            } else if(command.equals("forward")) {
                if(forward.isEmpty()) {
                    System.out.println("no next URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    currentURL = forward.pop();
                    history.push(currentURL);

                }
            }
            else {
                if(!currentURL.equals("blank")) {
                    history.push(currentURL);
                    forward.clear();
                }
                currentURL = command;
            }
            System.out.println(currentURL);
            command = scanner.nextLine();
        }


    }
}
