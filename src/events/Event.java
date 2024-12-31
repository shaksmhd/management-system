package events;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Event {
    private final String eventId;
    private final LocalDateTime timestamp;

    public Event() {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
    }

    public String getEventId() {
        return eventId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
