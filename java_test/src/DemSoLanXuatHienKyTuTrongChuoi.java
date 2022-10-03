import java.util.Scanner;

public class DemSoLanXuatHienKyTuTrongChuoi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            for( int j = 1; j<str.length(); j++){
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                }
            }
            System.out.println(str.charAt(i));
            System.out.println("co " + count+ " lan xuat hien");
            count = 0;


        }

    }
}
