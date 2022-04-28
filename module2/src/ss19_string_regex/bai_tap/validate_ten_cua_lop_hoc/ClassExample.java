package ss19_string_regex.bai_tap.validate_ten_cua_lop_hoc;


public class ClassExample {
    private static final String CLASS_REGEX ="^[CAP][0-9]{4}[GHIKLM]$";

    public ClassExample(){

    }
    public boolean validate(String className){
        return className.matches(CLASS_REGEX);
    }

    public static void main(String[] args) {
        ClassExample classExample=new ClassExample();
        System.out.println(classExample.validate("C0318G"));
        System.out.println(classExample.validate(" P0323A"));
    }
}
