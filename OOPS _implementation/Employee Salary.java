import java.util.*;

abstract class Employee {
    private int employeeId;
    private String employeeName;

    Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    int getEmployeeId() {
        return employeeId;
    }

    String getEmployeeName() {
        return employeeName;
    }

    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

class ContractEmployee extends Employee {
    int workingDays;
    double dailyRate;

    ContractEmployee(int id, String name, int workingDays, double dailyRate) {
        super(id, name);
        this.workingDays = workingDays;
        this.dailyRate = dailyRate;
    }

    @Override
    double calculateSalary() {
        return workingDays * dailyRate;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int employeeType = sc.nextInt();
        int id = sc.nextInt();
        String name = sc.next();
        Employee emp;

        if (employeeType == 1) {
            double salary = sc.nextDouble();
            emp = new FullTimeEmployee(id, name, salary);
        } else {
            int days = sc.nextInt();
            double rate = sc.nextDouble();
            emp = new ContractEmployee(id, name, days, rate);
        }

        System.out.println("Employee ID: " + emp.getEmployeeId());
        System.out.println("Employee Name: " + emp.getEmployeeName());
        System.out.printf(Locale.US, "Salary: %.2f%n", emp.calculateSalary());
    }
}
