package utopiaAirlines.main;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import utopiaAirlines.basic.Airport;
import utopiaAirlines.basic.AirportDao;
import utopiaAirlines.basic.AirportUpdateDao;
import utopiaAirlines.basic.Booking;
import utopiaAirlines.basic.BookingDao;
import utopiaAirlines.basic.BookingUpdateDao;
import utopiaAirlines.basic.Employee;
import utopiaAirlines.basic.EmployeeDao;
import utopiaAirlines.basic.EmployeeUpdateDao;
import utopiaAirlines.basic.Flight;
import utopiaAirlines.basic.FlightBookingUpdateDao;
import utopiaAirlines.basic.FlightDao;
import utopiaAirlines.basic.FlightDetailsUpdateDao;
import utopiaAirlines.basic.FlightUpdateDao;
import utopiaAirlines.basic.Traveler;
import utopiaAirlines.basic.TravelerBookingUpdateDao;
import utopiaAirlines.basic.TravelerDao;
import utopiaAirlines.basic.TravelerUpdateDao;

//import jdbcAssignment.basic.SchoolUpdateDao;
//import jdbcAssignment.basic.StudentUpdateDao;


public class UtopiaDeleteDemo {

		
		public static void main(String args[]) throws SQLException, IOException, ClassNotFoundException {
			
			Scanner sc = new Scanner(System.in);
			
			
			/**************************************************************
						deleteAirport
			 ****************************************************************/
			
//			AirportDao airportDao = new AirportDao();
//			List<Airport> airports = airportDao.getAirports("tbl_airport");
//			if(airports == null) {
//				System.out.println("We have no airports!");
//				System.exit(0);
//			}
//			for(Airport airport: airports) {
//				System.out.println(airport);
//			}
//			System.out.println();
//			
//			String deleteAirportIataIdent = "";
//			System.out.println("Please type the iataIdent for the airport to delete");
//			deleteAirportIataIdent = sc.nextLine();
//			
//			
//			System.out.println("You have entered: " + deleteAirportIataIdent);
//	
//			
//			
//			AirportUpdateDao airportUpdateDao = new AirportUpdateDao();
//			airportUpdateDao.deleteAirport("tbl_airport", deleteAirportIataIdent);
//			System.out.println("deleteAirport finished");
			
//			AirportUpdateDao airportUpdateDao = new AirportUpdateDao();
//			airportUpdateDao.deleteAirport("tbl_airport", "JRT");
//			System.out.println("deleteAirport finished");
			
			
			
			
			/**************************************************************
							deleteBooking
			 ****************************************************************/
			
			
			
			
			
			BookingDao bookingDao = new BookingDao();
			List<Booking> bookings = bookingDao.getBookings("tbl_booking", "tbl_bookings_has_travelers", "tbl_flight_has_bookings");
			if(bookings == null) {
				System.out.println("We have no bookings!");
				System.exit(0);
			}
			
			for(Booking booking: bookings) {
				System.out.println(booking);
			}
			System.out.println();
			
			String bookingString = "";
			System.out.println("Please type the bookingId for the ticket to delete");
			bookingString = sc.nextLine();
			int bookingIdDelete = Integer.parseInt(bookingString);
			
			System.out.println("You have entered: " + bookingIdDelete);
			
			FlightBookingUpdateDao flightBookingUpdateDao = new FlightBookingUpdateDao();
			flightBookingUpdateDao.deleteFlightBookings("tbl_flight_has_bookings", bookingIdDelete);
			System.out.println("deleteBooking finished");
			
			TravelerBookingUpdateDao travelerBookingUpdateDao = new TravelerBookingUpdateDao();
			travelerBookingUpdateDao.deleteTravelerBooking("tbl_bookings_has_travelers", bookingIdDelete);
			System.out.println("deleteBooking finished");
			
			BookingUpdateDao bookingUpdateDao = new BookingUpdateDao();
			bookingUpdateDao.deleteBooking("tbl_booking", bookingIdDelete);
			System.out.println("deleteBooking finished");
			

//			BookingUpdateDao bookingUpdateDao = new BookingUpdateDao();
//			bookingUpdateDao.deleteBooking("tbl_booking", 178);
//			System.out.println("deleteBooking finished");
			
			
			
			
			
			/**************************************************************
							deleteEmployee
			 ****************************************************************/
			
//			in our menu		
//			EmployeeDao employeeDao = new EmployeeDao();
//			List<Employee> employees = employeeDao.getEmployees("tbl_users");
//			if(employees == null) {
//				System.out.println("We have no employees!");
//				System.exit(0);
//			}
//			
//			for(Employee employee: employees) {
//				System.out.println(employee);
//			}
//			System.out.println();
//			
//			String employeeDeleteString = "";
//			System.out.println("Please type the userId for the employee to delete");
//			employeeDeleteString = sc.nextLine();
//			int employeeIdDelete = Integer.parseInt(employeeDeleteString);
//			
//			System.out.println("You have entered: " + employeeIdDelete);
//
//			EmployeeUpdateDao employeeUpdateDao = new EmployeeUpdateDao();
//			employeeUpdateDao.deleteEmployee("tbl_users", employeeIdDelete);
//			System.out.println("deleteEmployee finished");
			
			
//			EmployeeUpdateDao employeeUpdateDao = new EmployeeUpdateDao();
//			employeeUpdateDao.deleteEmployee("tbl_users", 105);
//			System.out.println("deleteEmployee finished");

			
			
			
			
			/**************************************************************
						deleteFlight
			 ***************************************************************/
			
			
//			FlightDao flightDao = new FlightDao();
//			List<Flight> flights = flightDao.getFlights("tbl_flight", "tbl_flight_details");
//			if(flights == null) {
//				System.out.println("We have no flights!");
//				System.exit(0);
//			}
//			
//			for(Flight flight: flights) {
//				System.out.println(flight);
//			}
//			System.out.println();
//			
//			
//
//			String[] stringFlight = new String[2];
//			System.out.println("Please enter flightId and flightNumber for flight to delete: ");
//			for(int i = 0; i < stringFlight.length; i++) {
//				stringFlight[i] = sc.nextLine();
//			}
//			
//			int flightId;
//			String flightNumber;
//			System.out.println("You have entered");
//			
//			flightId = Integer.parseInt(stringFlight[0]);
//			flightNumber = stringFlight[1];	
//			System.out.println(flightId);
//			System.out.println(flightNumber);
//			
//			
//			
//			/**************************************************************
//						Step 1 deleteFlight
//			 ***************************************************************/
//			
//			FlightUpdateDao flightUpdateDao = new FlightUpdateDao();
//			flightUpdateDao.deleteFlight("tbl_flight", flightId);
//			System.out.println("deleteFlight finished");
//			
////			FlightUpdateDao flightUpdateDao = new FlightUpdateDao();
////			flightUpdateDao.deleteFlight("tbl_flight", 2913650);
////			System.out.println("deleteFlight finished");
//			
//			/**************************************************************
//						Step 2 deleteFlightDetails
//			 ***************************************************************/
//			
//			FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
//			flightDetailsUpdateDao.deleteFlightDetails("tbl_flight_details", flightNumber);
//			System.out.println("deleteFlightDetails finished");
//		
			
//			FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
//			flightDetailsUpdateDao.deleteFlightDetails("tbl_flight_details", "A13");
//			System.out.println("deleteFlightDetails finished");
			
			
			
			
			
			/**************************************************************
							deleteTraveler
			 ****************************************************************/
			
			
//			TravelerDao travelerDao = new TravelerDao();
//			List<Traveler> travelers = travelerDao.getTravelers("tbl_traveler");
//			if(travelers == null) {
//				System.out.println("We have no travelers!");
//				System.exit(0);
//			}
//			
//			for(Traveler traveler: travelers) {
//				System.out.println(traveler);
//			}
//			System.out.println();
//			
//			String travelerDeleteString = "";
//			System.out.println("Please type the travelerId for the traveler to delete");
//			travelerDeleteString = sc.nextLine();
//			int travelerIdDelete = Integer.parseInt(travelerDeleteString);
//			
//			System.out.println("You have entered: " + travelerIdDelete);
//			
//			
//
//			TravelerUpdateDao travelerUpdateDao = new TravelerUpdateDao();
//			travelerUpdateDao.deleteTraveler("tbl_traveler", travelerIdDelete);
//			System.out.println("deleteTraveler finished");
			

//			TravelerUpdateDao travelerUpdateDao = new TravelerUpdateDao();
//			travelerUpdateDao.deleteTraveler("tbl_traveler", 102);
//			System.out.println("deleteTraveler finished");
			
			
		
		}
}
