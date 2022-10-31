import java.util.Scanner;

public class DaoMang {
    //    Cho 1 số nhập từ bàn phím, in ra số ngược lại (chỉ xử lý số, không sử dụng chuỗi hoặc mảng ).
//    VD: nhập vào 1523 kết quả là 3251
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nhap so bat ki: ");
        int input = scanner.nextInt();
        int sodaonguoc = 0;
        while (input != 0) {
            sodaonguoc = input % 10 + sodaonguoc * 10;
            input = input / 10;
        }
        System.out.println(sodaonguoc);
    }
}
