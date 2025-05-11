package Tuan7_PhongHoc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class quanLiPhongHoc {
    private List<phongHoc> danhSachPhongHoc;

    public quanLiPhongHoc() {
        this.danhSachPhongHoc = new ArrayList<>();
    }

    // Thêm một phòng học vào danh sách (không trùng mã phòng)
    public boolean themPhongHoc(phongHoc phongHoc) {
        // Kiểm tra trùng mã phòng
        if (danhSachPhongHoc.stream().anyMatch(p -> p.getMaPhong().equals(phongHoc.getMaPhong()))) {
            return false;
        }
        return danhSachPhongHoc.add(phongHoc);
    }

    // Tìm kiếm phòng học khi biết mã phòng
    public phongHoc timPhongHoc(String maPhong) {
        return danhSachPhongHoc.stream()
                .filter(p -> p.getMaPhong().equals(maPhong))
                .findFirst()
                .orElse(null);
    }

    // Lấy thông tin toàn bộ danh sách các phòng học
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DANH SÁCH PHÒNG HỌC:\n");
        for (phongHoc phongHoc : danhSachPhongHoc) {
            sb.append(phongHoc.toString()).append("\n");
        }
        return sb.toString();
    }

    // Lấy danh sách các phòng học đạt chuẩn
    public List<phongHoc> layDanhSachPhongDatChuan() {
        return danhSachPhongHoc.stream()
                .filter(phongHoc::datChuan)
                .collect(Collectors.toList());
    }

    // Sắp xếp danh sách tăng dần theo dãy nhà
    public void sapXepTheoDayNha() {
        danhSachPhongHoc.sort(Comparator.comparing(phongHoc::getDayNha));
    }

    // Sắp xếp danh sách giảm dần theo diện tích
    public void sapXepTheoDienTich() {
        danhSachPhongHoc.sort(Comparator.comparing(phongHoc::getDienTich).reversed());
    }

    // Sắp xếp danh sách tăng dần theo số bóng đèn
    public void sapXepTheoSoBongDen() {
        danhSachPhongHoc.sort(Comparator.comparing(phongHoc::getSoBongDen));
    }

    // Cập nhật số máy tính cho một phòng máy tính nào đó khi biết mã phòng
    public boolean capNhatSoMayTinh(String maPhong, int soMayTinhMoi) {
        phongHoc phongHoc = timPhongHoc(maPhong);
        if (phongHoc instanceof PhongMayTinh) {
            ((PhongMayTinh) phongHoc).setSoMayTinh(soMayTinhMoi);
            return true;
        }
        return false;
    }

    // Xóa một phòng học nào đó khi biết mã phòng
    public boolean xoaPhongHoc(String maPhong) {
        return danhSachPhongHoc.removeIf(p -> p.getMaPhong().equals(maPhong));
    }

    // Tính tổng số phòng học
    public int tinhTongSoPhongHoc() {
        return danhSachPhongHoc.size();
    }

    // Lấy danh sách các phòng máy có 60 máy
    public List<PhongMayTinh> layDanhSachPhongMay60May() {
        return danhSachPhongHoc.stream()
                .filter(p -> p instanceof PhongMayTinh)
                .map(p -> (PhongMayTinh) p)
                .filter(p -> p.getSoMayTinh() == 60)
                .collect(Collectors.toList());
        
    }

    public List<phongHoc> getDanhSachPhongHoc() {
        return danhSachPhongHoc;
    }
}

