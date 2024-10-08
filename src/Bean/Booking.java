package Bean;
import java.time.LocalDate;
import java.time.LocalTime;


public class Booking {
	
	private Event event;  // Reference to the Event class (it can refer to any subclass of Event)
	private int numTickets;
	private double totalCost;
	
	
	// default constructor
	Booking(){
		this.event = null;
		this.numTickets = 0;
		this.totalCost = 0.0;
	}
	
	
	// parameterized constructor
	Booking(Event event){
		this.event =event;   // Now event will refer to a concrete subclass object
		this.numTickets = 0;
		this.totalCost = 0.0;
	}
	
	public void calculateBookingCost(int numTickets) {
		this.totalCost = numTickets * event.getTicketPrice() ;
		System.out.println("Total Cost for " + numTickets + " tickets: " + this.totalCost);
	}
	
	public void bookTickets(int numTickets) {
		boolean bookingSuccess = event.bookTickets(numTickets);
		if(bookingSuccess) {
			this.numTickets += numTickets;
			System.out.println("Booked " + numTickets + " for the event " + event.getEventName());
		}
		else {
			System.out.println("Booking failed. Not enough available seats!");
		}
	}
	
	public void cancelTickets(int numTickets) {
		boolean cancelSuccess = event.cancelBooking(numTickets);
		if(cancelSuccess) {
			this.numTickets -= numTickets;
			System.out.println("Cancel " + numTickets + " tickets for event " + event.getEventName());
		}
		else {
			System.out.println("Cancellation failed. Not enough tickets to cancel");
		}
	}
	
	public void getAvailableNoOfTickets() {
		int availableTickets = event.getAvailableSeats();
		System.out.println("Available tickets for event: " + availableTickets);
	}
	
	public void getEventDetails() {
		event.displayEventDetails();
	}

}
