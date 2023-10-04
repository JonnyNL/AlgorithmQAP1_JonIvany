package LibraryCatalog;
import java.util.Scanner;
import java.util.List;
// The Menu class has the main method for LibraryCatalog, containing the menu system & user interface.
public class Menu {
    // Create a new book catalog instance
    private static BookCatalog catalog = new BookCatalog();

    public static void main(String[] args) {
        // Initialize Scanner for user selection
        Scanner scanner = new Scanner(System.in);

        //Welcome User
        System.out.println("\nWelcome to the Library Catalog!");
        System.out.println("============================");

        // Display menu using a while true loop
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Search for a book");
            System.out.println("2. Checkout a book");
            System.out.println("3. Return a book");
            System.out.println("4. Add a book");
            System.out.println("5. Modify a book");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");

            // Initialize int & capture user input
            int choice = scanner.nextInt();
            scanner.nextLine();
            // Depending on user selection call associated menu method
            switch (choice) {
                case 1:
                    searchForBook(scanner);
                    break;
                case 2:
                    checkoutBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    addBook(scanner);
                    break;
                case 5:
                    modifyBook(scanner);
                    break;
                case 6:
                    System.out.println("\nThank you for using the Library Catalog,");
                    System.out.println("a book a day keeps the crooks away!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Search method for main menu that gets result from catalog
    private static void searchForBook(Scanner scanner) {
        // Prompt user to search
        System.out.print("Enter title, author, or ISBN to search: ");
        // Read and capture users input
        String query = scanner.nextLine();
        // Use search method from catalog, storing results in a list
        List<Book> foundBooks = catalog.search(query);
        // Check if list is empty, if not, print book result
        if (foundBooks.isEmpty()) {
            System.out.println("No books found matching the query.");
        } else {
            for (Book book : foundBooks) {
                System.out.println("\nBook Found!");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
            }
        }
    }

    // Checkout method for main menu that checks out a book by ISBN #
    private static void checkoutBook(Scanner scanner) {
        // Ask user for ISBN indentifier of book for checkout, to get exact book
        System.out.print("Enter ISBN of the book to checkout: ");
        // Read and capture user input
        String isbn = scanner.nextLine();
        // Check if book checkout was successful
        if (catalog.checkoutBook(isbn)) {
            System.out.println("Book checked out successfully!");
        } else {
            System.out.println("Book is either not found or already checked out.");
        }
    }

    // Return method for main menu that returns a book by ISBN #
    private static void returnBook(Scanner scanner) {
        // Ask user for ISBN num of book they're returning
        System.out.print("Enter ISBN of the book to return: ");
        // Read and capture user input
        String isbn = scanner.nextLine();
        // Check if book return was successful or not
        if (catalog.returnBook(isbn)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book is either not found or already in the library.");
        }
    }

    // Add book method for main menu that adds a new book to the arraylist of catalogged books
    private static void addBook(Scanner scanner) {
        // Prompt user for book info, capture inputs
        System.out.println("Enter Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter Author: ");
        String author = scanner.nextLine();
        System.out.println("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        // Use bookCatalog addBook method
        // Check if it was successful
        if (catalog.addBook(title, author, ISBN)) {
            System.out.println("Book added successfully!");
        } else {
            // Let user know there is a matching ISBN in catalog
            System.out.println("A book with ISBN" + ISBN + " already exists. Cannot add book.");
        }
    }
    // Modify book method for main menu that allows modification of a stored books author or title.
    // ISBN is unique to identify the book, should not be modified
    private static void modifyBook(Scanner scanner) {
        // Prompt user for book info and capture input
        System.out.println("Enter ISBN of the book to modify: ");
        String ISBN = scanner.nextLine();
        // Prompt user for modification
        System.out.println("Enter new Title: ");
        String newTitle = scanner.nextLine();
        System.out.println("Enter new Author: ");
        String newAuthor = scanner.nextLine();
        // Check if modify method was successfull and prompt user.
        if (catalog.modifyBook(ISBN, newTitle, newAuthor)) {
            System.out.println("Book modified successfully!");
        } else {
            System.out.println("Book not found!");
        }

    }
}


