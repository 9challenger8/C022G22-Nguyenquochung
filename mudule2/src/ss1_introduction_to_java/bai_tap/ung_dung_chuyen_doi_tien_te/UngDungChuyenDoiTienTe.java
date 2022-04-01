package ss1_introduction_to_java.bai_tap.ung_dung_chuyen_doi_tien_te;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhap USD: ");
        double tienUsd = scanner.nextDouble();
        double tienVnd = tienUsd*23000 ;
        System.out.println("So tien VND: "+tienVnd);
    }
}
