package account;

import java.util.HashMap;
import java.util.Map;

public class AccountBDServise {
    private static final Map<String, Account>accountMap=new HashMap<>();
    static {//отработает один раз
        accountMap.put("1234567890",new Account("1234567890", 5000));
        accountMap.put("0987654321",new Account("0987654321", 5000));
        accountMap.put("1122334455",new Account("1122334455", 5000));
        accountMap.put("5544332211",new Account("5544332211", 5000));
        accountMap.put("9876543210",new Account("9876543210", 5000));
        accountMap.put("4455667788",new Account("4455667788", 5000));
        accountMap.put("8877665544",new Account("8877665544", 5000));

    }
}
