package events;

import model.User;

public class UserRegisteredEvent extends Event {
    private final User user;

    public UserRegisteredEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return super.toString() + ", UserRegisteredEvent{" +
                "user=" + user +
                '}';
    }
}
