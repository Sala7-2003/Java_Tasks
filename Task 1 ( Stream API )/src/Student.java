package Main;

public class Student {


    String name;
    String department;
    double grade;


    Student(String name, String department, double grade) {
        this.name = name;
        this.department = department;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", grade=" + grade ;
    }
}
