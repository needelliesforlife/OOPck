// Lớp kiểm thử
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static QuanLyHangHoa quanLyHangHoa = new QuanLyHangHoa(100);

    public static void main(String[] args) {
        int luaChon;

        do {
            hienThiMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line

            switch (luaChon) {
                case 1:
                    themHangHoa();
                    break;
                case 2:
                    inDanhSachHangHoa();
                    break;
                case 3:
                    inDanhSachTheoLoai();
                    break;
                case 4:
                    timKiemHangHoa();
                    break;
                case 5:
                    sapXepHangHoa();
                    break;
                case 6:
                    inDanhSachHangThucPhamKhoBan();
                    break;
                case 7:
                    xoaHangHoa();
                    break;
                case 8:
                    suaDonGiaHangHoa();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }

            System.out.println();
        } while (luaChon != 0);
    }

    private static void hienThiMenu() {
        System.out.println("===== MENU QUẢN LÝ HÀNG HÓA =====");
        System.out.println("1. Thêm hàng hóa");
        System.out.println("2. In danh sách hàng hóa");
        System.out.println("3. In danh sách theo loại hàng hóa");
        System.out.println("4. Tìm kiếm hàng hóa theo mã hàng");
        System.out.println("5. Sắp xếp hàng hóa");
        System.out.println("6. In danh sách hàng thực phẩm khó bán");
        System.out.println("7. Xóa hàng hóa theo mã hàng");
        System.out.println("8. Sửa đơn giá hàng hóa");
        System.out.println("0. Thoát chương trình");
        System.out.println("=================================");
    }

    private static void themHangHoa() {
        System.out.println("===== THÊM HÀNG HÓA =====");
        System.out.println("Chọn loại hàng hóa:");
        System.out.println("1. Hàng thực phẩm");
        System.out.println("2. Hàng điện máy");
        System.out.println("3. Hàng sành sứ");
        System.out.print("Nhập lựa chọn: ");
        int loaiHang = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng new line

        // Nhập thông tin chung
        System.out.print("Nhập mã hàng: ");
        String maHang = scanner.nextLine();
        System.out.print("Nhập tên hàng: ");
        String tenHang = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();
        System.out.print("Nhập số lượng tồn: ");
        int soLuongTon = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng new line

        try {
            HangHoa hangHoa = null;

            switch (loaiHang) {
                case 1: // Hàng thực phẩm
                    System.out.print("Nhập nhà cung cấp: ");
                    String nhaCungCap = scanner.nextLine();

                    System.out.print("Nhập ngày sản xuất (yyyy-MM-dd): ");
                    String strNgaySanXuat = scanner.nextLine();
                    LocalDate ngaySanXuat = strNgaySanXuat.isEmpty() ?
                            LocalDate.now() : LocalDate.parse(strNgaySanXuat);

                    System.out.print("Nhập ngày hết hạn (yyyy-MM-dd): ");
                    String strNgayHetHan = scanner.nextLine();
                    LocalDate ngayHetHan = strNgayHetHan.isEmpty() ?
                            ngaySanXuat : LocalDate.parse(strNgayHetHan);

                    hangHoa = new HangThucPham(maHang, tenHang, donGia, soLuongTon,
                            nhaCungCap, ngaySanXuat, ngayHetHan);
                    break;

                case 2: // Hàng điện máy
                    System.out.print("Nhập thời gian bảo hành (tháng): ");
                    int thoiGianBaoHanh = scanner.nextInt();
                    System.out.print("Nhập công suất (KW): ");
                    double congSuat = scanner.nextDouble();

                    hangHoa = new HangDienMay(maHang, tenHang, donGia, soLuongTon,
                            thoiGianBaoHanh, congSuat);
                    break;

                case 3: // Hàng sành sứ
                    System.out.print("Nhập nhà sản xuất: ");
                    String nhaSanXuat = scanner.nextLine();

                    System.out.print("Nhập ngày nhập kho (yyyy-MM-dd): ");
                    String strNgayNhapKho = scanner.nextLine();
                    LocalDate ngayNhapKho = strNgayNhapKho.isEmpty() ?
                            LocalDate.now() : LocalDate.parse(strNgayNhapKho);

                    hangHoa = new HangSanhSu(maHang, tenHang, donGia, soLuongTon,
                            nhaSanXuat, ngayNhapKho);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    return;
            }

            boolean ketQua = quanLyHangHoa.themHangHoa(hangHoa);
            if (ketQua) {
                System.out.println("Thêm hàng hóa thành công!");
            } else {
                System.out.println("Thêm hàng hóa thất bại. Mã hàng đã tồn tại!");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void inDanhSachHangHoa() {
        System.out.println("===== DANH SÁCH HÀNG HÓA =====");
        HangHoa[] danhSach = quanLyHangHoa.layDanhSachHangHoa();
        if (danhSach.length == 0) {
            System.out.println("Danh sách hàng hóa trống!");
        } else {
            for (HangHoa hangHoa : danhSach) {
                System.out.println(hangHoa);
                System.out.println("-------------------------");
            }
        }
    }

    private static void inDanhSachTheoLoai() {
        System.out.println("===== IN DANH SÁCH THEO LOẠI =====");
        System.out.println("Chọn loại hàng hóa:");
        System.out.println("1. Hàng thực phẩm");
        System.out.println("2. Hàng điện máy");
        System.out.println("3. Hàng sành sứ");
        System.out.print("Nhập lựa chọn: ");
        int loaiHang = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng new line

        HangHoa[] danhSach = null;

        switch (loaiHang) {
            case 1:
                danhSach = quanLyHangHoa.layDanhSachHangThucPham();
                System.out.println("===== DANH SÁCH HÀNG THỰC PHẨM =====");
                break;
            case 2:
                danhSach = quanLyHangHoa.layDanhSachHangDienMay();
                System.out.println("===== DANH SÁCH HÀNG ĐIỆN MÁY =====");
                break;
            case 3:
                danhSach = quanLyHangHoa.layDanhSachHangSanhSu();
                System.out.println("===== DANH SÁCH HÀNG SÀNH SỨ =====");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        if (danhSach.length == 0) {
            System.out.println("Danh sách trống!");
        } else {
            for (HangHoa hangHoa : danhSach) {
                System.out.println(hangHoa);
                System.out.println("-------------------------");
            }
        }
    }

    private static void timKiemHangHoa() {
        System.out.println("===== TÌM KIẾM HÀNG HÓA =====");
        System.out.print("Nhập mã hàng cần tìm: ");
        String maHang = scanner.nextLine();

        HangHoa hangHoa = quanLyHangHoa.timKiemHangHoa(maHang);
        if (hangHoa == null) {
            System.out.println("Không tìm thấy hàng hóa có mã " + maHang);
        } else {
            System.out.println("Thông tin hàng hóa:");
            System.out.println(hangHoa);
        }
    }

    private static void sapXepHangHoa() {
        System.out.println("===== SẮP XẾP HÀNG HÓA =====");
        System.out.println("Chọn kiểu sắp xếp:");
        System.out.println("1. Theo tên hàng (tăng dần)");
        System.out.println("2. Theo số lượng tồn (giảm dần)");
        System.out.print("Nhập lựa chọn: ");
        int luaChon = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng new line

        switch (luaChon) {
            case 1:
                quanLyHangHoa.sapXepTheoTen();
                System.out.println("Đã sắp xếp theo tên hàng tăng dần!");
                break;
            case 2:
                quanLyHangHoa.sapXepTheoSoLuongTon();
                System.out.println("Đã sắp xếp theo số lượng tồn giảm dần!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        // Hiển thị danh sách sau khi sắp xếp
        inDanhSachHangHoa();
    }

    private static void inDanhSachHangThucPhamKhoBan() {
        System.out.println("===== DANH SÁCH HÀNG THỰC PHẨM KHÓ BÁN =====");
        HangHoa[] danhSach = quanLyHangHoa.layDanhSachHangThucPhamKhoBan();
        if (danhSach.length == 0) {
            System.out.println("Không có hàng thực phẩm khó bán!");
        } else {
            for (HangHoa hangHoa : danhSach) {
                System.out.println(hangHoa);
                System.out.println("-------------------------");
            }
        }
    }

    private static void xoaHangHoa() {
        System.out.println("===== XÓA HÀNG HÓA =====");
        System.out.print("Nhập mã hàng cần xóa: ");
        String maHang = scanner.nextLine();

        boolean ketQua = quanLyHangHoa.xoaHangHoa(maHang);
        if (ketQua) {
            System.out.println("Xóa hàng hóa thành công!");
        } else {
            System.out.println("Xóa hàng hóa thất bại. Không tìm thấy hàng hóa có mã " + maHang);
        }
    }

    private static void suaDonGiaHangHoa() {
        System.out.println("===== SỬA ĐƠN GIÁ HÀNG HÓA =====");
        System.out.print("Nhập mã hàng cần sửa: ");
        String maHang = scanner.nextLine();
        System.out.print("Nhập đơn giá mới: ");
        double donGiaMoi = scanner.nextDouble();
        scanner.nextLine(); // Đọc bỏ dòng new line

        try {
            boolean ketQua = quanLyHangHoa.suaDonGia(maHang, donGiaMoi);
            if (ketQua) {
                System.out.println("Cập nhật đơn giá thành công!");
            } else {
                System.out.println("Cập nhật đơn giá thất bại. Không tìm thấy hàng hóa có mã " + maHang);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
