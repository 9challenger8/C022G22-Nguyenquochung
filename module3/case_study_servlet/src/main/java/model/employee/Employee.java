package model.employee;

public class Employee {
    private Integer id;
    private String name;
    private String birthday;
    private String idCard;
    private String salary;
    private String numberPhone;
    private String email;
    private String address;
    private Integer educationDegree;
    private Integer position;
    private Integer division;

    public Employee(String name, String birthday, String idCard, String salary, String numberPhone, String email,
                    String address, Integer educationDegree, Integer position, Integer division) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;
    }

    public Employee(Integer id, String name, String birthday, String idCard, String salary, String numberPhone,
                    String email, String address, Integer educationDegree, Integer position, Integer division) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(Integer educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getDivision() {
        return division;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }
}
