package Tuan1_Chao_hoi;
import java.util.Scanner;
public class SumSmallerN {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       n -= 1;
       int sum = (n * (n +1)) / 2;
       System.out.println("Sum is: " + sum);
    }
}
