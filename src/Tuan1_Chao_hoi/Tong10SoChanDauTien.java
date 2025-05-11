package Tuan1_Chao_hoi;

public class Tong10SoChanDauTien {
    public static void main ( String[] args){
        int ans = 0;
        int tmp =0;
        for (int i = 0; i < 10; i++) {
            ans += tmp;
            tmp += 2;
            System.out.println(ans);
        }
        System.out.println(ans);
    }
}
