package Tuan7_PhongHoc;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static quanLiPhongHoc quanLyPhongHoc = new quanLiPhongHoc();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    themPhongHoc();
                    break;
                case 2:
                    timPhongHoc();
                    break;
                case 3:
                    inDanhSachPhongHoc();
                    break;
                case 4:
                    inDanhSachPhongDatChuan();
                    break;
                case 5:
                    sapXepTheoDayNha();
                    break;
                case 6:
                    sapXepTheoDienTich();
                    break;
                case 7:
                    sapXepTheoSoBongDen();
                    break;
                case 8:
                    capNhatSoMayTinh();
                    break;
                case 9:
                    xoaPhongHoc();
                    break;
                case 10:
                    inTongSoPhongHoc();
                    break;
                case 11:
                    inDanhSachPhongMay60May();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n===== QUẢN LÝ PHÒNG HỌC =====");
        System.out.println("1. Thêm phòng học mới");
        System.out.println("2. Tìm kiếm phòng học theo mã");
        System.out.println("3. In danh sách phòng học");
        System.out.println("4. In danh sách phòng học đạt chuẩn");
        System.out.println("5. Sắp xếp theo dãy nhà");
        System.out.println("6. Sắp xếp theo diện tích (giảm dần)");
        System.out.println("7. Sắp xếp theo số bóng đèn");
        System.out.println("8. Cập nhật số máy tính cho phòng máy tính");
        System.out.println("9. Xóa phòng học");
        System.out.println("10. In tổng số phòng học");
        System.out.println("11. In danh sách phòng máy có 60 máy");
        System.out.println("0. Thoát");
    }

    private static void themPhongHoc() {
        System.out.println("\n----- THÊM PHÒNG HỌC MỚI -----");
        System.out.print("Nhập mã phòng: ");
        String maPhong = scanner.nextLine();
        System.out.print("Nhập dãy nhà: ");
        String dayNha = scanner.nextLine();
        System.out.print("Nhập diện tích: ");
        double dienTich = scanner.nextDouble();
        System.out.print("Nhập số bóng đèn: ");
        int soBongDen = scanner.nextInt();

        System.out.println("Chọn loại phòng:");
        System.out.println("1. Phòng lý thuyết");
        System.out.println("2. Phòng máy tính");
        System.out.println("3. Phòng thí nghiệm");
        int loaiPhong = scanner.nextInt();
        scanner.nextLine();

        phongHoc phongHoc = null;
        switch (loaiPhong) {
            case 1:
                System.out.print("Có máy chiếu không? (y/n): ");
                boolean coMayChieu;
                String luachon1 = scanner.nextLine();
                if (luachon1.equalsIgnoreCase("y")) {
                    coMayChieu = true;
                }
                else {
                    coMayChieu = false;
                }

                phongHoc = new PhongLiThuyet(maPhong, dayNha, dienTich, soBongDen, coMayChieu);
                break;
            case 2:
                System.out.print("Nhập số máy tính: ");
                int soMayTinh = scanner.nextInt();
                phongHoc = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
                break;
            case 3:
                boolean coBonRua;
                System.out.print("Nhập chuyên ngành: ");
                String chuyenNganh = scanner.nextLine();
                System.out.print("Nhập sức chứa: ");
                int sucChua = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Có bồn rửa không? (y/n): ");
                String luachon = scanner.nextLine();
                if (luachon.equalsIgnoreCase("y")) {
                    coBonRua = true;
                }
                else {
                    coBonRua = false;
                }
                phongHoc = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, coBonRua);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        if (quanLyPhongHoc.themPhongHoc(phongHoc)) {
            System.out.println("Thêm phòng học thành công!");
        } else {
            System.out.println("Thêm phòng học thất bại. Mã phòng đã tồn tại!");
        }
    }

    private static void timPhongHoc() {
        System.out.print("Nhập mã phòng cần tìm: ");
        String maPhong = scanner.nextLine();
        phongHoc phongHoc = quanLyPhongHoc.timPhongHoc(maPhong);
        if (phongHoc != null) {
            System.out.println("Thông tin phòng học:");
            System.out.println(phongHoc);
        } else {
            System.out.println("Không tìm thấy phòng học có mã " + maPhong);
        }
    }

    private static void inDanhSachPhongHoc() {
        System.out.println("\n----- DANH SÁCH PHÒNG HỌC -----");
        System.out.println(quanLyPhongHoc.toString());
    }

    private static void inDanhSachPhongDatChuan() {
        System.out.println("\n----- DANH SÁCH PHÒNG HỌC ĐẠT CHUẨN -----");
        List<phongHoc> dsPhongDatChuan = quanLyPhongHoc.layDanhSachPhongDatChuan();
        if (dsPhongDatChuan.isEmpty()) {
            System.out.println("Không có phòng học nào đạt chuẩn.");
        } else {
            for (phongHoc phongHoc : dsPhongDatChuan) {
                System.out.println(phongHoc);
            }
        }
    }

    private static void sapXepTheoDayNha() {
        quanLyPhongHoc.sapXepTheoDayNha();
        System.out.println("Đã sắp xếp danh sách phòng học theo dãy nhà tăng dần.");
        inDanhSachPhongHoc();
    }

    private static void sapXepTheoDienTich() {
        quanLyPhongHoc.sapXepTheoDienTich();
        System.out.println("Đã sắp xếp danh sách phòng học theo diện tích giảm dần.");
        inDanhSachPhongHoc();
    }

    private static void sapXepTheoSoBongDen() {
        quanLyPhongHoc.sapXepTheoSoBongDen();
        System.out.println("Đã sắp xếp danh sách phòng học theo số bóng đèn tăng dần.");
        inDanhSachPhongHoc();
    }

    private static void capNhatSoMayTinh() {
        System.out.print("Nhập mã phòng máy tính cần cập nhật: ");
        String maPhong = scanner.nextLine();
        System.out.print("Nhập số máy tính mới: ");
        int soMayTinhMoi = scanner.nextInt();

        try {
            if (quanLyPhongHoc.capNhatSoMayTinh(maPhong, soMayTinhMoi)) {
                System.out.println("Cập nhật số máy tính thành công!");
            } else {
                System.out.println("Cập nhật thất bại. Kiểm tra lại mã phòng hoặc loại phòng!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void xoaPhongHoc() {
        System.out.print("Nhập mã phòng cần xóa: ");
        String maPhong = scanner.nextLine();

        System.out.print("Bạn có chắc chắn muốn xóa phòng học này? (y/n): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            if (quanLyPhongHoc.xoaPhongHoc(maPhong)) {
                System.out.println("Xóa phòng học thành công!");
            } else {
                System.out.println("Xóa phòng học thất bại. Kiểm tra lại mã phòng!");
            }
        } else {
            System.out.println("Đã hủy thao tác xóa.");
        }
    }

    private static void inTongSoPhongHoc() {
        System.out.println("Tổng số phòng học: " + quanLyPhongHoc.tinhTongSoPhongHoc());
    }

    private static void inDanhSachPhongMay60May() {
        System.out.println("\n----- DANH SÁCH PHÒNG MÁY CÓ 60 MÁY -----");
        List<PhongMayTinh> dsPhongMay60 = quanLyPhongHoc.layDanhSachPhongMay60May();
        if (dsPhongMay60.isEmpty()) {
            System.out.println("Không có phòng máy tính nào có 60 máy.");
        } else {
            for (PhongMayTinh phongMayTinh : dsPhongMay60) {
                System.out.println(phongMayTinh);
            }
        }
    }
}
