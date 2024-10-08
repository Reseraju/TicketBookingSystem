
public interface IBookingSystemServiceProvider {
	double calculateBookingCost(int numTickets, double ticketPrice);
	Booking bookTickets(String eventName, int numTickets, Customer[] customers);
	boolean cancel_booking(int bookingId);
	Booking get_booking_details(int bookingId);
}
