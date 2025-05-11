package tuan6_giaodichnhadat;


import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DanhSachGiaoDich {
    private ArrayList<GiaoDich> dsGiaoDich;
    
    public DanhSachGiaoDich() {
        dsGiaoDich = new ArrayList<>();
    }
    
    public void themGiaoDich(GiaoDich gd) {
        dsGiaoDich.add(gd);
    }
    
    public void xoaGiaoDich(GiaoDich gd) {
        dsGiaoDich.remove(gd);
    }
    
    public GiaoDich timGiaoDich(String maGiaoDich) {
        for (GiaoDich gd : dsGiaoDich) {
            if (gd.getMaGiaoDich().equals(maGiaoDich)) {
                return gd;
            }
        }
        return null;
    }
    
    public int demSoLuongGiaoDichDat() {
        int count = 0;
        for (GiaoDich gd : dsGiaoDich) {
            if (gd instanceof GiaoDichDat) {
                count++;
            }
        }
        return count;
    }
    
    public int demSoLuongGiaoDichNha() {
        int count = 0;
        for (GiaoDich gd : dsGiaoDich) {
            if (gd instanceof GiaoDichNha) {
                count++;
            }
        }
        return count;
    }
    
    public double tinhTrungBinhThanhTienGiaoDichDat() {
        double tongThanhTien = 0;
        int count = 0;
        
        for (GiaoDich gd : dsGiaoDich) {
            if (gd instanceof GiaoDichDat) {
                tongThanhTien += gd.tinhThanhTien();
                count++;
            }
        }
        
        return count > 0 ? tongThanhTien / count : 0;
    }
    
    public void xuatGiaoDichThang9Nam2013() {
        System.out.println("\n== Các giao dịch tháng 9 năm 2013 ==");
        System.out.println("Loại      | Mã GD      | Ngày GD      | Đơn giá        | Diện tích  | Thông tin khác                | Thành tiền     ");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        
        boolean found = false;
        for (GiaoDich gd : dsGiaoDich) {
            if (gd.getNgayGiaoDich().getMonthValue() == 9 && gd.getNgayGiaoDich().getYear() == 2013) {
                System.out.println(gd);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Không có giao dịch nào trong tháng 9 năm 2013.");
        }
    }
    
    public void xuatTatCaGiaoDich() {
        System.out.println("\n== Danh sách tất cả các giao dịch ==");
        System.out.println("Loại      | Mã GD      | Ngày GD      | Đơn giá        | Diện tích  | Thông tin khác                | Thành tiền     ");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        
        for (GiaoDich gd : dsGiaoDich) {
            System.out.println(gd);
        }
    }
    
    public void xuatGiaoDichDat() {
        System.out.println("\n== Danh sách các giao dịch đất ==");
        System.out.println("Loại      | Mã GD      | Ngày GD      | Đơn giá        | Diện tích  | Loại đất   | Thành tiền     ");
        System.out.println("----------------------------------------------------------------------------------------------");
        
        boolean found = false;
        for (GiaoDich gd : dsGiaoDich) {
            if (gd instanceof GiaoDichDat) {
                System.out.println(gd);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Không có giao dịch đất nào.");
        }
    }
    
    public void xuatGiaoDichNha() {
        System.out.println("\n== Danh sách các giao dịch nhà ==");
        System.out.println("Loại      | Mã GD      | Ngày GD      | Đơn giá        | Diện tích  | Loại nhà   | Địa chỉ                  | Thành tiền     ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        
        boolean found = false;
        for (GiaoDich gd : dsGiaoDich) {
            if (gd instanceof GiaoDichNha) {
                System.out.println(gd);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Không có giao dịch nhà nào.");
        }
    }
    
    public void nhapGiaoDich(Scanner sc) {
        System.out.println("\n== Nhập thông tin giao dịch ==");
        
        System.out.println("Chọn loại giao dịch:");
        System.out.println("1. Giao dịch đất");
        System.out.println("2. Giao dịch nhà");
        System.out.print("Nhập lựa chọn: ");
        
        int loaiGd;
        try {
            loaiGd = Integer.parseInt(sc.nextLine());
            if (loaiGd != 1 && loaiGd != 2) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 1 hoặc 2.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 1 hoặc 2.");
            return;
        }
        
        System.out.print("Mã giao dịch: ");
        String maGd = sc.nextLine();
        
        // Kiểm tra trùng mã
        if (timGiaoDich(maGd) != null) {
            System.out.println("Mã giao dịch đã tồn tại. Vui lòng nhập lại!");
            return;
        }
        
        System.out.print("Ngày giao dịch (dd/MM/yyyy): ");
        LocalDate ngayGd;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ngayGd = LocalDate.parse(sc.nextLine(), formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy!");
            return;
        }
        
        System.out.print("Đơn giá: ");
        double donGia;
        try {
            donGia = Double.parseDouble(sc.nextLine());
            if (donGia <= 0) {
                System.out.println("Đơn giá phải lớn hơn 0. Vui lòng nhập lại!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Đơn giá không hợp lệ. Vui lòng nhập lại!");
            return;
        }
        
        System.out.print("Diện tích: ");
        double dienTich;
        try {
            dienTich = Double.parseDouble(sc.nextLine());
            if (dienTich <= 0) {
                System.out.println("Diện tích phải lớn hơn 0. Vui lòng nhập lại!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Diện tích không hợp lệ. Vui lòng nhập lại!");
            return;
        }
        
        if (loaiGd == 1) {
            System.out.print("Loại đất (A/B/C): ");
            String loaiDat = sc.nextLine().toUpperCase();
            
            if (!loaiDat.equals("A") && !loaiDat.equals("B") && !loaiDat.equals("C")) {
                System.out.println("Loại đất phải là A, B hoặc C. Vui lòng nhập lại!");
                return;
            }
            
            GiaoDichDat gd = new GiaoDichDat(maGd, ngayGd, donGia, dienTich, loaiDat);
            themGiaoDich(gd);
            System.out.println("Đã thêm giao dịch đất thành công!");
            
        } else {
            System.out.print("Loại nhà (cao cấp/thường): ");
            String loaiNha = sc.nextLine().toLowerCase();
            
            if (!loaiNha.equals("cao cấp") && !loaiNha.equals("thường")) {
                System.out.println("Loại nhà phải là 'cao cấp' hoặc 'thường'. Vui lòng nhập lại!");
                return;
            }
            
            System.out.print("Địa chỉ: ");
            String diaChi = sc.nextLine();
            if (diaChi.trim().isEmpty()) {
                System.out.println("Địa chỉ không thể để trống. Vui lòng nhập lại!");
                return;
            }
            
            GiaoDichNha gd = new GiaoDichNha(maGd, ngayGd, donGia, dienTich, loaiNha, diaChi);
            themGiaoDich(gd);
            System.out.println("Đã thêm giao dịch nhà thành công!");
        }
    }
    
    public void xuatThongKe() {
        int soLuongDat = demSoLuongGiaoDichDat();
        int soLuongNha = demSoLuongGiaoDichNha();
        double tbThanhTienDat = tinhTrungBinhThanhTienGiaoDichDat();
        
        Locale vn = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(vn);
        
        System.out.println("\n== Thống kê giao dịch ==");
        System.out.println("- Số lượng giao dịch đất: " + soLuongDat);
        System.out.println("- Số lượng giao dịch nhà: " + soLuongNha);
        System.out.println("- Trung bình thành tiền giao dịch đất: " + formatter.format(tbThanhTienDat));
    }
}