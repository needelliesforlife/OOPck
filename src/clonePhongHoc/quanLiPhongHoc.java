package clonePhongHoc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class quanLiPhongHoc {
    private List<Phonghoc> danhSachPhongHoc;

    public quanLiPhongHoc() {this.danhSachPhongHoc = new ArrayList<>();}
    public boolean themPhongHoc(Phonghoc phonghoc) {
        if (danhSachPhongHoc.stream().anyMatch(p->p.getMaPhong().equals(phonghoc.getMaPhong()))) {
            return false;
        }
        return danhSachPhongHoc.add(phonghoc);
    }


    public Phonghoc timPhongHoc(String maPhong) {
        return danhSachPhongHoc.stream()
                .filter(p->p.getMaPhong().equals(maPhong))
                .findFirst()
                .orElse(null);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Danh sach phong hoc: \n");
        for (Phonghoc p : danhSachPhongHoc) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    public List<Phonghoc> layDanhSachPhongHocDatChuan() {
        return danhSachPhongHoc.stream()
                .filter(Phonghoc::datChuan)
                .collect(Collectors.toList());
    }

    public void sapXepTheoDayNha() {danhSachPhongHoc.sort(Comparator.comparing(Phonghoc::getDayNha));}

    public void sapXepTheoDienTich() {danhSachPhongHoc.sort(Comparator.comparing(Phonghoc::getDienTich).reversed());}

    public void sapXepTheoSoBongDen() {danhSachPhongHoc.sort(Comparator.comparing(Phonghoc::getSoBongDen));}

    public boolean capNhatSoMayTinh(String maPhong, int soMayTinhMoi) {
        Phonghoc phonghoc = timPhongHoc(maPhong);
        if (phonghoc instanceof phongMayTinh) {
            ((phongMayTinh) phonghoc).setSoMayTinh(soMayTinhMoi);
            return true;
        }
        return false;
    }

    public boolean xoaPhongHoc(String maPhong) {
        return danhSachPhongHoc.removeIf(p->p.getMaPhong().equals(maPhong));
    }

    public int tinhTongSoPhongHoc() { return danhSachPhongHoc.size(); }


    public List<phongMayTinh> LayDanhSachPhong60May() {
        return danhSachPhongHoc.stream()
                .filter(p ->p instanceof phongMayTinh)
                .map(p->(phongMayTinh) p)
                .filter(p->p.getSoMayTinh()==60)
                .collect(Collectors.toList());
    }

 public List<Phonghoc> getDanhSachPhongHoc() {return danhSachPhongHoc;}





}
