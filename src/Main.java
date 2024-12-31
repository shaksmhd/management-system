import events.*;
import execption.MaxBorrowLimitExceededException;
import model.Book;
import model.User;
import service.Library;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventDispatcher eventDispatcher = new EventDispatcher();

        // Register event handlers
        eventDispatcher.registerHandler(BookAddedEvent.class, new BookAddedEventHandler()::onBookAdded);
        eventDispatcher.registerHandler(UserRegisteredEvent.class, new UserRegisteredEventHandler()::onUserRegistered);
        eventDispatcher.registerHandler(BookBorrowedEvent.class, new BookBorrowedEventHandler()::onBookBorrowed);
        eventDispatcher.registerHandler(BookReturnedEvent.class, new BookReturnedEventHandler()::onBookReturned);

        // Create library
        Library library = new Library(eventDispatcher);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter book title:");
                        String title = scanner.nextLine();
                        System.out.println("Enter book author:");
                        String author = scanner.nextLine();
                        System.out.println("Enter book ISBN:");
                        String isbn = scanner.nextLine();
                        Book book = new Book(title, author, isbn);
                        library.addBook(book);
                        break;
                    case 2:
                        System.out.println("Enter user name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter user ID:");
                        String userId = scanner.nextLine();
                        User user = new User(name, userId);
                        library.registerUser(user);
                        System.out.println("User registered successfully.");
                        break;
                    case 3:
                        System.out.println("Enter user ID:");
                        userId = scanner.nextLine();
                        System.out.println("Enter book ISBN:");
                        isbn = scanner.nextLine();
                        library.borrowBook(userId, isbn);
                        break;
                    case 4:
                        System.out.println("Enter user ID:");
                        userId = scanner.nextLine();
                        System.out.println("Enter book ISBN:");
                        isbn = scanner.nextLine();
                        library.returnBook(userId, isbn);
                        break;
                    case 5:
                        System.out.println("Enter search query:");
                        String query = scanner.nextLine();
                        List<Book> books = library.searchBooks(query);
                        for (Book b : books) {
                            System.out.println(b.getTitle() + " by " + b.getAuthor() + " (ISBN: " + b.getIsbn() + ")");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (MaxBorrowLimitExceededException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}