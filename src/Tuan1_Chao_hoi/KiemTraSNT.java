package Tuan1_Chao_hoi;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class KiemTraSNT {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap mot so: ");
        int n = sc.nextInt();
        int sum = 0;
        boolean check = true;
        if (n < 2) {
            System.out.println(n +  "khong la so nguyen to");
        }
        else {
            for (int i = 2; i <= sqrt(n); i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }
        }
        if (check) {
            System.out.println(n + " la so nguyen to");
        }
        else {
            System.out.println(n + " khong la so nguyen to");
        }


    }
}
