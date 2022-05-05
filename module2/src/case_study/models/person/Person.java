package case_study.models.person;

import case_study.services.impl.EmployeeManagement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public abstract class Person {
    private Integer iD;
    private String name;
    private LocalDate birthday;
    private String gender;
    private String numberCMND;
    private String numberPhone;
    private String email;

    public static void main(String[] args) {
    }

    public Person() {
    }

    public Person(Integer iD, String name, LocalDate birthday, String gender, String numberCMND, String numberPhone, String email) {
        this.iD = iD;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.numberCMND = numberCMND;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumberCMND() {
        return numberCMND;
    }

    public void setNumberCMND(String numberCMND) {
        this.numberCMND = numberCMND;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "iD=" + iD +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", numberCMND='" + numberCMND + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
