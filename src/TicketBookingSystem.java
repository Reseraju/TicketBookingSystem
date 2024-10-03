import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class TicketBookingSystem extends BookingSystem {

    @Override
    public Event createEvent(String eventName, String date, String time, int totalSeats, 
                             double ticketPrice, String eventType, String venueName) {

        LocalDate eventDate = LocalDate.parse(date);
        LocalTime eventTime = LocalTime.parse(time);
        
        Event newEvent;
        
        switch(eventType.toLowerCase()) {
            case "movie":
                newEvent = new Movie(eventName, eventDate, eventTime, venueName, totalSeats, 
                                     ticketPrice, "Action", "Tom Hans", "Reese Witherspoon");
                break;
                
            case "concert":
                newEvent = new Concert(eventName, eventDate, eventTime, venueName, totalSeats, 
                                       ticketPrice, "Coldplay", "Rock");
                break;
                
            case "sports":
                newEvent = new Sports(eventName, eventDate, eventTime, venueName, totalSeats, 
                                      ticketPrice, "Cricket", "India Vs Pakistan");
                break;
                
            default:
                System.out.println("Invalid event type. Creating a default event...");
                return null;
        }

        events.add(newEvent); // Add event to the list
        return newEvent;
    }

    @Override
    public void bookTickets(Event event, int numTickets) {
        if (event.bookTickets(numTickets)) {
            System.out.println("Total cost: $" + numTickets * event.getTicketPrice());
        } else {
            System.out.println("Failed to book tickets.");
        }
    }

    @Override
    public void cancelTickets(Event event, int numTickets) {
        if (event.cancelBooking(numTickets)) {
            System.out.println(numTickets + " tickets have been canceled.");
        } else {
            System.out.println("Failed to cancel tickets.");
        }
    }

    @Override
    public int getAvailableSeats(Event event) {
        return event.getAvailableSeats();
    }

    @Override
    public void displayEventDetails(Event event) {
        event.displayEventDetails();
    }

    public static void main(String[] args) {
        TicketBookingSystem tbs = new TicketBookingSystem();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nEnter a command: \n1. Create Event \n2. Book Tickets \n3. Cancel Tickets \n4. Get Available Seats \n5. Display Event Details \n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
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
                    sc.nextLine(); // consume newline
                    
                    System.out.print("Event Type (movie/concert/sports): ");
                    String eventType = sc.nextLine();
                    
                    System.out.print("Venue Name: ");
                    String venue = sc.nextLine();

                    Event event = tbs.createEvent(eventName, date, time, totalSeats, price, eventType, venue);
                    System.out.println("Event created successfully!");
                    break;
                    
                case 2:
                    System.out.println("Select event to book tickets:");
                    tbs.displayEventList(); // Assume a method to display event list
                    int eventIndex = sc.nextInt();
                    System.out.print("Enter number of tickets to book: ");
                    int numTickets = sc.nextInt();
                    tbs.bookTickets(tbs.events.get(eventIndex - 1), numTickets);
                    break;
                    
                case 3:
                    System.out.println("Select event to cancel tickets:");
                    tbs.displayEventList(); // Assume a method to display event list
                    eventIndex = sc.nextInt();
                    System.out.print("Enter number of tickets to cancel: ");
                    int cancelTickets = sc.nextInt();
                    tbs.cancelTickets(tbs.events.get(eventIndex - 1), cancelTickets);
                    break;
                    
                case 4:
                    System.out.println("Select event to check available seats:");
                    tbs.displayEventList(); // Assume a method to display event list
                    eventIndex = sc.nextInt();
                    int availableSeats = tbs.getAvailableSeats(tbs.events.get(eventIndex - 1));
                    System.out.println("Available seats: " + availableSeats);
                    break;
                    
                case 5:
                    System.out.println("Select event to display details:");
                    tbs.displayEventList(); // Assume a method to display event list
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
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getEventName() + " (" + events.get(i).getEventType() + ")");
        }
    }
}
