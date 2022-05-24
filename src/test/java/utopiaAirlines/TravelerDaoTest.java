package utopiaAirlines;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import utopiaAirlines.basic.Traveler;
import utopiaAirlines.basic.TravelerDao;
import utopiaAirlines.basic.TravelerUpdateDao;

import static org.junit.jupiter.api.Assertions.*;



public class TravelerDaoTest {
	

					@Test
				    public void testGetTraveler() throws SQLException, ClassNotFoundException {
						TravelerDao travelerDao = new TravelerDao();
				        TravelerUpdateDao travelerUpdateDao = new TravelerUpdateDao();
				        int rand = Math.abs(new Random().nextInt());
				        String tableName = "tbl_test_traveler" + rand;
				        System.out.println("Creating table: " + tableName);
				        travelerUpdateDao.createTable(tableName);
						Traveler traveler1 = new Traveler(91, "Traveler1", "921 Ice St", "555-0212", "traveler1@mail.com", new java.sql.Timestamp(2022, 5, 25, 11, 30, 0, 0));
						int attempt = travelerUpdateDao.insertTraveler(tableName, traveler1);
						System.out.println("traveler1 : " + attempt);
						List<Traveler> travelerList = new ArrayList<>();
						travelerList.add(traveler1);
						
						
			//
				        List<Traveler> travelerReturned = travelerDao.getTravelers(tableName);
				        assertEquals(travelerList, travelerReturned);
				        travelerUpdateDao.dropTable(tableName);
				        System.out.println("Deleted Table: " + tableName);
				    }

}
