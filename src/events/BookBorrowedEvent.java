package events;

import model.Book;
import model.User;

public class BookBorrowedEvent extends Event {
    private final User user;
    private final Book book;

    public BookBorrowedEvent(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return super.toString() + ", BookBorrowedEvent{" +
                "user=" + user +
                ", book=" + book +
                '}';
    }
}

