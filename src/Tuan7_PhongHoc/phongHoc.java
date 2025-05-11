package Tuan7_PhongHoc;

abstract class phongHoc {
    protected String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected long soBongDen;

    public phongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
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

    public long getSoBongDen() {
        return soBongDen;
    }

    public boolean duAnhSang(){
        return (soBongDen >= Math.ceil(dienTich/10));
    }

    public void setSoBongDen(long soBongDen) {
        this.soBongDen = soBongDen;
    }
    public abstract boolean datChuan();

    @Override
    public String toString() {
            return String.format("Ma phong: %-10s Day nha: %-5s Dien tich: %-7.2f So bong den: %-5d", maPhong, dayNha, dienTich, soBongDen);
    }
}



