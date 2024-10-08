package Bean;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Event {
	
	private String eventName;
	private LocalDate eventDate;
	private LocalTime eventTime;
	private String venueName;
	private int totalSeats;
	private int availableSeats;
	private double ticketPrice;
	private String eventType;
	
	//default constructor
	public Event()
	{
		this.eventName = "unknown";
		this.eventDate = null;
		this.eventTime = null;
		this.venueName = null;
		this.totalSeats = 0;
		this.availableSeats = 0;
		this.ticketPrice = 0.0;
		this.eventType = "unknown";
	}
	
	public Event(String eventName, LocalDate eventDate, LocalTime eventTime, Venue venue,int totalSeats,
	           double ticketPrice, String eventType ) {
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.venueName = venue.getVenueName();
		this.totalSeats = totalSeats;
		this.availableSeats = totalSeats;
		this.ticketPrice = ticketPrice;
		this.eventType = eventType;
	}
	
	// abstract method for displaying different events
    public abstract void displayEventDetails();
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public LocalDate getEventDate() {
		return eventDate;
	}
	
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	
	public LocalTime getEventTime() {
		return eventTime;
	}
	
	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}
	
	public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
    
    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    
    
    // calculate total revenue 
    public double calculateTotalRevenue() {
    	double ticketSold = totalSeats - availableSeats;
    	return ticketPrice * ticketSold;
    }
    
    // total tickets booked
    public int getBookedNoOfTickets() {
    	return totalSeats - availableSeats;
    }
    
    // book tickets
    public boolean bookTickets(int numTickets) {
    	if(availableSeats >= numTickets) {
    		availableSeats -= numTickets;
    		System.out.println("Ticket Booked Successfully :)");
    		return true;
    	}
    	else {
    		System.out.println("Not enough Available Seats :(");
    		return false;
    	}
    }
    
    
    // cancel tickets
    public boolean cancelBooking(int numTickets) {
    	if(numTickets <= (totalSeats - availableSeats)) {
    		availableSeats += numTickets;
    		System.out.println("Ticket Successfully Canceled");
    		return true;
    	}
    	else {
    		System.out.println("Cannot cancel more tickets than bokked!!");
    		return false;
    	}
    }
    

}
