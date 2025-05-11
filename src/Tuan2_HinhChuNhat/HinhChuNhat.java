package Tuan2_HinhChuNhat;
import java.util.Scanner;
import java.util.SortedMap;

public class HinhChuNhat {
    private int d, r;

    public int getD() {
        return d;
    }

    public int getR() {
        return r;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int ChuVi() {
        return 2*(getD()+getR());
    }
    public int DienTich() {
        return getD()*getR();
    }
    public String toString() {
        return String.format("%d\t%d\t%d\t%d", d, r, ChuVi(), DienTich());
    }

    public static void main(String[] args) {
        int d, r;
        HinhChuNhat hcn = new HinhChuNhat();
        Scanner sc = new Scanner(System.in);
        int c = -1;
        do {
            System.out.println("Hay chon tinh nang:");
            System.out.println("1. Nhap chieu dai: ");
            System.out.println("2. Nhap chieu rong: ");
            System.out.println("3. In ra chu vi va dien tich: ");
            System.out.println("0. Thoat chuong trinh: ");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    System.out.print("Nhap chieu dai: ");
                    d = sc.nextInt();
                    hcn.setD(d);
                    break;
                case 2:
                    System.out.print("Nhap chieu rong: ");
                    r = sc.nextInt();
                    hcn.setR(r);
                    break;
                case 3:
                    System.out.println("Dien tich va chu vi hinh chu nhat vua nhap: ");
                    System.out.println( hcn.toString());
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    continue;
            }
        } while(c != 0);
        sc.close();



    }
}
