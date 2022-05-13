package thi_ket_thuc_module2.models;

public class VipMobile extends Mobile {
    private String timeBaoHanh;
    private String areaBaoHanh;

    public VipMobile(Integer iD, String nameMobile, String costMobile,
                     String amountOfMobile, String manufactorMobile, String countryHandle, String trangThai) {
        super(iD, nameMobile, costMobile, amountOfMobile, manufactorMobile);
        this.timeBaoHanh = countryHandle;
        this.areaBaoHanh = trangThai;
    }

    public String getTimeBaoHanh() {
        return timeBaoHanh;
    }

    public void setTimeBaoHanh(String timeBaoHanh) {
        this.timeBaoHanh = timeBaoHanh;
    }

    public String getAreaBaoHanh() {
        return areaBaoHanh;
    }

    public void setAreaBaoHanh(String areaBaoHanh) {
        this.areaBaoHanh = areaBaoHanh;
    }

    public String getInFor() {
        return "Loại chính hãng:,"+ super.getInFor() + "," + this.timeBaoHanh + "," + this.areaBaoHanh;
    }

    @Override
    public String toString() {
        return "Loại chính hãng:,"+super.toString()+ "," + this.timeBaoHanh + "," + this.areaBaoHanh;
    }
}
