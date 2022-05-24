package utopiaAirlines;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import utopiaAirlines.basic.Airport;
import utopiaAirlines.basic.AirportDao;
import utopiaAirlines.basic.AirportUpdateDao;


public class AirportDaoTest {

		@Test
	    public void testGetAirport() throws SQLException, ClassNotFoundException {
//			AirportDao airportDao = new AirportDao();
//	        AirportUpdateDao airportUpdateDao = new AirportUpdateDao();
//	        int rand = Math.abs(new Random().nextInt());
//	        String tableName = "tbl_airport" + rand;
//	        System.out.println("Creating table: " + tableName);
//	        airportUpdateDao.createTable(tableName);
//			Airport airport1 = new Airport("OTQ", "Bermuda", "Bermuda Airport", 1);
//			String attempt = airportUpdateDao.insertAirport(tableName, airport1);
//			System.out.println("airport1 : " + attempt);
//			List<Airport> airportList = new ArrayList<>();
//			airportList.add(airport1);
//			
//			
////
//	        List<Airport> airportReturned = airportDao.getAirports(tableName);
//	        assertEquals(airportList, airportReturned);
//	        airportUpdateDao.dropTable(tableName);
//	        System.out.println("Deleted Table: " + tableName);
	    }
	
	
}