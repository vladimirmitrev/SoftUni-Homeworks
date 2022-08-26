package programming04FundamentalsFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodesRetake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "[@][#]+(?<text>[A-Z][A-Za-z0-9]{4,}[A-Z])[@][#]+";

        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String character = matcher.group("text");
                String productGroup = "";

                for (int j = 0; j < character.length(); j++) {
                    char symbol = character.charAt(j);
                    if(Character.isDigit(symbol)) {
                        productGroup += symbol;
                    }

                }
                if(!productGroup.equals("")) {
                    System.out.printf("Product group: %s%n", productGroup);
                } else {
                    System.out.println("Product group: 00");
                }

            } else {
                System.out.println("Invalid barcode");
            }

        }
        
    }
}
