package utopiaAirlines.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class BookingDao {

			
		
			final String URL = "jdbc:mysql://localhost:3306/utopia";
			final String USER = "root";
			final String PASSWORD = "";
			final String DRIVER = "com.mysql.cj.jdbc.Driver";
			
			
			
			/**************************************************************
							getBookings
			 ****************************************************************/
			

			public List<Booking> getBookings(String tableName1, String tableName2, String tableName3) throws SQLException, ClassNotFoundException {
				List<Booking> bookings = null;
				Connection conn = null;
				
				try {
					Class.forName(DRIVER);
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					Statement statement = conn.createStatement();
//					ResultSet resultSetKey = statement.getGeneratedKeys();
					ResultSet resultSet = statement.executeQuery("select tbl_booking.bookingId,  tbl_booking.isActive,  tbl_booking.stripeId,  tbl_booking.bookerId, tbl_bookings_has_travelers.travelerId, tbl_flight_has_bookings.flightId from "
							+    tableName1
							+ " JOIN "
							+    tableName2
							+ " ON "
							+ "   tbl_booking.bookingId = tbl_bookings_has_travelers.bookingId"
							+ " JOIN "
							+    tableName3
							+ " ON "
							+ "   tbl_booking.bookingId = tbl_flight_has_bookings.bookingId" + ";");
					
					while(resultSet.next()) {
						if(bookings == null) bookings = new ArrayList<>();
						int bookingId = resultSet.getInt(1);
						int isActive = resultSet.getInt(2);
						String stripeId = resultSet.getString(3);
						int bookerId = resultSet.getInt(4);
						int travelerId = resultSet.getInt(5);
						int flightId = resultSet.getInt(6);
						Booking booking = new Booking(bookingId, isActive, stripeId, bookerId, travelerId, flightId);
						bookings.add(booking);
					}

					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch(SQLException e) {
					e.printStackTrace();
				}
				finally {
					if(conn != null) conn.close();
				}
				
				return bookings;
			}
			
			
			/**************************************************************
							getCancellations
			 ****************************************************************/
			
			public List<Booking> getCancellations(String tableName1, String tableName2, String tableName3) throws SQLException, ClassNotFoundException {
				List<Booking> bookings = null;
				Connection conn = null;
				
				try {
					Class.forName(DRIVER);
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					Statement statement = conn.createStatement();
					ResultSet resultSet = statement.executeQuery("select tbl_booking.bookingId,  tbl_booking.isActive,  tbl_booking.stripeId,  tbl_booking.bookerId, tbl_bookings_has_travelers.travelerId, tbl_flight_has_bookings.flightId from "
							+    tableName1
							+ " JOIN "
							+    tableName2
							+ " ON "
							+ "   tbl_booking.bookingId = tbl_bookings_has_travelers.bookingId"
							+ " JOIN "
							+    tableName3
							+ " ON "
							+ "   tbl_booking.bookingId = tbl_flight_has_bookings.bookingId" + " WHERE tbl_booking.isActive = 0;");
					while(resultSet.next()) {
						if(bookings == null) bookings = new ArrayList<>();
						int bookingId = resultSet.getInt(1);
						int isActive = resultSet.getInt(2);
						String stripeId = resultSet.getString(3);
						int bookerId = resultSet.getInt(4);
						int travelerId = resultSet.getInt(5);
						int flightId = resultSet.getInt(6);
						Booking booking = new Booking(bookingId, isActive, stripeId, bookerId, travelerId, flightId);
						bookings.add(booking);
					}

					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch(SQLException e) {
					e.printStackTrace();
				}
				finally {
					if(conn != null) conn.close();
				}
				
				return bookings;
			}
			
			
			/**************************************************************
						getColumnNames
			 ****************************************************************/
			
			public List<String> getColumnNames(String table) throws SQLException, ClassNotFoundException {
				List<String> colNames = null;
				Connection conn = null;
				
				try {
					Class.forName(DRIVER);
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					
					Statement statement = conn.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * from " + table + " limit 1;");
					ResultSetMetaData rsmd = resultSet.getMetaData(); // Hw do we need data in the table
					for(int i = 0; i < rsmd.getColumnCount(); i++) {
						if(colNames == null) colNames = new ArrayList<>();
						colNames.add(rsmd.getColumnName(i + 1));
					}
							
				} catch(ClassNotFoundException e) {
					e.printStackTrace();
				} catch(SQLException e) {
					e.printStackTrace();
				} finally {
					if(conn != null) conn.close();
				}
				
				return colNames;
			}
	
}
