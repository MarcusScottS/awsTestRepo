package utopiaAirlines.main;


import java.sql.*;

import utopiaAirlines.basic.AirportDao;
import utopiaAirlines.basic.BookingDao;
import utopiaAirlines.basic.EmployeeDao;
import utopiaAirlines.basic.FlightBookingDao;
import utopiaAirlines.basic.FlightDao;
import utopiaAirlines.basic.FlightDetailsDao;
import utopiaAirlines.basic.TravelerBookingDao;
import utopiaAirlines.basic.TravelerDao;

public class RSMDDemo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("tbl_airport");
		AirportDao airportDao = new AirportDao();
		System.out.println(airportDao.getColumnNames("tbl_airport"));
		System.out.println();
		
		System.out.println("tbl_booking for tickets");
		BookingDao bookingDao = new BookingDao();
		System.out.println(bookingDao.getColumnNames("tbl_booking"));
		System.out.println();
		
		System.out.println("tbl_booking for cancellations");
//		TravelerDao travelerDao = new TravelerDao();
//		System.out.println(travelerDao.getColumnNames("tbl_userr"));
		System.out.println();
		
		System.out.println("tbl_traveler");
		TravelerDao travelerDao = new TravelerDao();
		System.out.println(travelerDao.getColumnNames("tbl_traveler"));
		System.out.println();
		
		
		System.out.println("tbl_flight");
		FlightDao flightDao = new FlightDao();
		System.out.println(flightDao.getColumnNames("tbl_flight"));
		System.out.println();
		
		System.out.println("tbl_flight_details");
		FlightDetailsDao flightDetailsDao = new FlightDetailsDao();
		System.out.println(flightDetailsDao.getColumnNames("tbl_flight_details"));
		System.out.println();
		
		System.out.println("tbl_flight_has_bookings");
		FlightBookingDao flightBookingDao = new FlightBookingDao();
		System.out.println(flightBookingDao.getColumnNames("tbl_flight_has_bookings"));
		System.out.println();
		
//		System.out.println("tbl_flight for seats");
//		TravelerDao travelerDao = new TravelerDao();
//		System.out.println(travelerDao.getColumnNames("tbl_userr"));
//		System.out.println();
		
		System.out.println("tbl_bookings_has_travelers");
		TravelerBookingDao travelerBookingDao = new TravelerBookingDao();
		System.out.println(travelerBookingDao.getColumnNames("tbl_bookings_has_travelers"));
		System.out.println();
		

	}
	
}