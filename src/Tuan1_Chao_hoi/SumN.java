package Tuan1_Chao_hoi;
import java.util.Scanner;
public class SumN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap n: ");
        int n = sc.nextInt();
        int sum = (n * (n + 1)) / 2;

        System.out.println("Sum is: " + sum);
    }
}
