package case_study.models;

import java.util.Date;

public class Booking {
    private Integer iDBooking;
    private Date dayBegin;
    private Date dayEnd;
    private Integer iDCustomer;
    private String nameService;
    private String typeService;

    public Integer getIDBooking() {
        return iDBooking;
    }

    public void setIDBooking(Integer iDBooking) {
        this.iDBooking = iDBooking;
    }

    public Date getDayBegin() {
        return dayBegin;
    }

    public void setDayBegin(Date dayBegin) {
        this.dayBegin = dayBegin;
    }

    public Date getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }

    public Integer getIDCustomer() {
        return iDCustomer;
    }

    public void setIDCustomer(Integer iDCustomer) {
        this.iDCustomer = iDCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "iDBooking=" + iDBooking +
                ", dayBegin=" + dayBegin +
                ", dayEnd=" + dayEnd +
                ", iDCustomer=" + iDCustomer +
                ", nameService='" + nameService + '\'' +
                ", typeService='" + typeService + '\'' +
                '}';
    }
}
