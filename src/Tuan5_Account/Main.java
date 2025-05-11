package Tuan5_Account;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSach_Account arrAcc = new DanhSach_Account();
        System.out.print("Nhập số lượng tài khoản ban đầu: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; ++i) {
            System.out.println("Nhập thông tin cho tài khoản thứ " + (i + 1) + ": ");
            System.out.print("Nhập số tài khoản: ");
            long accountNumber = sc.nextLong();
            sc.nextLine();
            System.out.print("Nhập tên chủ tài khoản: ");
            String name = sc.nextLine();
            System.out.print("Nhập số dư ban đầu: ");
            double balance = sc.nextDouble();
            sc.nextLine();
            Account account = new Account(accountNumber, name, balance);
            arrAcc.themAcc(account);
        }

        while(true) {
            menu(arrAcc, sc);
        }
    }

    public static void deposit(DanhSach_Account arrAcc, Scanner sc) throws Exception {
        System.out.print("Nhập số tài khoản cần gửi thêm tiền: ");
        long acc = sc.nextLong();
        System.out.print("Nhập số tiền cần gửi: ");
        double money = sc.nextDouble();
        Account account = arrAcc.timAccount(acc);
        if (account != null) {
            try {
                account.deposit(money);
                System.out.println("Gửi tiền thành công!");
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        } else {
            System.out.println("Tài khoản không tồn tại.");
        }

    }

    public static void withdraw(DanhSach_Account arrAcc, Scanner sc) throws Exception {
        System.out.print("Nhập số tài khoản cần rút tiền: ");
        long acc = sc.nextLong();
        System.out.print("Nhập số tiền cần rút: ");
        double money = sc.nextDouble();
        Account account = arrAcc.timAccount(acc);
        if (account != null) {
            try {
                account.withdraw(money);
                System.out.println("Rút tiền thành công!");
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        } else {
            System.out.println("Tài khoản không tồn tại.");
        }

    }

    public static void inThongTin(DanhSach_Account arrAcc) {
        System.out.println("\nThông tin các tài khoản:");
        System.out.println("|Số tài khoản         | Chủ Tài Khoản        | Số dư");
        System.out.println(arrAcc);
    }

    public static void transfer(DanhSach_Account arrAcc, Scanner sc) throws Exception {
        System.out.print("Nhập số tài khoản người chuyển tiền: ");
        long acc1 = sc.nextLong();
        System.out.print("Nhập số tài khoản người nhận tiền: ");
        long acc2 = sc.nextLong();
        System.out.print("Nhập số tiền cần chuyển: ");
        double money = sc.nextDouble();
        Account accChuyen = arrAcc.timAccount(acc1);
        Account accNhan = arrAcc.timAccount(acc2);
        if (accChuyen != null && accNhan != null) {
            try {
                accChuyen.transfer(accNhan, money);
                System.out.println("Chuyển tiền thành công!");
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        } else {
            System.out.println("Có ít nhất 1 tài khoản không tồn tại.");
        }

    }

    public static void addAccount(DanhSach_Account arrAcc, Scanner sc) {
        System.out.print("Nhập số tài khoản mới: ");
        long acc = sc.nextLong();
        sc.nextLine();
        System.out.print("Nhập tên chủ tài khoản: ");
        String name = sc.nextLine();
        System.out.print("Nhập số dư: ");
        double balance = sc.nextDouble();
        if (balance < (double)50000.0F) {
            System.out.println("Số dư không hợp lệ");
        }

        sc.nextLine();
        Account account = new Account(acc, name, balance);
        arrAcc.themAcc(account);
        System.out.println("Thêm tài khoản thành công!");
    }

    public static void menu(DanhSach_Account arrAcc, Scanner sc) {
        System.out.println("\nChọn các thao tác:");
        System.out.println("1. Gửi tiền");
        System.out.println("2. Rút tiền");
        System.out.println("3. In thông tin các tài khoản");
        System.out.println("4. Chuyển tiền");
        System.out.println("5. Thêm tài khoản");
        System.out.println("6. Thoát");
        System.out.print("Mời nhập lựa chọn: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                try {
                    deposit(arrAcc, sc);
                } catch (Exception e) {
                    System.out.println("Lỗi khi gửi tiền: " + e.getMessage());
                }
                break;
            case 2:
                try {
                    withdraw(arrAcc, sc);
                } catch (Exception e) {
                    System.out.println("Lỗi khi rút tiền: " + e.getMessage());
                }
                break;
            case 3:
                inThongTin(arrAcc);
                break;
            case 4:
                try {
                    transfer(arrAcc, sc);
                } catch (Exception e) {
                    System.out.println("Lỗi khi chuyển tiền: " + e.getMessage());
                }
                break;
            case 5:
                addAccount(arrAcc, sc);
                break;
            case 6:
                System.out.println("Cảm ơn đã dùng chương trình.");
                sc.close();
                return;
            default:
                System.out.println("lựa chọn không hợp lệ");
        }

    }
}
