package tuan7_NhanVien_2;

public class BasePlusCommission extends commissionEmployee{
    private double baseSalary;

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double getSalary() {
        return baseSalary + (grossSale * commissionRate);
    }
    @Override
    public String toString() {
        return String.format("Nhan vien hoa hong co ban: %s %s (SSN: %d) - luong co ban: %.2f - Doanh so: %.2f - Ty le: %.1f%%",
                firstName, lastName, ssn, baseSalary, grossSale, commissionRate * 100);
    }
}
