package clonePhongHoc;

public abstract class phongMayTinh extends Phonghoc{
    private int soMayTinh;

    public phongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    public void setSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }
    public boolean datChuan() {
        if (soMayTinh / dienTich >= 1.5) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("soMayTinh: %-10d Dat chuan: %-10s", soMayTinh, (datChuan() ? "Co" : "Khong"));
    }
}
