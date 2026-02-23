abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();
}

interface BonusCalculator {
    double getBonus();
}

class OfficeStaff extends Employee {
    public OfficeStaff(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}

class Manager extends Employee implements BonusCalculator {
    private double kpiBonus;

    public Manager(String name, double baseSalary, double kpiBonus) {
        super(name, baseSalary);
        this.kpiBonus = kpiBonus;
    }

    @Override
    public double getBonus() {
        return kpiBonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + getBonus();
    }
}

public class Bai5 {
    public static void main(String[] args) {
        Employee staff = new OfficeStaff("Nguyễn Văn A", 8000000);
        Employee manager = new Manager("Trần Thị B", 15000000, 5000000);

        System.out.println("===== BẢNG LƯƠNG =====");

        printSalary(staff);
        System.out.println("----------------------");
        printSalary(manager);
    }

    public static void printSalary(Employee emp) {
        System.out.println("Tên: " + emp.name);
        System.out.println("Lương cơ bản: " + emp.baseSalary);

        if (emp instanceof BonusCalculator) {
            BonusCalculator bonusEmp = (BonusCalculator) emp;
            System.out.println("Thưởng KPI: " + bonusEmp.getBonus());
            System.out.println("Tổng lương: " + emp.calculateSalary());
            System.out.println("(Có thưởng KPI)");
        } else {
            System.out.println("Thưởng KPI: Không có");
            System.out.println("Tổng lương: " + emp.calculateSalary());
            System.out.println("(Không có thưởng)");
        }
    }
}