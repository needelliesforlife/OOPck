package tuan7_NhanVien_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<NhanVien> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addSalariedEmployee();
                    break;
                case 2:
                    addCommissionEmployee();
                    break;
                case 3:
                    addBasePlusCommissionEmployee();
                    break;
                case 4:
                    addHourlyEmployee();
                    break;
                case 5:
                    displayAllEmployees();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println();
        } while (choice != 0);
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("=== EMPLOYEE MANAGEMENT SYSTEM ===");
        System.out.println("1. Add Salaried Employee");
        System.out.println("2. Add Commission Employee");
        System.out.println("3. Add Base Plus Commission Employee");
        System.out.println("4. Add Hourly Employee");
        System.out.println("5. Display All Employees");
        System.out.println("6. Exit");
    }
    
    private static void addSalariedEmployee() {
        salariedEmployee emp = new salariedEmployee();
        getEmployeeBasicInfo(emp);
        
        System.out.print("Enter weekly salary: ");
        double weeklySalary = scanner.nextDouble();
        emp.setWeeklySalary(weeklySalary);
        
        employees.add(emp);
        System.out.println("Salaried Employee added successfully!");
    }
    
    private static void addCommissionEmployee() {
        commissionEmployee emp = new commissionEmployee();
        getEmployeeBasicInfo(emp);
        
        System.out.print("Enter gross sales: ");
        double grossSales = scanner.nextDouble();
        emp.setGrossSale(grossSales);
        
        System.out.print("Enter commission rate (as decimal, e.g., 0.05 for 5%): ");
        double commissionRate = scanner.nextDouble();
        emp.setCommissionRate(commissionRate);
        
        employees.add(emp);
        System.out.println("Commission Employee added successfully!");
    }
    
    private static void addBasePlusCommissionEmployee() {
        BasePlusCommission emp = new BasePlusCommission();
        getEmployeeBasicInfo(emp);
        
        System.out.print("Enter gross sales: ");
        double grossSales = scanner.nextDouble();
        emp.setGrossSale(grossSales);
        
        System.out.print("Enter commission rate (as decimal, e.g., 0.05 for 5%): ");
        double commissionRate = scanner.nextDouble();
        emp.setCommissionRate(commissionRate);
        
        System.out.print("Enter base salary: ");
        double baseSalary = scanner.nextDouble();
        emp.setBaseSalary(baseSalary);
        
        employees.add(emp);
        System.out.println("Base Plus Commission Employee added successfully!");
    }
    
    private static void addHourlyEmployee() {
        hourlyEmployee emp = new hourlyEmployee();
        getEmployeeBasicInfo(emp);
        
        System.out.print("Enter hourly wage: ");
        double wage = scanner.nextDouble();
        emp.setWage(wage);
        
        System.out.print("Enter hours worked: ");
        double hours = scanner.nextDouble();
        emp.setHours(hours);
        
        employees.add(emp);
        System.out.println("Hourly Employee added successfully!");
    }
    
    private static void getEmployeeBasicInfo(NhanVien emp) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        emp.setFirstName(firstName);
        
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        emp.setLastName(lastName);
        
        System.out.print("Enter SSN: ");
        int ssn = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        emp.setSsn(ssn);
    }
    
    private static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        
        System.out.println("\n=== EMPLOYEE LIST ===");
        for (int i = 0; i < employees.size(); i++) {
            NhanVien emp = employees.get(i);
            System.out.println("\nEmployee #" + (i + 1));
            System.out.println(emp);
            System.out.printf("Salary: $%.2f%n", emp.getSalary());
            System.out.println("------------------------");
        }
    }
} 