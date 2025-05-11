package Tuan1_Chao_hoi;
import java.util.Scanner;
public class TongChanLe {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n: ");
        n = sc.nextInt();
        int tong = 0;
        if (n % 2 == 0) {
            for (int i = 0; i <= n; i += 2) {
                tong += i;
            }
        }
        else {
            for (int i = 1; i <= n; i += 2) {
                tong += i;
            }
        }
        System.out.println("Tong la: " + tong);
    }
}
