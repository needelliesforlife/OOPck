package Tuan1_Chao_hoi;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TongNSNTDau {
    public static boolean checkPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (checkPrime(i)) {
                sum += i;
            }
        }
        System.out.println("Tong la: " + sum);
    }
}
