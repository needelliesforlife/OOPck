package Tuan1_Chao_hoi;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = a + b;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap n: ");
        int n = sc.nextInt();
        System.out.print(a +" " + b+ " ");
        for (int i = 0; i < n; i++) {
            System.out.print(c+ " ");
            a = b;
            b = c;
            c = a + b;
        }
    }


}
