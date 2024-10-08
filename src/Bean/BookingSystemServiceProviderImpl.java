package Bean;

import java.util.ArrayList;
import java.util.List;

import Service.IBookingSystemServiceProvider;

public class BookingSystemServiceProviderImpl extends EventServiceProviderImpl implements IBookingSystemServiceProvider {

    private List<Event> events; // List to hold events

    // Constructor to initialize the events list
    public BookingSystemServiceProviderImpl() {
        events = new ArrayList<>();
    }

    // Method to add an event to the list
    public void addEvent(Event event) {
        events.add(event);
    }

    // Implement the calculateBookingCost method
    @Override
    public double calculateBookingCost(int numTickets, double ticketPrice) {
        return numTickets * ticketPrice;
    }

    // Implement the bookTickets method
    @Override
    public Booking bookTickets(String eventName, int numTickets, Customer[] customers) {
        // Find the event by event name
        for (Event event : events) {
            if (event.getEventName().equalsIgnoreCase(eventName)) {
                Booking booking = new Booking(event);
                booking.bookTickets(numTickets);
                booking.calculateBookingCost(numTickets); // Calculate total cost
                return booking; // Return the booking object
            }
        }
        System.out.println("Event not found: " + eventName);
        return null; // Return null if event not found
    }

    // Implement the cancel_booking method
    @Override
    public boolean cancel_booking(int bookingId) {
        // Placeholder for booking cancellation logic (not implemented)
        System.out.println("Cancellation feature is not implemented yet.");
        return false;
    }

    // Implement the get_booking_details method
    @Override
    public Booking get_booking_details(int bookingId) {
        // Placeholder for getting booking details logic (not implemented)
        System.out.println("Getting booking details feature is not implemented yet.");
        return null;
    }

    // Get all events
    public List<Event> getEvents() {
        return events;
    }

    // Display all events
    public void displayAllEvents() {
        System.out.println("Available Events:");
        for (Event event : events) {
            event.displayEventDetails(); // Assuming displayEventDetails method exists in Event class
        }
    }
}
