package events;

public class BookReturnedEventHandler {
    public void onBookReturned(BookReturnedEvent event) {
        // Logic to execute when a BookReturnedEvent occurs
        System.out.println("Book returned: " + event.getBook() + " by " + event.getUser());
    }
}
