package ServicesImplementation;

import Model.Account;
import Services.Registeration;
import DataBase.DataBase;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class RegisterationImplementation implements Registeration {
    Scanner sc = new Scanner(System.in);
    DataBase db = DataBase.getInstance();  // ✅ only way to get it

    private ArrayList<Account> accounts ;
    private int invalidAttempt ;


    public RegisterationImplementation() {
        this.accounts =  db.getAllAccounts();
        this.invalidAttempt = 0;
    }


    public RegisterationImplementation(DataBase db) {
        this.db = db;
    }


    @Override
    public Boolean checkAccountAvailability(String email){

        if (Objects.nonNull(accounts))
            for(Account a : accounts){
                if(a.getUserName().equals(email)){
                    return true;
                }
            }
        return false;
    }

    @Override
    public Account checkAccountAvailability(Account account) {
        for(Account a : accounts){
            if(a.getUserName().equals(account.getUserName())){
                return account;
            }
        }
        return null;
    }

    @Override
    public Account checkPasswordMatching(String userName , String password){

        for(Account a : accounts){
            if(a.getUserName().equals(userName)){
                if(a.getPassword().equals(password)) {
                    return a;
                }
            }
        }
        return null;
    }

    public void signIn(){

        System.out.println("Please enter your username: ");
        String userName = sc.nextLine();
        Account account;

        if (!checkAccountAvailability(userName)) {

            System.out.println("Invalid username !");
            invalidAttempt++;
            if (invalidAttempt == 3) {
                System.out.println("Too many falsy attempts , try again"
                        + " in 30 seconds");
                invalidAttempt = 0;
                try {
                    Thread.sleep(30_000);
                }catch (InterruptedException e){

                }
            }
            return;
        }
        else {
            System.out.println("Please enter your password: ");
            String password = sc.nextLine();

            account = checkPasswordMatching(userName, password);

            if(Objects.nonNull(account)) {
                System.out.println("You have successfully logged in");
            }else {
                System.out.println("Invalid password");
                invalidAttempt ++;
                if(invalidAttempt == 4) {
                    System.out.println("Too many falsy attempts , try again in 1 minute");
                    try {
                        Thread.sleep(20_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        }
        WalletOperationsImplementation w = new WalletOperationsImplementation();
        w.run(account);
    }

    public void signUp(){
        String userName , password , phoneNumber , name ;
        System.out.println("Please enter your user name : ");
        userName = sc.nextLine();
        if(checkAccountAvailability(userName)) {
            System.out.println("This account is already in use");
            return;
        } else {
            System.out.println("Please enter your password : ");
            password = sc.nextLine();
            System.out.println("Please enter your phone number : ");
            phoneNumber = sc.nextLine();
            System.out.println("Please enter your name : ");
            name = sc.nextLine();
        }
        Account account = new Account();
        account.setUserName(userName);
        account.setPassword(password);
        account.setPhoneNumber(phoneNumber);
        account.setName(name);
        account.setBalance(0D);
        db.AddAccount(account);
        this.accounts = db.getAllAccounts();


        WalletOperationsImplementation w = new WalletOperationsImplementation();
        w.run(account);
    }
}
