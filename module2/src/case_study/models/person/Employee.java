package case_study.models.person;

import case_study.models.person.Person;

import java.util.Date;

public class Employee extends Person {
    private String level;
    private String position;
    private Integer salary;

    public Employee() {
    }

    public Employee(String level, String position, Integer salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(Integer iD, String name, Date birthday, String gender, String numberCMND, String numberPhone, String email, String level, String position, Integer salary) {
        super(iD, name, birthday, gender, numberCMND, numberPhone, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
