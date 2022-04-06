package ss4_class_and_object.bai_tap.phuong_trinh_bac_2;

public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    private double getRoot1() {
        return (-b + Math.pow(b * b - 4 * a * c, 0.5)) / 2*a;
    }

    private double getRoot2() {
        return (-b - Math.pow(b * b - 4 * a * c, 0.5)) / 2*a;
    }

    public String calculate() {
        if (getDiscriminant() > 0) {
            return getRoot1() + " " + getRoot2();
        } else if (getDiscriminant() == 0) {
            return getRoot1() + " ";
        } else {
            return "The equation has no roots";
        }
    }
}
