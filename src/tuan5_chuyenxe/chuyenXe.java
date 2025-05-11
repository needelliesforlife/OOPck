package tuan5_chuyenxe;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class chuyenXe {
	@Override
	public int hashCode() {
		return Objects.hash(doanhThu, hoTenTaiXe, maChuyenxe, soXe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		chuyenXe other = (chuyenXe) obj;
		return Double.doubleToLongBits(doanhThu) == Double.doubleToLongBits(other.doanhThu)
				&& Objects.equals(hoTenTaiXe, other.hoTenTaiXe) && Objects.equals(maChuyenxe, other.maChuyenxe)
				&& Objects.equals(soXe, other.soXe);
	}




	protected String maChuyenxe;
	protected String hoTenTaiXe;
	protected String soXe;
	protected double doanhThu;
	
	
	public chuyenXe(String maChuyenxe, String hoTenTaiXe, String soXe, double doanhThu) {
		super();
		this.maChuyenxe = maChuyenxe;
		this.hoTenTaiXe = hoTenTaiXe;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}
	
	

	public String getMaChuyenxe() {
		return maChuyenxe;
	}


	public void setMaChuyenxe(String maChuyenxe) {
		this.maChuyenxe = maChuyenxe;
	}


	public String getHoTenTaiXe() {
		return hoTenTaiXe;
	}


	public void setHoTenTaiXe(String hoTenTaiXe) {
		this.hoTenTaiXe = hoTenTaiXe;
	}


	public String getSoXe() {
		return soXe;
	}


	public void setSoXe(String soXe) {
		this.soXe = soXe;
	}


	public double getDoanhThu() {
		return doanhThu;
	}


	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}
	
	


	@Override
	public String toString() {
		Locale money = new Locale("vi", "VN"); //Locale money = new Locale("Vi", "VN");
		NumberFormat form = NumberFormat.getCurrencyInstance(money);
		return String.format("%-20s| %-35s| %-20s|%-20s", maChuyenxe, hoTenTaiXe, soXe, form.format(doanhThu));
	
	}
	

	
}


