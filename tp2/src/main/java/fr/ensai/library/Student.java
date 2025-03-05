package fr.ensai.library;

public class Student extends Person {
    public int year;
    public boolean isClassDelegate;

    public Student(String name, int age, int year, boolean isClassDelegate) {
        super(name, age);
        this.year = year;
        this.isClassDelegate = isClassDelegate;
    }
}