package fr.ensai.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    // Attributes
    private String name;
    private List<Item> items;

    // Constructor
    public Library(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    // Method to add a book to the library's collection
    public void addIem(Item item) {
        items.add(item);
    }

    public void displayItems() {

        System.out.println("\n**********************************************");
        System.out.println("* All items                                  *");
        System.out.println("**********************************************\n");
        if (items.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    /**
     * Retrieves a list of books written by a specific author.
     *
     * @param author The author whose books are to be found.
     * @return A list of books written by the given author.
     */
    public ArrayList<Book> getBooksByAuthor(Author author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Book) { // Check if the item is a Book
                Book book = (Book) item; // Cast the item to a Book
                if (book.getAuthor().equals(author)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    /**
     * Loads books from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        if (url == null) {
            System.err.println("Error: Could not find resource file: " + filePath);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName);
                        authors.put(authorName, author);
                        System.out.println(author.toString());
                    }
                    Book book = new Book(isbn, title, author, year, pageCount);

                    this.addIem(book);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

}