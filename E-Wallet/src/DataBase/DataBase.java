package DataBase;

import Model.Account;
import java.util.ArrayList;
import java.util.Scanner;

// singelton pattern to make just one object !

public class DataBase {
    private static DataBase instance;
    private ArrayList<Account> accounts;
    Scanner sc = new Scanner(System.in);

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
    public void updateAccountPassword(Account account) {
        if (account != null) {
            for(Account acc : accounts) {
                if(acc.getUserName().equals(account.getUserName())) {
                    System.out.println("Enter the new password");
                    acc.setPassword(sc.nextLine());
                }
            }
        }
    }
}
