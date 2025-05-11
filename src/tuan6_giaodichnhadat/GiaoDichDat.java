package tuan6_giaodichnhadat;

import java.time.LocalDate;

public class GiaoDichDat extends GiaoDich {
    private String loaiDat; // "A", "B", "C"
    
    public GiaoDichDat(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, String loaiDat) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiDat = loaiDat;
    }

    public String getLoaiDat() {
        return loaiDat;
    }

    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }
    
    @Override
    public double tinhThanhTien() {
        if (loaiDat.equalsIgnoreCase("A")) {
            return dienTich * donGia * 1.5;
        } else {
            return dienTich * donGia;
        }
    }
    
    @Override
    public String toString() {
        return String.format("%-10s| %s| %-10s| %-15.2f", 
                "Đất", 
                super.toString(), 
                loaiDat, 
                tinhThanhTien());
    }
}