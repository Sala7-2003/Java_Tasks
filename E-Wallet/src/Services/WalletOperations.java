package Services;

import Model.Account;

public interface WalletOperations {
    public void run(Account account);
    public void deposit( Account account);
    public void withdraw( Account account);
    public void transfer( Account account);

}
