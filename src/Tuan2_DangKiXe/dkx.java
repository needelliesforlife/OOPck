package Tuan2_DangKiXe;

import java.util.Scanner;
public class dkx {
    private int dungtich;
    private String tenxe;
    private final double THUEBE = 0.01;
    private final double THUETB = 0.03;
    private final double THUELON = 0.05;
    private String tenchuxe;
    private String loaixe;
    private int trigia;
    private String maxe;

    public String getMaxe() {
        return maxe;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public String getTenchuxe() {
        return tenchuxe;
    }

    public void setTenchuxe(String tenchuxe) {
        this.tenchuxe = tenchuxe;
    }

    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    public int getTrigia() {
        return trigia;
    }

    public void setTrigia(int trigia) {
        this.trigia = trigia;
    }

    public int getDungtich() {
        return dungtich;
    }

    public void setDungtich(int dungtich) {
        this.dungtich = dungtich;
    }

    public double getThue() {
        if (getDungtich() < 100) {
            return THUEBE * getTrigia();
        }
        if (getDungtich() >= 100 && getDungtich() <= 200) {
            return THUETB * getTrigia();
        }
        return THUELON * getTrigia();
    }

    public static int timkiem(dkx[] dsxe, String mx, int sl) {
        for (int i = 0; i < sl; i++) {
            if (dsxe[i] != null && dsxe[i].getMaxe().equals(mx)) {
                return i;
            }
        }
        return -1;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public static dkx getDangKiXe(Scanner sc) {
        dkx dkx1 = new dkx();

        System.out.print("Nhap ma xe: ");
        while (true) {
            String maxe = sc.nextLine().trim();
            if (!maxe.isEmpty()) {
                dkx1.setMaxe(maxe);
                break;
            }
            System.out.print("Ma xe khong duoc de trong! Nhap lai: ");
        }
        System.out.print("Nhap ten xe: ");
        while (true) {
            try {
                String tenxe = sc.nextLine().trim();
                if(!tenxe.isEmpty()) {
                    dkx1.setTenxe(tenxe);
                }
                break;
            }
            catch (Exception e) {
                System.out.println("ten xe khong duoc de trong");
            }
        }
        System.out.print("Nhap ten chu xe: ");
        while (true) {
            String tenchuxe = sc.nextLine().trim();
            if (!tenchuxe.isEmpty()) {
                dkx1.setTenchuxe(tenchuxe);
                break;
            }
            System.out.print("Ten chu xe khong duoc de trong! Nhap lai: ");
        }

        System.out.print("Nhap loai xe: ");
        while (true) {
            String loaixe = sc.nextLine().trim();
            if (!loaixe.isEmpty()) {
                dkx1.setLoaixe(loaixe);
                break;
            }
            System.out.print("Loai xe khong duoc de trong! Nhap lai: ");
        }

        System.out.print("Nhap dung tich: ");
        while (true) {
            try {
                int dungtich = Integer.parseInt(sc.nextLine().trim());
                if (dungtich > 0) {
                    dkx1.setDungtich(dungtich);
                    break;
                }
                System.out.print("Dung tich phai lon hon 0! Nhap lai: ");
            } catch (NumberFormatException e) {
                System.out.print("Loi: Dung tich phai la so nguyen! Nhap lai: ");
            }
        }

        System.out.print("Nhap tri gia: ");
        while (true) {
            try {
                int trigia = Integer.parseInt(sc.nextLine().trim());
                if (trigia > 0) {
                    dkx1.setTrigia(trigia);
                    break;
                }
                System.out.print("Tri gia phai lon hon 0! Nhap lai: ");
            } catch (NumberFormatException e) {
                System.out.print("Loi: Tri gia phai la so nguyen! Nhap lai: ");
            }
        }

        return dkx1;
    }

    static int xoaXe(dkx[] dsxe, int sl, Scanner sc) {
        System.out.print("Nhap ma xe can xoa: ");
        String mx = sc.nextLine();
        int vt = timkiem(dsxe, mx, sl);

        if (vt != -1) {
            System.out.print("Ban co chac chan muon xoa xe " + mx + "? (y/n): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                for (int i = vt; i < sl - 1; i++) {
                    dsxe[i] = dsxe[i + 1];
                }
                dsxe[sl - 1] = null;
                sl--;
                System.out.println("Da xoa xe " + mx + ".");
            } else {
                System.out.println("Ban da khong xoa.");
            }
        } else {
            System.out.println("Khong tim thay xe voi ma xe: " + mx);
        }
        return sl;
    }

    public static void in(dkx[] dsxe, int sl) {
        if (sl > 0) {
            System.out.println("Danh sach xe:");
            for (int i = 0; i < sl; i++) {
                dkx xe = dsxe[i];
                System.out.println("Xe " + (i + 1) + ":");
                System.out.println("Ma xe: " + xe.getMaxe());
                System.out.println("Ten chu xe: " + xe.getTenchuxe());
                System.out.println("Loai xe: " + xe.getLoaixe());
                System.out.println("Dung tich: " + xe.getDungtich());
                System.out.println("Tri gia: " + xe.getTrigia());
                System.out.println("Thue xe: " + xe.getThue());
                System.out.println("------");
            }
        } else {
            System.out.println("Chua co xe nao duoc dang ki.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c;
        dkx[] dsxe = new dkx[100];
        int sl = 0;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Them thong tin xe.");
            System.out.println("2. In thong tin xe.");
            System.out.println("3. Xoa thong tin xe.");
            System.out.println("0. Thoat chuong trinh.");
            System.out.print("Nhap lua chon: ");

            while (!sc.hasNextInt()) {
                System.out.print("Loi: Nhap so! Moi nhap lai: ");
                sc.next();
            }
            c = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (c) {
                case 1:
                    if (sl < dsxe.length) {
                        dkx xe = getDangKiXe(sc);
                        if (xe != null) {
                            dsxe[sl++] = xe;
                        }
                    } else {
                        System.out.println("So luong xe da day.");
                    }
                    break;
                case 2:
                    in(dsxe, sl);
                    break;
                case 3:
                    sl = xoaXe(dsxe, sl, sc);
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (c != 0);

        sc.close();
    }
}
