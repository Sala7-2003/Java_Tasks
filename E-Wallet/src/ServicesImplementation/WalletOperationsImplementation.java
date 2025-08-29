package ServicesImplementation;

import Model.Account;
import Services.WalletOperations;

import java.util.Scanner;

public class WalletOperationsImplementation implements WalletOperations {
    Scanner sc = new Scanner(System.in);
    private AccountOperationsImplementation accountServices ;

    public WalletOperationsImplementation(){
        accountServices = new AccountOperationsImplementation();
    }



    public void run(Account account){

        System.out.println("Enter Your" +
                " Choice :\n" + "1- Deposit\n" +
                "2- Withdraw\n3- Transfer\n" + "4- Show Details\n"+
                "5- Log Out\n" + "6- Change Password\n" + "7- Remove Account\n");
        char c = sc.nextLine().charAt(0);
        switch (c){
            case '1':
                deposit(account);
                break;
                case '2':
                    withdraw(account);
                    break;
                    case '3':
                        transfer(account);
                        break;
                        case '4':
                            showDetails(account);
                            break;
                            case '5':
                                ApplicationImplementation a = new ApplicationImplementation();
                                a.start();
                                break;
                                case '6':
                                    changePassword(account);
                                    break;
                                    case '7':
                                        removeAccount(account);
                                        break;
            default:
                System.out.println("Invalid Choice");
        }
    }

    public void removeAccount(Account account){
        accountServices.removeAccount(account);
    }

    public void changePassword(Account account) {
        accountServices.changePassword(account);
    }

    @Override
    public void deposit( Account account) {
        accountServices.deposit(account);
    }

    @Override
    public void withdraw( Account account) {
        accountServices.withdraw(account);
    }

    @Override
    public void transfer( Account account) {
        accountServices.transfer(account);
    }

    public void showDetails(Account account){
        accountServices.showDetails(account);
    }
}
