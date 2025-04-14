import java.util.Random;

public class Main {

    private final static Random RANDOM = new Random();
    private final static String[] NAME = {"Мария", "Анна", "Екатерина", "Ольга", "Наталья", "Татьяна", "Марина", "Светлана"};
    private final static String[] SURNAME = {"Петрова", "Васильева", "Кузнецова", "Федорова", "Ковалёва", "Лебедева", "Зайцева", "Пономарева"};
    private final static String[] PATRONYMIC = {"Дмитриевна", "Сергеевна", "Николаевна", "Александровна", "Васильевна", "Юрьевна", "Владимировна"};

    private final static Employee[] EMPLOYEE = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEE.length; i++) {
            String fullName = SURNAME[RANDOM.nextInt(0, SURNAME.length)] + " " + NAME[RANDOM.nextInt(0, NAME.length)] + " " + PATRONYMIC[RANDOM.nextInt(0, PATRONYMIC.length)];

            EMPLOYEE[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(30000, 150000));
        }
    }

    public static void main(String[] args) {
        initEmployees();
        print();
        System.out.println("Сумма затрат на ЗП " + salaryCosts());
        System.out.println("Cотрудник с минимальной ЗП " + salaryMin());
        System.out.println("Cотрудник c максимальной ЗП " + salaryMax());
        System.out.println("Cреднее значение зарплат " + salaryAverage());
        fullName();
    }

    private static void print() {
        for (Employee employee : EMPLOYEE) {
            System.out.println(employee);
        }

    }

    private static int salaryCosts() {
        int sum = 0;
        for (Employee employee : EMPLOYEE) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee salaryMin() {
        Employee salaryMinEmployee = null;
        for (Employee employee : EMPLOYEE) {
            if (salaryMinEmployee == null || employee.getSalary() < salaryMinEmployee.getSalary()){
                salaryMinEmployee = employee;
            }
        }
        return salaryMinEmployee;
    }

    private static Employee salaryMax() {
        Employee salaryMaxEmployee = null;
        for (Employee employee : EMPLOYEE) {
            if (salaryMaxEmployee == null || employee.getSalary() > salaryMaxEmployee.getSalary()){
                salaryMaxEmployee = employee;
            }
        }
        return salaryMaxEmployee;
    }

    private static double salaryAverage() {
        return (double) salaryCosts() / EMPLOYEE.length;
    }

    private static void fullName() {
        for (Employee employee : EMPLOYEE) {
            System.out.println(employee.getFullName());
        }
    }
}