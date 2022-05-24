package utopiaAirlines.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TravelerBookingUpdateDao {

			
			final String URL = "jdbc:mysql://localhost:3306/utopia";
			final String USER = "root";
			final String PASSWORD = "";
			final String DRIVER = "com.mysql.cj.jdbc.Driver";
				
			
				/**************************************************************
						String  insertTravelerBooking
			 	****************************************************************/
			
				public String insertTravelerBooking(String tableName1, TravelerBooking travelerBooking) throws SQLException, ClassNotFoundException {
					Connection conn = null;
					try {
						Class.forName(DRIVER);
						conn = DriverManager.getConnection(URL, USER, PASSWORD);
						conn.setAutoCommit(false);
						Statement statement = conn.createStatement();
						statement.executeUpdate("insert into " + tableName1 + " set bookingId = '" + travelerBooking.getBookingId() + "', travelerId = '" + travelerBooking.getTravelerId() + "'");
						System.out.println("Inserting Traveler ... ");
						conn.commit();
						conn.setAutoCommit(true);
						return "Success";
						
					} finally {
						if(conn != null) conn.close();
					}
				}
				
				
				
				/**************************************************************
//						void  updateFlightDetails
				 ****************************************************************/
				
//				public void updateFlightDetails(String tableName, String flightNumber, String departCityId, String arriveCityId) throws SQLException, ClassNotFoundException {
//					Connection conn = null;
//					try {
//						Class.forName(DRIVER);
//						conn = DriverManager.getConnection(URL, USER, PASSWORD);
//						Statement statement = conn.createStatement();
//						statement.executeUpdate("update " + tableName + " set departCityId = '" + departCityId +
//					            "', arriveCityId = '" + arriveCityId +
//					            "' where flightNumber = '" + flightNumber + "'");
//						
//						System.out.println("Updating flightNumber ... " + flightNumber);
//					} finally {
//						if(conn != null) conn.close();
//					}
//				}
//				
				
				/**************************************************************
						void  deleteTravelerBooking
				 ****************************************************************/
			
				public void deleteTravelerBooking(String tableName, int bookingId) throws SQLException, ClassNotFoundException {
					Connection conn = null;
					try {
						Class.forName(DRIVER);
						conn = DriverManager.getConnection(URL, USER, PASSWORD);
						Statement statement = conn.createStatement();
						statement.executeUpdate("delete from " + tableName + " where bookingId = '" + bookingId + "'");
						System.out.println("Deleting travelerBooking ... " + bookingId);
					} finally {
						if(conn != null) conn.close();
					}
				}

}
