package tp2.src.main.java.edu.ensai.library;

import java.util.Objects;

public class Author {

    // Attributes
    public String name;
    public int age;
    public String nationality;

    // Constructor
    public Author(String name) {
        this.name = name;
    }

    // Methods
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Author author = (Author) obj;
        return Objects.equals(name, author.name);
    }
}
