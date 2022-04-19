package ss6_inheritance.bai_tap.lop_circle_va_lop_cylinder;

public class Circle {
    private double radius;
    private String color;
    public Circle(){

    }
    public Circle(double radius,String color){
        this.radius=radius;
        this.color=color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(double radius){
        return radius*radius*Math.PI;
    }

    @Override
    public String toString(){
        return "A circle with radius" + getRadius()+ " A circle with color"+ getColor();
    }
}
