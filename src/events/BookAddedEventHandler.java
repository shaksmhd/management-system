package events;

public class BookAddedEventHandler {
    public void onBookAdded(BookAddedEvent event) {
        // Logic to execute when a BookAddedEvent occurs
        System.out.println("Book added: " + event.getBook());
    }
}
