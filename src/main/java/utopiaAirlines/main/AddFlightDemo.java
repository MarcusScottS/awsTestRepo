package utopiaAirlines.main;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import utopiaAirlines.basic.Airport;
import utopiaAirlines.basic.AirportDao;
import utopiaAirlines.basic.AirportUpdateDao;
import utopiaAirlines.basic.Flight;
import utopiaAirlines.basic.FlightDetails;
import utopiaAirlines.basic.FlightDetailsUpdateDao;
import utopiaAirlines.basic.FlightUpdateDao;

public class AddFlightDemo {
	
	

	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
		
		
		Scanner sc = new Scanner(System.in);
		
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
		
		String departCityId = sc.nextLine();
//		System.out.println("Origin Airport: " + departCityId);
		
		
		System.out.println("Please enter the iataIdent for your destination airport or enter 101 to create your a new airport");
		String arriveCityId = sc.nextLine();
		if(arriveCityId.equals("101")) {
			System.out.println("You have chosen to create a new airport");
			
			System.out.println();
			String[] stringAirportInsert = new String[4];
			System.out.println("Please enter new airport details: iataIdent, city, name, airportId");
			for(int i = 0; i < stringAirportInsert.length; i++) {
				stringAirportInsert[i] = sc.nextLine();
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
//			System.out.println("Destination Airport: " + arriveCityId);
		} else {
//			System.out.println("Destination Airport: " + arriveCityId);
		}
		
		System.out.println("Please enter the value associated with your chosen departue date.");
		System.out.println("1. 2022 - 04 - 24");
		System.out.println("2. 2022 - 04 - 26");
		System.out.println("3. 2022 - 05 - 05");
		System.out.println("4. 2022 - 05 - 07");
		System.out.println("5. 2022 - 05 - 25");
		
		
		String userDate;
		userDate = sc.nextLine();
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
		
//		System.out.println("Departure Date: " + userDate);
		
		
		System.out.println("Please enter the value associated with your chosen departue time or enter 101 to create your own time.");
		System.out.println("1. 10:00:00");
		System.out.println("2. 12:00:00");
		System.out.println("3. 05:30:00");
		System.out.println("4. 02:45:00");
		System.out.println("5. 09:15:00");
		
		
		String userTime;
		userTime = sc.nextLine();
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
			userTime = sc.nextLine();
		}
		
		
//		System.out.println("Departure Time: " + userTime);
		
		String stringDepartTime = userDate + userTime;
//		System.out.println(stringDepartTime);
		
		Timestamp departTime = Timestamp.valueOf(stringDepartTime);
		int seatsAvailable = 20;
		double price = 200;
		Timestamp arrivalTime = new Timestamp(departTime.getTime() + (1000 * 60 * 60 * 3));
//		System.out.println("arrivalTime: " + arrivalTime);

		

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
//		System.out.println("You are ready to insertFlight");

		
			
			/**************************************************************
						step1 insertFlightDetails
			 ***************************************************************/
		
		FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
		FlightDetails flightDetails1 = new FlightDetails(flightNumber, departCityId, arriveCityId);
		flightDetailsUpdateDao.insertFlightDetails("tbl_flight_details", flightDetails1);
			
//		FlightDetailsUpdateDao flightDetailsUpdateDao = new FlightDetailsUpdateDao();
//		FlightDetails flightDetails1 = new FlightDetails("A13", "LHR", "JFK");
//		flightDetailsUpdateDao.insertFlightDetails("tbl_flight_details", flightDetails1);
		
		/**************************************************************
				 		step 2 insertFlight 
		 ***************************************************************/
		
		FlightUpdateDao flightUpdateDao = new FlightUpdateDao();	
		Flight flight1 = new Flight(departTime, seatsAvailable, price, arrivalTime, flightNumber);
		int flightId = flightUpdateDao.insertFlight("tbl_flight", flight1);
		System.out.println("flight.flightId: " + flightId);
		
//		FlightUpdateDao flightUpdateDao = new FlightUpdateDao();	
//		Flight flight1 = new Flight(new java.sql.Timestamp(2022, 5, 25, 11, 30, 0, 0), 20, 350.00, new java.sql.Timestamp(2022, 5, 25, 11, 30, 0, 0), "A13");
//		int flightId = flightUpdateDao.insertFlight("tbl_flight", flight1);
//		System.out.println("flight.flightId: " + flightId);
		
		
		
		
	}
	
}