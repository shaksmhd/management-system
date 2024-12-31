package events;

public class BookBorrowedEventHandler {
    public void onBookBorrowed(BookBorrowedEvent event) {
        // Logic to execute when a BookBorrowedEvent occurs
        System.out.println("Book borrowed: " + event.getBook() + " by " + event.getUser());
    }
}
