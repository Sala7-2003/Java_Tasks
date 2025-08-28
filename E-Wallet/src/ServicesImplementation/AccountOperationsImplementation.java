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
//r.

    }


    @Override
    public void deposit(Account account) {

        DataBase db = DataBase.getInstance();  // ✅ only way to get it

        if (!db.getAllAccounts().contains(account))
            System.out.println("Please Log In First , to Complete the transaction");

            else {
            Double amount = 0.0;
            System.out.println("Enter the amount to deposit");
            amount = sc.nextDouble();
            if(amount < 0.0D)
                System.out.println("Sorry ! You can't deposit a negative value "+amount);
            else {
                account.setBalance(amount);
                System.out.println("Deposit Successful" + "Total Balance = "+account.getBalance()); ;
            }
        }
        WalletOperationsImplementation w = new WalletOperationsImplementation();
        w.run(account);

    }

    @Override
    public void withdraw(Account account) {
        DataBase db = DataBase.getInstance();  // ✅ only way to get it

        if (!db.getAllAccounts().contains(account))
            System.out.println("Please Log In First , to Complete the transaction");

        else {

        }

    }

    @Override
    public void transfer(Account account) {
        DataBase db = DataBase.getInstance();  // ✅ only way to get it

        if (!db.getAllAccounts().contains(account))
            System.out.println("Please Log In First , to Complete the transaction");

        else {

        }

    }

}
