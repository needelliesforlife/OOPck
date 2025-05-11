package Tuan3_QuanLiXe;
import java.util.Scanner;
public class ListChuyenXe {
    private quanLiXe[] CX = new quanLiXe[100];
    private int countCX = 0;
    private double sum1 = 0, sum2 = 0;
    public ListChuyenXe() {
        for (int i = 0; i < 100; i++) {
            CX[i] = new quanLiXe();
        }
    }
    public void them(int loaixe) {
        if (countCX > 100) {
            System.out.println("Khong the them du lieu");
        }
        else {
            Scanner sc = new Scanner(System.in);
            int temp = sc.nextInt();
            if (temp == 1) {
                CX[countCX] = new NoiThanh();
                NoiThanh noi = new NoiThanh();
                noi.nhap();
                CX[countCX] = noi;
                sum1 += noi.getDoanhThu();
            }
            else {
                CX[countCX] = new NgoaiThanh();
                NgoaiThanh ngoai = new NgoaiThanh();
                ngoai.nhap();
                CX[countCX] = ngoai;
                sum2 += ngoai.getDoanhThu();
        }
            countCX += 1;
        }
    }
    public void xuatTT()
    {
        for(int i=0 ; i<countCX; i++)
        {
            System.out.println("------------/---------------/------------");
            System.out.println(CX[i].toString());
            System.out.println("----------------Doanh Thu-----------------");
            System.out.println("| Chuyen Xe Noi Thanh: " + sum1 + "|");
            System.out.println("| Chuyen Xe Ngoai Thanh: " + sum2 + "|");
            System.out.println("------------------------------------------");
        }

    }

}


