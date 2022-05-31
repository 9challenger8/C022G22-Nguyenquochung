package model;

public class Product {
    private Integer iD;
    private String name;
    private String price;
    private String detail;
    private String producer;

    public Product(Integer iD, String name, String price, String detail, String producer) {
        this.iD = iD;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.producer = producer;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
