package events;

import model.Book;
import model.User;

public class BookReturnedEvent extends Event {
    private final User user;
    private final Book book;

    public BookReturnedEvent(User user, Book book) {
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
        return super.toString() + ", BookReturnedEvent{" +
                "user=" + user +
                ", book=" + book +
                '}';
    }
}
