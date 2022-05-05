package case_study.models.person;

import java.time.LocalDate;

public class Customers extends Person {
    private String guestType;
    private String address;

    public Customers() {
    }

    public Customers(String guestType, String address) {
        this.guestType = guestType;
        this.address = address;
    }

    public Customers(Integer iD, String name, LocalDate birthday, String gender, String numberCMND, String numberPhone, String email, String guestType, String address) {
        super(iD, name, birthday, gender, numberCMND, numberPhone, email);
        this.guestType = guestType;
        this.address = address;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customers{" + super.toString() +
                ",guestType='" + guestType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
