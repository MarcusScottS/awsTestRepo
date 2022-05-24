package utopiaAirlines.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class FlightDao {			
		
			final String URL = "jdbc:mysql://localhost:3306/utopia";
			final String USER = "root";
			final String PASSWORD = "";
			final String DRIVER = "com.mysql.cj.jdbc.Driver";
			
			
			/**************************************************************
						getFlights
			 ****************************************************************/

			public List<Flight> getFlights(String tableName, String tableName2) throws SQLException, ClassNotFoundException {
				List<Flight> flights = null;
				Connection conn = null;
				
				try {
					Class.forName(DRIVER);
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					Statement statement = conn.createStatement();
//					ResultSet resultSetKey = statement.getGeneratedKeys();
					ResultSet resultSet = statement.executeQuery("SELECT tbl_flight.flightId, tbl_flight.departTime, tbl_flight.seatsAvailable, tbl_flight.price, tbl_flight.arrivalTime, tbl_flight.flightNumber, tbl_flight_details.departCityId, tbl_flight_details.arriveCityId FROM " + tableName + " INNER JOIN " + tableName2 + " ON  tbl_flight.flightNumber = tbl_flight_details.flightNumber" + ";");
					while(resultSet.next()) {
						if(flights == null) flights = new ArrayList<>();
						int flightId = resultSet.getInt(1);
						Timestamp departTime = resultSet.getTimestamp(2);
						int seatsAvailable = resultSet.getInt(3);
						double price = resultSet.getDouble(4);
						Timestamp arrivalTime = resultSet.getTimestamp(5);
						String flightNumber = resultSet.getString(6);
						String departCityId = resultSet.getString(7);
						String arriveCityId = resultSet.getString(8);
						Flight flight = new Flight(flightId, departTime, seatsAvailable, price, arrivalTime, flightNumber, departCityId, arriveCityId);
						flights.add(flight);
					}

					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch(SQLException e) {
					e.printStackTrace();
				}
				finally {
					if(conn != null) conn.close();
				}
				
				return flights;
			}
			
			
			/**************************************************************
						getSeats
			 ****************************************************************/
			
			
			
			
//			public List<Flight> getSeats(String tableName) throws SQLException, ClassNotFoundException {
//				List<Flight> flights = null;
//				Connection conn = null;
//				
//				try {
//					Class.forName(DRIVER);
//					conn = DriverManager.getConnection(URL, USER, PASSWORD);
//					Statement statement = conn.createStatement();
////					ResultSet resultSetKey = statement.getGeneratedKeys();
//					ResultSet resultSet = statement.executeQuery("SELECT flightId, seatsAvailable FROM " + tableName + ";");
//					while(resultSet.next()) {
//						if(flights == null) flights = new ArrayList<>();
//						int flightId = resultSet.getInt(1);
//						int seatsAvailable = resultSet.getInt(2);
//						Flight flight = new Flight(flightId, seatsAvailable);
//						flights.add(flight);
//					}
//
//					
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				} catch(SQLException e) {
//					e.printStackTrace();
//				}
//				finally {
//					if(conn != null) conn.close();
//				}
//				
//				return flights;
//			}
			
			
			
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
