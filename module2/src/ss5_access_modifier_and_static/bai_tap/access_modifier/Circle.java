package ss5_access_modifier_and_static.bai_tap.access_modifier;

public class Circle {
    private double radius=1.0;
    private String color="red";
    private Boolean filled=false;

    public Circle(){

    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public Circle(double radius){

    }
    public Circle( double radius,String color,Boolean filled){

    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {

        return color;
    }
}
