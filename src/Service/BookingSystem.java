package Service;
import java.util.ArrayList;

import Bean.Event;
import Bean.Venue;

public abstract class BookingSystem {
	protected ArrayList<Event> events;
	
	public BookingSystem() {
        events = new ArrayList<>();
    }
	
	public abstract Event createEvent(String eventName, String date, String time, int totalSeats, 
			double ticketPrice, String eventType, Venue venueName );
	public abstract void displayEventDetails(Event event);
	public abstract void bookTickets(Event event, int numTickets);
	public abstract void cancelTickets(Event event, int numTickets);
	public abstract int getAvailableSeats(Event event);
}
