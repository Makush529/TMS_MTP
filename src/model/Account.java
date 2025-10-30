package model;

import servise.Patterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static Map<String,Integer> createAccountNumbers() throws IOException {

        try (FileReader fileReader = new FileReader("src/resources/accountDetails.txt");
             BufferedReader bufferedReaderForAccount = new BufferedReader(fileReader);) {
            String line;
            Map<String, Integer> accountMap = new HashMap<>();
            Pattern pattern = Pattern.compile(Patterns.ACCOUNT_NUMBER_AND_AMOUNT.getRegex());
            while ((line = bufferedReaderForAccount.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String accountNumber = matcher.group(1);
                    int balance = Integer.parseInt(matcher.group(2));
                    accountMap.put(accountNumber, balance);
                } else {
                    System.out.println("проверь Account!"+line);
                }
            }
            return accountMap;
        }

    }

    public static void printAccountMap(Map<String, Integer> accountMap) {
        for (Map.Entry<String, Integer> entry : accountMap.entrySet()) {
            System.out.println("Номер счёта: " + entry.getKey() + ", Баланс: " + entry.getValue());
        }
    }
}
