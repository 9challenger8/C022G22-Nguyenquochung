package thi_ket_thuc_module2.models;

public abstract class Mobile {
    private Integer iD;
    private String nameMobile;
    private String costMobile;
    private String amountOfMobile;
    private String manufactorMobile;

    public Mobile(Integer iD, String nameMobile, String costMobile, String amountOfMobile, String manufactorMobile) {
        this.iD = iD;
        this.nameMobile = nameMobile;
        this.costMobile = costMobile;
        this.amountOfMobile = amountOfMobile;
        this.manufactorMobile = manufactorMobile;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getNameMobile() {
        return nameMobile;
    }

    public void setNameMobile(String nameMobile) {
        this.nameMobile = nameMobile;
    }

    public String getCostMobile() {
        return costMobile;
    }

    public void setCostMobile(String costMobile) {
        this.costMobile = costMobile;
    }

    public String getAmountOfMobile() {
        return amountOfMobile;
    }

    public void setAmountOfMobile(String amountOfMobile) {
        this.amountOfMobile = amountOfMobile;
    }

    public String getManufactorMobile() {
        return manufactorMobile;
    }

    public void setManufactorMobile(String manufactorMobile) {
        this.manufactorMobile = manufactorMobile;
    }

    public String getInFor() {
        return this.iD + "," + this.nameMobile + "," + this.costMobile + "," + this.amountOfMobile + "," + this.manufactorMobile;
    }

    @Override
    public String toString() {
        return  this.iD + "," + this.nameMobile + "," + this.costMobile + "," +
                this.amountOfMobile + "," + this.manufactorMobile;

    }
}
