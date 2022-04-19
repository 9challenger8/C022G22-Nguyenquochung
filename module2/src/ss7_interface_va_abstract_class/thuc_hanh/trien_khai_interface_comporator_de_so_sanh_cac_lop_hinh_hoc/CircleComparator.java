package ss7_interface_va_abstract_class.thuc_hanh.trien_khai_interface_comporator_de_so_sanh_cac_lop_hinh_hoc;

import ss5_access_modifier_and_static.bai_tap.access_modifier.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
