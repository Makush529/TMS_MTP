package servise;

import model.Account;

import java.util.Map;

public class AccountService {
public static void transfer(String accountFrom, String accountIn, int amount, Map<String, Integer> accountMap){
    Integer fromAccount = accountMap.get(Integer.parseInt(accountFrom));
    Integer InAccount =accountMap.get(Integer.parseInt(accountIn));
}

}
