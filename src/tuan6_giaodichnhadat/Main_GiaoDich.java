package tuan6_giaodichnhadat;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main_GiaoDich {
    public static void main(String[] args) {
        DanhSachGiaoDich dsGD = new DanhSachGiaoDich();
        
        // Thêm một số dữ liệu mẫu
        dsGD.themGiaoDich(new GiaoDichDat("D001", LocalDate.of(2013, 9, 15), 5000000, 200, "A"));
        dsGD.themGiaoDich(new GiaoDichDat("D002", LocalDate.of(2013, 8, 20), 4000000, 150, "B"));
        dsGD.themGiaoDich(new GiaoDichDat("D003", LocalDate.of(2013, 9, 25), 4500000, 180, "C"));
        
        dsGD.themGiaoDich(new GiaoDichNha("N001", LocalDate.of(2013, 9, 10), 10000000, 100, "cao cấp", "123 Lê Lợi, Q1, TP.HCM"));
        dsGD.themGiaoDich(new GiaoDichNha("N002", LocalDate.of(2013, 10, 15), 8000000, 120, "thường", "456 Nguyễn Huệ, Q1, TP.HCM"));
        
        Scanner sc = new Scanner(System.in);
        int option;
        
        do {
            menu();
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
                option = 0;
                continue;
            }
            
            switch(option) {
                case 1:
                    dsGD.nhapGiaoDich(sc);
                    break;
                case 2:
                    dsGD.xuatTatCaGiaoDich();
                    break;
                case 3:
                    dsGD.xuatGiaoDichDat();
                    break;
                case 4:
                    dsGD.xuatGiaoDichNha();
                    break;
                case 5:
                    dsGD.xuatThongKe();
                    break;
                case 6:
                    xoaGiaoDich(dsGD);
                    break;
                case 7:
                    suaGiaoDich(dsGD);
                    break;
                case 8:
                    dsGD.xuatGiaoDichThang9Nam2013();
                    break;
                case 9:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while(option != 9);
        
        sc.close();
    }
    
    public static void menu() {
        System.out.println("\nQUẢN LÝ GIAO DỊCH NHÀ ĐẤT");
        System.out.println("--------------------------------");
        System.out.println("1. Nhập giao dịch mới");
        System.out.println("2. Hiển thị tất cả giao dịch");
        System.out.println("3. Hiển thị giao dịch đất");
        System.out.println("4. Hiển thị giao dịch nhà");
        System.out.println("5. Xem thống kê giao dịch");
        System.out.println("6. Xóa giao dịch");
        System.out.println("7. Sửa thông tin giao dịch");
        System.out.println("8. Xem giao dịch tháng 9 năm 2013");
        System.out.println("9. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    public static void xoaGiaoDich(DanhSachGiaoDich dsGD) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n== Xóa giao dịch ==");
        System.out.print("Nhập mã giao dịch cần xóa: ");
        String maGiaoDich = sc.nextLine();
        
        GiaoDich gd = dsGD.timGiaoDich(maGiaoDich);
        if (gd == null) {
            System.out.println("Không tìm thấy giao dịch có mã " + maGiaoDich);
            return;
        }
        
        System.out.print("Bạn có chắc chắn muốn xóa giao dịch này không? (y/n): ");
        String confirm = sc.nextLine();
        
        if (confirm.equalsIgnoreCase("y")) {
            dsGD.xoaGiaoDich(gd);
            System.out.println("Đã xóa giao dịch thành công!");
        } else {
            System.out.println("Đã hủy thao tác xóa giao dịch!");
        }
    }

    public static void suaGiaoDich(DanhSachGiaoDich dsGD) {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n== Sửa thông tin giao dịch ==");
    System.out.print("Nhập mã giao dịch cần sửa: ");
    String maGiaoDich = sc.nextLine();
    
    GiaoDich gd = dsGD.timGiaoDich(maGiaoDich);
    if (gd == null) {
        System.out.println("Không tìm thấy giao dịch có mã " + maGiaoDich);
        return;
    }
    
    System.out.println("Thông tin giao dịch hiện tại:");
    if (gd instanceof GiaoDichDat) {
        GiaoDichDat gdDat = (GiaoDichDat) gd;
        System.out.println("Loại: Giao dịch đất");
        System.out.println("Mã giao dịch: " + gdDat.getMaGiaoDich());
        System.out.println("Ngày giao dịch: " + gdDat.getNgayGiaoDich().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Đơn giá: " + gdDat.getDonGia());
        System.out.println("Diện tích: " + gdDat.getDienTich());
        System.out.println("Loại đất: " + gdDat.getLoaiDat());
        
        System.out.println("\nNhập thông tin mới (để trống nếu giữ nguyên):");
        
        // Không cho phép sửa mã giao dịch
        
        System.out.print("Ngày giao dịch (dd/MM/yyyy): ");
        String ngayGdStr = sc.nextLine();
        if (!ngayGdStr.trim().isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate ngayGd = LocalDate.parse(ngayGdStr, formatter);
                gdDat.setNgayGiaoDich(ngayGd);
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày không hợp lệ. Giữ nguyên giá trị cũ.");
            }
        }
        
        System.out.print("Đơn giá: ");
        String donGiaStr = sc.nextLine();
        if (!donGiaStr.trim().isEmpty()) {
            try {
                double donGia = Double.parseDouble(donGiaStr);
                if (donGia > 0) {
                    gdDat.setDonGia(donGia);
                } else {
                    System.out.println("Đơn giá phải lớn hơn 0. Giữ nguyên giá trị cũ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Đơn giá không hợp lệ. Giữ nguyên giá trị cũ.");
            }
        }
        
        System.out.print("Diện tích: ");
        String dienTichStr = sc.nextLine();
        if (!dienTichStr.trim().isEmpty()) {
            try {
                double dienTich = Double.parseDouble(dienTichStr);
                if (dienTich > 0) {
                    gdDat.setDienTich(dienTich);
                } else {
                    System.out.println("Diện tích phải lớn hơn 0. Giữ nguyên giá trị cũ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Diện tích không hợp lệ. Giữ nguyên giá trị cũ.");
            }
        }
        
        System.out.print("Loại đất (A/B/C): ");
        String loaiDat = sc.nextLine().toUpperCase();
        if (!loaiDat.trim().isEmpty()) {
            if (loaiDat.equals("A") || loaiDat.equals("B") || loaiDat.equals("C")) {
                gdDat.setLoaiDat(loaiDat);
            } else {
                System.out.println("Loại đất phải là A, B hoặc C. Giữ nguyên giá trị cũ.");
            }
        }
        
    } else if (gd instanceof GiaoDichNha) {
        GiaoDichNha gdNha = (GiaoDichNha) gd;
        System.out.println("Loại: Giao dịch nhà");
        System.out.println("Mã giao dịch: " + gdNha.getMaGiaoDich());
        System.out.println("Ngày giao dịch: " + gdNha.getNgayGiaoDich().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Đơn giá: " + gdNha.getDonGia());
        System.out.println("Diện tích: " + gdNha.getDienTich());
        System.out.println("Loại nhà: " + gdNha.getLoaiNha());
        System.out.println("Địa chỉ: " + gdNha.getDiaChi());
        
        System.out.println("\nNhập thông tin mới (để trống nếu giữ nguyên):");
        
        // Không cho phép sửa mã giao dịch
        
        System.out.print("Ngày giao dịch (dd/MM/yyyy): ");
        String ngayGdStr = sc.nextLine();
        if (!ngayGdStr.trim().isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate ngayGd = LocalDate.parse(ngayGdStr, formatter);
                gdNha.setNgayGiaoDich(ngayGd);
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày không hợp lệ. Giữ nguyên giá trị cũ.");
            }
        }
        
        System.out.print("Đơn giá: ");
        String donGiaStr = sc.nextLine();
        if (!donGiaStr.trim().isEmpty()) {
            try {
                double donGia = Double.parseDouble(donGiaStr);
                if (donGia > 0) {
                    gdNha.setDonGia(donGia);
                } else {
                    System.out.println("Đơn giá phải lớn hơn 0. Giữ nguyên giá trị cũ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Đơn giá không hợp lệ. Giữ nguyên giá trị cũ.");
            }
        }
        
        System.out.print("Diện tích: ");
        String dienTichStr = sc.nextLine();
        if (!dienTichStr.trim().isEmpty()) {
            try {
                double dienTich = Double.parseDouble(dienTichStr);
                if (dienTich > 0) {
                    gdNha.setDienTich(dienTich);
                } else {
                    System.out.println("Diện tích phải lớn hơn 0. Giữ nguyên giá trị cũ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Diện tích không hợp lệ. Giữ nguyên giá trị cũ.");
            }
        }
        
        System.out.print("Loại nhà (cao cấp/thường): ");
        String loaiNha = sc.nextLine().toLowerCase();
        if (!loaiNha.trim().isEmpty()) {
            if (loaiNha.equals("cao cấp") || loaiNha.equals("thường")) {
                gdNha.setLoaiNha(loaiNha);
            } else {
                System.out.println("Loại nhà phải là 'cao cấp' hoặc 'thường'. Giữ nguyên giá trị cũ.");
            }
        }
        
        System.out.print("Địa chỉ: ");
        String diaChi = sc.nextLine();
        if (!diaChi.trim().isEmpty()) {
            gdNha.setDiaChi(diaChi);
        }
    }
    
    System.out.println("Đã cập nhật thông tin giao dịch thành công!");
}
}