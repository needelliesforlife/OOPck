package Tuan3_QuanLiXe;
import java.util.Scanner;
import java.lang.String;
public class NgoaiThanh extends quanLiXe{
    private String NoiDen;
    private int SoNgay;
    Scanner sc = new Scanner(System.in);

    public int getSoNgay() {
        return SoNgay;
    }

    public void setSoNgay(int soNgay) {
        SoNgay = soNgay;
    }

    public String getNoiDen() {
        return NoiDen;
    }

    public void setNoiDen(String noiDen) {
        NoiDen = noiDen;
    }
    public NgoaiThanh() {
    }
    public NgoaiThanh(String ma, String name, String sx, double dt, String nd, int sn) {
        super(ma, name, sx, dt);
        this.SoNgay = sn;
        this.NoiDen = nd;
    }
    public void nhap() {
        super.nhap();
        System.out.print("Noi den: ");
        this.NoiDen = sc.nextLine();
        System.out.print("SoNgay: ");
        this.SoNgay = sc.nextInt();
    }
    public String toString() {
        return "Chuyen xe ngoai thanh " + super.toString() + "\nNoi den: "+ this.NoiDen + "\nSoNgay: "+ this.SoNgay + "\nDoanh thu: " + this.DoanhThu;
    }
}
