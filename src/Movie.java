import java.time.LocalDate;
import java.time.LocalTime;

public class Movie extends Event {
	private String genre;
	private String actorName;
	private String actressName;
	
	public Movie(){
		super();
		this.genre = "unknown";
		this.actorName = "unknown";
		this.actressName = "unknown";
	}
	
	public Movie(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName, int totalSeats,
	           double ticketPrice,String genre, String actorName, String actressName) {
		super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, "Movie");
		this.genre =genre;
		this.actorName = actorName;
		this.actressName = actressName;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getActorName() {
		return actorName;
	}
	
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	
	public String getActressName() {
		return actressName;
	}
	
	public void setActressName(String actressName) {
		this.actressName = actressName;
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
        System.out.println("Genre: " + genre);
        System.out.println("Actor Name: " + actorName);
        System.out.println("Actress Name: " + actressName);
	}
	
	
	
}
