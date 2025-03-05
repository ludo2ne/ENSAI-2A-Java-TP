package fr.ensai.library;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("City Library");

        String csvFilePath = "books.csv";
        library.loadBooksFromCSV(csvFilePath);

        library.displayItems();

        System.out.println("\n**********************************************");
        System.out.println("* Books by Stephen King                      *");
        System.out.println("**********************************************");

        ArrayList<Book> skingsBooks = library.getBooksByAuthor(new Author("Stephen King"));

        for (Book b : skingsBooks) {
            System.out.println(b);
        }
    }
}