



    // DanhSachHangHoa.java
import java.util.*;

    public class QLDSHH {
        private HangHoa[] danhSach;
        private int soLuong;

        // Constructor
        public QLDSHH(int n) {
            danhSach = new HangHoa[n];
            soLuong = 0;
        }

        // Thêm hàng hóa
        public boolean themHangHoa(HangHoa hangHoa) {
            if (soLuong >= danhSach.length) {
                return false;
            }

            // Kiểm tra trùng mã
            for (int i = 0; i < soLuong; i++) {
                if (danhSach[i].maHang.equals(hangHoa.maHang)) {
                    return false;
                }
            }

            danhSach[soLuong] = hangHoa;
            soLuong++;
            return true;
        }

        // Lấy toàn bộ danh sách
        public void xuatDanhSach() {
            for (int i = 0; i < soLuong; i++) {
                System.out.println("Hàng hóa " + (i+1) + ": " + danhSach[i]);
            }
        }

        // Lấy danh sách theo loại
        public void xuatHangThucPham() {
            for (int i = 0; i < soLuong; i++) {
                if (danhSach[i] instanceof HangThucPham) {
                    System.out.println(danhSach[i]);
                }
            }
        }

        public void xuatHangDienMay() {
            for (int i = 0; i < soLuong; i++) {
                if (danhSach[i] instanceof HangDienMay) {
                    System.out.println(danhSach[i]);
                }
            }
        }

        public void xuatHangSanhSu() {
            for (int i = 0; i < soLuong; i++) {
                if (danhSach[i] instanceof HangSanhSu) {
                    System.out.println(danhSach[i]);
                }
            }
        }

        // Tìm kiếm theo mã hàng
        public HangHoa timKiem(String maHang) {
            for (int i = 0; i < soLuong; i++) {
                if (danhSach[i].maHang.equals(maHang)) {
                    return danhSach[i];
                }
            }
            return null;
        }

        // Sắp xếp theo tên tăng dần
        public void sapXepTheoTen() {
            for (int i = 0; i < soLuong - 1; i++) {
                for (int j = i + 1; j < soLuong; j++) {
                    if (danhSach[i].tenHang.compareTo(danhSach[j].tenHang) > 0) {
                        HangHoa temp = danhSach[i];
                        danhSach[i] = danhSach[j];
                        danhSach[j] = temp;
                    }
                }
            }
        }

        // Sắp xếp theo số lượng tồn giảm dần
        public void sapXepTheoSoLuongTon() {
            for (int i = 0; i < soLuong - 1; i++) {
                for (int j = i + 1; j < soLuong; j++) {
                    if (danhSach[i].soLuongTon < danhSach[j].soLuongTon) {
                        HangHoa temp = danhSach[i];
                        danhSach[i] = danhSach[j];
                        danhSach[j] = temp;
                    }
                }
            }
        }

        // Lấy thông tin hàng thực phẩm khó bán
        public void hangThucPhamKhoBan() {
            for (int i = 0; i < soLuong; i++) {
                if (danhSach[i] instanceof HangThucPham && danhSach[i].soLuongTon > 100) {
                    System.out.println(danhSach[i]);
                }
            }
        }

        // Xóa hàng hóa
        public boolean xoaHangHoa(String maHang) {
            for (int i = 0; i < soLuong; i++) {
                if (danhSach[i].maHang.equals(maHang)) {
                    for (int j = i; j < soLuong - 1; j++) {
                        danhSach[j] = danhSach[j + 1];
                    }
                    soLuong--;
                    return true;
                }
            }
            return false;
        }

        // Sửa đơn giá
        public boolean suaDonGia(String maHang, double donGiaMoi) {
            for (int i = 0; i < soLuong; i++) {
                if (danhSach[i].maHang.equals(maHang)) {
                    danhSach[i].donGia = donGiaMoi;
                    return true;
                }
            }
            return false;
        }
    }

    // Main.java
    class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số lượng hàng hóa tối đa: ");
            int n = scanner.nextInt();
            QLDSHH danhSach = new QLDSHH(n);

            int choice;
            do {
                System.out.println("\n----- MENU -----");
                System.out.println("1. Thêm hàng hóa");
                System.out.println("2. Xuất danh sách hàng hóa");
                System.out.println("3. Xuất hàng thực phẩm");
                System.out.println("4. Xuất hàng điện máy");
                System.out.println("5. Xuất hàng sành sứ");
                System.out.println("6. Tìm kiếm hàng hóa");
                System.out.println("7. Sắp xếp theo tên");
                System.out.println("8. Sắp xếp theo số lượng tồn");
                System.out.println("9. Xem hàng thực phẩm khó bán");
                System.out.println("10. Xóa hàng hóa");
                System.out.println("11. Sửa đơn giá");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        // Code thêm hàng hóa
                        System.out.println("Chọn loại hàng hóa (1-Thực phẩm, 2-Điện máy, 3-Sành sứ): ");
                        int loai = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Mã hàng: ");
                        String maHang = scanner.nextLine();
                        System.out.print("Tên hàng: ");
                        String tenHang = scanner.nextLine();
                        System.out.print("Đơn giá: ");
                        double donGia = scanner.nextDouble();
                        System.out.print("Số lượng tồn: ");
                        int soLuongTon = scanner.nextInt();

                        HangHoa hangHoa = null;
                        switch (loai) {
                            case 1:
                                // Thêm thông tin cho hàng thực phẩm
                                hangHoa = new HangThucPham(maHang, tenHang, donGia, soLuongTon,
                                        "NCC", new Date(), new Date());
                                break;
                            case 2:
                                // Thêm thông tin cho hàng điện máy
                                hangHoa = new HangDienMay(maHang, tenHang, donGia, soLuongTon,
                                        12, 220);
                                break;
                            case 3:
                                // Thêm thông tin cho hàng sành sứ
                                hangHoa = new HangSanhSu(maHang, tenHang, donGia, soLuongTon,
                                        "NSX", new Date());
                                break;
                        }

                        if (hangHoa != null && danhSach.themHangHoa(hangHoa)) {
                            System.out.println("Thêm thành công!");
                        } else {
                            System.out.println("Thêm thất bại!");
                        }
                        break;

                    case 2:
                        danhSach.xuatDanhSach();
                        break;

                    case 3:
                        danhSach.xuatHangThucPham();
                        break;

                    case 4:
                        danhSach.xuatHangDienMay();
                        break;

                    case 5:
                        danhSach.xuatHangSanhSu();
                        break;

                    case 6:
                        System.out.print("Nhập mã hàng cần tìm: ");
                        String maTimKiem = scanner.nextLine();
                        HangHoa kq = danhSach.timKiem(maTimKiem);
                        if (kq != null) {
                            System.out.println("Tìm thấy: " + kq);
                        } else {
                            System.out.println("Không tìm thấy hàng hóa!");
                        }
                        break;

                    case 7:
                        danhSach.sapXepTheoTen();
                        System.out.println("Đã sắp xếp theo tên!");
                        break;

                    case 8:
                        danhSach.sapXepTheoSoLuongTon();
                        System.out.println("Đã sắp xếp theo số lượng tồn!");
                        break;

                    case 9:
                        danhSach.hangThucPhamKhoBan();
                        break;

                    case 10:
                        System.out.print("Nhập mã hàng cần xóa: ");
                        String maXoa = scanner.nextLine();
                        if (danhSach.xoaHangHoa(maXoa)) {
                            System.out.println("Xóa thành công!");
                        } else {
                            System.out.println("Xóa thất bại!");
                        }
                        break;

                    case 11:
                        System.out.print("Nhập mã hàng cần sửa: ");
                        String maSua = scanner.nextLine();
                        System.out.print("Nhập đơn giá mới: ");
                        double donGiaMoi = scanner.nextDouble();
                        if (danhSach.suaDonGia(maSua, donGiaMoi)) {
                            System.out.println("Sửa thành công!");
                        } else {
                            System.out.println("Sửa thất bại!");
                        }
                        break;
                }
            } while (choice != 0);

            scanner.close();
        }
    }
