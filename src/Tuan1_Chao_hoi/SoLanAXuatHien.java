package Tuan1_Chao_hoi;
import java.util.Scanner;
public class SoLanAXuatHien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line: ");
        String n = sc.nextLine();
        int cnt = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == 'a') {
                cnt++;
            }
        }
        System.out.println("Number of 'a' is: " + cnt);
    }
}
