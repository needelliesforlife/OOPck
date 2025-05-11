
public class Employee {
    protected String firstName;  // Changed to camelCase
    protected String lastName;   // Changed to camelCase
    protected String ssn;       // Changed to lowercase as per convention

    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public double getSalary() {
        return 0;
    }
}

class SalariedEmployee extends Employee {  // Changed to PascalCase
    private double weekSalary;  // Changed to camelCase

    public SalariedEmployee(String firstName, String lastName, String ssn, double weekSalary) {
        super(firstName, lastName, ssn);
        this.weekSalary = weekSalary;
    }

    @Override
    public double getSalary() {
        return weekSalary;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s %10.2f", firstName, lastName, ssn, getSalary());
    }
}

class HourlyEmployee extends Employee {  // Changed to PascalCase
    private int hours;  // Changed name for clarity
    private double hourlyWage;  // Changed to double for more precise calculations

    public HourlyEmployee(String firstName, String lastName, String ssn, int hours, double hourlyWage) {
        super(firstName, lastName, ssn);
        this.hours = hours;
        this.hourlyWage = hourlyWage;
    }

    @Override
    public double getSalary() {
        if (hours <= 40) {
            return hours * hourlyWage;
        } else {
            return (40 * hourlyWage) + ((hours - 40) * hourlyWage * 1.5);
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s %10.2f %10d", firstName, lastName, ssn, getSalary(), hours);
    }
}

class CommissionEmployee extends Employee {  // Changed to PascalCase
    private double grossSales;  // Changed to double
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String ssn, double grossSales, double commissionRate) {
        super(firstName, lastName, ssn);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }

    @Override
    public double getSalary() {
        return commissionRate * grossSales;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s %10.2f %10.2f", firstName, lastName, ssn, grossSales, commissionRate);
    }
}

class BasePlusCommissionEmployee extends Employee {  // Changed to PascalCase
    private double baseSalary;
    private double grossSales;  // Changed to double
    private double commissionRate;

    public BasePlusCommissionEmployee(String firstName, String lastName, String ssn, double grossSales,
                                      double commissionRate, double baseSalary) {
        super(firstName, lastName, ssn);
        this.baseSalary = baseSalary;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    @Override
    public double getSalary() {
        return (grossSales * commissionRate) + baseSalary;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s %10.2f %10.2f %10.2f",
                firstName, lastName, ssn, grossSales, commissionRate, baseSalary);
    }

}


