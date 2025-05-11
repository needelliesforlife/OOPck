package phongHoc;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Comparator;

public class danhsachphonghoc {
	private List<phonghoc> dsphonghoc;
	
	public danhsachphonghoc() {this.dsphonghoc = new ArrayList<>();}
	public boolean themPhongHoc(phonghoc ph) {
		if (dsphonghoc.stream().anyMatch(p->p.getMaPhong().equals(ph.getMaPhong()))) {
			return false;
		}
		return dsphonghoc.add(ph);
	}
	
	public phonghoc timPhongHoc(String maPhong) {
		return dsphonghoc.stream().filter(p->p.getMaPhong().equals(maPhong)).findFirst()
.orElse(null);	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Danh sach phong hoc: \n");
		for (phonghoc p : dsphonghoc) {
			sb.append(p.toString()).append("\n");
		}
		return sb.toString();
	}
	
	public List<phonghoc> layDanhSachPhongHocDatChuan() {
		return dsphonghoc.stream().filter(phonghoc::datChuan).collect(Collectors.toList());
	}
	public void sapXepTheoDayNha() { dsphonghoc.sort(Comparator.comparing(phonghoc::getDayNha));}
	
	public void sapXepTheoDienTich() { dsphonghoc.sort(Comparator.comparing(phonghoc::getDienTich).reversed());}
	
	public void sapXepTheoSoBongDen() { dsphonghoc.sort(Comparator.comparing(phonghoc::getSoBongDen));}
	
	public boolean capNhatSoMayTinh(String maPhong, int soMayTinhMoi) {
		phonghoc ph = timPhongHoc(maPhong);
		if (ph instanceof phongmaytinh) {
			((phongmaytinh) ph).setSoMayTinh(soMayTinhMoi);
			return true;
		}
		return false;
	}
	public boolean xoaPhongHoc(String maPhong) { return dsphonghoc.remove(maPhong);}
	
    public int tinhTongSoPhongHoc() { return dsphonghoc.size(); }

    
	public List<phongmaytinh> layDSPhong60May() {
		return dsphonghoc.stream().filter(p->p instanceof phongmaytinh).map(p->(phongmaytinh)p).filter(p->p.getSoMayTinh()==60).collect(Collectors.toList());
	}
	
	public List<phonghoc> getDSphonghoc() {
		return dsphonghoc;
	}
	
	
}
