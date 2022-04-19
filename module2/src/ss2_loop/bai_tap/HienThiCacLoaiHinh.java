package ss2_loop.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the square triangle");
            System.out.println("3. Draw  isosceles triangle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Draw the rectangle");
                    for (int i = 1; i <= 3; ++i) {
                        for (int j = 1; j <= 7; ++j)
                            System.out.print("* ");
                            System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("2. Draw the square triangle");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++)
                            System.out.print("* ");
                            System.out.print("\n");
                    }
                    System.out.print("\n");
                    for(int i = 0; i < 5; i++) {
                        for(int j=0; j<i; j++)
                            System.out.print("  ");

                        for(int j=i; j < 5; j++)
                            System.out.print(" *");
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.println("3. Draw  isosceles triangle");
                    int m = 4, n = 4;
                    for (int i = 1; i <= 4; i++)
                    {
                        for (int j = 1; j <= 2 * 4 - 1; j++)
                        {
                            if (j >= m && j <= n)
                                System.out.print("*");
                            else
                                System.out.print(" ");
                        }
                        m--;
                        n++;
                        System.out.print("\n");
                    }
                            break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
                        }
                    }
            }
        }


