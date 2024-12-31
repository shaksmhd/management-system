package service;

import events.*;
import execption.BookValidator;
import execption.InvalidIsbnException;
import execption.UserValidator;
import model.Book;
import model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Library {
    private static final Logger logger = Logger.getLogger(Library.class.getName());

    private List<Book> books;
    private List<User> users;
    private EventDispatcher eventDispatcher;

    public Library(EventDispatcher eventDispatcher) {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.eventDispatcher = eventDispatcher;
        logger.info("Library initialized.");
    }

    public void addBook(Book book) {
        try {
            // Validate the book before adding
            BookValidator.validate(book);
            books.add(book);
            eventDispatcher.dispatch(new BookAddedEvent(book));
            logger.info("Book added successfully: " + book);
        } catch (InvalidIsbnException e) {
            logger.log(Level.SEVERE, "Failed to add book: " + book, e);
        }
    }

    public void registerUser(User user) {
        users.add(user);
        eventDispatcher.dispatch(new UserRegisteredEvent(user));
        logger.info("User registered successfully: " + user);
    }

    public void borrowBook(String userId, String isbn) throws Exception {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);

        if (book.isBorrowed()) {
            logger.warning("Book already borrowed: " + book);
            throw new Exception("Book is already borrowed.");
        }

        // Validate user borrow limit
        UserValidator.validate(user);

        book.setBorrowed(true);
        user.getBorrowedBooks().add(book);
        eventDispatcher.dispatch(new BookBorrowedEvent(user, book));
        logger.info("Book borrowed successfully: " + book + " by user: " + user);
    }

    public void returnBook(String userId, String isbn) throws Exception {
        User user = findUserById(userId);
        Book book = findBookByIsbn(isbn);

        if (!book.isBorrowed()) {
            logger.warning("Book not borrowed: " + book);
            throw new Exception("Book is not borrowed.");
        }

        book.setBorrowed(false);
        user.getBorrowedBooks().remove(book);
        eventDispatcher.dispatch(new BookReturnedEvent(user, book));
        logger.info("Book returned successfully: " + book + " by user: " + user);
    }

    private User findUserById(String userId) throws Exception {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> {
                    logger.severe("User not found: " + userId);
                    return new Exception("User not found.");
                });
    }

    private Book findBookByIsbn(String isbn) throws Exception {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow(() -> {
                    logger.severe("Book not found: " + isbn);
                    return new Exception("Book not found.");
                });
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Book> searchBooks(String query) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase())
                        || book.getAuthor().toLowerCase().contains(query.toLowerCase())
                        || book.getIsbn().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}