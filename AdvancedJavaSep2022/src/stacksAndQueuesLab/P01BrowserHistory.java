package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String currentURL = "blank";

        ArrayDeque<String> history = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if(command.equals("back")) {
                if(!history.isEmpty()) {
                    currentURL = history.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }

            } else {
                if(!currentURL.equals("blank")) {
                    history.push(currentURL);
                }
                currentURL = command;
            }
            System.out.println(currentURL);
            command = scanner.nextLine();
        }

    }
}
