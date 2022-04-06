package ss4_class_and_object.bai_tap.Fan;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan(3, 10, "yellow", true);
        Fan fan2 = new Fan(3, 5, "blue", false);

        System.out.println("Fan 1: "+fan1);
        System.out.println("Fan 2: "+fan2);
    }
}
