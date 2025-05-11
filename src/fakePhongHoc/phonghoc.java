package fakePhongHoc;

public abstract class phonghoc {
    protected String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected int soBongDen;

    public phonghoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        this.dienTich = dienTich;
        this.soBongDen = soBongDen;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public void setDayNha(String dayNha) {
        this.dayNha = dayNha;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getSoBongDen() {
        return soBongDen;
    }

    public void setSoBongDen(int soBongDen) {
        this.soBongDen = soBongDen;
    }

    abstract boolean datChuan();
    @Override
    public String toString() {
        return "phonghoc: " +
                "maPhong='" + maPhong + '\'' +
                ", dayNha='" + dayNha + '\'' +
                ", dienTich=" + dienTich +
                ", soBongDen=" + soBongDen +
                ", Dat chuan:" + datChuan();
    }
}
