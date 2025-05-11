package Tuan2_QuanLiSach;

public class STK extends QLS{
    private double thue;

    public STK(String masach, String ngaynhap, double dongia, int soluong, String nxb, double thue) {
        super(masach, ngaynhap, dongia, soluong, nxb);
        this.thue = thue;
    }

    @Override
    public double getGiaTien() {
        return soluong * dongia + thue;
    }
}
