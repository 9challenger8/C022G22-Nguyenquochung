package case_study.common;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Regex {
    private static final String CODE_VILLA_REGEX = "^SVVL-[0-9]{4}$";
    private static final String CODE_HOUSE_REGEX = "^SVHO-[0-9]{4}$";
    private static final String CODE_ROOM_REGEX = "^SVRO-[0-9]{4}$";
    private static final String NAME_REGEX = "^[A-Z][a-z]+$";
    private static final String AREA_REGEX = "^([3-9][0-9]|[1-9][0-9]+)\\.[0-9]+$";
    private static final String NUMBER_OF_PERSON_REGEX = "^[1-9]|1[0-9]|20$";
    private static final String INT_REGEX = "^[1-9][0-9]+$";
    static Scanner scanner = new Scanner(System.in);

    public static String regex(String sc, String regex, String error) {
        boolean check = true;
        do {
            if (sc.matches(regex)) {
                check = false;
            } else {
                System.err.println(error);
                sc = scanner.nextLine();
            }
        } while (check);
        return sc;
    }

    public static String inputVillaCodeService() {
        System.out.print("Nhập mã dịch vụ theo định dạng SVXX-YYYY: ");
        return Regex.regex(scanner.nextLine(),CODE_VILLA_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static String inputServiceName() {
        System.out.print("Nhập tên dịch vụ theo định dạng viết hoa ký tự đầu: ");
        return Regex.regex(scanner.nextLine(), NAME_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static String inputUsableArea() {
        System.out.println("Nhập diện tích sử dụng: ");
        return Regex.regex(scanner.nextLine(), AREA_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static String inputRentalCost() {
        System.out.print("Nhập chi phi thuê dịch vụ: ");
        return Regex.regex(scanner.nextLine(), INT_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static String inputAmountOfPeople() {
        System.out.print("Nhập số lượng người ở : ");
        return Regex.regex(scanner.nextLine(), NUMBER_OF_PERSON_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static String inputRentalType() {
        System.out.print("Nhập kiểu thuê (theo day, week, month hoặc year): ");
        return Regex.regex(scanner.nextLine(), NAME_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static String inputRoomStandard() {
        System.out.print("Nhập loại villa muốn thuê (normal, vip hoặc special) : ");
        return Regex.regex(scanner.nextLine(), NAME_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static String inputSwimmingPoolArea() {
        System.out.print("Nhập diện tích hồ bơi: ");
        return Regex.regex(scanner.nextLine(), AREA_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static String inputNumberOfFloor() {
        System.out.print("Nhập số tầng : ");
        return Regex.regex(scanner.nextLine(), INT_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static String inputHouseCodeService() {
        System.out.print("Nhập mã dịch vụ theo định dạng SVXX-YYYY: ");
        return Regex.regex(scanner.nextLine(), Regex.CODE_HOUSE_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static String inputRoomCodeService() {
        System.out.print("Nhập mã dịch vụ theo định dạng SVXX-YYYY: ");
        return Regex.regex(scanner.nextLine(), Regex.CODE_ROOM_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static String inputFreeService() {
        System.out.print("Nhập dịch vụ miễn phí (viết hoa chữ cái đầu): ");
        return Regex.regex(scanner.nextLine(), NAME_REGEX, "ERROR: Bạn đã nhập sai định dạng.");
    }

    public static LocalDate ageException(LocalDate date){
        boolean check=true;
        LocalDate currentTime = LocalDate.now();
        Period p = Period.between(date, currentTime);
        while (check) {
            try {
                if (p.getYears() < 18 || p.getYears() > 100) {
                    throw new AgeException("Nhap ngu");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        return date;
    }

}
