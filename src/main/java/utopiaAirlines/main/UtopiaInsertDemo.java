package utopiaAirlines.main;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import utopiaAirlines.basic.Airport;
import utopiaAirlines.basic.AirportDao;
import utopiaAirlines.basic.AirportUpdateDao;
import utopiaAirlines.basic.Booking;
import utopiaAirlines.basic.BookingUpdateDao;
import utopiaAirlines.basic.Employee;
import utopiaAirlines.basic.EmployeeUpdateDao;
import utopiaAirlines.basic.Flight;
import utopiaAirlines.basic.FlightBooking;
import utopiaAirlines.basic.FlightBookingUpdateDao;
import utopiaAirlines.basic.FlightDetails;
import utopiaAirlines.basic.FlightDetailsUpdateDao;
import utopiaAirlines.basic.FlightUpdateDao;
import utopiaAirlines.basic.Traveler;
import utopiaAirlines.basic.TravelerBooking;
import utopiaAirlines.basic.TravelerBookingUpdateDao;
import utopiaAirlines.basic.TravelerUpdateDao;



public class UtopiaInsertDemo {
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
		
	
	 //
	Scanner sc = new Scanner(System.in);
	

	/**************************************************************
				insertAirport
	 ****************************************************************/
	
	
	// in our menu
//	String[] stringAirport = new String[4];
//	System.out.println("Please enter new airport details: iataIdent, city, name, airportId");
//	for(int i = 0; i < string.length; i++) {
//		string[i] = sc.nextLine();
//	}
//	
//	String iataIdent;
//	String city;
//	String name;
//	int airportId;
//	System.out.println("You have entered");
//	
//	iataIdent = string[0];
//	city = string[1];
//	name = string[2];
//	airportId = Integer.parseInt(string[3]);
//	
//	System.out.println(iataIdent);
//	System.out.println(city);
//	System.out.println(name);
//	System.out.println(airportId);
//	
//	
//	AirportUpdateDao airportUpdateDao = new AirportUpdateDao();
//	Airport airport1 = new Airport(iataIdent, city, name, airportId);
//	String attempt = airportUpdateDao.insertAirport("tbl_airport", airport1);
//	System.out.println("airport1 : " + attempt);
	
	
	/**************************************************************
				insertBooking
	 ****************************************************************/
	
	
	
	String[] stringBooking = new String[5];
	System.out.println("Please enter new booking details: int isAcive, String stripeId, int bookerId, int travelerId, int flightId");
	for(int i = 0; i < stringBooking.length; i++) {
		stringBooking[i] = sc.nextLine();
	}
	
	int isActive;
	String stripeId;
	int bookerId;
	int travelerId;
	int flightId;
	System.out.println("You have entered");
	
	isActive = Integer.parseInt(stringBooking[0]);
	stripeId = stringBooking[1];
	bookerId= Integer.parseInt(stringBooking[2]);
	travelerId = Integer.parseInt(stringBooking[3]);
	flightId = Integer.parseInt(stringBooking[4]);
	
	System.out.println(isActive);
	System.out.println(stripeId);
	System.out.println(bookerId);
	System.out.println(travelerId);
	System.out.println(flightId);
	
	
	BookingUpdateDao bookingUpdateDao = new BookingUpdateDao();
	Booking booking1 = new Booking(isActive, stripeId, bookerId, travelerId, flightId);
	int bookingId = bookingUpdateDao.insertBooking("tbl_booking", booking1);
	System.out.println("booking1.id: " + bookingId);	
	
	
	TravelerBookingUpdateDao travelerBookingUpdateDao = new TravelerBookingUpdateDao();
	TravelerBooking travelerBooking1 = new TravelerBooking(bookingId, travelerId);
	travelerBookingUpdateDao.insertTravelerBooking("tbl_bookings_has_travelers", travelerBooking1);
	
	FlightBookingUpdateDao flightBookingUpdateDao = new FlightBookingUpdateDao();
	FlightBooking flightBooking1 = new FlightBooking(flightId, bookingId);
	flightBookingUpdateDao.insertFlightBooking("tbl_flight_has_bookings", flightBooking1);
	
	
//	BookingUpdateDao bookingUpdateDao = new BookingUpdateDao();
//	Booking booking1 = new Booking(1, "133ABC", 104);
//	int bookingId = bookingUpdateDao.insertBooking("tbl_booking", booking1);
//	System.out.println("booking1.id: " + bookingId);
	
	
	
	
	
	/**************************************************************
				insertEmployee
	 ****************************************************************/
	
	
	
