import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event {
	
	private String artist;
	private String type;
	
	public Concert() {
		super();
		this.artist = "unknown";
		this.type = "unknown";
	}
	
	public Concert(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,int totalSeats,
	           double ticketPrice, String artist, String type) {
		super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, "Concert");
		this.artist = artist;
		this.type = type;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	// Implement the abstract method
    @Override
	public void displayEventDetails() {
		System.out.println("Event Name: " + getEventName());
        System.out.println("Event Date: " + getEventDate());
        System.out.println("Event Time: " + getEventTime());
        System.out.println("Event Venue: " + getVenueName());
        System.out.println("Total Seats: " + getTotalSeats());
        System.out.println("Available Seats: " + getAvailableSeats());
        System.out.println("Ticket Price: $" + getTicketPrice());
        System.out.println("Artist : " + artist);
		System.out.println("Type : " + type);
	}

}
