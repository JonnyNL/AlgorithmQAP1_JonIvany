package LibraryCatalog;
// The Book class represents a single book with attributes such as title, author, ISBN, and availability.
public class Book {
    // Private instance variables for the book class
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;
    // Book Constructor, creates book object on title, author, and ISBN
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }
    // Getter method, returns book title
    public String getTitle() {
        return title;
    }
    // Getter method, returns Author name
    public String getAuthor() {
        return author;
    }
    // Getter method, returns ISBN identifier
    public String getISBN() {
        return ISBN;
    }
    // Getter method, returns boolean availability value
    public boolean isAvailable() {
        return isAvailable;
    }
    // Setter method, sets book availability boolean value
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    // Setter method, sets books title
    public void setTitle(String title) {
        this.title = title;
    }
    // Setter method, sets books author
    public void setAuthor(String author) {
        this.author = author;
    }
}

