package model;

public class Transaction {
    private String accountFrom;
    private String accountTo;
    private int amount;
    private String fileName;

    public Transaction(String accountFrom, String accountTo, int amount, String fileName) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.fileName=fileName;
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

    public String getFileName(){
        return fileName;
    }
}
