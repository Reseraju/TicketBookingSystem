import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class TicketBookingSystem {
	
	public Event createEvent(String eventName, String date, String time, int totalSeats, 
			double ticketPrice, String eventType, String venueName ) {
		
		LocalDate eventDate = LocalDate.parse(date);
		LocalTime eventTime = LocalTime.parse(time);
		
		switch(eventType) {
		case "movie":
			return new Movie(eventName, eventDate, eventTime, venueName, totalSeats,
	           ticketPrice, eventType, "Action",  "Tom Hans",  "Reese Witherspoon");
			
		case "concert":
			return new Concert(eventName, eventDate, eventTime, venueName, totalSeats,
	           ticketPrice, eventType, "Coldplay", "Rock");
			
		case "sports":
			return new Sports(eventName, eventDate, eventTime, venueName, totalSeats,
			           ticketPrice, eventType, "Cricket", "India Vs Pakistan");
			
		default:
			System.out.println("Invalid event type. Creating a default event...");
			return new Event(eventName, eventDate, eventTime, venueName, totalSeats,
	            ticketPrice, eventType);
		}
	}
	
	
	public void displayEventDetails(Event event) {
		event.displayEventDetails();
	}
	
	public void bookTickets(Event event, int numTickets) {
		if(event.bookTickets(numTickets)) {
			System.out.println("Total Cost : $" + numTickets * event.getTicketPrice());
		}
	}
	
	public void cancelTickets(Event event, int numTickets) {
		if(event.cancelBooking(numTickets)) {
			System.out.println(numTickets + " tickets have been canceled.");
		}
	}
	
	
	
	public static void main(String[] args) {
		TicketBookingSystem tbs = new TicketBookingSystem();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Ticket Booking System :)");
		System.out.println("------------------------------------");
		
		System.out.println("Enter your choice \n1. Movie \n2. Concert\n3. Sports \n");
		int choice = sc.nextInt();
		
		String eventType = "";
		switch(choice) {
		case 1:
			eventType = "movie";
			break;
		
		case 2:
			eventType = "concert";
			break;
			
		case 3:
			eventType = "sport";
			break;
			
		default:
			System.out.println("Invalid choice");
			return;
		}
		
		//creating a sample event
		System.out.println("Creating a sample event....");
		Event event = tbs.createEvent("sample event", "2024-09-04", "19:00", 100, 50.0, eventType, "Grand Venue");
		
		tbs.displayEventDetails(event);
		
		//ticket booking
		System.out.println("Enter number of tickets to book: ");
		int numTickets = sc.nextInt();
		tbs.bookTickets(event, numTickets);
		
		//ticket cancellation
		System.out.println("Enter number of tickets to cancel: ");
		int cancelTickets = sc.nextInt();
		tbs.cancelTickets(event, cancelTickets);
		
		sc.close();
	}

}
