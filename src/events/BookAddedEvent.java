package events;

import model.Book;

public class BookAddedEvent extends Event {
    private final Book book;

    public BookAddedEvent(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return super.toString() + ", BookAddedEvent{" +
                "book=" + book +
                '}';
    }
}
