package Tuan5_CD;
import java.util.Scanner;

public class kiemThu {
    private static Scanner scanner = new Scanner(System.in);
    private static CD_List danhSachCD = new CD_List(100);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    themCD();
                    break;
                case 2:
                    xoaCD();
                    break;
                case 3:
                    System.out.println("Số lượng CD: " + danhSachCD.soCD());
                    break;
                case 4:
                    System.out.printf("Tổng giá thành: %.2f\n", danhSachCD.tongTienCD());
                    break;
                case 5:
                    timKiemCD();
                    break;
                case 6:
                    danhSachCD.giamTheoGia();
                    System.out.println(danhSachCD);
                    break;
                case 7:
                    danhSachCD.tangTheoTua();
                    System.out.println(danhSachCD);
                    break;
                case 8:
                    System.out.println(danhSachCD);
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n=== QUẢN LÝ CD ===");
        System.out.println("1. Thêm CD");
        System.out.println("2. Xóa CD");
        System.out.println("3. Xem số lượng CD");
        System.out.println("4. Tính tổng giá thành");
        System.out.println("5. Tìm kiếm CD");
        System.out.println("6. Sắp xếp giảm dần theo giá");
        System.out.println("7. Sắp xếp tăng dần theo tựa");
        System.out.println("8. Xuất danh sách CD");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private static void themCD() {
        System.out.println("\n=== THÊM CD MỚI ===");
        System.out.print("Nhập mã CD: ");
        long maCD = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        System.out.print("Nhập tựa CD: ");
        String tuaCD = scanner.nextLine();

        System.out.print("Nhập số bài hát: ");
        long soBaiHat = scanner.nextLong();

        System.out.print("Nhập giá thành: ");
        double giaThanh = scanner.nextDouble();

        CD cd = new CD(maCD, tuaCD, soBaiHat, giaThanh);
        if (danhSachCD.themCD(cd)) {
            System.out.println("Thêm CD thành công!");
        } else {
            System.out.println("Thêm CD thất bại! (Danh sách đầy hoặc trùng mã)");
        }
    }

    private static void xoaCD() {
        System.out.print("\nNhập mã CD cần xóa: ");
        long maCD = scanner.nextLong();
        if (danhSachCD.xoaCD(maCD)) {
            System.out.println("Xóa CD thành công!");
        } else {
            System.out.println("Không tìm thấy CD có mã " + maCD);
        }
    }

    private static void timKiemCD() {
        System.out.print("\nNhập mã CD cần tìm: ");
        long maCD = scanner.nextLong();
        try {
            CD cd = danhSachCD.timCD(maCD);
            System.out.println("Tìm thấy CD: " + cd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
