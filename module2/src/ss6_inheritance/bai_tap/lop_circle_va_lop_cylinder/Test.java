package ss6_inheritance.bai_tap.lop_circle_va_lop_cylinder;

public class Test {
    public static void main(String[] args) {
        Cylinder shape1= new Cylinder();
        shape1.setH(10);
        shape1.setRadius(4.5);
        shape1.getH();
        System.out.println(shape1.getVolume());
        System.out.println(shape1.toString());
    }
}
