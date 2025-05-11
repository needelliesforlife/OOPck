package Tuan1_Chao_hoi;
import java.util.Scanner;
public class Tong1DenN {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n: ");
        n = sc.nextInt();
        int tong = 0;
        for (int i = 1; i <= n; i++) {
            tong += i;
        }
        System.out.println("Tong la: " + tong);
    }
}
