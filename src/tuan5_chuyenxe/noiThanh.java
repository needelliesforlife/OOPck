package tuan5_chuyenxe;
public class noiThanh extends chuyenXe {
	private int soTuyen;
	private int soKm;
	
	public noiThanh(String maChuyenxe, String hoTenTaiXe, String soXe, double doanhThu) {
		super(maChuyenxe, hoTenTaiXe, soXe, doanhThu);
		
	}

	public noiThanh(String maChuyenxe, String hoTenTaiXe, String soXe, double doanhThu, int soTuyen, int soKm) {
		super(maChuyenxe, hoTenTaiXe, soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKm = soKm;
	}

	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}

	public int getSoKm() {
		return soKm;
	}

	public void setSoKm(int soKm) {
		this.soKm = soKm;
	}

	@Override
	public String toString() {
		String parentString = super.toString();
		return String.format("%-20s| %-20d| %-20d|", parentString, soTuyen, soKm);
	}

}

