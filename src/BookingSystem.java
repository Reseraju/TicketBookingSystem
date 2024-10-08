import java.util.ArrayList;

public abstract class BookingSystem {
	protected ArrayList<Event> events;
	
	public BookingSystem() {
        events = new ArrayList<>();
    }
	
	public abstract Event createEvent(String eventName, String date, String time, int totalSeats, 
			double ticketPrice, String eventType, String venueName );
	public abstract void displayEventDetails(Event event);
	public abstract void bookTickets(Event event, int numTickets);
	public abstract void cancelTickets(Event event, int numTickets);
	public abstract int getAvailableSeats(Event event);
}
