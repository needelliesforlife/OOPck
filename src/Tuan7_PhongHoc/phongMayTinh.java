package Tuan7_PhongHoc;

public class PhongMayTinh extends phongHoc{
    private int soMayTinh;
        public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh ) {
            super(maPhong, dayNha, dienTich, soBongDen);
            this.soMayTinh = soMayTinh;
        }
        public int getSoMayTinh() {
            return soMayTinh;
        }
        public void setSoMayTinh(int soMayTinh) {
            this.soMayTinh = soMayTinh;
        }
        @Override
        public boolean datChuan() {
            return duAnhSang() && (soMayTinh <= Math.floor(getDienTich() / 1.5));
        }

        @Override
        public String toString() {
            return super.toString() +
                    " Số máy tính: " + soMayTinh +
                    ", Đạt chuẩn: " + (datChuan() ? "Có" : "Không");
        }
    }

