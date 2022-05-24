package utopiaAirlines.main;


import java.sql.*;
import java.util.List;
import java.util.Random;
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
import utopiaAirlines.basic.FlightBooking;
import utopiaAirlines.basic.FlightBookingUpdateDao;
import utopiaAirlines.basic.FlightDao;
import utopiaAirlines.basic.FlightDetails;
import utopiaAirlines.basic.FlightDetailsUpdateDao;
import utopiaAirlines.basic.FlightUpdateDao;
import utopiaAirlines.basic.Traveler;
import utopiaAirlines.basic.TravelerBooking;
import utopiaAirlines.basic.TravelerBookingUpdateDao;
import utopiaAirlines.basic.TravelerDao;
import utopiaAirlines.basic.TravelerUpdateDao;

public class UtopiaMenu {



		public static void main(String[] args) {
//	      System.out.println("Hello World");
	  	final String URL = "jdbc:mysql://localhost:3306/utopia";
	  	final String USER = "root";
	  	final String PASSWORD = "";
	  	
	  	int userMenuChoice = 0;
	  	Scanner userInput = new Scanner(System.in);
	  	Scanner userParams = new Scanner(System.in);


	      try {
	      while(userMenuChoice != -1) {
	      
		      MAIN : {
		    	  System.out.println("Welcome to the Utopia Airlines Management System. Which category of user are you?");
		          System.out.println("1 - Employee/Agent	2 - Administrator	3 - Traveler");
		          userMenuChoice = userInput.nextInt();
		          
		          EMP1: {
		        	  if(userMenuChoice == 1) {
			        		  // EMP1:												 // to MAIN MENU		
			            	  System.out.println("1 Employee/Agent Under Construction");
			            	  System.out.println();
			            	  break EMP1;
		        	  	}
			        	  
			          } // end of EMP1

		          
		          TRAV1: {
		        	  if(userMenuChoice == 3) {
		        		  // TRAV1:												 // to MAIN MENU		
		            	  System.out.println("3 Traveler Under Construction");
		            	  System.out.println();
		            	  break TRAV1;
		        	  }
		          } // end of TRAV1
		          
		          
		          ADMIN1: {
		        	  if(userMenuChoice == 2) {
		        		  boolean admin1Quit = false;
		        		  while(admin1Quit == false) {
			        		  System.out.println("1 Flights   |   2 Seats  |  3 Tickets and Passengers  |  4 Airports  |  5 Travelers  |  6 Employees  |  7 Trip Cancellations  |  8 Quit to Main menu");
			        		  userMenuChoice = userInput.nextInt();
			            	  if(userMenuChoice == 8) {
			            		  System.out.println("breaking ADMIN1");
			            		  userMenuChoice = 0;
			            		  admin1Quit = true;
			            		  break ADMIN1;
			            	  } else {
			            		  flights: {
			            			  if(userMenuChoice == 1) {
			            			  boolean flightsMenuQuit = false;
				            			  while(flightsMenuQuit == false) {
				            				  System.out.println("1 Add flight  |  2 Edit flight  |  3 Delete flight  |  4 Show flights  |  5 Quit to previous menu");
				            				  userMenuChoice = userInput.nextInt();
				            				  if(userMenuChoice == 1) {
					            				  System.out.println("Add flight");
					            				  
					            					
					            					System.out.println("a. Origin/Departure Airports");
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
					            					System.out.println("Please enter the iataIdent for your origin airport.");
					            					
					            					String departCityId = userParams.nextLine();
//					            					System.out.println("Origin Airport: " + departCityId);
					            					
					            					
					            					System.out.println("Please enter the iataIdent for your destination airport or enter 101 to create your a new airport");
					            					String arriveCityId = userParams.nextLine();
					            					if(arriveCityId.equals("101")) {
					            						System.out.println("You have chosen to create a new airport");
					            						
					            						System.out.println();
					            						String[] stringAirportInsert = new String[4];
					            						System.out.println("Please enter new airport details: iataIdent, city, name, airportId");
					            						for(int i = 0; i < stringAirportInsert.length; i++) {
					            							stringAirportInsert[i] = userParams.nextLine();
					            						}
					            						
					            						String iataIdent;
					            						String city;
					            						String name;
					            						int airportId;
					            						System.out.println("You have entered");
					            						
					            						iataIdent = stringAirportInsert[0];
					            						city = stringAirportInsert[1];
					            						name = stringAirportInsert[2];
					            						airportId = Integer.parseInt(stringAirportInsert[3]);
					            						
					            						System.out.println(iataIdent);
					            						System.out.println(city);
					            						System.out.println(name);
					            						System.out.println(airportId);
					            						
					            						
					            						AirportUpdateDao airportUpdateDao = new AirportUpdateDao();
					            						Airport airport1 = new Airport(iataIdent, city, name, airportId);
					            						String attempt = airportUpdateDao.insertAirport("tbl_airport", airport1);
					            						System.out.println("airport1 : " + attempt);
					            						
					            						arriveCityId = iataIdent;
					            						
					            						System.out.println();
//					            						System.out.println("Destination Airport: " + arriveCityId);
					            					} else {
//					            						System.out.println("Destination Airport: " + arriveCityId);
					            					}
					            					
					            					System.out.println("Please enter the value associated with your chosen departue date.");
					            					System.out.println("1. 2022 - 04 - 24");
					            					System.out.println("2. 2022 - 04 - 26");
					            					System.out.println("3. 2022 - 05 - 05");
					            					System.out.println("4. 2022 - 05 - 07");
					            					System.out.println("5. 2022 - 05 - 25");
					            					
					            					
					            					String userDate;
					            					userDate = userParams.nextLine();
					            					if(userDate.equals("1")) {
					            						userDate = "2022-04-24 ";
					            					} else if(userDate.equals("2")) {
					            						userDate = "2022-04-26 ";
					            					} else if(userDate.equals("3")) {
					            						userDate = "2022-05-05 ";
					            					} else if(userDate.equals("4")) {
					            						userDate = "2022-05-07 ";
					            					} else if(userDate.equals("5")) {
					            						userDate = "2022-05-25 ";
					            					}
					            					
//					            					System.out.println("Departure Date: " + userDate);
					            					
					            					
					            					System.out.println("Please enter the value associated with your chosen departue time or enter 101 to create your own time.");
					            					System.out.println("1. 10:00:00");
					            					System.out.println("2. 12:00:00");
					            					System.out.println("3. 05:30:00");
					            					System.out.println("4. 02:45:00");
					            					System.out.println("5. 09:15:00");
					            					
					            					
					            					String userTime;
					            					userTime = userParams.nextLine();
					            					if(userTime.equals("1")) {
					            						userTime = "10:00:00";
					            					} else if(userTime.equals("2")) {
					            						userTime = "12:00:00";
					            					} else if(userTime.equals("3")) {
					            						userTime = "05:30:00";
					            					} else if(userTime.equals("4")) {
					            						userTime = "02:45:00";
					            					} else if(userTime.equals("5")) {
					            						userTime = "09:15:00";
					            					} else if(userTime.equals("101")) {
					            						System.out.println("You have chosen to create a custom time. Please type a time in the following format 00:00:00 HH:MM:SS");
					            						userTime = userParams.nextLine();
					            					}
					            					
					            					
//					            					System.out.println("Departure Time: " + userTime);
					            					
					            					String stringDepartTime = userDate + userTime;
//					            					System.out.println(stringDepartTime);
					            					
					            					Timestamp departTime = Timestamp.valueOf(stringDepartTime);
					            					int seatsAvailable = 20;
					            					double price = 200;
					            					Timestamp arrivalTime = new Timestamp(departTime.getTime() + (1000 * 60 * 60 * 3));
//					            					System.out.println("arrivalTime: " + arrivalTime);

					            					

					            					Random r = new Random();
					            					int low = 10;
					            					int high = 100;
					            					int result = r.nextInt(high-low) + low;

					            					String flightNumber = "C" + result;
					            					
					            					System.out.println(flightNumber);
					            					System.out.println(departCityId);
					            					System.out.println(arriveCityId);
					            					System.out.println(departTime);
					            					System.out.println(seatsAvailable);
					            					System.out.println(price);
					            					System.out.println(arrivalTime);
//					            					System.out.println("You are ready to insertFlight");

					            					
					            						
					            						/**************************************************************
					            									step1 insertFlightDetails
					            						 ***************************************************************/
					            					
					            					FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
					            					FlightDetails flightDetails1 = new FlightDetails(flightNumber, departCityId, arriveCityId);
					            					flightDetailsUpdateDao.insertFlightDetails("tbl_flight_details", flightDetails1);
					            						
//					            					FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
//					            					FlightDetails flightDetails1 = new FlightDetails("A13", "LHR", "JFK");
//					            					flightDetailsUpdateDao.insertFlightDetails("tbl_flight_details", flightDetails1);
					            					
					            					/**************************************************************
					            							 		step 2 insertFlight 
					            					 ***************************************************************/
					            					
					            					FlightUpdateDao flightUpdateDao = new FlightUpdateDao();	
					            					Flight flight1 = new Flight(departTime, seatsAvailable, price, arrivalTime, flightNumber);
					            					int flightId = flightUpdateDao.insertFlight("tbl_flight", flight1);
					            					System.out.println("flight.flightId: " + flightId);
					            				  
					            			  } else if (userMenuChoice == 2) {
					            				  System.out.println("Edit flight");
					            				  
					            				  
					            				  FlightDao flightDao = new FlightDao();
					            					List<Flight> flights = flightDao.getFlights("tbl_flight", "tbl_flight_details");
					            					if(flights == null) {
					            						System.out.println("We have no flights!");
					            						System.exit(0);
					            					}
					            					
					            					for(Flight flight: flights) {
					            						System.out.println(flight);
					            					}
					            					System.out.println();
					            					
					            					
					            					String[] stringFlightUpdate = new String[8];
					            					System.out.println("Please enter the flightId and flightNumber to select flight, and then enter update values : String departCityId, String arriveCityId, TimeStamp departTime, int seatsAvailable, double price, TimeStamp arrivalTime");
					            					for(int i = 0; i < stringFlightUpdate.length; i++) {
					            						stringFlightUpdate[i] = userParams.nextLine();
					            					}
					            					
					            					int flightId;
					            					String flightNumber;
					            					String departCityId;
					            					String arriveCityId;
					            					Timestamp departTime;
					            					int seatsAvailable;
					            					double price;
					            					Timestamp arrivalTime;
					            					
					            					System.out.println("You have entered");
					            					
					            					flightId = Integer.parseInt(stringFlightUpdate[0]);
					            					flightNumber = stringFlightUpdate[1];
					            					departCityId = stringFlightUpdate[2];
					            					arriveCityId = stringFlightUpdate[3];
					            					departTime = Timestamp.valueOf(stringFlightUpdate[4]);
					            					seatsAvailable = Integer.parseInt(stringFlightUpdate[5]);
					            					price = Double.parseDouble(stringFlightUpdate[6]);
					            					arrivalTime = Timestamp.valueOf(stringFlightUpdate[7]);
					            					
					            					
					            					
					            					System.out.println("You have entered: " + flightId + ", " + flightNumber + ", " + departCityId + ", " + arriveCityId + ", " + departTime + ", " + seatsAvailable + ", " + price + ", " + arrivalTime);
					            					
					            					
					            							FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
					            							flightDetailsUpdateDao.updateFlightDetails("tbl_flight_details", flightNumber, departCityId, arriveCityId);
					            							System.out.println("updateFlightDetails finished");
					            					
					            					//			FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
					            					//			flightDetailsUpdateDao.updateFlightDetails("tbl_flight_details", "A13", "JFK", "LHR");
					            					//			System.out.println("updateFlightDetails finished");
					            					
					            					
//					            					help with understanding input
//					            					public void updateFlight(String tableName, int flightId, TimeStamp departTime, int seatsAvailable, double price, Date arrivalTime) 
					            					
					            					FlightUpdateDao flightUpdateDao = new FlightUpdateDao();
					            					flightUpdateDao.updateFlight("tbl_flight", flightId,  departTime , seatsAvailable, price, arrivalTime);
					            					System.out.println("updateFlight finished");
					            					
					            				  
					            				  
					            				  
					            			  } else if (userMenuChoice == 3) {
					            				  System.out.println("Delete flight");
					            				  
					            				  
					            					FlightDao flightDao = new FlightDao();
					            					List<Flight> flights = flightDao.getFlights("tbl_flight", "tbl_flight_details");
					            					if(flights == null) {
					            						System.out.println("We have no flights!");
					            						System.exit(0);
					            					}
					            					
					            					for(Flight flight: flights) {
					            						System.out.println(flight);
					            					}
					            					System.out.println();
					            					
					            					

					            					String[] stringFlight = new String[2];
					            					System.out.println("Please enter flightId and flightNumber for flight to delete: ");
					            					for(int i = 0; i < stringFlight.length; i++) {
					            						stringFlight[i] = userParams.nextLine();
					            					}
					            					
					            					int flightId;
					            					String flightNumber;
					            					System.out.println("You have entered");
					            					
					            					flightId = Integer.parseInt(stringFlight[0]);
					            					flightNumber = stringFlight[1];	
					            					System.out.println(flightId);
					            					System.out.println(flightNumber);
					            					
					            					
					            					
					            					/**************************************************************
					            								Step 1 deleteFlight
					            					 ***************************************************************/
					            					
					            					FlightUpdateDao flightUpdateDao = new FlightUpdateDao();
					            					flightUpdateDao.deleteFlight("tbl_flight", flightId);
					            					System.out.println("deleteFlight finished");
					            					
					            					/**************************************************************
					            								Step 2 deleteFlightDetails
					            					 ***************************************************************/
					            					
					            					FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
					            					flightDetailsUpdateDao.deleteFlightDetails("tbl_flight_details", flightNumber);
					            					System.out.println("deleteFlightDetails finished");
					            				
					            				  
					            			  
					            			  } else if (userMenuChoice == 4) {
					            				  System.out.println("Showing all flights");
	//				            				  System.out.println("flightId  |  departTime  |  seatsAvailable  |  price  |  arrivalTime  |  flightNumber");
					            				  
					            				  FlightDao flightDao = new FlightDao();
					            					List<Flight> flights = flightDao.getFlights("tbl_flight", "tbl_flight_details");
					            					if(flights == null) {
					            						System.out.println("We have no flights!");
					            						System.exit(0);
					            					}
					            					
					            					for(Flight flight: flights) {
					            						System.out.println(flight);
					            					}
					            					System.out.println();
					            					
					            					userMenuChoice = 1;
					            			  } else {
					            				  System.out.println("Breaking flights menu");
					            				  userMenuChoice = 0;
					            				  flightsMenuQuit = true;
					            				  break flights;
					            			  } // end of else
				            			  } // end of while
			            			  } // end of menu choice 1
			            			 
			            		  } // end of flights
			            		  
			            		  seats: {
			            			  if(userMenuChoice == 2) {
			            				  boolean seatsMenuQuit = false;
			            				  while(seatsMenuQuit == false) {
			            				  System.out.println("1 Edit seats  |  2 Show flight seats  |  3 Quit to previous menu");
			            				  userMenuChoice = userInput.nextInt();
			            				  if (userMenuChoice == 1) {
				            				  System.out.println("Edit seat");
				            				  FlightDao flightDao = new FlightDao();
				            					List<Flight> flights = flightDao.getFlights("tbl_flight", "tbl_flight_details");
				            					if(flights == null) {
				            						System.out.println("We have no flights!");
				            						System.exit(0);
				            					}
				            					
				            					for(Flight flight: flights) {
				            						System.out.println(flight);
				            					}
				            					System.out.println();
				            					
				            					
				            					String[] stringFlightUpdate = new String[2];
				            					System.out.println("Please enter the flightId to edit seats for, and then enter the update value:  int seatsAvailable ");
				            					for(int i = 0; i < stringFlightUpdate.length; i++) {
				            						stringFlightUpdate[i] = userParams.nextLine();
				            					}
				            					
				            					int flightId;
				            					int seatsAvailable;
				            					
				            					System.out.println("You have entered");
				            					
				            					flightId = Integer.parseInt(stringFlightUpdate[0]);
				            					seatsAvailable = Integer.parseInt(stringFlightUpdate[1]);
				            					
				            					
				            					
				            					System.out.println("You have entered: " + flightId + ", " + seatsAvailable);
				            					
				            					
				            					
				            					FlightUpdateDao flightUpdateDao = new FlightUpdateDao();
				            					flightUpdateDao.updateSeats("tbl_flight", flightId,  seatsAvailable);
				            					System.out.println("updateSeats finished");
				            				  
				            			  
				            			  } else if (userMenuChoice == 2) {
				            				  System.out.println("Showing all seats");
				            				  FlightDao flightDao = new FlightDao();
				            					List<Flight> flights = flightDao.getFlights("tbl_flight", "tbl_flight_details");
				            					if(flights == null) {
				            						System.out.println("We have no flights!");
				            						System.exit(0);
				            					}
				            					
				            					for(Flight flight: flights) {
				            						System.out.println(flight);
				            					}
				            					System.out.println();
				            					userMenuChoice = 1;

				            				  System.out.println();
				            				  
				            				  
				            				  
				            			  } else {
				            				  System.out.println("Breaking seats");
				            				  userMenuChoice = 0;
				            				  seatsMenuQuit = true;
				            				  break seats;
				            			  } // end else
			            				  } // end while loop
			            			  } // end while
			            		    } // end menu choice 2
			            			  
			            		  } // end flights
			            		  
			            		  tickets: {
			            			  if(userMenuChoice == 3) {
			            				  boolean ticketsMenuQuit = false;
			            				  while(ticketsMenuQuit == false) {
			            				  System.out.println("1 Add ticket  |  2 Edit ticket  |  3 Delete ticket  |  4 Show flight tickets  |  5 Quit to previous menu");
			            				  userMenuChoice = userInput.nextInt();
			            				  if(userMenuChoice == 1) {
				            				  System.out.println("Add ticket");
				            				  
				            				  /**************************************************************
				          								show travelers
				            				   ****************************************************************/
				            				  
				            				  TravelerDao travelerDao = new TravelerDao();
				            					List<Traveler> travelers = travelerDao.getTravelers("tbl_traveler");
				            					if(travelers == null) {
				            						System.out.println("We have no travelers!");
				            						System.exit(0);
				            					}
				            					
				            					for(Traveler traveler: travelers) {
				            						System.out.println(traveler);
				            					}
				            					System.out.println();
				            					
				            					/**************************************************************
		          										show flights
				            					 ****************************************************************/
				            					
				            					FlightDao flightDao = new FlightDao();
				            					List<Flight> flights = flightDao.getFlights("tbl_flight", "tbl_flight_details");
				            					if(flights == null) {
				            						System.out.println("We have no flights!");
				            						System.exit(0);
				            					}
				            					
				            					for(Flight flight: flights) {
				            						System.out.println(flight);
				            					}
				            					System.out.println();
				            					
				            					
				            				  String[] stringBooking = new String[5];
				            					System.out.println("Please enter new booking details: int isAcive, String stripeId, int bookerId, int travelerId, int flightId");
				            					for(int i = 0; i < stringBooking.length; i++) {
				            						stringBooking[i] = userParams.nextLine();
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
				            			  } else if (userMenuChoice == 2) {
				            				  System.out.println("Edit ticket");
				            				  
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
				            					
				            					String[] stringBooking = new String[4];
				            					System.out.println("Please enter the bookingID to select ticket, and then enter update values : int isAcive, String stripeId, int bookerId");
				            					for(int i = 0; i < stringBooking.length; i++) {
				            						stringBooking[i] = userParams.nextLine();
				            					}
				            					
				            					int bookingId;
				            					int isActive;
				            					String stripeId;
				            					int bookerId;
				            					
				            					bookingId = Integer.parseInt(stringBooking[0]);
				            					isActive = Integer.parseInt(stringBooking[1]);
				            					stripeId = stringBooking[2];
				            					bookerId= Integer.parseInt(stringBooking[3]);
				            				
				            					System.out.println("You have entered: " + bookingId + ", " + isActive + ", " + stripeId + ", " + bookerId);
				            					
				            					
				            					BookingUpdateDao bookingUpdateDao = new BookingUpdateDao();
				            					bookingUpdateDao.updateBooking("tbl_booking", bookingId, isActive, stripeId,  bookerId);
				            					System.out.println("updateBooking finished");
				            				  
				            			  } else if (userMenuChoice == 3) {
				            				  System.out.println("Delete ticket");
				            				  
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
				            					bookingString = userParams.nextLine();
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
				            			  
				            			  } else if (userMenuChoice == 4) {
				            				  System.out.println("Showing all tickets");
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
				            				  
				            				  
				            			  } else {
				            				  System.out.println("Breaking tickets");
				            				  userMenuChoice = 0;
				            				  ticketsMenuQuit = true;
				            				  break tickets;
				            			  } // end of else
			            			    } // end of while loop
			            			  } // end of menu choice 3
			            			  
			            		  } // end of tickets:
			            		  
			            		  airports: {
			            			  if(userMenuChoice == 4) {
			            				  boolean airportsMenuQuit = false;
			            				  while(airportsMenuQuit == false) {
			            				  System.out.println("1 Add airport  |  2 Edit airport  |  3 Delete airport  |  4 Show airports  |  5 Quit to previous menu");
			            				  userMenuChoice = userInput.nextInt();
			            				  if(userMenuChoice == 1) {
			            						String[] string = new String[4];
			            						System.out.println("Please enter new airport details: iataIdent, city, name, airportId");
			            						for(int i = 0; i < string.length; i++) {
			            							string[i] = userParams.nextLine();
			            						}
			            						
			            						String iataIdent;
			            						String city;
			            						String name;
			            						int airportId;
			            						System.out.println("You have entered");
			            						
			            						iataIdent = string[0];
			            						city = string[1];
			            						name = string[2];
			            						airportId = Integer.parseInt(string[3]);
			            						
			            						System.out.println(iataIdent);
			            						System.out.println(city);
			            						System.out.println(name);
			            						System.out.println(airportId);
			            						
			            						
			            						AirportUpdateDao airportUpdateDao = new AirportUpdateDao();
			            						Airport airport1 = new Airport(iataIdent, city, name, airportId);
			            						String attempt = airportUpdateDao.insertAirport("tbl_airport", airport1);
			            						System.out.println("create new airport : " + attempt);
				            			  } else if (userMenuChoice == 2) {
				            				  System.out.println("Edit airport");
				            				  
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
				            						stringAirportUpdate[i] = userParams.nextLine();
				            					}
				            					
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
				            				//	
				            					System.out.println(iataIdent);
				            					System.out.println(city);
				            					System.out.println(name);
				            					System.out.println(airportId);

				            					
				            					
				            					System.out.println("You have entered: " + iataIdent + ", " + city + ", " + name + ", " + airportId);
				            					
				            					
				            					AirportUpdateDao airportUpdateDao = new AirportUpdateDao();
				            					airportUpdateDao.updateAirport("tbl_airport", iataIdent, city, name,  airportId);
				            					System.out.println("updateAirport finished");
				            				  
				            			  } else if (userMenuChoice == 3) {
				            				  System.out.println("Delete airport");
				            				  
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
				            					
				            					String deleteAirportIataIdent = "";
				            					System.out.println("Please type the iataIdent for the airport to delete");
				            					deleteAirportIataIdent = userParams.nextLine();
				            					
				            					
				            					System.out.println("You have entered: " + deleteAirportIataIdent);
				            			
				            					
				            					
				            					AirportUpdateDao airportUpdateDao = new AirportUpdateDao();
				            					airportUpdateDao.deleteAirport("tbl_airport", deleteAirportIataIdent);
				            					System.out.println("deleteAirport finished");
				            			  
				            			  } else if (userMenuChoice == 4) {
				            				  System.out.println("Showing all airports");
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
				            		          System.out.println();
				            				  
				            			  } else {
				            				  System.out.println("Breaking airports");
				            				  userMenuChoice = 0;
				            				  airportsMenuQuit = true;
				            				  break airports;
				            			  } // end of else
			            				 } // end of while
			            			  } // end of menu choice 4
			            		
			            		  } // end of airports:
			            		  
			            		  travelers: {
			            			  if(userMenuChoice == 5) {
			            				  boolean travelersMenuQuit = false;
			            				  while(travelersMenuQuit == false) {
			            				  System.out.println("1 Add traveler  |  2 Edit traveler  |  3 Delete traveler  |  4 Show travelers  |  5 Quit to previous menu");
			            				  userMenuChoice = userInput.nextInt();
			            				  if(userMenuChoice == 1) {
				            				  System.out.println("Add traveler");
				            				  
				            				  String[] stringUser = new String[5];
				            					System.out.println("Please enter new traveler details: String name, String address, String phone, String email, TimeStamp dob");
				            					for(int i = 0; i < stringUser.length; i++) {
				            						stringUser[i] = userParams.nextLine();
				            					}
				            					
				            					String name;
				            					String address;
				            					String phone;
				            					String email;
				            					Timestamp dob;
				            					System.out.println("You have entered");
				            					
				            					name = stringUser[0];
				            					address = stringUser[1];
				            					phone = stringUser[2];
				            					email = stringUser[3];
				            					dob = Timestamp.valueOf(stringUser[4]);

				            					
				            					System.out.println(name);
				            					System.out.println(address);
				            					System.out.println(phone);
				            					System.out.println(email);
				            					System.out.println(dob);
//				            					2011-10-02 18:48:05.123

				            					

				            					TravelerUpdateDao travelerUpdateDao = new TravelerUpdateDao();	
				            					Traveler traveler1 = new Traveler(name, address, phone, email, dob);
				            					int travelerId = travelerUpdateDao.insertTraveler("tbl_traveler", traveler1);
				            					System.out.println("traveler.id: " + travelerId);
				            				  
				            				  
				            			  } else if (userMenuChoice == 2) {
				            				  System.out.println("Edit traveler");
				            				  
				            				  TravelerDao travelerDao = new TravelerDao();
				            					List<Traveler> travelers = travelerDao.getTravelers("tbl_traveler");
				            					if(travelers == null) {
				            						System.out.println("We have no travelers!");
				            						System.exit(0);
				            					}
				            					
				            					for(Traveler traveler: travelers) {
				            						System.out.println(traveler);
				            					}
				            					System.out.println();
				            					
				            					String[] stringTravelerUpdate = new String[6];
				            					System.out.println("Please enter the travelerId to select traveler, and then enter update values : String name, String address, String phone, String email, TimeStamp dob");
				            					for(int i = 0; i < stringTravelerUpdate.length; i++) {
				            						stringTravelerUpdate[i] = userParams.nextLine();
				            					}
				            					
				            					int travelerId;
				            					String name;
				            					String address;
				            					String phone;
				            					String userEmail;
				            					Timestamp dob;
				            					
				            					travelerId = Integer.parseInt(stringTravelerUpdate[0]);
				            					name = stringTravelerUpdate[1];
				            					address = stringTravelerUpdate[2];
				            					phone = stringTravelerUpdate[3];
				            					userEmail = stringTravelerUpdate[4];
				            					dob = Timestamp.valueOf(stringTravelerUpdate[5]);
				            				
				            					System.out.println("You have entered: " + travelerId + ", " + name + ", " + address + ", " + phone + ", " + userEmail + ", " + dob);
				            					
				            					
//				            					2011-10-02 18:48:05.123


				            					TravelerUpdateDao travelerUpdateDao = new TravelerUpdateDao();
				            					travelerUpdateDao.updateTraveler("tbl_traveler", travelerId, name, address, phone, userEmail, dob);
				            					System.out.println("updateTraveler finished");
				            				  
				            				  
				            			  } else if (userMenuChoice == 3) {
				            				  System.out.println("Delete traveler");
				            				  
				            				  TravelerDao travelerDao = new TravelerDao();
				            					List<Traveler> travelers = travelerDao.getTravelers("tbl_traveler");
				            					if(travelers == null) {
				            						System.out.println("We have no travelers!");
				            						System.exit(0);
				            					}
				            					
				            					for(Traveler traveler: travelers) {
				            						System.out.println(traveler);
				            					}
				            					System.out.println();
				            					
				            					String travelerDeleteString = "";
				            					System.out.println("Please type the travelerId for the traveler to delete");
				            					travelerDeleteString = userParams.nextLine();
				            					int travelerIdDelete = Integer.parseInt(travelerDeleteString);
				            					
				            					System.out.println("You have entered: " + travelerIdDelete);
				            					
				            					

				            					TravelerUpdateDao travelerUpdateDao = new TravelerUpdateDao();
				            					travelerUpdateDao.deleteTraveler("tbl_traveler", travelerIdDelete);
				            					System.out.println("deleteTraveler finished");
				            			  
				            				  
				            			  } else if (userMenuChoice == 4) {
				            				  System.out.println("Showing all travelers");
				            					TravelerDao travelerDao = new TravelerDao();
				            					List<Traveler> travelers = travelerDao.getTravelers("tbl_traveler");
				            					if(travelers == null) {
				            						System.out.println("We have no travelers!");
				            						System.exit(0);
				            					}
				            					
				            					for(Traveler traveler: travelers) {
				            						System.out.println(traveler);
				            					}
				            					System.out.println();

				            			  } else {
				            				  System.out.println("Breaking travelers");
				            				  userMenuChoice = 0;
				            				  travelersMenuQuit = true;
				            				  break travelers;
				            			  } // end of else
			            			  } // end of userMenuChoice 5
			            		    } // end of while loop
			            		  } // end of travelers
			            		  
			            		  employees: {
			            			  if(userMenuChoice == 6) {
			            				  boolean employeesMenuQuit = false;
			            				  while(employeesMenuQuit == false) {
			            				  System.out.println("1 Add employee  |  2 Edit employee  |  3 Delete employee  |  4 Show employees  |  5 Quit to previous menu");
			            				  userMenuChoice = userInput.nextInt();
			            				  if(userMenuChoice == 1) {
				            				  System.out.println("Add employee");
				            				  
				            				  String[] stringUser = new String[7];
				            					System.out.println("Please enter new employee details: String password, String email, String firstName, String lastName, int enabled, int locked, int userRole");
				            					for(int i = 0; i < stringUser.length; i++) {
				            						stringUser[i] = userParams.nextLine();
				            					}
				            					
				            					String password;
				            					String email;
				            					String firstName;
				            					String lastName;
				            					int enabled;
				            					int locked;
				            					int userRole;
				            					System.out.println("You have entered");
				            					
				            					password = stringUser[0];
				            					email = stringUser[1];
				            					firstName = stringUser[2];
				            					lastName = stringUser[3];
				            					enabled = Integer.parseInt(stringUser[4]);
				            					locked = Integer.parseInt(stringUser[5]);
				            					userRole = Integer.parseInt(stringUser[6]);

				            					
				            					System.out.println(password);
				            					System.out.println(email);
				            					System.out.println(firstName);
				            					System.out.println(lastName);
				            					System.out.println(enabled);
				            					System.out.println(locked);
				            					System.out.println(userRole);
				            					
				            					
				            					EmployeeUpdateDao employeeUpdateDao = new EmployeeUpdateDao();
				            					Employee employee1 = new Employee(password, email, firstName, lastName, enabled, locked, userRole);
				            					int employeeId = employeeUpdateDao.insertEmployee("tbl_users", employee1);
				            					System.out.println("employee.id: " + employeeId);
				            				  
				            			  } else if (userMenuChoice == 2) {
				            				  System.out.println("Edit employee");
				            				  
				            				  EmployeeDao employeeDao = new EmployeeDao();
				            					List<Employee> employees = employeeDao.getEmployees("tbl_users");
				            					if(employees == null) {
				            						System.out.println("We have no employees!");
				            						System.exit(0);
				            					}
				            					
				            					for(Employee employee: employees) {
				            						System.out.println(employee);
				            					}
				            					System.out.println();
				            					
				            					
				            					String[] stringUserUpdate = new String[8];
				            					System.out.println("Please enter the userId to select employee, and then enter update values : String password, String email, String firstName, String lastName, int enabled, int locked, int userRole");
				            					for(int i = 0; i < stringUserUpdate.length; i++) {
				            						stringUserUpdate[i] = userParams.nextLine();
				            					}
				            					
				            					int userId;
				            					String password;
				            					String email;
				            					String firstName;
				            					String lastName;
				            					int enabled;
				            					int locked;
				            					int userRole;
				            				

				            					userId = Integer.parseInt(stringUserUpdate[0]);
				            					password = stringUserUpdate[1];
				            					email = stringUserUpdate[2];
				            					firstName =stringUserUpdate[3];
				            					lastName = stringUserUpdate[4];
				            					enabled = Integer.parseInt(stringUserUpdate[5]);
				            					locked = Integer.parseInt(stringUserUpdate[6]);
				            					userRole = Integer.parseInt(stringUserUpdate[7]);
				            				
				            					
				            					System.out.println("You have entered: " + userId + ", " + password + ", " + email + ", " + firstName + ", " + lastName + ", " + enabled + ", " + locked + ", " + userRole + ", ");
				            					
				            					EmployeeUpdateDao employeeUpdateDao = new EmployeeUpdateDao();
				            					employeeUpdateDao.updateEmployee("tbl_users", userId, password, email, firstName, lastName, enabled, locked, userRole);
				            					System.out.println("updateEmployee finished");
				            				  
				            			  } else if (userMenuChoice == 3) {
				            				  System.out.println("Delete employee");
				            				  
				            				  EmployeeDao employeeDao = new EmployeeDao();
				            					List<Employee> employees = employeeDao.getEmployees("tbl_users");
				            					if(employees == null) {
				            						System.out.println("We have no employees!");
				            						System.exit(0);
				            					}
				            					
				            					for(Employee employee: employees) {
				            						System.out.println(employee);
				            					}
				            					System.out.println();
				            					
				            					String employeeDeleteString = "";
				            					System.out.println("Please type the userId for the employee to delete");
				            					employeeDeleteString = userParams.nextLine();
				            					int employeeIdDelete = Integer.parseInt(employeeDeleteString);
				            					
				            					System.out.println("You have entered: " + employeeIdDelete);

				            					EmployeeUpdateDao employeeUpdateDao = new EmployeeUpdateDao();
				            					employeeUpdateDao.deleteEmployee("tbl_users", employeeIdDelete);
				            					System.out.println("deleteEmployee finished");
				            			  
				            			  } else if (userMenuChoice == 4) {
				            				  System.out.println("Show all employees");
				            					EmployeeDao employeeDao = new EmployeeDao();
				            					List<Employee> employees = employeeDao.getEmployees("tbl_users");
				            					if(employees == null) {
				            						System.out.println("We have no employees!");
				            						System.exit(0);
				            					}
				            					
				            					for(Employee employee: employees) {
				            						System.out.println(employee);
				            					}
				            					System.out.println();
				            				  
				            			  } else {
				            				  System.out.println("Breaking employees:");
				            				  userMenuChoice = 0;
				            				  employeesMenuQuit = true;
				            				  break employees;
				            			  } // end of else
			            			    } // end of while loop
			            			  } // end of menu choice 6
			            		  } // end of Employees:
			            		  
			            		  cancellations: {
			            			  if(userMenuChoice == 7) {
			            				  boolean cancellationsMenuQuit = false;
			            				  while(cancellationsMenuQuit == false) {
			            				  System.out.println("1 Edit cancellation  | 2 Show cancellations  |  3 Quit to previous menu");
			            				  userMenuChoice = userInput.nextInt();
			            				  if(userMenuChoice == 1) {
				            				  System.out.println("Edit cancellation");
				            				  
				            				  BookingDao bookingDao = new BookingDao();
				            					List<Booking> bookings = bookingDao.getCancellations("tbl_booking" , "tbl_bookings_has_travelers", "tbl_flight_has_bookings");
				            					if(bookings == null) {
				            						System.out.println("We have no cancellations!");
				            						System.exit(0);
				            					}
				            					
				            					for(Booking booking: bookings) {
				            						System.out.println(booking);
				            					}
				            					System.out.println();
				            					
				            					String[] stringBooking = new String[2];
				            					System.out.println("Please enter the bookingID to select ticket, and then enter 1 to set isActive to true : int isAcive");
				            					for(int i = 0; i < stringBooking.length; i++) {
				            						stringBooking[i] = userParams.nextLine();
				            					}
				            					
				            					int bookingId;
				            					int isActive;
				            					
				            					bookingId = Integer.parseInt(stringBooking[0]);
				            					isActive = Integer.parseInt(stringBooking[1]);
				            					
				            					System.out.println("You have entered: " + bookingId + ", " + isActive);
				            					
				            					
				            					BookingUpdateDao bookingUpdateDao = new BookingUpdateDao();
				            					bookingUpdateDao.updateCancellation("tbl_booking", bookingId, isActive);
				            					System.out.println("updateBooking finished");
				            					
				            				  
				            				  
				            			  } else if(userMenuChoice == 2){
				            				  BookingDao bookingDao = new BookingDao();
				            					List<Booking> bookings = bookingDao.getCancellations("tbl_booking" , "tbl_bookings_has_travelers", "tbl_flight_has_bookings");
				            					if(bookings == null) {
				            						System.out.println("We have no cancellations!");
				            						System.exit(0);
				            					}
				            					
				            					for(Booking booking: bookings) {
				            						System.out.println(booking);
				            					}
				            					System.out.println();
				            				
				            					
				            			  } else {
				            				  System.out.println("Breaking cancellations:");
				            				  userMenuChoice = 0;
				            				  cancellationsMenuQuit = true;
				            				  break cancellations;
				            			  } // end of else
			            				} // end of while
			            			  } // end of if menu choice
			            		  } // end of cancellations
			            			  

			            	  } // end of while loop
		            	  
		        	  } // end of if
		          } // end of ADMIN
		          
		      	} // end of main
	      } // end of while loop
	         
			userInput.close();
			userParams.close();
	      } catch(Exception e){
	          System.out.println(e);
	      }
	      
	  }
	
}