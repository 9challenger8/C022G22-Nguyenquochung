public class ThapPhanSangBatPhan {

    public static int decToOct(int number){
        int decimal = 0;
        int p=0;

        while (true){
            if(number==0){
                break;
            }else {
//                int temp= number%10;
            }
        }





















//        while (true){
//            if(number==0){
//                break;
//            }else {
//                int temp = number%10;
//                decimal += temp*Math.pow(2,p);
//                System.out.println(decimal);
//                number /= 10;
//                p++;
//            }
//        }

        return decimal;
    }

    public static void main(String[] args){
        int a= decToOct(1000);
        System.out.println(a);

    }
}
