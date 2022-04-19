package ss7_interface_va_abstract_class.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

import ss6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Circle;
import ss6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Rectangle;
import ss6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;
import ss7_interface_va_abstract_class.bai_tap.trien_khai_interface_colorable_cho_cac_lop_hinh_hoc.Square;


public class CheckShape  {
    public static void main(String[] args) {
        Shape [] arraysShape = new Shape[3];
        arraysShape[0]= new Circle(3.5);
        arraysShape[1]= new Rectangle(3,4);
        arraysShape[2]= new Square(3);

        for (Shape array: arraysShape) {
            array.resize(Math.random()*100);
        }
    }
}
