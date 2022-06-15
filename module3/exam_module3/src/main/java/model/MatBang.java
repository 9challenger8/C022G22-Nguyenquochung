package model;

public class MatBang {
    private String id;
    private Integer idTrangThai;
    private String dienTich;
    private Integer tang;
    private Integer idLoaiMatBang;
    private String gia;
    private String ngayBatDau;
    private String ngayKetThuc;

    public MatBang(Integer idTrangThai, String dienTich, Integer tang, Integer idLoaiMatBang, String gia, String ngayBatDau, String ngayKetThuc) {
        this.idTrangThai = idTrangThai;
        this.dienTich = dienTich;
        this.tang = tang;
        this.idLoaiMatBang = idLoaiMatBang;
        this.gia = gia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public MatBang(String id, Integer idTrangThai, String dienTich, Integer tang, Integer idLoaiMatBang, String gia, String ngayBatDau, String ngayKetThuc) {
        this.id = id;
        this.idTrangThai = idTrangThai;
        this.dienTich = dienTich;
        this.tang = tang;
        this.idLoaiMatBang = idLoaiMatBang;
        this.gia = gia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(Integer idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public Integer getTang() {
        return tang;
    }

    public void setTang(Integer tang) {
        this.tang = tang;
    }

    public Integer getIdLoaiMatBang() {
        return idLoaiMatBang;
    }

    public void setIdLoaiMatBang(Integer idLoaiMatBang) {
        this.idLoaiMatBang = idLoaiMatBang;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
