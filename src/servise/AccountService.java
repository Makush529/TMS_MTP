package servise;

import exceptions.InsufficientFundsException;
import exceptions.InvalidTransactionException;
import model.Account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountService {
    static Map<String, Account> accountMap = new HashMap<>();

    public static void createAccountNumbers() throws IOException {
        try (FileReader fileReader = new FileReader(Directions.ACCOUNT_DETAILS.getPath());
             BufferedReader bufferedReaderForAccount = new BufferedReader(fileReader);) {
            String line;
            Pattern pattern = Pattern.compile(Patterns.ACCOUNT_NUMBER_AND_AMOUNT.getRegex());
            while ((line = bufferedReaderForAccount.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String accountNumber = matcher.group(1);
                    int balance = Integer.parseInt(matcher.group(2));
                    accountMap.put(accountNumber, new Account(accountNumber, balance));
                } else {
                    System.out.println("invalid account number!" + line);
                }
            }
        }
    }

    public static void transfer(String accountFrom, String accountIn, int amount) throws InvalidTransactionException, InsufficientFundsException {
        Account fromAccount = accountMap.get(accountFrom);
        Account InAccount = accountMap.get(accountIn);
        if (fromAccount == null || InAccount == null) {
            throw new InvalidTransactionException("invalid account number");
        }
        if (amount < 0) {
            throw new InvalidTransactionException("incorrect transfer amount");
        }
        if (fromAccount.getBalance() < amount) {
            throw new InsufficientFundsException("insufficient funds in the account" + fromAccount);
        }
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        InAccount.setBalance(InAccount.getBalance() + amount);
        try {
            updateAccountDetails();
        } catch (IOException e) {
            System.out.println("data saving error " + e.getMessage());
        }
    }

    public static void updateAccountDetails() throws IOException {
        FileWriter fileWriter = new FileWriter(Directions.ACCOUNT_DETAILS.getPath());
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Account account : accountMap.values()) {
            printWriter.println(account.getAccountNumber() + ":" + account.getBalance());
        }
    }
}
