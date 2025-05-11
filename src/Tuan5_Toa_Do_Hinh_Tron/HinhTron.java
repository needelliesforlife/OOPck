package Tuan5_Toa_Do_Hinh_Tron;

public class HinhTron {
    private Toado tam;
    private double bankinh;
    public final double PI = 3.14;
    public HinhTron() {}
    public HinhTron(Toado tam, double bankinh) {
        this.tam = tam;
        this.bankinh = bankinh;
    }

    public Toado getTam() {
        return tam;
    }

    public void setTam(Toado tam) {
        this.tam = tam;
    }

    public double getBankinh() {
        return bankinh;
    }

    public void setBankinh(double bankinh) {
        this.bankinh = bankinh;
    }

    public double tinhChuVi() {
        return 2 * PI * bankinh;
    }
    public double tinhDienTich() {
        return PI * bankinh * bankinh;
    }
    @Override
    public String toString() {
        return String.format("Diện tích và chu vi hình trong tâm %s có bán kính %.1fm là %.2f và %.2f", tam.toString(), bankinh, tinhDienTich(), tinhChuVi());
    }
}


