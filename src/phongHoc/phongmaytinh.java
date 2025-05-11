package phongHoc;

public class phongmaytinh extends phonghoc{
    private int soMayTinh;

    public phongmaytinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    public void setSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }

    boolean datChuan() {
        return (this.soMayTinh / getDienTich() >= 1.5);
    }
}