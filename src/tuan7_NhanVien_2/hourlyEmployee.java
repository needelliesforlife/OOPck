package tuan7_NhanVien_2;

public class hourlyEmployee extends NhanVien{
    private double hours;
    private double wage;

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public double getSalary() {
        if (hours <= 40) {
            return hours * wage;
        }
        else {
            return 40 * wage + (hours - 40) * wage* 1.5;
        }
    }
    @Override
    public String toString() {
        return String.format("Nhan vien luong theo gio: %s %s (SSN: %d) - Gio lam: %.2f - Luong gio: %.2f",
                firstName, lastName, ssn, hours, wage);
    }
}
