package banHangThucPham;
import java.time.LocalDate;
public class HangThucPham {
	private final String maHang;
	private String tenHang;
	private double donGia;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) throws Exception {
		if (tenHang == null || tenHang.trim().isEmpty()) {
			throw new Exception("Tên hàng không được để rỗng !!!");
		}
		this.tenHang = tenHang;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) throws Exception {
		if (donGia < 0) {
			throw new Exception("Đơn giá phải lớn hơn hoặc bằng 0 !!!");
		}
		this.donGia = donGia;
	}
	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}
	public void setNgaySanXuat(LocalDate ngaySanXuat) throws Exception {
		LocalDate now = LocalDate.now();
		if (ngaySanXuat == null || !ngaySanXuat.isBefore(now)) {
			throw new Exception("Ngày sản xuất phải trước ngày hiện tại.");
		}
		this.ngaySanXuat = ngaySanXuat;
		if (!ngayHetHan.isAfter(this.ngaySanXuat)) {
			this.ngayHetHan = this.ngaySanXuat;
		}
	}
	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(LocalDate ngayHetHan) throws Exception {
		if (ngayHetHan == null || !ngayHetHan.isAfter(this.ngaySanXuat)) {
			throw new Exception("Ngày hết hạn phải sau ngày sản xuất !!!");
		}
		this.ngayHetHan = ngayHetHan;
	}
	public String getMaHang() {
		return maHang;
	}
	public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) throws Exception{
		super();
		if(maHang==null || maHang.trim().isEmpty()) {
			throw new Exception("Mã hàng không được để rỗng !!!");
		}
		this.maHang = maHang;		
		this.tenHang = (tenHang== null || tenHang.trim().isEmpty()) ? "xxx" : tenHang;
		if (donGia < 0) {
			throw new Exception("Đơn giá phải lớn hơn hoặc bằng 0 !!!");
		}
		this.donGia = donGia;
		LocalDate now = LocalDate.now();
		this.ngaySanXuat = (ngaySanXuat == null || !ngaySanXuat.isBefore(now)) ? now : ngaySanXuat;
		if (ngayHetHan == null || !ngayHetHan.isAfter(this.ngaySanXuat)) {
			throw new Exception("Ngày hết hạn phải sau ngày sản xuất !!!");
		} else {
			this.ngayHetHan = ngayHetHan;
		}
	}
	@Override
	public String toString() {
	    return String.format("%-10s%-15s%-15.2f%-15s%-15s",
	            getMaHang(), getTenHang(), getDonGia(), getNgaySanXuat(), getNgayHetHan());
	}
	
}
