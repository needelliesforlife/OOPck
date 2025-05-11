package Tuan7_PhongHoc;

public class PhongThiNghiem extends phongHoc {
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonRua;
    public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh, int sucChua, boolean coBonRua)
    {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.coBonRua = coBonRua;
    }
    public String getChuyenNganh() {
        return chuyenNganh;
    }
    public int getSucChua() {
        return sucChua;
    }
    public boolean isCoBonRua() {
        return coBonRua;
    }
    @Override
    public boolean datChuan() {
        return duAnhSang() && coBonRua;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Chuyên ngành: " + chuyenNganh +
                ", Sức chứa: " + sucChua +
                ", Có bồn rửa: " + (isCoBonRua()? "Có" : "Không") +
                ", Đạt chuẩn: " + (datChuan() ? "Có" : "Không");
    }
}

