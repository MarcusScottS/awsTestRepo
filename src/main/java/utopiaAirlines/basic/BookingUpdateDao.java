package utopiaAirlines.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingUpdateDao {
	final String URL = "jdbc:mysql://localhost:3306/utopia";
	final String USER = "root";
	final String PASSWORD = "";
	final String DRIVER = "com.mysql.cj.jdbc.Driver";

	
	
		/**************************************************************
					int  insertBooking
	 	****************************************************************/
	
	public int insertBooking(String tableName, Booking booking) throws SQLException, ClassNotFoundException {
	
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String query = "insert into " + tableName + " set isActive = '" + booking.getIsActive() + "', stripeId = '" + booking.getStripeId() + "', bookerId = '" + booking.getBookerId() + "'";
			conn.setAutoCommit(false);
			
			Statement statement = conn.createStatement();
			int numRows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			System.out.println("numRows inserted = " + numRows);
			int lastInsertId = 0;
			if(numRows == 1) {
				ResultSet genKeys = statement.getGeneratedKeys();
				if(genKeys.next()) {
					lastInsertId = genKeys.getInt(1); // ResultSet should have exactly one collumn, the primary key of Insert table.
				} else {
					throw new SQLException("Could not get the id");
				}
			} else {
				throw new SQLException("Could not get the id");
			}
			conn.commit();
			conn.setAutoCommit(true);
			return lastInsertId;
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	
	
	
		/**************************************************************
					void  updateBooking
		****************************************************************/
//	("tbl_booking",  1, "321CBA",  104);
		public void updateBooking(String tableName, int bookingId,  int isActive, String stripeId, int bookerId) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = conn.createStatement();
			statement.executeUpdate("update " + tableName + " set isActive= '" + isActive +
		            "', stripeId = '" + stripeId +
		            "', bookerId = '" + bookerId +
		            "' where bookingId = '" + bookingId + "'");
			
			System.out.println("Updating booking ... " + bookingId);
		} finally {
			if(conn != null) conn.close();
		}
}

		
		/**************************************************************
				void  updateCancellation
		****************************************************************/
		//("tbl_booking",  1, "321CBA",  104);
		public void updateCancellation(String tableName, int bookingId,  int isActive) throws SQLException, ClassNotFoundException {
			Connection conn = null;
			try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = conn.createStatement();
			statement.executeUpdate("update " + tableName + " set isActive= '" + isActive +
			        "' where bookingId = '" + bookingId + "'");
			
			System.out.println("Updating booking ... " + bookingId);
			} finally {
			if(conn != null) conn.close();
			}
		}
		
	
	
	
		/**************************************************************
			void  deleteBooking
		****************************************************************/

		public void deleteBooking(String tableName, int bookingId) throws SQLException, ClassNotFoundException {
			Connection conn = null;
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = conn.createStatement();
				statement.executeUpdate("delete from " + tableName + " where bookingId = '" + bookingId + "'");
				System.out.println("Deleting booking ... " + bookingId);
			} finally {
				if(conn != null) conn.close();
			}
		}




}
