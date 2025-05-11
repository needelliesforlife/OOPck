package tuan5_chuyenxe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class danhSachChuyenXe {
    private ArrayList<chuyenXe> dsChuyenXe;

    public danhSachChuyenXe() {
        dsChuyenXe = new ArrayList<>();
    }

    public void themChuyenXe(chuyenXe cx) {
        dsChuyenXe.add(cx);
    }

    public void xoa(chuyenXe xe) {
        dsChuyenXe.remove(xe);
    }

    public void sua(chuyenXe xe) {
        int vt = timKiemViTri(xe.getMaChuyenxe());
        dsChuyenXe.set(vt, xe);
    }

    public double tinhDoanhThu() {
        double s = 0;
        for (chuyenXe xe : dsChuyenXe) {
            s += xe.getDoanhThu();
        }
        return s;
    }

    private int timKiemViTri(String maChuyenXe) {
        for (int i = 0; i < dsChuyenXe.size(); i++) {
            if (dsChuyenXe.get(i).getMaChuyenxe().equals(maChuyenXe)) {
                return i;
            }
        }
        return -1;
    }



    public chuyenXe timChuyenXe(String maChuyenXe) {
        for (chuyenXe cx : dsChuyenXe) {
            if (cx.getMaChuyenxe().equals(maChuyenXe)) {
                return cx;
            }
        }
        return null;
    }

    public void xuatDanhSachNoiThanh() {
        System.out.printf("%-20s| %-34s| %-20s| %-20s| %-20s| %-20s|\n",
            "Mã Chuyến", "Tài Xế", "Số Xe", "Doanh Thu", "Số Tuyến", "Số Km");
        for (chuyenXe cx : dsChuyenXe) {
            if (cx instanceof noiThanh) {
                System.out.println(cx);
            }
        }
    }

    public void xuatDanhSachNgoaiThanh() {
        System.out.printf("%-20s| %-34s| %-20s| %-20s| %-20s| %-20s|\n",
            "Mã Chuyến", "Tài Xế", "Số Xe", "Doanh Thu", "Nơi đến", "Số ngày đi");
        for (chuyenXe cx : dsChuyenXe) {
            if (cx instanceof ngoaiThanh) {
                System.out.println(cx);
            }
        }
    }

    
    public void nhapChuyenXe(Scanner sc) {
        System.out.println("\n== Nhập thông tin chuyến xe ==");
        
        System.out.println("Chọn loại chuyến xe:");
        System.out.println("1. Chuyến xe nội thành");
        System.out.println("2. Chuyến xe ngoại thành");
        System.out.print("Nhập lựa chọn: ");
        
        int loaiXe = sc.nextInt();
        sc.nextLine();
        
        if (loaiXe != 1 && loaiXe != 2) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 1 hoặc 2.");
            return;
        }
        
        System.out.print("Mã chuyến xe: ");
        String maChuyenXe = sc.nextLine();
        
        // Kiểm tra trùng mã
        if (timChuyenXe(maChuyenXe) != null) {
            System.out.println("Mã chuyến xe đã tồn tại. Vui lòng nhập lại!");
            return;
        }
        
        System.out.print("Họ tên tài xế: ");
        String hoTenTaiXe = sc.nextLine();
        
        System.out.print("Số xe: ");
        String soXe = sc.nextLine();
        
        System.out.print("Doanh thu: ");
        double doanhThu = 0;
        try {
            doanhThu = Double.parseDouble(sc.nextLine());
            if (doanhThu < 0) {
                System.out.println("Doanh thu không thể âm. Vui lòng nhập lại!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Doanh thu không hợp lệ. Vui lòng nhập lại!");
            return;
        }
        
        if (loaiXe == 1) {
            System.out.print("Số tuyến: ");
            int soTuyen = 0;
            try {
                soTuyen = Integer.parseInt(sc.nextLine());
                if (soTuyen <= 0) {
                    System.out.println("Số tuyến phải lớn hơn 0. Vui lòng nhập lại!");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Số tuyến không hợp lệ. Vui lòng nhập lại!");
                return;
            }
            
            System.out.print("Số km: ");
            int soKm = 0;
            try {
                soKm = Integer.parseInt(sc.nextLine());
                if (soKm <= 0) {
                    System.out.println("Số km phải lớn hơn 0. Vui lòng nhập lại!");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Số km không hợp lệ. Vui lòng nhập lại!");
                return;
            }
            
            noiThanh chuyenXe = new noiThanh(maChuyenXe, hoTenTaiXe, soXe, doanhThu, soTuyen, soKm);
            themChuyenXe(chuyenXe);
            System.out.println("Đã thêm chuyến xe nội thành thành công!");
            
        } else {
            System.out.print("Nơi đến: ");
            String noiDen = sc.nextLine();
            if (noiDen.trim().isEmpty()) {
                System.out.println("Nơi đến không thể để trống. Vui lòng nhập lại!");
                return;
            }
            
            System.out.print("Số ngày đi: ");
            int soNgay = 0;
            try {
                soNgay = Integer.parseInt(sc.nextLine());
                if (soNgay <= 0) {
                    System.out.println("Số ngày đi phải lớn hơn 0. Vui lòng nhập lại!");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Số ngày đi không hợp lệ. Vui lòng nhập lại!");
                return;
            }
            
            ngoaiThanh chuyenXe = new ngoaiThanh(maChuyenXe, hoTenTaiXe, soXe, doanhThu, noiDen, soNgay);
            themChuyenXe(chuyenXe);
            System.out.println("Đã thêm chuyến xe ngoại thành thành công!");
        }
    }
    
    public void xuatDanhSachTatCa() {
        System.out.println("\n== Danh sách tất cả các chuyến xe ==");
        System.out.println("\n-- Danh sách chuyến xe nội thành --");
        xuatDanhSachNoiThanh();
        System.out.println("\n-- Danh sách chuyến xe ngoại thành --");
        xuatDanhSachNgoaiThanh();
    }

    public void sortTheoTenTaiXe() {
        Collections.sort(dsChuyenXe, new Comparator<chuyenXe>() {
            @Override
            public int compare(chuyenXe o1, chuyenXe o2) {
                return o1.getHoTenTaiXe().compareToIgnoreCase(o2.getHoTenTaiXe());
            }
        });
    }

    public void sortTheoDoanhThu() {
        Collections.sort(dsChuyenXe, new Comparator<chuyenXe>() {
            @Override
            public int compare(chuyenXe o1, chuyenXe o2) {
                return Double.compare(o1.getDoanhThu(), o2.getDoanhThu());
            }
        });
    }

  
}
