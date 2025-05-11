package tuan5_chuyenxe;

public class ngoaiThanh extends chuyenXe {
	private String noiDen;
	private int soNgay;
	
	public ngoaiThanh(String maChuyenxe, String hoTenTaiXe, String soXe, double doanhThu) {
		super(maChuyenxe, hoTenTaiXe, soXe, doanhThu);
	}

	public ngoaiThanh(String maChuyenxe, String hoTenTaiXe, String soXe, double doanhThu, String noiDen, int soNgay) {
		super(maChuyenxe, hoTenTaiXe, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgay = soNgay;
	}

	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public int getSoNgay() {
		return soNgay;
	}

	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}

	@Override
	public String toString() {
		String parentString = super.toString();
		return String.format("%-20s| %-20s| %-20d|", parentString, noiDen, soNgay);
	}

	
}
