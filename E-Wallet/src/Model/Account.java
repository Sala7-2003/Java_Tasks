package Model;

public class Account {
    String name;
    double balance;
    String phoneNumber;
    String userName;
    String password;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) {
        this.balance -= amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;

        return account.userName.equals(userName) &&
               account.password.equals(password);
    }

    @Override
    public String toString() {
        return "Account Details : " +
                "UserName = " + userName +
                 " Balance = " + balance +
                ", PhoneNumber = "  + phoneNumber + ", Password = " + password;
    }
}
