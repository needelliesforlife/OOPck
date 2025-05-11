package Tuan1_Chao_hoi;
import java.util.Scanner;
public class DiemKiTuSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                cnt++;
            }
        }
        System.out.println("Number of digits is: " + cnt);
    }
}
