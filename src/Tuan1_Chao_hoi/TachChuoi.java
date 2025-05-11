package Tuan1_Chao_hoi;
import java.util.*;
public class TachChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi: ");
        String s = sc.nextLine();
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
