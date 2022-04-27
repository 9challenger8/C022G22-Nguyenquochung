package case_study.models;

public class Contract {
    private int numbersContract;
    private Integer iDBooking;
    private Integer deposit;
    private Integer payments;
    private Integer iDCustomer;

    public int getNumbersContract() {
        return numbersContract;
    }

    public void setNumbersContract(int numbersContract) {
        this.numbersContract = numbersContract;
    }

    public Integer getiDBooking() {
        return iDBooking;
    }

    public void setiDBooking(Integer iDBooking) {
        this.iDBooking = iDBooking;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getPayments() {
        return payments;
    }

    public void setPayments(Integer payments) {
        this.payments = payments;
    }

    public Integer getiDCustomer() {
        return iDCustomer;
    }

    public void setiDCustomer(Integer iDCustomer) {
        this.iDCustomer = iDCustomer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "numbersContract=" + numbersContract +
                ", iDBooking=" + iDBooking +
                ", deposit=" + deposit +
                ", payments=" + payments +
                ", iDCustomer=" + iDCustomer +
                '}';
    }
}
