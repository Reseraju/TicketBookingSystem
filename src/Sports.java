import java.time.LocalDate;
import java.time.LocalTime;

public class Sports extends Event {
	
	private String sportName;
	private String teamsName;
	
	public Sports() {
		super();
		this.sportName = "unknown";
		this.teamsName = "unknown";
	}
	
	public Sports(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName,int totalSeats,
	           double ticketPrice, String sportName, String teamsName) {
		super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, "Sports");
		this.sportName = sportName;
		this.teamsName = teamsName;
	}
	
	public String getSportName() {
		return sportName;
	}
	
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	
	public String getTeamsName() {
		return teamsName;
	}
	
	public void setTeamsName(String teamsName) {
		this.teamsName = teamsName;
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
        System.out.println("Sport Name : " + sportName);
		System.out.println("Teams Name : " + teamsName);
	}
}
