package tuan7_NhanVien_2;

public class salariedEmployee extends NhanVien{
    private double weeklySalary;

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getSalary() {
        return weeklySalary;
    }
    @Override
    public String toString() {
        return String.format("Nhan vien co dinh: %s %s (SSN: %d) - luong tuan: %.2f",
                firstName, lastName, ssn, weeklySalary);
    }
}
