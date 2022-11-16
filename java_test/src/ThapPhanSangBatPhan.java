import static java.lang.Math.pow;

public class ThapPhanSangBatPhan {

    public static int decToOct(int number){
        int decimal = 0;
        int p=0;

//        while (number!=0){
//            int temp = number%8;
//            decimal  += temp*Math.pow(8,p);
//            number /= 10;
//            p++;
//
//        }
        while(number > 0){
            decimal += (number % 8) * pow(10, p);
            p++;
            number /= 8;
        }

        return decimal;
    }

    public static void main(String[] args){
        int a= decToOct(500);
        System.out.println(a);

    }
}
