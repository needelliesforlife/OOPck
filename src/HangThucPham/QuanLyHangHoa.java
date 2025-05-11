import java.util.Arrays;
import java.util.Comparator;

public class QuanLyHangHoa {
    private HangHoa[] danhSachHangHoa;
    private int soLuong;

    public QuanLyHangHoa(int soLuongToiDa) {
        this.danhSachHangHoa = new HangHoa[soLuongToiDa];
        this.soLuong = 0;
    }

    // Thêm một hàng hóa vào danh sách (nếu không bị trùng mã hàng)
    public boolean themHangHoa(HangHoa hangHoa) {
        // Kiểm tra trùng mã hàng
        if (timKiemHangHoa(hangHoa.getMaHang()) != null) {
            return false;
        }

        // Kiểm tra nếu mảng đã đầy
        if (soLuong >= danhSachHangHoa.length) {
            // Tăng kích thước mảng
            danhSachHangHoa = Arrays.copyOf(danhSachHangHoa, danhSachHangHoa.length * 2);
        }

        // Thêm hàng hóa mới
        danhSachHangHoa[soLuong] = hangHoa;
        soLuong++;
        return true;
    }

    // Lấy toàn bộ danh sách hàng hóa
    public HangHoa[] layDanhSachHangHoa() {
        return Arrays.copyOf(danhSachHangHoa, soLuong);
    }

    // Lấy danh sách hàng thực phẩm
    public HangHoa[] layDanhSachHangThucPham() {
        return layDanhSachTheoLoai(HangThucPham.class);
    }

    // Lấy danh sách hàng điện máy
    public HangHoa[] layDanhSachHangDienMay() {
        return layDanhSachTheoLoai(HangDienMay.class);
    }

    // Lấy danh sách hàng sành sứ
    public HangHoa[] layDanhSachHangSanhSu() {
        return layDanhSachTheoLoai(HangSanhSu.class);
    }

    // Phương thức hỗ trợ lấy danh sách theo loại
    private HangHoa[] layDanhSachTheoLoai(Class<?> clazz) {
        // Đếm số lượng hàng hóa thuộc loại cần tìm
        int count = 0;
        for (int i = 0; i < soLuong; i++) {
            if (clazz.isInstance(danhSachHangHoa[i])) {
                count++;
            }
        }

        // Tạo mảng kết quả
        HangHoa[] ketQua = new HangHoa[count];
        int index = 0;
        for (int i = 0; i < soLuong; i++) {
            if (clazz.isInstance(danhSachHangHoa[i])) {
                ketQua[index++] = danhSachHangHoa[i];
            }
        }

        return ketQua;
    }

    // Tìm kiếm hàng hóa theo mã hàng
    public HangHoa timKiemHangHoa(String maHang) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSachHangHoa[i].getMaHang().equals(maHang)) {
                return danhSachHangHoa[i];
            }
        }
        return null;
    }

    // Sắp xếp hàng hóa theo tên hàng tăng dần
    public void sapXepTheoTen() {
        Arrays.sort(danhSachHangHoa, 0, soLuong, new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa h1, HangHoa h2) {
                return h1.getTenHang().compareToIgnoreCase(h2.getTenHang());
            }
        });
    }

    // Sắp xếp hàng hóa theo số lượng tồn giảm dần
    public void sapXepTheoSoLuongTon() {
        Arrays.sort(danhSachHangHoa, 0, soLuong, new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa h1, HangHoa h2) {
                // Sắp xếp giảm dần, nên đảo thứ tự so sánh
                return Integer.compare(h2.getSoLuongTon(), h1.getSoLuongTon());
            }
        });
    }

    // Lấy danh sách hàng thực phẩm khó bán
    public HangHoa[] layDanhSachHangThucPhamKhoBan() {
        // Lọc ra các hàng thực phẩm có đánh giá là "Khó bán"
        HangHoa[] danhSachHangThucPham = layDanhSachHangThucPham();
        int count = 0;
        for (HangHoa hangHoa : danhSachHangThucPham) {
            if ("Khó bán".equals(hangHoa.danhGiaMucDoBanBuon())) {
                count++;
            }
        }

        HangHoa[] ketQua = new HangHoa[count];
        int index = 0;
        for (HangHoa hangHoa : danhSachHangThucPham) {
            if ("Khó bán".equals(hangHoa.danhGiaMucDoBanBuon())) {
                ketQua[index++] = hangHoa;
            }
        }

        return ketQua;
    }

    // Xóa hàng hóa theo mã hàng
    public boolean xoaHangHoa(String maHang) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSachHangHoa[i].getMaHang().equals(maHang)) {
                // Dịch các phần tử phía sau lên để ghi đè phần tử cần xóa
                for (int j = i; j < soLuong - 1; j++) {
                    danhSachHangHoa[j] = danhSachHangHoa[j + 1];
                }
                danhSachHangHoa[soLuong - 1] = null;
                soLuong--;
                return true;
            }
        }
        return false;
    }

    // Sửa đơn giá của hàng hóa khi biết mã hàng
    public boolean suaDonGia(String maHang, double donGiaMoi) {
        if (donGiaMoi < 0) {
            throw new IllegalArgumentException("Đơn giá phải >= 0");
        }

        HangHoa hangHoa = timKiemHangHoa(maHang);
        if (hangHoa != null) {
            hangHoa.setDonGia(donGiaMoi);
            return true;
        }
        return false;
    }
}

