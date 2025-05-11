package Tuan5_Account;

public class DanhSach_Account {
    private Account[] accounts;
    private int count;
    private int capacity;

    public DanhSach_Account() {
        this.capacity = 100;
        this.accounts = new Account[this.capacity];
        this.count = 0;
    }

    public DanhSach_Account(int capacity) {
        this.capacity = capacity;
        this.accounts = new Account[capacity];
        this.count = 0;
    }

    public void themAcc(Account account) {
        if (this.count < this.capacity) {
            this.accounts[this.count++] = account;
        } else {
            System.out.println("Danh sách tài khoản đã đầy!");
        }

    }

    public boolean xoaAccount(long accountNumber) {
        int index = -1;
        for(int i = 0; i < this.count; ++i) {
            if (this.accounts[i].getAccountNumber() == accountNumber) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        } else {
            for(int i = index; i < this.count - 1; ++i) {
                this.accounts[i] = this.accounts[i + 1];
            }

            --this.count;
            return true;
        }
    }

    public Account timAccount(long accountNumber) throws Exception {
        for(int i = 0; i < this.count; ++i) {
            if (this.accounts[i].getAccountNumber() == accountNumber) {
                return this.accounts[i];
            }
        }

        throw new Exception("Tài khoản không tồn tại");
    }

    public Account[] getAllAccounts() {
        Account[] currentAccounts = new Account[this.count];

        for(int i = 0; i < this.count; ++i) {
            currentAccounts[i] = this.accounts[i];
        }

        return currentAccounts;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < this.count; ++i) {
            sb.append(this.accounts[i]).append("\n");
        }

        return sb.toString();
    }
}
