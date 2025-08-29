package Services;

public interface AccountValidationService {
    boolean isUserNameValid(String userName);
    boolean isPasswordValid(String password);
    boolean isPhoneNumberValid(String phoneNumber);
}
