package library;

public class Book extends LibraryItem {

    private String author;
    private int pages;

    // Constructor
    public Book(String title, String author, int pages) {

        super(title);

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }

        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than zero.");
        }

        this.author = author;
        this.pages = pages;
    }

    // Getters
    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    // Setters
    public void setAuthor(String author) {

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }

        this.author = author;
    }

    public void setPages(int pages) {

        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than zero.");
        }

        this.pages = pages;
    }

    @Override
    public int getLoanPeriodDays() {
        return 21;
    }

    @Override
    public String getType() {
        return "Book";
    }
}