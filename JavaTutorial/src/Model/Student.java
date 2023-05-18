package Model;

public class Student {
    private int roll;
    private String name;
    private int age;
    Subjects subjects;

    public Student(int roll, String name, int age, Subjects subjects) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", subjects=" + subjects +
                '}';
    }
}
