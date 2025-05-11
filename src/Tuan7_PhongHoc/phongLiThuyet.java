package Tuan7_PhongHoc;

public class PhongLiThuyet extends phongHoc{
        boolean coMayChieu;
        public PhongLiThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
            super(maPhong, dayNha, dienTich, soBongDen);
            this.coMayChieu = coMayChieu;
        }

        public boolean isCoMayChieu() {
            return coMayChieu;
        }
        @Override
        public boolean datChuan() {
            return duAnhSang() && coMayChieu;
        }

        @Override
        public String toString() {
            return super.toString() +
                    " Có máy chiếu: " + (isCoMayChieu() ? "Có" : "Không") +
                    ", Đạt chuẩn: " + (datChuan() ? "Có" : "Không");
        }
    }

