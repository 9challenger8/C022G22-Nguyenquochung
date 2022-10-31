public class TinhTongCacSoNguyenTo {

    public static void main(String[] args) {

//        if (checkPrime(2)){
//            System.out.println("So nguyen to");
//        }else {
//            System.out.println("Khong phai so nguyen to");
//        }
//
        int total = 0;

        for (int i = 0; i < 30; i++) {
            if (checkPrime(i)) {
                System.out.print(i + " ");
                total += i;
            }
        }

        System.out.println("tong la: " + total);
    }

    public static boolean checkPrime(int n) {
        if (n <= 1) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
