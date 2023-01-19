package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class    P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        ArrayDeque<String> browserHistoryBack = new ArrayDeque<>();
        ArrayDeque<String> browserHistoryForward = new ArrayDeque<>();
        String input;
        String currentURL = null;

        while (!"Home".equals(input = scanner.nextLine())) {
            if (input.equals("back")) {
                if (!browserHistoryBack.isEmpty()) {
                    browserHistoryForward.offerFirst(currentURL);
                }
                if (browserHistoryBack.isEmpty()) {
                    System.out.println("no previous URLs");
                    continue;
                } else {
                    currentURL = browserHistoryBack.pop();
                }
            } else if (input.equals("forward")) {
                if (browserHistoryForward.isEmpty()) {
                    System.out.println("no next URLs");
                    continue;
                } else {
                    currentURL = browserHistoryForward.poll();
                }
            } else {
                if (currentURL != null) {
                    browserHistoryBack.push(currentURL);
                }
                currentURL = input;
                browserHistoryForward.clear();
            }
            System.out.println(currentURL);
        }
    }
}
