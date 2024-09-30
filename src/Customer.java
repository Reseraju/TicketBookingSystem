
public class Customer {
	String customerName;
	String email;
	String phoneNumber;
	
	
	// Default constructor
	Customer(){
		customerName = null;
		email = null;
		phoneNumber = null;
	}
	
	
	// Getter and Setter methods
	public String getCustomerName() {
		return customerName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhonenUmber() {
		return phoneNumber;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	// Display Customer Details method
	public void displayCustomerDetails() {
		System.out.println("Customer Name : " + customerName);
		System.out.println("Customer Email : " + email);
		System.out.println("Phone number : " + phoneNumber);
	}
}
