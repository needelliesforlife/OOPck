package tuan5_chuyenxe;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class mainChuyenXe {
    public static void main(String args[]) {
        danhSachChuyenXe dsCX = new danhSachChuyenXe();
        
        
        dsCX.themChuyenXe(new noiThanh("001", "Nathan Doan", "X3275", 400000, 3, 15));
        dsCX.themChuyenXe(new noiThanh("002", "Steven He", "D98102", 50000, 1, 3));
        
        dsCX.themChuyenXe(new ngoaiThanh("003", "Uncle Roger", "A12332", 400000, "Ha Noi", 1));
        dsCX.themChuyenXe(new ngoaiThanh("004", "konghidcten", "84 A5 1123", 500000, "TP Ho Chi Minh", 2));

        Scanner sc = new Scanner(System.in);
        int option;
        
        do {
            Menu();
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
                option = 0;
                continue;
            }
            
            switch(option) {
                case 1:
                    dsCX.nhapChuyenXe(sc);
                    break;
                case 2:
                    suaChuyenXe(dsCX);
                    break;
                case 3:
                	xoaXe(dsCX);
                    break;
                case 4:
                    System.out.println("\n==Danh sách tất cả chuyến xe==");
                    dsCX.xuatDanhSachTatCa();
                    break;
                case 5:
                    System.out.println("\n==Danh sách xe nội thành==");
                    dsCX.xuatDanhSachNoiThanh();
                    break;
                case 6:
                    System.out.println("\n==Danh sách xe ngoại thành==");
                    dsCX.xuatDanhSachNgoaiThanh();
                    break;
                case 7:
                    xuatTongDoanhThu(dsCX);
                    break;
                case 8:
                    dsCX.sortTheoTenTaiXe();
                    System.out.println("Đã sắp xếp danh sách theo tên tài xế.");
                    break;
                case 9:
                    dsCX.sortTheoDoanhThu();
                    System.out.println("Đã sắp xếp danh sách theo doanh thu.");
                    break;
                case 10:
                    System.out.println("Cảm ơn bạn đã dùng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        } while(option != 10);
        
        sc.close();
    }

    public static void Menu() {
        System.out.println("\nQUẢN LÝ CHUYẾN XE");
        System.out.println("--------------------------------");
        System.out.println("1. Thêm chuyến xe mới");
        System.out.println("2. Sửa thông tin chuyến xe");
        System.out.println("3. Xóa chuyến xe");
        System.out.println("4. Xuất danh sách tất cả chuyến xe");
        System.out.println("5. Xuất danh sách xe nội thành");
        System.out.println("6. Xuất danh sách xe ngoại thành");
        System.out.println("7. Xem thống kê doanh thu");
        System.out.println("8. Sắp xếp danh sách theo tên tài xế");
        System.out.println("9. Sắp xếp danh sách theo doanh thu");
        System.out.println("10. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    public static void xuatTongDoanhThu(danhSachChuyenXe dsCX) {
        Locale locale = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        
        System.out.println("\n==Thống kê doanh thu==");
        System.out.println("Tổng doanh thu: " + formatter.format(dsCX.tinhDoanhThu()));

    }
    public static void xoaXe(danhSachChuyenXe dsCX) {
    	Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập mã chuyến xe cần xóa: ");
            String maChuyenXe = sc.nextLine();
            chuyenXe xex = dsCX.timChuyenXe(maChuyenXe);
            if (xex != null) {
                System.out.println("Bạn có xác nhận xóa xe này không [y/n]: ");
                String acp = sc.nextLine();
                if (acp.equalsIgnoreCase("y")) {
                	dsCX.xoa(xex);
                    throw new Exception("Đã xóa thành công");
                } else {
                    throw new Exception("Bạn đã giữ lại chuyến xe này");
                }
            } else {
                throw new Exception("Không tồn tại xe này");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void suaChuyenXe(danhSachChuyenXe dsCX) {
     	Scanner sc = new Scanner(System.in);
        System.out.println("\n== Sửa thông tin chuyến xe ==");
        System.out.print("Nhập mã chuyến xe cần sửa: ");
        String maChuyenXe = sc.nextLine();
        
        chuyenXe cx = dsCX.timChuyenXe(maChuyenXe);
        if (cx == null) {
            System.out.println("Không tìm thấy chuyến xe có mã " + maChuyenXe);
            return;
        }
        
        System.out.println("Thông tin chuyến xe hiện tại:");
        if (cx instanceof noiThanh) {
            noiThanh nt = (noiThanh) cx;
            System.out.println("Loại: Nội thành");
            System.out.println("Mã chuyến xe: " + nt.getMaChuyenxe());
            System.out.println("Họ tên tài xế: " + nt.getHoTenTaiXe());
            System.out.println("Số xe: " + nt.getSoXe());
            System.out.println("Doanh thu: " + nt.getDoanhThu());
            System.out.println("Số tuyến: " + nt.getSoTuyen());
            System.out.println("Số km: " + nt.getSoKm());
            
            System.out.println("\nNhập thông tin mới (để trống nếu giữ nguyên):");
            
            System.out.print("Họ tên tài xế: ");
            String hoTenTaiXe = sc.nextLine();
            if (!hoTenTaiXe.trim().isEmpty()) {
                nt.setHoTenTaiXe(hoTenTaiXe);
            }
            
            System.out.print("Số xe: ");
            String soXe = sc.nextLine();
            if (!soXe.trim().isEmpty()) {
                nt.setSoXe(soXe);
            }
            
            System.out.print("Doanh thu: ");
            String doanhThuStr = sc.nextLine();
            if (!doanhThuStr.trim().isEmpty()) {
                try {
                    double doanhThu = Double.parseDouble(doanhThuStr);
                    if (doanhThu >= 0) {
                        nt.setDoanhThu(doanhThu);
                    } else {
                        System.out.println("Doanh thu không thể âm. Giữ nguyên giá trị cũ.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Doanh thu không hợp lệ. Giữ nguyên giá trị cũ.");
                }
            }
            
            System.out.print("Số tuyến: ");
            String soTuyenStr = sc.nextLine();
            if (!soTuyenStr.trim().isEmpty()) {
                try {
                    int soTuyen = Integer.parseInt(soTuyenStr);
                    if (soTuyen > 0) {
                        nt.setSoTuyen(soTuyen);
                    } else {
                        System.out.println("Số tuyến phải lớn hơn 0. Giữ nguyên giá trị cũ.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Số tuyến không hợp lệ. Giữ nguyên giá trị cũ.");
                }
            }
            
            System.out.print("Số km: ");
            String soKmStr = sc.nextLine();
            if (!soKmStr.trim().isEmpty()) {
                try {
                    int soKm = Integer.parseInt(soKmStr);
                    if (soKm > 0) {
                        nt.setSoKm(soKm);
                    } else {
                        System.out.println("Số km phải lớn hơn 0. Giữ nguyên giá trị cũ.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Số km không hợp lệ. Giữ nguyên giá trị cũ.");
                }
            }
            
        } else if (cx instanceof ngoaiThanh) {
            ngoaiThanh nt = (ngoaiThanh) cx;
            System.out.println("Loại: Ngoại thành");
            System.out.println("Mã chuyến xe: " + nt.getMaChuyenxe());
            System.out.println("Họ tên tài xế: " + nt.getHoTenTaiXe());
            System.out.println("Số xe: " + nt.getSoXe());
            System.out.println("Doanh thu: " + nt.getDoanhThu());
            System.out.println("Nơi đến: " + nt.getNoiDen());
            System.out.println("Số ngày: " + nt.getSoNgay());
            
            System.out.println("\nNhập thông tin mới (để trống nếu giữ nguyên):");
            
            System.out.print("Họ tên tài xế: ");
            String hoTenTaiXe = sc.nextLine();
            if (!hoTenTaiXe.trim().isEmpty()) {
                nt.setHoTenTaiXe(hoTenTaiXe);
            }
            
            System.out.print("Số xe: ");
            String soXe = sc.nextLine();
            if (!soXe.trim().isEmpty()) {
                nt.setSoXe(soXe);
            }
            
            System.out.print("Doanh thu: ");
            String doanhThuStr = sc.nextLine();
            if (!doanhThuStr.trim().isEmpty()) {
                try {
                    double doanhThu = Double.parseDouble(doanhThuStr);
                    if (doanhThu >= 0) {
                        nt.setDoanhThu(doanhThu);
                    } else {
                        System.out.println("Doanh thu không thể âm. Giữ nguyên giá trị cũ.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Doanh thu không hợp lệ. Giữ nguyên giá trị cũ.");
                }
            }
            
            System.out.print("Nơi đến: ");
            String noiDen = sc.nextLine();
            if (!noiDen.trim().isEmpty()) {
                nt.setNoiDen(noiDen);
            }
            
            System.out.print("Số ngày đi: ");
            String soNgayStr = sc.nextLine();
            if (!soNgayStr.trim().isEmpty()) {
                try {
                    int soNgay = Integer.parseInt(soNgayStr);
                    if (soNgay > 0) {
                        nt.setSoNgay(soNgay);
                    } else {
                        System.out.println("Số ngày đi phải lớn hơn 0. Giữ nguyên giá trị cũ.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Số ngày đi không hợp lệ. Giữ nguyên giá trị cũ.");
                }
            }
        }
        
        System.out.println("Đã cập nhật thông tin chuyến xe thành công!");
    }
    
}

