package definingClassesLab.definingClassesLab03;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int nextId = 1;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = nextId;
        nextId++;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }
    public double getInterestRate(int years) {
        return interestRate * years * this.balance;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}

