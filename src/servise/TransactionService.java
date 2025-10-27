package servise;

public class TransactionService {
    private String sendersAccount;
    private String recipientsAccount;
    private int amount;
    private String file;

    public TransactionService(String sendersAccount, String recipientsAccount, int amount, String file) {
        this.sendersAccount = sendersAccount;
        this.recipientsAccount = recipientsAccount;
        this.amount = amount;
        this.file = file;
    }

    public String getSendersAccount() {
        return sendersAccount;
    }

    public String getRecipientsAccount() {
        return recipientsAccount;
    }

    public int getAmount() {
        return amount;
    }

    public String getFile() {
        return file;
    }
}
