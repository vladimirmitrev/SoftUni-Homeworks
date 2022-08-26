package programming04FundamentalsFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String text = scanner.nextLine();

            String regex = "[@][#]+(?<text>[A-Z][A-Za-z0-9]{4,}[A-Z])[@][#]+";
            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {

                String extractedText = matcher.group("text");
                String productGroup = "";

                for (int j = 0; j < extractedText.length(); j++) {
                    char symbol = extractedText.charAt(j);
                    if (Character.isDigit(symbol)) {
                        productGroup += symbol;
                    }
                }
                if(!productGroup.equals("")) {
                    System.out.printf("Product group: %s%n", productGroup);
                } else {
                    System.out.printf("Product group: 00%n");
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
