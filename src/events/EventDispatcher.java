package events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventDispatcher {
    private final Map<Class<? extends Event>, List<Consumer<Event>>> handlers = new HashMap<>();

    public <E extends Event> void registerHandler(Class<E> eventType, Consumer<E> handler) {
//        handlers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(handler::accept);
        handlers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event -> handler.accept((E) event));
    }

    public void dispatch(Event event) {
        List<Consumer<Event>> eventHandlers = handlers.get(event.getClass());
        if (eventHandlers != null) {
            eventHandlers.forEach(handler -> handler.accept(event));
        }
    }
}
