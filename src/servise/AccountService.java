package servise;

import exceptions.InsufficientFundsException;
import exceptions.InvalidTransactionException;
import model.Account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountService {
    static Map<String, Account> accountMap = new HashMap<>();
    public static void createAccountNumbers() throws IOException {
        try (FileReader fileReader = new FileReader("src/resources/accountDetails.txt");
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
    }
}
