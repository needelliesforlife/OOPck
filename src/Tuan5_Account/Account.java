package Tuan5_Account;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private long accountNumber;
    private String name;
    private double balance;
    public static final double RATE = 0.035;
    public static final double SETBALANCE = (double)50000.0F;


    public Account() {
        this.accountNumber = 999999L;
        this.name = "chưa xác nhận";
        this.balance = (double)50000.0F;
    }

    public Account(long accountNumber, String name, double balance) {
        if (accountNumber > 0L) {
            this.accountNumber = accountNumber;
        } else {
            this.accountNumber = 999999L;
        }

        if (name.isEmpty()) {
            this.name = "chưa xác nhận";
        } else {
            this.name = name;
        }

        if (balance >= (double)50000.0F) {
            this.balance = balance;
        } else {
            this.balance = SETBALANCE;
        }

    }

    public Account(long accNumber, String name) {
        this(accNumber, name, (double)50000.0F);
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) throws Exception {
        if (amount > (double)0.0F) {
            this.balance += amount;
            return true;
        } else {
            throw new Exception("số tiền nạp vào không hợp lệ");
        }
    }

    public boolean withdraw(double amount) throws Exception {
        double fee = amount * 0.035;
        if (amount > (double)0.0F && this.balance - (amount + fee) >= (double)50000.0F) {
            this.balance -= amount + fee;
            return true;
        } else {
            throw new Exception("số tiền rút không hợp lệ");
        }
    }

    public void addInterest() {
        this.balance += this.balance * RATE;
    }

    public boolean transfer(Account acc2, double amount) throws Exception {
        if (amount > (double)0.0F && amount <= this.balance) {
            this.balance -= amount;
            acc2.balance += amount;
            return true;
        } else {
            throw new Exception("chuyển tiền thất bại");
        }
    }

    public String toString() {
        Locale money = Locale.of("vi", "VN");
        NumberFormat form = NumberFormat.getCurrencyInstance(money);
        return String.format("|%-20d | %-20s | %-5s", this.accountNumber, this.name, form.format(this.balance));
    }
}