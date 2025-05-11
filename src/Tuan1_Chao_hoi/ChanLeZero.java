package Tuan1_Chao_hoi;
import java.util.Scanner;
public class ChanLeZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhap n: ");
        n = sc.nextInt();
        if (n == 0) {
            System.out.println("n bang 0");
        }
        else if (n % 2 == 0) {
            System.out.println("n la so chan");
        } else {
            System.out.println("n la so le");
        }

    }
}
