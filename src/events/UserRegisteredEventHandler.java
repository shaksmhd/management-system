package events;

public class UserRegisteredEventHandler {
    public void onUserRegistered(UserRegisteredEvent event) {
        // Logic to execute when a UserRegisteredEvent occurs
        System.out.println("User registered: " + event.getUser());
    }
}
