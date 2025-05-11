package Tuan1_Chao_hoi;
import java.util.Scanner;
public class PhuongTrinhBac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao a");
        int a = sc.nextInt();
        System.out.println("Nhap vao b");
        int b = sc.nextInt();
        double kq = -(double)b/ (double)a;
        System.out.println("Ket qua la: " + kq);

    }
}
