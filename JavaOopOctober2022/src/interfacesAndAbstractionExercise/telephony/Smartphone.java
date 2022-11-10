package interfacesAndAbstractionExercise.telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (hasDigits(url)) {
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!%n", url));
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (hasOnlyDigits(number)) {
                sb.append(String.format("Calling... %s%n", number));
            } else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    private boolean hasDigits(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasOnlyDigits(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
//    @Override
//    public String browse() {
//        StringBuilder output = new StringBuilder();
//        this.urls.forEach(e -> output.append(e.matches("^[^0-9]+$") ? String.format("Browsing: %s!", e)
//                : "Invalid URL!").append(System.lineSeparator()));
//        return output.toString().trim();
//    }
//
//    @Override
//    public String call() {
//        StringBuilder output = new StringBuilder();
//        this.numbers.forEach(e -> output.append(e.matches("^[0-9]+$") ? String.format("Calling... %s", e)
//                : "Invalid number!").append(System.lineSeparator()));
//        return output.toString().trim();
//    }

    //        return numbers.stream().map(number -> number.matches(".*\\D+.*")
//                        ? "Invalid number!"
//                        : "Calling... " + number)
//                .collect(Collectors.joining(System.lineSeparator()));

