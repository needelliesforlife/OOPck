package Tuan1_Chao_hoi;

public class VeHinh6 {
    public static void main(String[] args) {
        int n = 10;
        int m = 19;
        double tmp  = m / 2;
        int k = (int)(Math.floor(tmp));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j >= k && j < m - k) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            k -= 1;
            System.out.println();
        }
    }
}
