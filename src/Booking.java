//import java.time.LocalDate;
//import java.time.LocalTime;
//
//
//public class Booking {
//	
//	private Event event;
//	private int numTickets;
//	private double totalCost;
//	
//	
//	// default constructor
//	Booking(){
//		this.event = new Event();
//		this.numTickets = 0;
//		this.totalCost = 0.0;
//	}
//	
//	
//	// parameterized constructor
//	Booking(Event event){
//		this.event =event;
//		this.numTickets = 0;
//		this.totalCost = 0.0;
//	}
//	
//	public void calculateBookingCost(int numTickets) {
//		this.totalCost = numTickets * event.getTicketPrice() ;
//		System.out.println("Total Cost for " + numTickets + " tickets: " + this.totalCost);
//	}
//	
//	public void bookTickets(int numTickets) {
//		boolean bookingSuccess = event.bookTickets(numTickets);
//		if(bookingSuccess) {
//			this.numTickets += numTickets;
//			System.out.println("Booked " + numTickets + " for the event " + event.getEventName());
//		}
//		else {
//			System.out.println("Booking failed. Not enough available seats!");
//		}
//	}
//	
//	public void cancelTickets(int numTickets) {
//		boolean cancelSuccess = event.cancelBooking(numTickets);
//		if(cancelSuccess) {
//			this.numTickets -= numTickets;
//			System.out.println("Cancel " + numTickets + " tickets for event " + event.getEventName());
//		}
//		else {
//			System.out.println("Cancellation failed. Not enough tickets to cancel");
//		}
//	}
//	
//	public void getAvailableNoOfTickets() {
//		int availableTickets = event.getAvailableSeats();
//		System.out.println("Available tickets for event: " + availableTickets);
//	}
//	
//	public void getEventDetails() {
//		event.displayEventDetails();
//	}
//	
//	public static void main(String[] args) {
//		
//		Event event1 = new Event("Rock Concert", LocalDate.of(2024, 10, 15), LocalTime.of(20, 0),
//                "Stadium A", 5000, 100, "Concert");
//		
//		Booking booking1 = new Booking(event1);
//		
//		System.out.println("-----------------Event Details-------------------\n");
//		booking1.getEventDetails();
//		
//		System.out.println("\n-----------------Booking Tickets-------------------\n");
//		booking1.bookTickets(100);
//		
//		System.out.println("\n-----------------Displaying available tickets-------------------\n");
//		booking1.getAvailableNoOfTickets();
//		
//		System.out.println("\n-----------------Cancelling Tickets-------------------\n");
//		booking1.cancelTickets(50);
//		
//		System.out.println("\n-----------------Displaying available tickets-------------------\n");
//		booking1.getAvailableNoOfTickets();
//	
//	}
//
//}
