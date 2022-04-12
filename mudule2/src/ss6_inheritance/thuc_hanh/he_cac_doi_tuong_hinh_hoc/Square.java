package ss6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc;

import ss7_interface_va_abstract_class.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc.Resizeable;

public class Square extends Rectangle implements Resizeable {

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    @Override
    public double getWidth() {
        return super.getWidth();
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public void resize(double percent) {

    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();

    }


}

