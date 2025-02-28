package tp2.src.main.java.edu.ensai.library;

public class Person {

    // Attributes
    public String firstName;
    public String lastName;
    public int age;

    // Constructor
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Methods
    public void birthday() {
        this.age += 1;
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
