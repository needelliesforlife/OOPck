import java.util.Date;
import java.text.SimpleDateFormat;
public class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected double donGia;
    protected int soLuongTon;
    public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }
}

class HangThucPham extends HangHoa{
    private String nhaCungCap;
    private Date ngaySanXuat = new Date();
    private Date ngayHetHan = new Date();
    public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String nhaCungCap, Date ngaySanXuat, Date ngayHetHan) {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaCungCap = nhaCungCap;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-10s %-10s %10.3f %10d %-15s %-12s %-12s",
                maHang,
                tenHang,
                donGia,
                soLuongTon,
                nhaCungCap,
                dateFormat.format(ngaySanXuat),
                dateFormat.format(ngayHetHan)
        );
    }
}

class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private int congXuat;
    public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon, int thoiGianBaoHanh, int congXuat) {
        super(maHang, tenHang, donGia, soLuongTon);
        this.congXuat = congXuat;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-10s %-10s %10.3f %10d %-15d %-12d ",
                maHang,
                tenHang,
                donGia,
                soLuongTon,
                thoiGianBaoHanh,
                congXuat
        );
    }
}

class HangSanhSu extends HangHoa{
    private String nhaCungCap;
    private Date ngayNhapKho = new Date();
    public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon, String nhaSanXuat, Date ngayNhapKho) {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaCungCap = nhaCungCap;
        this.ngayNhapKho = ngayNhapKho;
    }
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-10s %-10s %10.3f %10d %-15s %-12s",
                maHang,
                tenHang,
                donGia,
                soLuongTon,
                nhaCungCap,
                dateFormat.format(ngayNhapKho)
        );
    }
}
