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
	           double ticketPrice, String eventType, String sportName, String teamsName) {
		super(eventName, eventDate, eventTime, venueName, totalSeats, ticketPrice, eventType);
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
	
	public void displaySportDetails() {
		super.displayEventDetails();
		System.out.println("Sport Name : " + sportName);
		System.out.println("Teams Name : " + teamsName);
	}

}
