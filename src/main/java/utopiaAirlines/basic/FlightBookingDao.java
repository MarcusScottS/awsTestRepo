package utopiaAirlines.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightBookingDao {

		
			final String URL = "jdbc:mysql://localhost:3306/utopia";
			final String USER = "root";
			final String PASSWORD = "";
			final String DRIVER = "com.mysql.cj.jdbc.Driver";
			
			/**************************************************************
						List<FlightBookings> getFlightBookings
			 ****************************************************************/

			public List<FlightBooking> getFlightBookings(String tableName) throws SQLException, ClassNotFoundException {
				List<FlightBooking> flightBookings = null;
				Connection conn = null;
				
				try {
					Class.forName(DRIVER);
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					
					Statement statement = conn.createStatement();
					ResultSet resultSet = statement.executeQuery("select flightId, bookingId from " + tableName + ";");
					while(resultSet.next()) {
						if(flightBookings == null) flightBookings = new ArrayList<>();
						int flightId = resultSet.getInt(1);
						int bookingId = resultSet.getInt(2);
						FlightBooking flightBooking = new FlightBooking(flightId, bookingId);
						flightBookings.add(flightBooking);
					}
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch(SQLException e) {
					e.printStackTrace();
				}
				finally {
					if(conn != null) conn.close();
				}
				
				return flightBookings;
			}
			
			/**************************************************************
						List<String> getColumnNames
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