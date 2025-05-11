package Tuan5_Toa_Do_Hinh_Tron;

public class kiemthu {
    public static void main(String[] args) {
        Toado tamp = new Toado("P", 5, 5);
        HinhTron hinhtron = new HinhTron(tamp, 10.5);
        System.out.println(hinhtron);
    }
}
