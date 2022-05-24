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
import utopiaAirlines.basic.FlightDao;
import utopiaAirlines.basic.FlightDetailsUpdateDao;
import utopiaAirlines.basic.FlightUpdateDao;
import utopiaAirlines.basic.Traveler;
import utopiaAirlines.basic.TravelerDao;
import utopiaAirlines.basic.TravelerUpdateDao;

//import jdbcAssignment.basic.SchoolUpdateDao;
//import jdbcAssignment.basic.StudentUpdateDao;

public class UtopiaUpdateDemo {
	
//		updateAirport(String tableName, String iataIdent,  String city, String name, int airportId)
		public static void main(String args[]) throws SQLException, IOException, ClassNotFoundException {
			
			Scanner sc = new Scanner(System.in);
			
			
			/**************************************************************
						updateAirport
			 ****************************************************************/
			
			
//			
			AirportDao airportDao = new AirportDao();
			List<Airport> airports = airportDao.getAirports("tbl_airport");
			if(airports == null) {
				System.out.println("We have no airports!");
				System.exit(0);
			}
			for(Airport airport: airports) {
				System.out.println(airport);
			}
			System.out.println();
			
			String[] stringAirportUpdate = new String[4];
			System.out.println("Please enter the iataIdent to select airport, and then enter update values : city, name, airportId");
			for(int i = 0; i < stringAirportUpdate.length; i++) {
				stringAirportUpdate[i] = sc.nextLine();
			}
//			
			String iataIdent;
			String city;
			String name;
			int airportId;
			System.out.println("You have entered");
		//	
			iataIdent = stringAirportUpdate[0];
			city = stringAirportUpdate[1];
			name = stringAirportUpdate[2];
			airportId = Integer.parseInt(stringAirportUpdate[3]);
//		//	
			System.out.println(iataIdent);
			System.out.println(city);
			System.out.println(name);
			System.out.println(airportId);

			
			
			System.out.println("You have entered: " + iataIdent + ", " + city + ", " + name + ", " + airportId);
//			
//			
			AirportUpdateDao airportUpdateDao = new AirportUpdateDao();
			airportUpdateDao.updateAirport("tbl_airport", iataIdent, city, name,  airportId);
			System.out.println("updateAirport finished");
			
			
			
			/**************************************************************
						updateBooking
			 ****************************************************************/
			
//			BookingDao bookingDao = new BookingDao();
//			List<Booking> bookings = bookingDao.getBookings("tbl_booking");
//			if(bookings == null) {
//				System.out.println("We have no bookings!");
//				System.exit(0);
//			}
//			
//			for(Booking booking: bookings) {
//				System.out.println(booking);
//			}
//			System.out.println();
//			
//			String[] stringBooking = new String[4];
//			System.out.println("Please enter the bookingID to select ticket, and then enter update values : int isAcive, String stripeId, int bookerId");
//			for(int i = 0; i < stringBooking.length; i++) {
//				stringBooking[i] = sc.nextLine();
//			}
//			
//			int bookingId;
//			int isActive;
//			String stripeId;
//			int bookerId;
//			
//			bookingId = Integer.parseInt(stringBooking[0]);
//			isActive = Integer.parseInt(stringBooking[1]);
//			stripeId = stringBooking[2];
//			bookerId= Integer.parseInt(stringBooking[3]);
//		
//			System.out.println("You have entered: " + bookingId + ", " + isActive + ", " + stripeId + ", " + bookerId);
//			
//			
//			BookingUpdateDao bookingUpdateDao = new BookingUpdateDao();
//			bookingUpdateDao.updateBooking("tbl_booking", bookingId, isActive, stripeId,  bookerId);
//			System.out.println("updateBooking finished");
			
//			BookingUpdateDao bookingUpdateDao = new BookingUpdateDao();
//			bookingUpdateDao.updateBooking("tbl_booking", 177, 1, "321CBA",  104);
//			System.out.println("updateBooking finished");
			
			
			
			/**************************************************************
						updateCancellations
			 ****************************************************************/

//			 BookingDao bookingDao = new BookingDao();
//			 List<Booking> bookings = bookingDao.getCancellations("tbl_booking");
//			 if(bookings == null) {
//				System.out.println("We have no cancellations!");
//				System.exit(0);
//			}
//			
//			for(Booking booking: bookings) {
//				System.out.println(booking);
//			}
//			System.out.println();
//			
//			String[] stringBooking = new String[2];
//			System.out.println("Please enter the bookingID to select ticket, and then enter 1 to set isActive to true : int isAcive");
//			for(int i = 0; i < stringBooking.length; i++) {
//				stringBooking[i] = sc.nextLine();
//			}
//			
//			int bookingId;
//			int isActive;
//			
//			bookingId = Integer.parseInt(stringBooking[0]);
//			isActive = Integer.parseInt(stringBooking[1]);
//			
//			System.out.println("You have entered: " + bookingId + ", " + isActive);
//			
//			
//			BookingUpdateDao bookingUpdateDao = new BookingUpdateDao();
//			bookingUpdateDao.updateCancellation("tbl_booking", bookingId, isActive);
//			System.out.println("updateBooking finished");
			
			
			
			
			
			/**************************************************************
						updateEmployee
			 ****************************************************************/
			
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
//			
//			String[] stringUserUpdate = new String[8];
//			System.out.println("Please enter the userId to select employee, and then enter update values : String password, String email, String firstName, String lastName, int enabled, int locked, int userRole");
//			for(int i = 0; i < stringUserUpdate.length; i++) {
//				stringUserUpdate[i] = sc.nextLine();
//			}
//			
//			int userId;
//			String password;
//			String email;
//			String firstName;
//			String lastName;
//			int enabled;
//			int locked;
//			int userRole;
//		
//
//			userId = Integer.parseInt(stringUserUpdate[0]);
//			password = stringUserUpdate[1];
//			email = stringUserUpdate[2];
//			firstName =stringUserUpdate[3];
//			lastName = stringUserUpdate[4];
//			enabled = Integer.parseInt(stringUserUpdate[5]);
//			locked = Integer.parseInt(stringUserUpdate[6]);
//			userRole = Integer.parseInt(stringUserUpdate[7]);
//		
//			
//			System.out.println("You have entered: " + userId + ", " + password + ", " + email + ", " + firstName + ", " + lastName + ", " + enabled + ", " + locked + ", " + userRole + ", ");
//			
//			EmployeeUpdateDao employeeUpdateDao = new EmployeeUpdateDao();
//			employeeUpdateDao.updateEmployee("tbl_users", userId, password, email, firstName, lastName, enabled, locked, userRole);
//			System.out.println("updateEmployee finished");

//			EmployeeUpdateDao employeeUpdateDao = new EmployeeUpdateDao();
//			employeeUpdateDao.updateEmployee("tbl_users", 104, "agt124", "employee2@mail.com", "Dilly", "Doe", 1, 0, 2);
//			System.out.println("updateEmployee finished");
			
			
			
			/**************************************************************
					updateFlight
			 ****************************************************************/
			
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
//			String[] stringFlightUpdate = new String[8];
//			System.out.println("Please enter the flightId and flightNumber to select flight, and then enter update values : String departCityId, String arriveCityId, TimeStamp departTime, int seatsAvailable, double price, TimeStamp arrivalTime");
//			for(int i = 0; i < stringFlightUpdate.length; i++) {
//				stringFlightUpdate[i] = sc.nextLine();
//			}
//			
//			int flightId;
//			String flightNumber;
//			String departCityId;
//			String arriveCityId;
//			Timestamp departTime;
//			int seatsAvailable;
//			double price;
//			Timestamp arrivalTime;
//			
//			System.out.println("You have entered");
//			
//			flightId = Integer.parseInt(stringFlightUpdate[0]);
//			flightNumber = stringFlightUpdate[1];
//			departCityId = stringFlightUpdate[2];
//			arriveCityId = stringFlightUpdate[3];
//			departTime = Timestamp.valueOf(stringFlightUpdate[4]);
//			seatsAvailable = Integer.parseInt(stringFlightUpdate[5]);
//			price = Double.parseDouble(stringFlightUpdate[6]);
//			arrivalTime = Timestamp.valueOf(stringFlightUpdate[7]);
//			
//			
//			
//			System.out.println("You have entered: " + flightId + ", " + flightNumber + ", " + departCityId + ", " + arriveCityId + ", " + departTime + ", " + seatsAvailable + ", " + price + ", " + arrivalTime);
			
			
//					FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
//					flightDetailsUpdateDao.updateFlightDetails("tbl_flight_details", flightNumber, departCityId, arriveCityId);
//					System.out.println("updateFlightDetails finished");
			
			//			FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
			//			flightDetailsUpdateDao.updateFlightDetails("tbl_flight_details", "A13", "JFK", "LHR");
			//			System.out.println("updateFlightDetails finished");
			
			
//			help with understanding input
//			public void updateFlight(String tableName, int flightId, TimeStamp departTime, int seatsAvailable, double price, Date arrivalTime) 
			
//			FlightUpdateDao flightUpdateDao = new FlightUpdateDao();
//			flightUpdateDao.updateFlight("tbl_flight", flightId,  departTime , seatsAvailable, price, arrivalTime);
//			System.out.println("updateFlight finished");
//			
			
//			FlightUpdateDao flightUpdateDao = new FlightUpdateDao();
//			flightUpdateDao.updateFlight("tbl_flight", 2913651,  new java.sql.Timestamp(2022, 5, 24, 11, 30, 0, 0) , 20, 350.00, new java.sql.Timestamp(2022, 5, 24, 4, 30, 0, 0));
//			System.out.println("updateFlight finished");
			
			
			
			/**************************************************************
						updateSeats
			 ****************************************************************/
			
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
//			String[] stringFlightUpdate = new String[2];
//			System.out.println("Please enter the flightId to edit seats for, and then enter the update value:  int seatsAvailable ");
//			for(int i = 0; i < stringFlightUpdate.length; i++) {
//				stringFlightUpdate[i] = sc.nextLine();
//			}
//			
//			int flightId;
//			int seatsAvailable;
//			
//			System.out.println("You have entered");
//			
//			flightId = Integer.parseInt(stringFlightUpdate[0]);
//			seatsAvailable = Integer.parseInt(stringFlightUpdate[1]);
//			
//			
//			
//			System.out.println("You have entered: " + flightId + ", " + seatsAvailable);
//			
//			
//			
//			FlightUpdateDao flightUpdateDao = new FlightUpdateDao();
//			flightUpdateDao.updateSeats("tbl_flight", flightId,  seatsAvailable);
//			System.out.println("updateSeats finished");
			
			
			/**************************************************************
						updateTraveler
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
//			String[] stringTravelerUpdate = new String[6];
//			System.out.println("Please enter the travelerId to select traveler, and then enter update values : String name, String address, String phone, String email, TimeStamp dob");
//			for(int i = 0; i < stringTravelerUpdate.length; i++) {
//				stringTravelerUpdate[i] = sc.nextLine();
//			}
//			
//			int travelerId;
//			String name;
//			String address;
//			String phone;
//			String userEmail;
//			Timestamp dob;
//			
//			travelerId = Integer.parseInt(stringTravelerUpdate[0]);
//			name = stringTravelerUpdate[1];
//			address = stringTravelerUpdate[2];
//			phone = stringTravelerUpdate[3];
//			userEmail = stringTravelerUpdate[4];
//			dob = Timestamp.valueOf(stringTravelerUpdate[5]);
//		
//			System.out.println("You have entered: " + travelerId + ", " + name + ", " + address + ", " + phone + ", " + userEmail + ", " + dob);
//			
			
//			2011-10-02 18:48:05.123

//
//			TravelerUpdateDao travelerUpdateDao = new TravelerUpdateDao();
//			travelerUpdateDao.updateTraveler("tbl_traveler", travelerId, name, address, phone, userEmail, dob);
//			System.out.println("updateTraveler finished");
//			
			
//			TravelerUpdateDao travelerUpdateDao = new TravelerUpdateDao();
//			travelerUpdateDao.updateTraveler("tbl_traveler", 101, "traveler22", "999 Alamo Way", "555-0022", "traveler22@mail.com");
//			System.out.println("updateTraveler finished");

		}
	

}