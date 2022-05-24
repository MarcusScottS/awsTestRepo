package utopiaAirlines.basic;


import java.util.Objects;

public class Booking {
	
	
	
	private int bookingId;
	private int isActive;
	private String stripeId;
	private int bookerId;
	private int travelerId;
	private int flightId;

	
	@Override
	public String toString() {
		return "Ticket{"  + "bookingId ='" + bookingId + '\'' + "isActive='" + isActive + '\'' + "stripeId ='" + stripeId + '\'' + " bookerId ='" + bookerId + '\'' + " travelerId ='" + travelerId +  '\'' + ", flightId ='" + flightId + '}';
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Booking booking = (Booking ) o;
		return  bookingId == booking.bookingId && isActive == booking.isActive && stripeId.equals(booking.stripeId) && bookerId == booking.bookerId && travelerId == booking.travelerId && flightId == booking.flightId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bookingId, isActive, stripeId, bookerId, travelerId, flightId);
	}
	
	public int getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	public int getIsActive() {
		return isActive;
	}
	
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	public String getStripeId () {
		return stripeId;
	}
	
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}
	
	public int getBookerId() {
		return bookerId;
	}
	
	public void setBookerId(int bookerId) {
		this.bookerId = bookerId;
	}
	
	public int getTravelerId() {
		return travelerId;
	}
	
	public void setTravelerId(int travelerId) {
		this.travelerId = travelerId;
	}
	
	public int getFlightId() {
		return flightId;
	}
	
	public void seFlightId(int flightId) {
		this.flightId = flightId;
	}
	
	
	
	
	// when doing insertTravler manually
	public Booking( int isActive, String stripeId, int bookerId, int travelerId, int flightId) {
		this.isActive = isActive;
		this.stripeId = stripeId;
		this.bookerId = bookerId;
		this.travelerId = travelerId;
		this.flightId = flightId;
	}
	
	// when using loop to popular an ArrayList of Traveler(s)
	public Booking(int bookingId, int isActive, String stripeId, int bookerId, int travelerId, int flightId) {
		this.bookingId = bookingId;
		this.isActive = isActive;
		this.stripeId = stripeId;
		this.bookerId = bookerId;
		this.travelerId = travelerId;
		this.flightId = flightId;
	}

}
