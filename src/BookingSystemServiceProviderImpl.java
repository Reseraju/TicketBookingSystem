
public class BookingSystemServiceProviderImpl implements IBookingSystemServiceProvider {

	@Override
	public double calculateBookingCost(int numTickets, double ticketPrice) {
		return numTickets * ticketPrice;
	}

	@Override
	public Booking bookTickets(String eventName, int numTickets, Customer[] customers) {
		
		return null;
	}

	@Override
	public boolean cancel_booking(int bookingId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Booking get_booking_details(int bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

}
