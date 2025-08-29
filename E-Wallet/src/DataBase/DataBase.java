package DataBase;

import Model.Account;
import java.util.ArrayList;

// singelton pattern to make just one object !

public class DataBase {
    private static DataBase instance;
    private ArrayList<Account> accounts;

    private DataBase() {
        accounts = new ArrayList<>();
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void AddAccount(Account account) {
        if (account != null) {
            accounts.add(account);
            System.out.println("Account added successfully");
        }
    }

    public ArrayList<Account> getAllAccounts() {
        return accounts;
    }

    public void updateAccount(Account account) {
        if (account != null) {
            for(Account acc : accounts) {
                if(acc.getUserName().equals(account.getUserName())) {
                    acc.setBalance(account.getBalance());
                }
            }
        }
    }
}
