package tuan6_giaodichnhadat;


import java.time.LocalDate;

public class GiaoDichNha extends GiaoDich {
    private String loaiNha; // "cao cấp", "thường"
    private String diaChi;
    
    public GiaoDichNha(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, 
                        String loaiNha, String diaChi) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }

    public String getLoaiNha() {
        return loaiNha;
    }

    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    @Override
    public double tinhThanhTien() {
        if (loaiNha.equalsIgnoreCase("cao cấp")) {
            return dienTich * donGia;
        } else {
            return dienTich * donGia * 0.9; // 90% của đơn giá
        }
    }
    
    @Override
    public String toString() {
        return String.format("%-10s| %s| %-10s| %-25s| %-15.2f", 
                "Nhà", 
                super.toString(), 
                loaiNha, 
                diaChi, 
                tinhThanhTien());
    }
}