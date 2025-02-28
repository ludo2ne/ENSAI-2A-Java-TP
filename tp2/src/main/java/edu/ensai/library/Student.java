package tp2.src.main.java.edu.ensai.library;

public class Student extends Person {
    public int year;
    public boolean isClassDelegate;

    public Student(String firstName, String lastName, int age, int year, boolean isClassDelegate) {
        super(firstName, lastName, age);
        this.year = year;
        this.isClassDelegate = isClassDelegate;
    }
}