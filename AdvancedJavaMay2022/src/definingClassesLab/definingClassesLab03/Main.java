package definingClassesLab.definingClassesLab03;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        HashMap<Integer, BankAccount> accountsMap = new HashMap<>();


        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String output = null;

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    int key = bankAccount.getId();
                    accountsMap.put(key, bankAccount);
                    output = "Account ID" + key + " created";

                    break;
                case "Deposit":
                    int idToDeposit = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    BankAccount bankAccount1 = accountsMap.get(idToDeposit);
                    if (bankAccount1 != null) {
                        bankAccount1.deposit(amount);
                        output = "Deposited " + amount + " to ID" + idToDeposit;
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int idGetInterest = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    BankAccount bankAccount2 = accountsMap.get(idGetInterest);
                    if (bankAccount2 != null) {
                        output = String.format("%.2f", bankAccount2.getInterestRate(years));
                    } else {
                        output = "Account does not exist";
                    }
                    break;

            }
            if (output != null) {
                System.out.println(output);
            }

            input = scanner.nextLine();
        }
    }
}
