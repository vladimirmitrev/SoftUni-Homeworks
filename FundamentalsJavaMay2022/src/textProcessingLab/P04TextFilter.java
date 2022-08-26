package textProcessingLab;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banWordArr = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String banWord : banWordArr) {
            if(text.contains(banWord)) {
                text = text.replace(banWord, toRepeat("*", banWord.length()));
            }
        }
        System.out.println(text);
    }
    public static String toRepeat(String s, int count){
        String result = "";
        for (int i = 0; i < count ; i++) {
            result += s;
        }
        return result;
    }
}
