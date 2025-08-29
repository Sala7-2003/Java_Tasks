package ServicesImplementation;

import DataBase.DataBase;
import Model.Account;
import Services.AccoountOperations;

import java.util.Objects;
import java.util.Scanner;

public class AccountOperationsImplementation implements AccoountOperations {

    Scanner sc = new Scanner(System.in);
    RegisterationImplementation r ;


    public AccountOperationsImplementation() {
        r = new RegisterationImplementation();
    }


    @Override
    public boolean deposit(Account account) {
        Boolean success = false;

        DataBase db = DataBase.getInstance();

        if (!db.getAllAccounts().contains(account))
            System.out.println("Please Log In First , to Complete the transaction");

            else {
            Double amount = 0.0;
            System.out.println("Enter the amount to deposit");
            amount = sc.nextDouble();
            if(amount < 0.0D)
                System.out.println("Sorry ! You can't deposit a negative value "+amount);
            else {
                account.credit(amount);
                System.out.println("Deposit Successful" + "Total Balance = "+account.getBalance());
                // I made debugging and found that this step 👇 is not important as once I change in the account object it is changed in the data base too !
                // db.updateAccount(account);
                success = true;
            }
        }

        WalletOperationsImplementation w = new WalletOperationsImplementation();
        w.run(account);

        return success;
    }

    @Override
    public boolean withdraw(Account account) {
        Boolean success = false;
        DataBase db = DataBase.getInstance();

        if (!db.getAllAccounts().contains(account)) {
            System.out.println("Please Log In First , to Complete the transaction");
        } else {
            Double amount = 0.0;
            System.out.println("Enter the amount to withdraw");
            amount = sc.nextDouble();

            if (amount <= 0.0D) {
                System.out.println("Sorry! You can't withdraw a non-positive value " + amount);
            } else if (amount > account.getBalance()) {
                System.out.println("Insufficient balance! Your current balance is " + account.getBalance());
            } else {
                account.debit(amount);
                System.out.println("Withdraw Successful" + " | Total Balance = " + account.getBalance());
                // I made debugging and found that this step 👇 is not important as once I change in the account object it is changed in the data base too ! without any need to update.
                // db.updateAccount(account);
                success = true;
            }
        }

        WalletOperationsImplementation w = new WalletOperationsImplementation();
        w.run(account);
        return success;
    }


    @Override
    public void transfer(Account account) {
        DataBase db = DataBase.getInstance();

        if (!db.getAllAccounts().contains(account)) {
            System.out.println("Please Log In First , to Complete the transaction");
            return;
        }

        System.out.println("Enter the user name of account to transfer money to:");
        String username = sc.nextLine();

        Account receiver = r.findAccountByUserName(username);

        if (receiver == null ) {
            System.out.println("No account found with username: " + username);
            return;
        }
        if( receiver.equals(account)){
            System.out.println("You can't transfer money to yourself");
            return;
        }

        System.out.println("Enter the amount to transfer:");
        double amount = sc.nextDouble();

        if (amount <= 0.0) {
            System.out.println("Invalid amount! You must transfer a positive value.");
            return;
        }

        if (account.getBalance() < amount) {
            System.out.println("Insufficient balance! Your current balance is " + account.getBalance());
            return;
        }

        account.setBalance(account.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        // Update both accounts in DB but is not necessary
        //        db.updateAccount(account);
        //        db.updateAccount(receiver);

        System.out.println("Transfer Successful! You sent " + amount + " to " + receiver.getUserName());
        System.out.println("Your New Balance = " + account.getBalance());

        WalletOperationsImplementation w = new WalletOperationsImplementation();
        w.run(account);
    }

    public void showDetails(Account account) {
        DataBase db = DataBase.getInstance();
        // get the account from list
        for (Account acc : db.getAllAccounts()) {
            if (acc.equals(account))
                System.out.println(acc);
        }
        WalletOperationsImplementation w = new WalletOperationsImplementation();
        w.run(account);

    }
}
