public class DayFibonacciNhoHon100 {


    public static void checkFibonacci() {
        int a1 = 0;
        int a2 = 1;
        int fibonacciNumber = 1 ;


        while (fibonacciNumber<100){
            System.out.print(fibonacciNumber+ " ");
            fibonacciNumber = a1 + a2;
            a1=a2;
            a2=fibonacciNumber;
        }

//        for (int i = 0; i < 10; i++) {
//            int a3 = a1 + a2;
//            System.out.println(a3);
//            a1=a2;
//            a2=a3;
//
//        }
    }

    public static void main(String[] args) {
        int num1 = 55, num2 = 121, gcd = 1;
        for(int i = 1; i <= num1; i++)
        {
            if(num1%i==0 && num2%i==0)
                gcd = i;
        }
        System.out.printf("Ước chung lớn nhất của %d và %d là: %d", num1, num2, gcd);
    }

}
