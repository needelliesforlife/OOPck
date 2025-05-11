package clonePhongHoc;

public abstract class phongThiNghiem extends Phonghoc{
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonRua;


    public phongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh, int sucChua, boolean coBonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.coBonRua = coBonRua;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public boolean isCoBonRua() {
        return coBonRua;
    }

    public void setCoBonRua(boolean coBonRua) {
        this.coBonRua = coBonRua;
    }
    public boolean datChuan() {
        return coBonRua;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" Chuyên ngành: %-10s Sức chứa: %-5d Có bồn rửa: %-7s Dat chuan: -10s", this.chuyenNganh, this.sucChua, (this.coBonRua ? "Có" : "Không"), (datChuan() ? "Co" : "Khong"));
    }
}
