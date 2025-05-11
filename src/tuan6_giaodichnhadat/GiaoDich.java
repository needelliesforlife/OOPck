package tuan6_giaodichnhadat;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class GiaoDich {
    protected String maGiaoDich;
    protected LocalDate ngayGiaoDich;
    protected double donGia;
    protected double dienTich;

    public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }
    
    public double tinhThanhTien() {
        return 0.0; // Sẽ được ghi đè trong các lớp con
    }
    
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale vn = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(vn);
        
        return String.format("%-10s| %-12s| %-15s| %-10.2f", 
                maGiaoDich, 
                ngayGiaoDich.format(dtf), 
                formatter.format(donGia), 
                dienTich);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(maGiaoDich, ngayGiaoDich, donGia, dienTich);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GiaoDich other = (GiaoDich) obj;
        return Objects.equals(maGiaoDich, other.maGiaoDich)
                && Objects.equals(ngayGiaoDich, other.ngayGiaoDich)
                && Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
                && Double.doubleToLongBits(dienTich) == Double.doubleToLongBits(other.dienTich);
    }
}