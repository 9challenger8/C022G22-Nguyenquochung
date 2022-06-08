import java.util.Scanner;

public class GIaiThuatTuan13 {
    static Scanner sc= new Scanner(System.in);
        public static void main(String[] args) {
            int h = Integer.parseInt(sc.nextLine());
            for(int i= h/2; i>0; i--){
                for(int j = i; j<=h ; j++){
                    System.out.print("  ");
                }
                for(int n=0; n<=i*2 ; n++){
                    if(n==(i*2)){
                        System.out.print("  ");
                    }
                    else
                        System.out.print("* ");
                }
                System.out.println();
            }


            for(int i= 1; i<=h/2; i++){
                for(int j = h; j>=i ; j--){
                    System.out.print("  ");
                }
                for(int n=0; n<=i*2 ; n++){
                    if((n==(i*2))){
                        System.out.print("  ");
                    }
                    else
                        System.out.print("* ");
                }
                System.out.println();
            }

        }
    }

