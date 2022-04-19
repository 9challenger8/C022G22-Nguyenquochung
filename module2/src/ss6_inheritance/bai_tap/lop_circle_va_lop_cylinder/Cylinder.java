package ss6_inheritance.bai_tap.lop_circle_va_lop_cylinder;

public class Cylinder extends Circle{
    private double h;

    public double getH(){
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
    public double getVolume(){
        return getArea(getRadius())*getH();
    }
    @Override
    public String toString(){
        return "A cylinder with height: "+ getH() +" A cylinger with volume: "+getVolume();
    }
}