	// in our menu
//	String[] stringUser = new String[7];
//	System.out.println("Please enter new employee details: String password, String email, String firstName, String lastName, int enabled, int locked, int userRole");
//	for(int i = 0; i < stringUser.length; i++) {
//		stringUser[i] = sc.nextLine();
//	}
//	
//	String password;
//	String email;
//	String firstName;
//	String lastName;
//	int enabled;
//	int locked;
//	int userRole;
//	System.out.println("You have entered");
//	
//	password = stringUser[0];
//	email = stringUser[1];
//	firstName = stringUser[2];
//	lastName = stringUser[3];
//	enabled = Integer.parseInt(stringUser[4]);
//	locked = Integer.parseInt(stringUser[5]);
//	userRole = Integer.parseInt(stringUser[6]);
//
//	
//	System.out.println(password);
//	System.out.println(email);
//	System.out.println(firstName);
//	System.out.println(lastName);
//	System.out.println(enabled);
//	System.out.println(locked);
//	System.out.println(userRole);
	
	
//	EmployeeUpdateDao employeeUpdateDao = new EmployeeUpdateDao();
//	Employee employee1 = new Employee(password, email, firstName, lastName, enabled, locked, userRole);
//	int employeeId = employeeUpdateDao.insertEmployee("tbl_users", employee1);
//	System.out.println("employee.id: " + employeeId);
	
//	EmployeeUpdateDao employeeUpdateDao = new EmployeeUpdateDao();
//	Employee employee1 = new Employee("agt123", "employee2@mail.com", "Jimmy", "John", 1, 0, 2);
//	int employeeId = employeeUpdateDao.insertEmployee("tbl_users", employee1);
//	System.out.println("employee.id: " + employeeId);
		
	
//	
//	System.out.println("a. Origin/Departure Airports");
//	AirportDao airportDao = new AirportDao();
//	List<Airport> airports = airportDao.getAirports("tbl_airport");
//	if(airports == null) {
//		System.out.println("We have no airports!");
//		System.exit(0);
//	}
//	for(Airport airport: airports) {
//		System.out.println(airport);
//	}
//	System.out.println();
	
	
	/**************************************************************
				creating a new flight
	 ****************************************************************/
	
	
	
	
//	
//	String[] stringFlight = new String[7];
//	System.out.println("Please enter new flight details: String flightNumber, String departCityId, String arriveCityId, TimeStamp departTime, int seatsAvailable, double price, TimeStamp arrivalTime");
//	for(int i = 0; i < stringFlight.length; i++) {
//		stringFlight[i] = sc.nextLine();
//	}
//	
//	String flightNumber;
//	String departCityId;
//	String arriveCityId;
//	Timestamp departTime;
//	int seatsAvailable;
//	double price;
//	Timestamp arrivalTime;
//	
//	System.out.println("You have entered");
//	
//	flightNumber = stringFlight[0];
//	departCityId = stringFlight[1];
//	arriveCityId = stringFlight[2];
//	departTime = Timestamp.valueOf(stringFlight[3]);
//	seatsAvailable = Integer.parseInt(stringFlight[4]);
//	price = Double.parseDouble(stringFlight[5]);
//	arrivalTime = Timestamp.valueOf(stringFlight[3]);
//
//
//
//	
//	System.out.println(flightNumber);
//	System.out.println(departCityId);
//	System.out.println(arriveCityId);
//	System.out.println(departTime);
//	System.out.println(seatsAvailable);
//	System.out.println(price);
//	System.out.println(arrivalTime);
//	2011-10-02 18:48:05.123
	

	
		
		/**************************************************************
					step1 insertFlightDetails
		 ***************************************************************/
	
//	FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
//	FlightDetails flightDetails1 = new FlightDetails(flightNumber, departCityId, arriveCityId);
//	flightDetailsUpdateDao.insertFlightDetails("tbl_flight_details", flightDetails1);
		
//	FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
//	FlightDetails flightDetails1 = new FlightDetails("A13", "LHR", "JFK");
//	flightDetailsUpdateDao.insertFlightDetails("tbl_flight_details", flightDetails1);
	
	/**************************************************************
			 		step 2 insertFlight 
	 ***************************************************************/
	
//	FlightUpdateDao flightUpdateDao = new FlightUpdateDao();	
//	Flight flight1 = new Flight(departTime, seatsAvailable, price, arrivalTime, flightNumber);
//	int flightId = flightUpdateDao.insertFlight("tbl_flight", flight1);
//	System.out.println("flight.flightId: " + flightId);
	
//	FlightUpdateDao flightUpdateDao = new FlightUpdateDao();	
//	Flight flight1 = new Flight(new java.sql.Timestamp(2022, 5, 25, 11, 30, 0, 0), 20, 350.00, new java.sql.Timestamp(2022, 5, 25, 11, 30, 0, 0), "A13");
//	int flightId = flightUpdateDao.insertFlight("tbl_flight", flight1);
//	System.out.println("flight.flightId: " + flightId);
	
	
	
	
	
	
	
	
	
	/**************************************************************
					insertTraveler
	 ****************************************************************/
	
	
//	String[] stringUser = new String[5];
//	System.out.println("Please enter new traveler details: String name, String address, String phone, String email, TimeStamp dob");
//	for(int i = 0; i < stringUser.length; i++) {
//		stringUser[i] = sc.nextLine();
//	}
//	
//	String name;
//	String address;
//	String phone;
//	String email;
//	Timestamp dob;
//	System.out.println("You have entered");
//	
//	name = stringUser[0];
//	address = stringUser[1];
//	phone = stringUser[2];
//	email = stringUser[3];
//	dob = Timestamp.valueOf(stringUser[4]);
//
//	
//	System.out.println(name);
//	System.out.println(address);
//	System.out.println(phone);
//	System.out.println(email);
//	System.out.println(dob);
//	2011-10-02 18:48:05.123

	

//	TravelerUpdateDao travelerUpdateDao = new TravelerUpdateDao();	
//	Traveler traveler1 = new Traveler(name, address, phone, email, dob);
//	int travelerId = travelerUpdateDao.insertTraveler("tbl_traveler", traveler1);
//	System.out.println("traveler.id: " + travelerId);
	
//	TravelerUpdateDao travelerUpdateDao = new TravelerUpdateDao();	
//	Traveler traveler1 = new Traveler("traveler12", "911 Jump Streeet", "555-0012", "traveler12@mail.", new java.sql.Timestamp(2022, 5, 25, 11, 30, 0, 0));
//	int travelerId = travelerUpdateDao.insertTraveler("tbl_traveler", traveler1);
//	System.out.println("traveler.id: " + travelerId);
	
	
	
	
	
	}

}
