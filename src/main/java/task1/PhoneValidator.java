package task1;

import java.util.regex.Pattern;

public class PhoneValidator implements Validator {
    private final String patterns = "^\\(\\d{3}\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$";

    @Override
    public boolean isValid(String phone) {
        Pattern pattern = Pattern.compile(patterns);
        return pattern.matcher(phone).matches();
    }

    @Override
    public void printIfValid(String phone) {
        if (isValid(phone)) {
            System.out.println(phone);
        }
    }
}
