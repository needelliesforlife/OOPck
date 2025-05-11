package banHangThucPham;
import java.time.LocalDate;
import java.util.Scanner;
public class KiemThu_HangThucPham {
	public static void main(String[] args) {
		System.out.println("Chương trình nhập Hàng Thực Phẩm");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số lượng hàng thực phẩm ban đầu: ");
		int soLuong = scanner.nextInt();
		scanner.nextLine();     
		HangThucPham[] dsHang = new HangThucPham[soLuong];
		int soLuongHangHT = 0;
		int luaChon;
		do {
			System.out.println("\n--- Menu ---");
			System.out.println("1. Thêm hàng thực phẩm");
			System.out.println("2. Hiển thị danh sách hàng thực phẩm");
			System.out.println("3. Thoát");
			System.out.print("Nhập lựa chọn của bạn: ");
			luaChon = scanner.nextInt();
			scanner.nextLine();
			switch (luaChon) {

			case 1:
				try {
					if (soLuongHangHT == dsHang.length) {
						HangThucPham[] tempHang = new HangThucPham[dsHang.length * 2];
						System.arraycopy(dsHang, 0, tempHang, 0, dsHang.length);
						dsHang = tempHang;
					}
					System.out.println("\nNhập thông tin hàng mới:");
					System.out.print("Nhập mã hàng: ");
					String maHang = scanner.nextLine();
					System.out.print("Nhập tên hàng: ");
					String tenHang = scanner.nextLine();
					System.out.print("Nhập đơn giá: ");
					double donGia = scanner.nextDouble();
					scanner.nextLine();
					System.out.print("Nhập ngày sản xuất (yyyy-MM-dd): ");
					LocalDate ngaySanXuat = LocalDate.parse(scanner.nextLine());
					System.out.print("Nhập ngày hết hạn (yyyy-MM-dd): ");
					LocalDate ngayHetHan = LocalDate.parse(scanner.nextLine());
					HangThucPham hang = new HangThucPham(maHang, tenHang, donGia, ngaySanXuat, ngayHetHan);
					dsHang[soLuongHangHT++] = hang;
					System.out.println("Thêm hàng thành công!");
				} catch (Exception e) {
					System.out.println("Có lỗi xảy ra: " + e.getMessage());
				}
				break;
			case 2:
				if (soLuongHangHT == 0) {
					System.out.println("Danh sách trống.");
				} else {
					TieuDeCot();
					for (int i = 0; i < soLuongHangHT; i++) {
						HangThucPham hang = dsHang[i];
						System.out.printf("%-10s%-15s%-15.2f%-15s%-15s\n",
								hang.getMaHang(),
								hang.getTenHang(),
								hang.getDonGia(),
								hang.getNgaySanXuat(),
								hang.getNgayHetHan());
					}
				}
				break;
			case 3:
				System.out.println("Cảm ơn đã sử dụng chương trình");
				break;
			default:
				System.out.println("Vui lòng chọn lại.");
			}
		} while (luaChon <3);

		scanner.close();
	}
	public static void TieuDeCot() {
		System.out.printf("%-10s%-15s%-15s%-15s%-15s\n", "Mã Hàng", "Tên Hàng", "Đơn Giá", "Ngày Sản Xuất", "Ngày Hết Hạn");
		System.out.println("--------------------------------------------------------------------------------");
	}
	
}
