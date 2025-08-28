package ServicesImplementation;

import Services.Application;

import java.util.Scanner;

public class ApplicationImplementation implements Application {
    Scanner sc = new Scanner(System.in);
    RegisterationImplementation r ;
    public ApplicationImplementation() {
        r = new RegisterationImplementation();
    }

    @Override
    public void start() {
        int invalidChoices = 0;

        System.out.println("Welcome to the E-Wallet Application \n" +
                "Please choose from the " +
                "following options:");

        System.out.println("1- Sign In\n" + "2- Sign Up\n" + "3- Exit");
        char choice = sc.next().charAt(0);
        while (true) {
            switch (choice) {
                case '1':
                    r.signIn();
                    break;
                case '2':
                    r.signUp();
                    break;
                case '3':
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    invalidChoices++;
            }
            if(invalidChoices == 3) {
                System.out.println("You have entered an invalid choice 3 times , " +
                        "please try again later");
            }

        }
    }
}
