package Tuan2_QuanLiSach;

public class SGK extends QLS{
    private String tinhtrang;
    public SGK(String masach, String ngaynhap, double dongia, int soluong, String nxb, String tinhtrang) {
        super(masach, ngaynhap, dongia, soluong, nxb);
        this.tinhtrang = tinhtrang;
    }
    @Override
    public double getGiaTien() {
        return tinhtrang.equals("moi") ? soluong * dongia : soluong * dongia * 0.5;
    }
    public String getNhaXuatBan() {
        return nxb;
    }
}
