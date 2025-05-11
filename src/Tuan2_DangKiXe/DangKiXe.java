package Tuan2_DangKiXe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DangKiXe
{
    private int dungtich ;
    private String tenxe ;

    public String getTenchuxe() {
        return tenchuxe;
    }

    public void setTenchuxe(String tenchuxe) {
        this.tenchuxe = tenchuxe;
    }

    private String tenchuxe ;
    private String loaixe ;


    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    public int getTrigia() {
        return trigia;
    }

    public void setTrigia(int trigia) {
        this.trigia = trigia;
    }

    private int trigia ;
    public int getDungtich() {
        return dungtich;
    }

    public void setDungtich(int dungtich) {
        this.dungtich = dungtich;
    }
    public double getThue() {
        if (getDungtich() < 100) {
            return 0.01 * getTrigia() ;
        }
        if (getDungtich() >= 100 && getDungtich() <= 200) {
            return 0.03 *getTrigia() ;
        }
        return 0.05 * getTrigia() ;
    }
    public static DangKiXe getDangKiXe(Scanner sc){
    DangKiXe dkx = new DangKiXe();
    System.out.print("Nhap ten chu xe: ");
    sc.nextLine();
    dkx.setTenchuxe(sc.nextLine());
    System.out.print("Nhap loai xe: ");
    dkx.setLoaixe(sc.nextLine());
    System.out.print("Nhap dung tich: ");
    dkx.setDungtich(sc.nextInt());
    System.out.print("Nhap tri gia: ");
    dkx.setTrigia(sc.nextInt());
    return dkx;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = -1;
        List<DangKiXe> dangki = new ArrayList<>();
        do{
            System.out.println("Chon chuc nang: ");
            System.out.println("1. Nhap thong tin.");
            System.out.println("2. Xuat bang thong tin.");
            System.out.println("0. Thoat.");
            c = sc.nextInt();
            switch(c){
                case 1:
                    dangki.add(getDangKiXe(sc));
                    break;
                case 2:
                    if (dangki.isEmpty()) {
                        System.out.println("Chua co thong tin xe");
                    }
                    else {
                        System.out.printf("%-20s %-15s %-15s %-20s %-20s\n","Ten Chu Xe", "loaixe", "Dung Tich", "Tri gia", "Thue phai nop");
                        System.out.println("=========================================================================================");
                        for (DangKiXe d : dangki) {
                            System.out.printf("%-20s %-15s %-15d %-20.2f %-20.2f\n", d.getTenchuxe(), d.getLoaixe(), d.getDungtich(), (double)d.getTrigia(), d.getThue());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while(c != 0);
    }
}
