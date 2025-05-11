package Tuan1_Chao_hoi;
import java.util.Scanner;
public class UCLN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        System.out.println("Nhap vao a");
        a = sc.nextInt();
        System.out.println("Nhap vao b");
        b = sc.nextInt();
        while(b != 0) {
            int tmp = b;
            b =  a % b;
            a = tmp;
        }
        System.out.println("UCLN la: " + a);
    }
}
