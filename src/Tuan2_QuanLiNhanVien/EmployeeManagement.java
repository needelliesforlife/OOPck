import java.util.*;
public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        ArrayList<CommissionEmployee> commissionEmployees = new ArrayList<>();
        ArrayList<HourlyEmployee> hourlyEmployees = new ArrayList<>();
        ArrayList<BasePlusCommissionEmployee> basePlusCommissionEmployees = new ArrayList<>();
        ArrayList<SalariedEmployee> salariedEmployees = new ArrayList<>();

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add weekly employee");
            System.out.println("2. Add hourly employee");
            System.out.println("3. Add commission employee");
            System.out.println("4. Add base plus commission employee");
            System.out.println("5. Display weekly employees");
            System.out.println("6. Display hourly employees");
            System.out.println("7. Display commission employees");
            System.out.println("8. Display base plus commission employees");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSalariedEmployee(scanner, salariedEmployees);
                    break;
                case 2:
                    addHourlyEmployee(scanner, hourlyEmployees);
                    break;
                case 3:
                    addCommissionEmployee(scanner, commissionEmployees);
                    break;
                case 4:
                    addBasePlusCommissionEmployee(scanner, basePlusCommissionEmployees);
                    break;
                case 5:
                    displayEmployees("Weekly Employees", salariedEmployees);
                    break;
                case 6:
                    displayEmployees("Hourly Employees", hourlyEmployees);
                    break;
                case 7:
                    displayEmployees("Commission Employees", commissionEmployees);
                    break;
                case 8:
                    displayEmployees("Base Plus Commission Employees", basePlusCommissionEmployees);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addSalariedEmployee(Scanner scanner, ArrayList<SalariedEmployee> employees) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter SSN: ");
        String ssn = scanner.nextLine();
        System.out.print("Enter weekly salary: ");
        double weekSalary = scanner.nextDouble();

        employees.add(new SalariedEmployee(firstName, lastName, ssn, weekSalary));
        System.out.println("Employee added successfully!");
    }

    private static void addHourlyEmployee(Scanner scanner, ArrayList<HourlyEmployee> employees) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter SSN: ");
        String ssn = scanner.nextLine();
        System.out.print("Enter hours worked: ");
        int hours = scanner.nextInt();
        System.out.print("Enter hourly wage: ");
        double hourlyWage = scanner.nextDouble();

        employees.add(new HourlyEmployee(firstName, lastName, ssn, hours, hourlyWage));
        System.out.println("Employee added successfully!");
    }

    private static void addCommissionEmployee(Scanner scanner, ArrayList<CommissionEmployee> employees) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter SSN: ");
        String ssn = scanner.nextLine();
        System.out.print("Enter gross sales: ");
        double grossSales = scanner.nextDouble();
        System.out.print("Enter commission rate (0-1): ");
        double commissionRate = scanner.nextDouble();

        employees.add(new CommissionEmployee(firstName, lastName, ssn, grossSales, commissionRate));
        System.out.println("Employee added successfully!");
    }

    private static void addBasePlusCommissionEmployee(Scanner scanner, ArrayList<BasePlusCommissionEmployee> employees) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter SSN: ");
        String ssn = scanner.nextLine();
        System.out.print("Enter gross sales: ");
        double grossSales = scanner.nextDouble();
        System.out.print("Enter commission rate (0-1): ");
        double commissionRate = scanner.nextDouble();
        System.out.print("Enter base salary: ");
        double baseSalary = scanner.nextDouble();

        employees.add(new BasePlusCommissionEmployee(firstName, lastName, ssn, grossSales, commissionRate, baseSalary));
        System.out.println("Employee added successfully!");
    }

    private static <T> void displayEmployees(String title, ArrayList<T> employees) {
        if (employees.isEmpty()) {
            System.out.println("\nNo " + title + " found.");
            return;
        }

        System.out.println("\n" + title + ":");
        for (T employee : employees) {
            System.out.println(employee.toString());
        }
    }
}