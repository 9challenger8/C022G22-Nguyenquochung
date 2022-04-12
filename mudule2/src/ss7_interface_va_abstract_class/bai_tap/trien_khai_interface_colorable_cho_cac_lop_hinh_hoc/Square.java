package ss7_interface_va_abstract_class.bai_tap.trien_khai_interface_colorable_cho_cac_lop_hinh_hoc;

import ss6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;

public class Square extends Shape {
    private double side=1.0;

    public Square(double side){
        this.side=side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double getArea(){
        return side*side;
    }

    @Override
    public void resize(double percent) {
        side*=percent;
        System.out.println(getArea());
    }
    @Override
    public void howToColor() {
        System.out.println(" Color all four sides..");
    }
}
