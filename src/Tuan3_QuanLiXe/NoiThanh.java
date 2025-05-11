package Tuan3_QuanLiXe;
import java.util.Scanner;
public class NoiThanh extends quanLiXe {
    private double SoKm;
    private String SoTuyen;
    private Scanner sc = new Scanner(System.in);
    public NoiThanh() {
    }
    public NoiThanh(String ma, String name, String sx, double dt,double skm, String st) {
        super(ma, name,sx,dt );
        this.SoKm = skm;
        this.SoTuyen = st;
    }

    public double getSoKm() {
        return SoKm;
    }

    public void setSoKm(double soKm) {
        SoKm = soKm;
    }

    public String getSoTuyen() {
        return SoTuyen;
    }

    public void setSoTuyen(String soTuyen) {
        SoTuyen = soTuyen;
    }
    public void nhap() {
        super.nhap();
        System.out.print("Hay nhap so tuyen: ");
        SoTuyen = sc.nextLine();
        System.out.print("So Km: ");
        SoKm = sc.nextDouble();
    }
    public String toString() {
        return "Chuyen xe noi thanh " + super.toString() + "\nSo tuyen " + this.SoTuyen + "\nSo Km: " + this.SoKm + "\nDoanh thu: "+this.DoanhThu;
    }
}
