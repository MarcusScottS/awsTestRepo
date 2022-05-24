package utopiaAirlines.basic;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Flight {



				private int flightId;
				private Timestamp departTime;
				private int seatsAvailable;
				private double price;
				private Timestamp arrivalTime;
				private String flightNumber;
				private String departureAirport;
				private String arrivalAirport;
				
				@Override
				public String toString() {
					return "Flight{"  + "flightId ='" + flightId + '\'' + "departTime='" + departTime + '\'' + "seatsAvailable ='" + seatsAvailable + '\'' + "price ='" + price + '\'' + ", arrivalTime ='" + arrivalTime + '\'' + ", flightNumber='" + flightNumber + '\'' + ", departureAirport='" + departureAirport + '\'' + ", arrivalAirport ='" + arrivalAirport + '}';
				}
				
				
				@Override
				public boolean equals(Object o) {
					if(this == o) return true;
					if(o == null || getClass() != o.getClass()) return false;
					Flight  flight = (Flight ) o;
					return  flightId == flight.flightId && departTime.equals(flight.departTime) && seatsAvailable == flight.seatsAvailable && price == flight.price && arrivalTime.equals(flight.arrivalTime) && flightNumber.equals(flight.flightNumber);

				}
				
				@Override
				public int hashCode() {
					return Objects.hash(flightId, departTime, seatsAvailable, price, arrivalTime, flightNumber, departureAirport, arrivalAirport);
				}
				
				public int getFlightId() {
					return flightId;
				}
				
				public void setFlightId(int flightId) {
					this.flightId = flightId;
				}
				
				public Timestamp getDepartTime() {
					return departTime;
				}
				
				public void setDepartTime(Timestamp departTime) {
					this.departTime = departTime;
				}
				
				
				public int getSeatsAvailable() {
					return seatsAvailable;
				}
				
				public void setSeatsAvailable(int seatsAvailable) {
					this.seatsAvailable = seatsAvailable;
				}
				
				public double getPrice() {
					return price;
				}
				
				public void setPrice(double price) {
					this.price = price;
				}
				
				
				public Timestamp getArrivalTime() {
					return arrivalTime;
				}
				
				public void setArrivalTime(Timestamp arrivalTime) {
					this.arrivalTime = arrivalTime;
				}
				
				public String getFlightNumber () {
					return flightNumber;
				}
				
				public void setFlightNumber(String flightNumber) {
					this.flightNumber = flightNumber;
				}
				
				public String getDepartureAirport () {
					return departureAirport;
				}
				
				public void setDepartureAirport(String departureAirport) {
					this.departureAirport = departureAirport;
				}
				
				public String getArrivalAirport () {
					return arrivalAirport;
				}
				
				public void setArrivalAirport(String arrivalAirport) {
					this.arrivalAirport = arrivalAirport;
				}
				
				
				// get seats
				public Flight(int flightId , int seatsAvailable) {
					this.flightId = flightId;
					this.seatsAvailable = seatsAvailable;
				}
				
				
				
				// when doing insertAirport manually
				public Flight( Timestamp departTime, int seatsAvailable, double price, Timestamp  arrivalTime, String flightNumber) {
					this.departTime = departTime;
					this.seatsAvailable = seatsAvailable;
					this.price = price;
					this.arrivalTime = arrivalTime;
					this.flightNumber = flightNumber;
				}
				
				// constuctor for testing
				public Flight(int flightId, Timestamp departTime, int seatsAvailable, double price, Timestamp arrivalTime, String flightNumber) {
					this.flightId = flightId;
					this.departTime = departTime;
					this.seatsAvailable = seatsAvailable;
					this.price = price;
					this.arrivalTime = arrivalTime;
				}
				
				// when using loop to populate an ArrayList of Airport(s)
				public Flight(int flightId, Timestamp departTime, int seatsAvailable, double price, Timestamp arrivalTime, String flightNumber, String departureAirport, String arrivalAirport) {
					this.flightId = flightId;
					this.departTime = departTime;
					this.seatsAvailable = seatsAvailable;
					this.price = price;
					this.arrivalTime = arrivalTime;
					this.flightNumber = flightNumber;
					this.departureAirport = departureAirport;
					this.arrivalAirport = arrivalAirport;
				}
}
