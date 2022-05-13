package thi_ket_thuc_module2.common;

import java.util.Scanner;

public class CheckException extends Exception {
    static Scanner scanner = new Scanner(System.in);

    public CheckException(String message) {
        super(message);
    }

    public static Integer checkInteger() {
        int choice = 0;
        boolean flag = true;
        while (flag) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.err.println("Hãy nhập đúng định dạng.");
            }
        }
        return choice;
    }
}
