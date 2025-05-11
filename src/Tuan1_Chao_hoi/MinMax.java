package Tuan1_Chao_hoi;
import java.util.Scanner;
public class MinMax {
    public static void main(String[] args) {
        int min = 100000000;
        int max = -100000000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap day: ");
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        for (String num : arr) {
            int tmp = Integer.parseInt(num);
            if (tmp > max) {
                max = tmp;
            }
            if (tmp < min) {
                min = tmp;
            }
        }
        System.out.println("min: " + min + "\nmax: " + max );
    }
}
