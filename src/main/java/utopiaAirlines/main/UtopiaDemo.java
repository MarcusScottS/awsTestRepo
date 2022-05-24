package utopiaAirlines.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import utopiaAirlines.basic.Airport;
import utopiaAirlines.basic.AirportDao;
import utopiaAirlines.basic.Booking;
import utopiaAirlines.basic.BookingDao;
import utopiaAirlines.basic.Employee;
import utopiaAirlines.basic.EmployeeDao;
import utopiaAirlines.basic.Flight;
import utopiaAirlines.basic.FlightBooking;
import utopiaAirlines.basic.FlightBookingDao;
import utopiaAirlines.basic.FlightDao;
import utopiaAirlines.basic.FlightDetails;
import utopiaAirlines.basic.FlightDetailsDao;
import utopiaAirlines.basic.Traveler;
import utopiaAirlines.basic.TravelerBooking;
import utopiaAirlines.basic.TravelerBookingDao;
import utopiaAirlines.basic.TravelerDao;

//import jdbcAssignment.basic.School;
//import jdbcAssignment.basic.SchoolDao;
//import jdbcAssignment.basic.Student;
//import jdbcAssignment.basic.StudentDao;

public class UtopiaDemo {
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
		
		
		/**************************************************************
						getAirports
		 ****************************************************************/

//		 in our menu
//		AirportDao airportDao = new AirportDao();
//		List<Airport> airports = airportDao.getAirports("tbl_airport");
//		if(airports == null) {
//			System.out.println("We have no airports!");
//			System.exit(0);
//		}
//		for(Airport airport: airports) {
//			System.out.println(airport);
//		}
//		System.out.println();

		
		
		
		/**************************************************************
					getBookings
		 ****************************************************************/
		

//		in our menu
//		BookingDao bookingDao = new BookingDao();
//		List<Booking> bookings = bookingDao.getBookings("tbl_booking", "tbl_bookings_has_travelers", "tbl_flight_has_bookings");
//		if(bookings == null) {
//			System.out.println("We have no bookings!");
//			System.exit(0);
//		}
//		
//		for(Booking booking: bookings) {
//			System.out.println(booking);
//		}
//		System.out.println();
		
		

		/**************************************************************
					getCancellations
		 ****************************************************************/

//		BookingDao bookingDao = new BookingDao();
//		List<Booking> bookings = bookingDao.getCancellations("tbl_booking" , "tbl_bookings_has_travelers", "tbl_flight_has_bookings");
//		if(bookings == null) {
//			System.out.println("We have no cancellations!");
//			System.exit(0);
//		}
//		
//		for(Booking booking: bookings) {
//			System.out.println(booking);
//		}
//		System.out.println();
		
		
		
		/**************************************************************
					getEmployees
		 ****************************************************************/
		
		
//		in our menu		
//		EmployeeDao employeeDao = new EmployeeDao();
//		List<Employee> employees = employeeDao.getEmployees("tbl_users");
//		if(employees == null) {
//			System.out.println("We have no employees!");
//			System.exit(0);
//		}
//		
//		for(Employee employee: employees) {
//			System.out.println(employee);
//		}
//		System.out.println();
		
		
		
		/**************************************************************
						getFlights
		 ****************************************************************/
		
		
//		in our menu		
//		FlightDao flightDao = new FlightDao();
//		List<Flight> flights = flightDao.getFlights("tbl_flight", "tbl_flight_details");
//		if(flights == null) {
//			System.out.println("We have no flights!");
//			System.exit(0);
//		}
//		
//		for(Flight flight: flights) {
//			System.out.println(flight);
//		}
//		System.out.println();
		
		
		
		
		
//		FlightDetailsDao flightDetailsDao = new FlightDetailsDao();
//		List<FlightDetails> flightDetails = flightDetailsDao.getFlightDetails("tbl_flight_details");
//		if(flightDetails == null) {
//			System.out.println("We have no details for this flight!");
//			System.exit(0);
//		}
//		
//		for(FlightDetails flightDetail: flightDetails) {
//			System.out.println(flightDetail);
//		}
//		System.out.println();
		
		
		
//		in our menu		
//		FlightDao flightDao = new FlightDao();
//		List<Flight> flights = flightDao.getSeats("tbl_flight");
//		if(flights == null) {
//			System.out.println("We have no flights!");
//			System.exit(0);
//		}
//		
//		for(Flight flight: flights) {
//			System.out.println(flight);
//		}
//		System.out.println();
		
		
		
		/**************************************************************
				getFlightBookings
		 ****************************************************************/


//in our menu
		FlightBookingDao flightBookingDao = new FlightBookingDao();
		List<FlightBooking> flightBookings = flightBookingDao.getFlightBookings("tbl_flight_has_bookings");
		if(flightBookings == null) {
			System.out.println("We have no flight bookings!");
			System.exit(0);
		}
		
		for(FlightBooking flightBooking: flightBookings) {
			System.out.println(flightBooking);
		}
		System.out.println();
		
		
		
		
		
		
		/**************************************************************
					getTravelers
		 ****************************************************************/

		// in our menu
//		TravelerDao travelerDao = new TravelerDao();
//		List<Traveler> travelers = travelerDao.getTravelers("tbl_traveler");
//		if(travelers == null) {
//			System.out.println("We have no travelers!");
//			System.exit(0);
//		}
//		
//		for(Traveler traveler: travelers) {
//			System.out.println(traveler);
//		}
//		System.out.println();
		
		/**************************************************************
				getTravelers
		 ****************************************************************/

		// in our menu
	TravelerBookingDao travelerBookingDao = new TravelerBookingDao();
	List<TravelerBooking> travelerBookings = travelerBookingDao.getTravelerBookings("tbl_bookings_has_travelers");
	if(travelerBookings == null) {
	System.out.println("We have no traveler bookings!");
	System.exit(0);
	}
	
	for(TravelerBooking travelerBooking: travelerBookings) {
	System.out.println(travelerBooking);
	}
	System.out.println();

	}
}
