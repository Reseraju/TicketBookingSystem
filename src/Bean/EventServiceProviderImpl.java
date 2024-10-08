package Bean;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Service.IEventServiceProvider;

public class EventServiceProviderImpl implements IEventServiceProvider {

    // Assuming we have a list to store the created events
    private List<Event> eventsList;

    // Constructor to initialize the events list
    public EventServiceProviderImpl() {
        this.eventsList = new ArrayList<>();
    }

    @Override
    public Event createEvent(String eventName, String date, String time, int totalSeats, double ticketPrice,
            String eventType, Venue venue) {
        Event event = null;
        LocalDate eventDate = LocalDate.parse(date);
        LocalTime eventTime = LocalTime.parse(time);

        switch (eventType.toLowerCase()) {
            case "movie":
                // For movie, gather additional details: genre, actor, actress
                String genre = getInput("Enter Genre: ");
                String actorName = getInput("Enter Actor Name: ");
                String actressName = getInput("Enter Actress Name: ");
                event = new Movie(eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, genre, actorName, actressName);
                break;

            case "concert":
                // For concert, gather additional details: artist and type
                String artist = getInput("Enter Artist Name: ");
                String concertType = getInput("Enter Concert Type (e.g., Rock, Jazz): ");
                event = new Concert(eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, artist, concertType);
                break;

            case "sports":
                // For sports, gather additional details: sport name and team names
                String sportName = getInput("Enter Sport Name: ");
                String teamsName = getInput("Enter Teams Name: ");
                event = new Sports(eventName, eventDate, eventTime, venue, totalSeats, ticketPrice, sportName, teamsName);
                break;

            default:
                System.out.println("Invalid event type. Please choose 'Movie', 'Concert', or 'Sports'.");
                break;
        }

        if (event != null) {
            eventsList.add(event); // Store the created event
            System.out.println("Event created successfully!");
        }
        return event;
    }

    @Override
    public Event[] getEventDetails() {
        // Convert the event list to an array and return it
        return eventsList.toArray(new Event[0]);
    }

    @Override
    public int getAvailableNoOfTickets() {
        int totalAvailableTickets = 0;

        // Loop through all events and calculate available tickets
        for (Event event : eventsList) {
            totalAvailableTickets += event.getAvailableSeats();
        }

        return totalAvailableTickets;
    }

    // Helper method to get input from the user
    private String getInput(String prompt) {
        System.out.print(prompt);
        java.util.Scanner sc = new java.util.Scanner(System.in);
        return sc.nextLine();
    }
}
