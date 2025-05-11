// Lớp trừu tượng HangHoa - lớp cơ sở
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class HangHoa {
    private String maHang; // không được sửa, không được để trống
    private String tenHang; // không được rỗng, mặc định là "xxx"
    private double donGia; // >= 0
    private int soLuongTon; // >= 0

    public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống");
        }
        this.maHang = maHang;

        if (tenHang == null || tenHang.trim().isEmpty()) {
            this.tenHang = "xxx";
        } else {
            this.tenHang = tenHang;
        }

        if (donGia < 0) {
            throw new IllegalArgumentException("Đơn giá phải >= 0");
        }
        this.donGia = donGia;

        if (soLuongTon < 0) {
            throw new IllegalArgumentException("Số lượng tồn phải >= 0");
        }
        this.soLuongTon = soLuongTon;
    }

    // Getters
    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    // Setters (không có setter cho maHang vì không được sửa)
    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên hàng không được để trống");
        }
        this.tenHang = tenHang;
    }

    public void setDonGia(double donGia) {
        if (donGia < 0) {
            throw new IllegalArgumentException("Đơn giá phải >= 0");
        }
        this.donGia = donGia;
    }

    public void setSoLuongTon(int soLuongTon) {
        if (soLuongTon < 0) {
            throw new IllegalArgumentException("Số lượng tồn phải >= 0");
        }
        this.soLuongTon = soLuongTon;
    }

    // Phương thức trừu tượng
    public abstract String danhGiaMucDoBanBuon();
    public abstract double tinhVAT();

    @Override
    public String toString() {
        return "Mã hàng: " + maHang +
                ", Tên hàng: " + tenHang +
                ", Đơn giá: " + donGia +
                ", Số lượng tồn: " + soLuongTon;
    }
}

// Lớp con HangThucPham
class HangThucPham extends HangHoa {
    private String nhaCungCap;
    private LocalDate ngaySanXuat; // phải trước ngày hiện tại, mặc định là ngày hiện tại
    private LocalDate ngayHetHan; // phải sau ngày sản xuất, mặc định là ngày sản xuất

    public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon,
                        String nhaCungCap, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaCungCap = nhaCungCap;

        // Kiểm tra ngày sản xuất
        if (ngaySanXuat == null) {
            this.ngaySanXuat = LocalDate.now();
        } else if (ngaySanXuat.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Ngày sản xuất phải trước ngày hiện tại");
        } else {
            this.ngaySanXuat = ngaySanXuat;
        }

        // Kiểm tra ngày hết hạn
        if (ngayHetHan == null) {
            this.ngayHetHan = this.ngaySanXuat;
        } else if (ngayHetHan.isBefore(this.ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất");
        } else {
            this.ngayHetHan = ngayHetHan;
        }
    }

    // Getters và Setters
    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        if (ngaySanXuat.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Ngày sản xuất phải trước ngày hiện tại");
        }
        if (ngayHetHan != null && ngaySanXuat.isAfter(ngayHetHan)) {
            throw new IllegalArgumentException("Ngày sản xuất phải trước ngày hết hạn");
        }
        this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if (ngayHetHan.isBefore(ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau ngày sản xuất");
        }
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        // Hàng thực phẩm, nếu vẫn còn tồn kho và bị hết hạn thì đánh giá là khó bán
        if (getSoLuongTon() > 0 && ngayHetHan.isBefore(LocalDate.now())) {
            return "Khó bán";
        }
        return "Không đánh giá";
    }

    @Override
    public double tinhVAT() {
        // VAT của hàng thực phẩm là 5%
        return 0.05 * getDonGia() * getSoLuongTon();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Nhà cung cấp: " + nhaCungCap +
                ", Ngày sản xuất: " + ngaySanXuat +
                ", Ngày hết hạn: " + ngayHetHan +
                ", Đánh giá: " + danhGiaMucDoBanBuon() +
                ", VAT: " + tinhVAT();
    }
}

// Lớp con HangDienMay
class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh; // >= 0 tháng
    private double congSuat; // >= 0 KW

    public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon,
                    int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, donGia, soLuongTon);

        if (thoiGianBaoHanh < 0) {
            throw new IllegalArgumentException("Thời gian bảo hành phải >= 0");
        }
        this.thoiGianBaoHanh = thoiGianBaoHanh;

        if (congSuat < 0) {
            throw new IllegalArgumentException("Công suất phải >= 0");
        }
        this.congSuat = congSuat;
    }

    // Getters và Setters
    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if (thoiGianBaoHanh < 0) {
            throw new IllegalArgumentException("Thời gian bảo hành phải >= 0");
        }
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        if (congSuat < 0) {
            throw new IllegalArgumentException("Công suất phải >= 0");
        }
        this.congSuat = congSuat;
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        // Hàng điện máy, nếu số lượng tồn kho <3 thì được đánh giá là bán được
        if (getSoLuongTon() < 3) {
            return "Bán được";
        }
        return "Không đánh giá";
    }

    @Override
    public double tinhVAT() {
        // VAT của hàng điện máy là 10%
        return 0.1 * getDonGia() * getSoLuongTon();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Thời gian bảo hành: " + thoiGianBaoHanh + " tháng" +
                ", Công suất: " + congSuat + " KW" +
                ", Đánh giá: " + danhGiaMucDoBanBuon() +
                ", VAT: " + tinhVAT();
    }
}

// Lớp con HangSanhSu
class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private LocalDate ngayNhapKho; // phải trước ngày hiện tại, mặc định là ngày hiện tại

    public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon,
                    String nhaSanXuat, LocalDate ngayNhapKho) {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaSanXuat = nhaSanXuat;

        // Kiểm tra ngày nhập kho
        if (ngayNhapKho == null) {
            this.ngayNhapKho = LocalDate.now();
        } else if (ngayNhapKho.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Ngày nhập kho phải trước ngày hiện tại");
        } else {
            this.ngayNhapKho = ngayNhapKho;
        }
    }

    // Getters và Setters
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public LocalDate getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(LocalDate ngayNhapKho) {
        if (ngayNhapKho.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Ngày nhập kho phải trước ngày hiện tại");
        }
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public String danhGiaMucDoBanBuon() {
        // Hàng sành sứ, nếu số lượng tồn kho >50 và thời gian lưu kho >10 ngày thì đánh giá là bán chậm
        long thoiGianLuuKho = ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
        if (getSoLuongTon() > 50 && thoiGianLuuKho > 10) {
            return "Bán chậm";
        }
        return "Không đánh giá";
    }

    @Override
    public double tinhVAT() {
        // VAT của hàng sành sứ là 10%
        return 0.1 * getDonGia() * getSoLuongTon();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Nhà sản xuất: " + nhaSanXuat +
                ", Ngày nhập kho: " + ngayNhapKho +
                ", Đánh giá: " + danhGiaMucDoBanBuon() +
                ", VAT: " + tinhVAT();
    }
}
