package Tuan2_QuanLiSach;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<SGK> danhSachSGK = new ArrayList<>();
        List<STK> danhSachSTK = new ArrayList<>();

        // Thêm 3 sách giáo khoa
        danhSachSGK.add(new SGK("SGK01", "2024-01-01", 50000, 10, "NXB K", "mới"));
        danhSachSGK.add(new SGK("SGK02", "2024-01-02", 40000, 8, "NXB A", "cũ"));
        danhSachSGK.add(new SGK("SGK03", "2024-01-03", 60000, 5, "NXB K", "mới"));

        // Thêm 3 sách tham khảo
        danhSachSTK.add(new STK("STK01", "2024-01-04", 70000, 6, "NXB B", 10000));
        danhSachSTK.add(new STK("STK02", "2024-01-05", 80000, 7, "NXB C", 12000));
        danhSachSTK.add(new STK("STK03", "2024-01-06", 90000, 4, "NXB D", 15000));

        // Tính tổng thành tiền từng loại
        double tongTienSGK = danhSachSGK.stream().mapToDouble(SGK::getGiaTien).sum();
        double tongTienSTK = danhSachSTK.stream().mapToDouble(STK::getGiaTien).sum();

        System.out.println("Tổng thành tiền sách giáo khoa: " + tongTienSGK);
        System.out.println("Tổng thành tiền sách tham khảo: " + tongTienSTK);


        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên nhà xuất bản cần tìm: ");
        String nhaXuatBanK = scanner.nextLine();

        System.out.println("Danh sách sách giáo khoa của NXB " + nhaXuatBanK + ":");
        danhSachSGK.stream()
                .filter(sgk -> sgk.getNhaXuatBan().equalsIgnoreCase(nhaXuatBanK))
                .forEach(sgk -> System.out.println(sgk.masach));


        double maxThanhTien = Math.max(
                danhSachSGK.stream().mapToDouble(SGK::getGiaTien).max().orElse(0),
                danhSachSTK.stream().mapToDouble(STK::getGiaTien).max().orElse(0)
        );
        System.out.println("Thành tiền cao nhất: " + maxThanhTien);
    }
}
