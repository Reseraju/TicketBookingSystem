package Bean;

public class Venue {
	
	private String venueName;
	private String address;
	
	public Venue(){
		venueName = null;
		address = null;
	}
	
	Venue(String venueName, String address){
		this.venueName = venueName;
		this.address = address;
	}
	
	public String getVenueName() {
		return venueName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void displayVenueDetails() {
		System.out.println("Venue Name : " + venueName);
		System.out.println("Address : " + address);
	}

}
