package clonePhongHoc;

public abstract class phongLyThuyet extends Phonghoc{
    private boolean coMayChieu;

    public phongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coMayChieu = coMayChieu;
    }

    public boolean isCoMayChieu() {
        return coMayChieu;
    }

    public void setCoMayChieu(boolean coMayChieu) {
        this.coMayChieu = coMayChieu;
    }

    public boolean datChuan() {
        return coMayChieu ;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" co May Chieu = %-10s Dat chuan: -10s", (this.coMayChieu ? "Có" : "Không"), (datChuan() ? "Co" : "Khong"));
    }
}
