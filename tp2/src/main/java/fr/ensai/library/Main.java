package fr.ensai.library;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("City Library");

        String csvFilePath = "books.csv"; // Update path if necessary
        library.loadBooksFromCSV(csvFilePath);

        library.displayItems();

        System.out.println("---------------------------------------------");

        ArrayList<Book> skingsBooks = library.getBooksByAuthor(new Author("Stephen King"));

        for (Book b : skingsBooks) {
            System.out.println(b);
        }

    }
}