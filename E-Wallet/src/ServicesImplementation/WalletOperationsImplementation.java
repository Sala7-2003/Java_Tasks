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
        System.out.println("Enter Your Choice :" + "1- Deposit\n2- Withdrawal\n3- Transfer\n" +
                "4- Exit\n");
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
                            ApplicationImplementation a = new ApplicationImplementation();
                            a.start();
//                            System.exit(1);
            default:
                System.out.println("Invalid Choice");
        }

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
}
