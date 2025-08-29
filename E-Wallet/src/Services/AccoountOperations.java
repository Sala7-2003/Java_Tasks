package Services;

import Model.Account;

public interface AccoountOperations {

    public boolean deposit(Account account ) ;

    public boolean withdraw(Account account) ;

    public void transfer(Account account) ;

    public void showDetails(Account account) ;

    public void changePassword(Account account) ;

    public void removeAccount(Account account) ;

}
