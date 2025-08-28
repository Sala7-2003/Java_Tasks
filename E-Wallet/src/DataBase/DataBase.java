package DataBase;

import Model.Account;

import java.util.ArrayList;
import java.util.Objects;

//public class DataBase {
//
//    private ArrayList<Account> accounts = new ArrayList<>();
//
////    public DataBase() {
////        accounts = new ArrayList<>();
////    }
//
//    public void AddAccount(Account account) {
//        if (!Objects.isNull(account)) {
//            this.accounts.add(account);
//            System.out.println("Account added successfully");
//        }
//    }
//
//    public void RemoveAccount(Account account) {
//        this.accounts.remove(account);
//    }
//
//    public ArrayList<Account> getAllAccounts() {
//        return this.accounts;
//    }
//}
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
}
