package fakePhongHoc;

public class phonglithuyet extends phonghoc{
    private boolean coMayChieu;

    public phonglithuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coMayChieu = coMayChieu;
    }

    public boolean isCoMayChieu() {
        return coMayChieu;
    }

    public void setCoMayChieu(boolean coMayChieu) {
        this.coMayChieu = coMayChieu;
    }
    boolean datChuan(){
        return coMayChieu;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" Co May Chieu: %s Dat chuan: %s", (coMayChieu ? "Co" : "khong"));
    }
}
