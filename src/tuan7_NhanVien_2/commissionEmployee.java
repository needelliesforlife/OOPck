package tuan7_NhanVien_2;

public class commissionEmployee extends NhanVien {
    protected double commissionRate;
    protected double grossSale;

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSale() {
        return grossSale;
    }

    public void setGrossSale(double grossSale) {
        this.grossSale = grossSale;
    }

    @Override
    public double getSalary() {
        return commissionRate * grossSale;
    }
    @Override
    public String toString() {
        return String.format("Nhan vien hoa hong: %s %s (SSN: %d) - Doanh so: %.2f - Ty le: %.1f%%",
                firstName, lastName, ssn, grossSale, commissionRate * 100);
    }
}
