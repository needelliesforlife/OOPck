package Tuan1_Chao_hoi;

public class VeHinh5 {
    public static void main(String[] args) {
       int n = 7;
       for (int i = 1; i <= n; i++) {
           for (int j = 0; j < n - i; j++) {
               System.out.print("* ");
           }
           System.out.println();
       }
    }
}
