package ServicesImplementation;

import Services.AccountValidationService;

public class AccountValidationServiceImpl implements AccountValidationService {

    @Override
    public boolean isUserNameValid(String userName) {
        if (userName == null || userName.length() < 3) return false;
        return Character.isUpperCase(userName.charAt(0));
    }

    @Override
    public boolean isPasswordValid(String password) {
        if (password == null || password.length() < 10) return false;

        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        String specialChars = "@#$%&^*-+()!";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (specialChars.contains(String.valueOf(c))) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    @Override
    public boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 12) return false;
        return phoneNumber.startsWith("20");
    }
}
