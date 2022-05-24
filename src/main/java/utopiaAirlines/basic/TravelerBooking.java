package utopiaAirlines.basic;

import java.util.Objects;

public class TravelerBooking {


					private int bookingId;
					private int travelerId;
				
					
					@Override
					public String toString() {
						return "TravelerBooking{"  + "bookingId ='" + bookingId + '\'' + "travelerId='" + travelerId  + '}';
					}
					
					
					@Override
					public boolean equals(Object o) {
						if(this == o) return true;
						if(o == null || getClass() != o.getClass()) return false;
						TravelerBooking travelerBooking = (TravelerBooking) o;
						return  bookingId == travelerBooking.bookingId && travelerId == travelerBooking.travelerId;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(bookingId, travelerId);
					}
					
					
					public int getBookingId() {
						return bookingId;
					}
					
					public void setBookingId(int bookingId) {
						this.bookingId = bookingId;
					}
					
					public int getTravelerId() {
						return travelerId;
					}
					
					public void setTravelerId(int travelerId) {
						this.travelerId = travelerId;
					}
					
					public TravelerBooking(int bookingId, int travelerId) {
						this.bookingId = bookingId;
						this.travelerId = travelerId;
					}
	
}