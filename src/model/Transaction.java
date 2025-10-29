package model;

public class Transaction {
    private String transaction;
    private String sendersA;
    private String recipientA;
    private int amount;

    public Transaction(String transaction, String sendersA, String recipientA, int amount) {
        this.transaction = transaction;
        this.sendersA = sendersA;
        this.recipientA = recipientA;
        this.amount = amount;
    }

    public String getTransaction() {
        return transaction;
    }

    public String getSendersA() {
        return sendersA;
    }

    public String getRecipientA() {
        return recipientA;
    }

    public int getAmount() {
        return amount;
    }
}
