package _05_BillsPaymentSystem.entities;

public enum BillingType {
    CREDIT_CARD("credit card"), BANK_ACCOUNT("bank account");
    private String value;

    BillingType() {
    }

    BillingType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
