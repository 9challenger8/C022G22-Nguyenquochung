package case_study.models.person;

import case_study.models.person.Person;

public class Customers extends Person {
    private String guestType;
    private String address;

    public Customers() {
    }

    public Customers(String guestType, String address) {
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
        return "Customers{" +
                "guestType='" + guestType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
