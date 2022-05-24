package utopiaAirlines.basic;

import java.util.Objects;

public class FlightBooking {



	

				private int flightId;
				private int bookingId;
			
				
				@Override
				public String toString() {
					return "FlightBooking{"  + "flightId ='" + flightId + '\'' + "bookId='" + bookingId  + '}';
				}
				
				
				@Override
				public boolean equals(Object o) {
					if(this == o) return true;
					if(o == null || getClass() != o.getClass()) return false;
					FlightBooking flightBooking = (FlightBooking) o;
					return  flightId == flightBooking.flightId && bookingId == flightBooking.bookingId;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(flightId, bookingId);
				}
				
				public int getFlightId() {
					return flightId;
				}
				
				public void setFlightId(int flightId) {
					this.flightId = flightId;
				}
				
				public int getBookingId() {
					return bookingId;
				}
				
				public void setBookingId(int bookingId) {
					this.bookingId = bookingId;
				}
				
				
				
				public FlightBooking(int flightId, int bookingId) {
					this.flightId = flightId;
					this.bookingId = bookingId;
				}
}	