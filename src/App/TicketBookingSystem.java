package App;
import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Bean.Event;
import Bean.Venue;
import Bean.EventServiceProviderImpl;

public class TicketBookingSystem  {

    private List<Event> events; // List to hold events
    private EventServiceProviderImpl eventServiceProvider; // Instance of EventServiceProviderImpl

    public TicketBookingSystem() {
        events = new ArrayList<>(); // Initialize the events list
        eventServiceProvider = new EventServiceProviderImpl(); // Initialize event service provider
    }

    public Event createEvent(String eventName, String date, String time, int totalSeats, 
                             double ticketPrice, String eventType, Venue venue) {
        return eventServiceProvider.createEvent(eventName, date, time, totalSeats, ticketPrice, eventType, venue);
    }

    public void bookTickets(Event event, int numTickets) {
        if (event.bookTickets(numTickets)) {
            System.out.println("Total cost: $" + numTickets * event.getTicketPrice());
        } else {
            System.out.println("Failed to book tickets.");
        }
    }

    
    public void cancelTickets(Event event, int numTickets) {
        if (event.cancelBooking(numTickets)) {
            System.out.println(numTickets + " tickets have been canceled.");
        } else {
            System.out.println("Failed to cancel tickets.");
        }
    }

    
    public int getAvailableSeats(Event event) {
        return event.getAvailableSeats();
    }

    
    public void displayEventDetails(Event event) {
        event.displayEventDetails();
    }

    // Main method for user interaction
    public static void main(String[] args) {
        TicketBookingSystem tbs = new TicketBookingSystem();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nEnter a command: \n1. Create Event \n2. Book Tickets \n3. Cancel Tickets \n4. Get Available Seats \n5. Display Event Details \n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.println("Enter event details:");
                    System.out.print("Name: ");
                    String eventName = sc.nextLine();
                    
                    System.out.print("Date (yyyy-mm-dd): ");
                    String date = sc.nextLine();
                    System.out.print("Time (hh:mm): ");
                    String time = sc.nextLine();
                    
                    System.out.print("Total Seats: ");
                    int totalSeats = sc.nextInt();
                    
                    System.out.print("Ticket Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    
                    System.out.print("Event Type (movie/concert/sports): ");
                    String eventType = sc.nextLine();
                    
                    System.out.print("Venue Name: ");
                    String venue = sc.nextLine();
                    Venue venue1 = new Venue();
                    venue1.setVenueName(venue);

                    Event event = tbs.createEvent(eventName, date, time, totalSeats, price, eventType, venue1);
                    if (event != null) {
                        System.out.println("Event created successfully!");
                        tbs.events.add(event); // Add the created event to the events list
                    } else {
                        System.out.println("Event creation failed.");
                    }
                    break;
                    
                case 2:
                    System.out.println("Select event to book tickets:");
                    tbs.displayEventList(); // Display list of events
                    int eventIndex = sc.nextInt();
                    System.out.print("Enter number of tickets to book: ");
                    int numTickets = sc.nextInt();
                    tbs.bookTickets(tbs.events.get(eventIndex - 1), numTickets);
                    break;
                    
                case 3:
                    System.out.println("Select event to cancel tickets:");
                    tbs.displayEventList(); // Display list of events
                    eventIndex = sc.nextInt();
                    System.out.print("Enter number of tickets to cancel: ");
                    int cancelTickets = sc.nextInt();
                    tbs.cancelTickets(tbs.events.get(eventIndex - 1), cancelTickets);
                    break;
                    
                case 4:
                    System.out.println("Select event to check available seats:");
                    tbs.displayEventList(); // Display list of events
                    eventIndex = sc.nextInt();
                    int availableSeats = tbs.getAvailableSeats(tbs.events.get(eventIndex - 1));
                    System.out.println("Available seats: " + availableSeats);
                    break;
                    
                case 5:
                    System.out.println("Select event to display details:");
                    tbs.displayEventList(); // Display list of events
                    eventIndex = sc.nextInt();
                    tbs.displayEventDetails(tbs.events.get(eventIndex - 1));
                    break;
                    
                case 6:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        
        sc.close();
    }

    // Add this method to display the list of events
    public void displayEventList() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getEventName() + " (" + events.get(i).getEventType() + ")");
        }
    }
}
