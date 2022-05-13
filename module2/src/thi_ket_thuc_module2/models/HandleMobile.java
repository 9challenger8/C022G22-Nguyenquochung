package thi_ket_thuc_module2.models;

public class HandleMobile extends Mobile {
    private String countryHandle;
    private String trangThai;

    public HandleMobile(Integer iD, String nameMobile, String costMobile, String amountOfMobile,
                        String manufactorMobile, String countryHandle, String trangThai) {
        super(iD, nameMobile, costMobile, amountOfMobile, manufactorMobile);
        this.countryHandle = countryHandle;
        this.trangThai = trangThai;
    }

    public String getCountryHandle() {
        return countryHandle;
    }

    public void setCountryHandle(String countryHandle) {
        this.countryHandle = countryHandle;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getInFor() {
        return "Loại xách tay:"+ super.getInFor() + "," + this.countryHandle + "," + this.trangThai;
    }

    @Override
    public String toString() {
        return "Loại xách tay:," + super.toString()+ "," + this.countryHandle + "," + this.trangThai;
    }
}
