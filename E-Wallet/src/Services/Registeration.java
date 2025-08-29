package Services;

import Model.Account;

public interface Registeration {
    public Boolean checkAccountAvailability(String email);
    public Account checkPasswordMatching(String userName, String password);
    public Account findAccountByUserName(String userName);
}
