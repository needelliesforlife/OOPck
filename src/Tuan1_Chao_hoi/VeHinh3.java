package Tuan1_Chao_hoi;

import static java.lang.Math.ceil;

public class VeHinh3 {
    public static void main(String[] args) {
        int n  =9;
        int m = (int)(Math.ceil(n/2));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == m) {
                    System.out.print("* ");
                }
                else if (j == i || j == n - i - 1) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
