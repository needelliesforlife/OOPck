package Tuan1_Chao_hoi;

public class VeHinh7 {
    public static void main(String[] args) {
        int n = 10;
        int m = 19;
        double tmp  = m / 2;
        int k = (int)(Math.floor(tmp));
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m ; j++) {
                if (j == k || j == m - k -1) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            if (k > 0) k -= 1;
            System.out.println();
        }
        for (int i = 0; i < m; i++) {
            System.out.print("* ");
        }
    }
}
