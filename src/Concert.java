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
	           double ticketPrice, String eventType, String artist, String type) {
		super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, eventType);
		this.artist = "unknown";
		this.type = "unknown";
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
	
	public void displayConcertDetails() {
		super.displayEventDetails();
		System.out.println("Artist : " + artist);
		System.out.println("Type : " + type);
	}

}
