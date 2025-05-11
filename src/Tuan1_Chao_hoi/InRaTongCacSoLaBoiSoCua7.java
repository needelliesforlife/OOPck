package tuan1_HelloClass;

public class InRaTongCacSoLaBoiSoCua7 {
    public static void main (String[] args) {
        int ans = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 7 == 0) {
                ans += i;
            }
        }
        System.out.println(ans);
    }
}
