package fakePhongHoc;

public class phongthuchanh extends phonghoc{
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonChua;

    public phongthuchanh(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh, int sucChua, boolean coBonChua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.coBonChua = coBonChua;
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

    public boolean isCoBonChua() {
        return coBonChua;
    }

    public void setCoBonChua(boolean coBonChua) {
        this.coBonChua = coBonChua;
    }

    boolean datChuan() {
        return coBonChua;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Chuyen Nganh: %s  Suc chua: %d   Co bon rua: %s", chuyenNganh, sucChua, (coBonChua ? "Co" : "Khong"));
    }
}
