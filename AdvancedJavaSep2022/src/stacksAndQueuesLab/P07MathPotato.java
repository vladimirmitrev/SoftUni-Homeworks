package stacksAndQueuesLab;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> kids = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int transfers = Integer.parseInt(scan.nextLine());

        int cycle = 1;
        while (kids.size() > 1) {
            IntStream.range(1, transfers).forEach(i -> kids.offer(Objects.requireNonNull(kids.poll())));
            if (isPrime(cycle)) {
                System.out.println("Prime " + kids.peek());
            } else {
                System.out.println("Removed " + kids.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + kids.poll());

    }

    private static boolean isPrime(int cycle) {
        if (cycle == 1) {
            return false;
        }
        for (int i = 2; i <= cycle / 2; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;

    }
}
//        Scanner scanner = new Scanner(System.in);
//
//        String[] data = scanner.nextLine().split(" ");
//        ArrayDeque<String> queue = new ArrayDeque<>();
//        Collections.addAll(queue, data);
//
//        int n = Integer.parseInt(scanner.nextLine());
//        while (queue.size() > 1){
//            for (int i = 1; i < n; i++) {
//                queue.offer(queue.poll());
//            }
//
//            System.out.println("Removed " + queue.poll());
//        }
//
//        System.out.println("Last is " + queue.poll());
//
//    }

