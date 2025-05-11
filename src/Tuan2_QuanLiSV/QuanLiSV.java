package Tuan2_QuanLiSV;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class QuanLiSV {
    private String masv = "";
    private String hoten = "";
    private float DiemLT = 0, DiemTH = 0;

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public float getDiemLT() {
        return DiemLT;
    }

    public void setDiemLT(float diemLT) {
        DiemLT = diemLT;
    }

    public float getDiemTH() {
        return DiemTH;
    }

    public void setDiemTH(float diemTH) {
        DiemTH = diemTH;
    }
    public float DiemTB() {
        return (DiemLT + DiemTH) / 2;
    }
    public String toString() {
        return String.format("%s %s %.2f %.2f %.2f", getMasv(), getHoten(), DiemLT, DiemTH ,DiemTB());
    }

    public static void main(String[] args) {
        int c = -1;
        Scanner sc = new Scanner(System.in);
        List<QuanLiSV> students = new ArrayList<>();
        do {
            System.out.println("Chon chuc nang: ");
            System.out.println("1. Nhap thong tin cua chinh minh.");
            System.out.println("2. Nhap thong tin ban than nhat.");
            System.out.println("3. Nhap thong tin cho sinh vien khac.");
            System.out.println("4. In thong tin.");
            System.out.println("0. Thoat chuong trinh.");
            c= sc.nextInt();
            switch (c) {
                case 1:
                    students.add(getQuanLiSV(sc)) ;
                    break;
                case 2:
                    students.add(getQuanLiSV(sc)) ;
                    break;
                case 3:
                    students.add(getQuanLiSV(sc)) ;
                    break;
                case 4:
                    if (students.isEmpty()) {
                        System.out.println("Chua co thong tin sinh vien nao.");
                    }
                    else {
                        System.out.printf("%-10s %-20s %-10s %-10s %-10s\n", "MSSV", "Ho Ten", "Diem LT", "Diem TH", "Diem TB");
                        System.out.println("------------------------------------------------------------");

                        for (QuanLiSV sv : students) {
                            System.out.printf("%-10s %-20s %-10.2f %-10.2f %-10.2f%n",
                                    sv.getMasv(), sv.getHoten(), sv.getDiemLT(), sv.getDiemTH(), sv.DiemTB());
                        }
                        break;
                    }

                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }

        } while(c!= 0);
    }
    public static QuanLiSV getQuanLiSV(Scanner sc) {
        QuanLiSV sv = new QuanLiSV();
        System.out.print("Nhap ma sinh vien: ");
        sc.nextLine();
        sv.setMasv(sc.nextLine());
        System.out.print("Nhap ten sinh vien: ");
        sv.setHoten(sc.nextLine());
        System.out.print("Nhap diem LT: ");
        sv.setDiemLT(sc.nextFloat());
        System.out.print("Nhap diem TH: ");
        sv.setDiemTH(sc.nextFloat());

        return sv;
    }
}
