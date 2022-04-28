package ss19_string_regex.bai_tap.validate_so_dien_thoai;

public class PhoneNumberExample {
    private static final String NUMBER_PHONE_REGEX="^\\([0-9]{2}\\)\\-\\([0][0-9]{9}\\)$";

    public boolean checkPhoneNumber(String phoneNumber){
        return phoneNumber.matches(NUMBER_PHONE_REGEX);
    }

    public static void main(String[] args) {
        PhoneNumberExample phoneNumberExample= new PhoneNumberExample();
        System.out.println(phoneNumberExample.checkPhoneNumber( "(84)-(0978489648)"));
        System.out.println(phoneNumberExample.checkPhoneNumber( "(a4)-(0978489648)"));
    }
}
