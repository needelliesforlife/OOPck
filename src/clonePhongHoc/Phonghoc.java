package clonePhongHoc;

abstract class Phonghoc {
    protected String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected int soBongDen;

    public Phonghoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
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
        return String.format("Ma phong: %-10s Day nha: %-5s Dien tich: %-7.2f So bong den: %-5d", this.maPhong, this.dayNha, this.dienTich, this.soBongDen);
}
}
