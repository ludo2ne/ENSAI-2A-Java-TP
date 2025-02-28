package tp2.src.main.java.edu.ensai.library;

public class Magazine extends Item {
    // Attributes
    private String issn;
    private String title;
    private String issueNumber;
    private int year;
    private int pageCount;

    // Constructor
    public Magazine(String issn, String title, String issueNumber, int year, int pageCount) {
        super(title, year, pageCount);
        this.issn = issn;
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return "Magazine " + title;
    }

}
