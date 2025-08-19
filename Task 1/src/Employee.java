package Main;

public class Employee {
    String name;
    int age;
    String department;
    double salary;

Employee(String name, int age, String department, double salary) {
    this.name = name;
    this.age = age;
    this.department = department;
    this.salary = salary;
}

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }

}
