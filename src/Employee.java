import java.util.Objects;

public class Employee {
    private static int idNumber = 1;

    private final String fullName;
    private final int id;
    private int salary;
    private int department;

    public Employee(String fullName, int department, int salary) {
        id = idNumber++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {

        return fullName;
    }

    public int getId() {

        return id;
    }

    public int getDepartment() {

        return department;
    }

    public void setSalary(int salary) {

        this.salary = salary;
    }

    public int getSalary() {

        return salary;
    }


    public void setDepartment(int department) {

        this.department = department;
    }

    @Override
    public String toString() {
        return "fullName='" + fullName + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", department=" + department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && department == employee.department && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fullName, id, salary, department);
    }
}
