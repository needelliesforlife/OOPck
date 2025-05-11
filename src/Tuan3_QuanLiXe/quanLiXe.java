package Tuan3_QuanLiXe;
import java.util.Scanner;
public class quanLiXe {
    protected String Macx, NameTX, SoX;
    protected double DoanhThu;
    Scanner sc = new Scanner(System.in);

    protected String getMacx() {
        return Macx;
    }

    protected void setMacx(String macx) {
        Macx = macx;
    }

    protected String getNameTX() {
        return NameTX;
    }

    protected void setNameTX(String nameTX) {
        NameTX = nameTX;
    }

    protected String getSoX() {
        return SoX;
    }

    protected void setSoX(String soX) {
        SoX = soX;
    }

    protected double getDoanhThu() {
        return DoanhThu;
    }

    protected void setDoanhThu(double doanhThu) {
        DoanhThu = doanhThu;
    }
    protected quanLiXe() {}
    protected quanLiXe(String ma, String name, String sx, double dt) {
        this.Macx = ma;
        this.NameTX = name;
        this.SoX = sx;
        this.DoanhThu = dt;
    }
    protected void nhap() {
        System.out.print("Nhap Ma so Chuyen: ");
        this.Macx = sc.nextLine();
        System.out.print("Ho ten tai xe: ");
        this.NameTX = sc.nextLine();
        System.out.print("So xe: ");
        this.SoX = sc.nextLine();
        System.out.print("Doanh thu: ");
        this.DoanhThu = sc.nextDouble();
    }
 @Override
    public String toString(){
        return "\nMS chuyen: " + this.Macx + "\nName tai xe: " + this.NameTX + "\nSo xe: "+ this.SoX;
    }
}
