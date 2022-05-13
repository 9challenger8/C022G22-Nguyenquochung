package case_study.common;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
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

    public static LocalDate checkAge() {
        boolean flag = true;
        LocalDate date = null;
        while (flag) {
            try {
                date = LocalDate.parse(scanner.nextLine());
                if (Period.between(date, LocalDate.now()).getYears() >= 18 &&
                        Period.between(date, LocalDate.now()).getYears() <= 100) {
                    flag = false;
                } else {
                    throw new CheckException("Sai độ tuổi cho phép.");
                }
            } catch (DateTimeParseException e) {
                System.err.println("Nhập sai định dạng. Nhập theo định dạng yyyy-MM-dd.");
                System.err.print("Nhập lại ngày sinh: ");

            } catch (CheckException e) {
                System.err.println(e.getMessage());
                System.out.print("Nhập lại ngày sinh: ");
            }
        }
        return date;
    }
}
