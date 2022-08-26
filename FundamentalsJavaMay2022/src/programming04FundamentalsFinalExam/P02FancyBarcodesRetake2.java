package programming04FundamentalsFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodesRetake2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String regex = "([@][#]+)(?<word>[A-Z][A-Za-z0-9]{4,}[A-Z])([@][#]+)";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();

            Matcher matcher = pattern.matcher(text);

            if(matcher.find()) {
                String barcode = matcher.group("word");
                String product = "";

                for (int j = 0; j < barcode.length(); j++) {
                    char symbol = barcode.charAt(j);

                    if(Character.isDigit(symbol)) {
                        product += symbol;
                    }
                }
                if(product.equals("")) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", product);
                }

            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
