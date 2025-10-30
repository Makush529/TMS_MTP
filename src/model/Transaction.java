package model;

public class Transaction {
    private String accountFrom;
    private String accountTo;
    private int amount;

    public Transaction(String accountFrom, String accountTo, int amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public String getAccountTo() {
        return accountTo;
    }

    public int getAmount() {
        return amount;
    }


}
