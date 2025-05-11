package Tuan2_QuanLiSach;

class QLS {
    protected String masach;
    protected String ngaynhap;
    protected double dongia;
    protected int soluong;
    protected String nxb;
    public QLS(String masach, String ngaynhap, double dongia, int soluong, String nxb) {
        this.masach = masach;
        this.ngaynhap = ngaynhap;
        this.dongia = dongia;
        this.soluong = soluong;
        this.nxb = nxb;
    }
    public double getGiaTien() {
        return soluong * dongia;
    }
}