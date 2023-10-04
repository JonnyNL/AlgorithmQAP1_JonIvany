package LibraryCatalog;
import java.util.ArrayList;
import java.util.List;
// The BookCatalog class has the logic for managing the books, such as searching, checking out, and returning.
public class BookCatalog {
    // Private instance variable of BookCatalog to initialize book list
    private List<Book> books;

    // A catalog of books constructor, but with a sample set of data
    public BookCatalog() {
        books = new ArrayList<>();

        // Sample data of some good books I know
        books.add(new Book("The Hidden Life of Trees", "Peter Wohlleben", "978-1771642484"));
        books.add(new Book("Harry Potter and the Sorcerer's Stone","J.K. Rowling","978-0590353427"));
        books.add(new Book("Superintelligence: Paths, Dangers, Strategies","Nick Bostrom","978-0198739838"));
        books.add(new Book("The Quran","Various", "978-1590080276"));
        books.add(new Book("Percy Jackson & the Olympians: The Sea of Monsters","Rick Riordan","978-1423103349"));
        // More sample data
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890"));
        books.add(new Book("Moby Dick", "Herman Melville", "2345678901"));
        books.add(new Book("1984", "George Orwell", "3456789012"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "4567890123"));
    }

    // Searching method to display a given book by ISBN
    public Book searchByISBN(String ISBN) {
        // For loop based on the books in the book list to the given ISBN number to get the exact book
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    // Searching method to display books based on given query
    public List<Book> search(String query) {
        // New list to store the found books
        List<Book> foundBooks = new ArrayList<>();
        // For loops based on the books in the book list compared to string query, if attribute matches, store book to array.
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                    book.getISBN().equals(query)) {
                foundBooks.add(book);
            }
        }
        // Return the found books
        return foundBooks;
    }

    // Checkout by ISBN method, sets matched book availability to false if available
    public boolean checkoutBook(String ISBN) {
        // Use the search method to check for the book
        Book book = searchByISBN(ISBN);
        // If book is there and available, make it unavailable.
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    // Return by ISBN method, sets matched book availability to true if checked out
    public boolean returnBook(String ISBN) {
        // Use the search method to check for the book
        Book book = searchByISBN(ISBN);
        // If book is there and unavailable, make it available.
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    // Add a new book method, takes title, author, and ISBN number adds to array list

    public boolean addBook(String title, String author, String ISBN) {
        // Check to make sure ISBN doesn't already exist before adding book.
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                // Return false if the ISBN exists
                return false;
            }
        }
        // If ISBN doesn't exist, add book and return true.
        books.add(new Book(title, author, ISBN));
        return true;
    }

    // Modify an existing book method, ISBN cannot be modified as this is a unique identifier.
    // Important for the tracking of checked out/available books
    public boolean modifyBook(String ISBN, String newTitle, String newAuthor) {
        Book book = searchByISBN(ISBN);
        // Check if book was found, allow modification, otherwise return false
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            return true;
        }
        return false;
    }
}
