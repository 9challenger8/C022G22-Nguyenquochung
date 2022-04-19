package ss4_class_and_object.bai_tap.Fan;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    public boolean getOn() {
        return this.on;
    }

    public void setOn(boolean newStatus) {
        this.on = newStatus;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    Fan() {
        speed = SLOW;
        on = false;
        radius = 5;
        color = "yellow";
    }

    Fan(int speed, double radius, String color, boolean on) {
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.on = on;
    }

    public String toString() {
        if (this.on) {
            return "Fan is on \n" +
                    "Speed: " + this.speed + "\n" +
                    "Color: " + this.color + "\n" +
                    "Radius: " + this.radius;
        } else {
            return "Fan is off \n" +
                    "Color: " + this.color + "\n" +
                    "Radius: " + this.radius;
        }
    }
}




