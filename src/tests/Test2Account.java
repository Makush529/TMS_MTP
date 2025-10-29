package tests;

import model.Account;

import java.io.IOException;
import java.util.Map;

public class Test2Account {
    public static void main(String[] args) throws IOException {
        Map<String,Integer>accountMap=Account.createAccountNumbers();
        Account.printAccountMap(accountMap);

    }
}
