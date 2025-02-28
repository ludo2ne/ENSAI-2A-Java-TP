package tp2.src.main.java.edu.ensai.library;

public class Book extends Item {
    // Attributes
    private String isbn;
    private Author author;

    // Constructor
    public Book(String isbn, String title, Author author, int year, int pageCount) {
        super(title, year, pageCount);
        this.isbn = isbn;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book " + title + " written by " + author.getName();
    }

    public Author getAuthor() {
        return author;
    }

}
