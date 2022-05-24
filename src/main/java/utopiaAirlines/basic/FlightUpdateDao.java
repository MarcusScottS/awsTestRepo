package utopiaAirlines.basic;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class FlightUpdateDao {
		
	
	final String URL = "jdbc:mysql://localhost:3306/utopia";
	final String USER = "root";
	final String PASSWORD = "";
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	
	
	/**************************************************************
					void  insertFlightDetails
	 ****************************************************************/
	
//	public void insertFlightDetails(String tableName, String flightNumber, String departCityId, String arriveCityId) throws SQLException, ClassNotFoundException {
//		
//		Connection conn = null;
//		try {
//			Class.forName(DRIVER);
//			conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			conn.setAutoCommit(false);
//			Statement statement = conn.createStatement();
//			statement.executeUpdate("insert into " + tableName + " set flightNumber = '" + flightNumber + "', departCityId = '" + departCityId + "', arriveCityId = '" + arriveCityId + "'");
////			ResultSet resultSet = statement1.executeQuery("insert into tbl_flight_details set flightNumber = '" + flight.getFlightNumber() + "', departCityId = '" + flight.getDepartCityId() + "', arrivalCityId = '" + flight.getArrivalCityId + "'";
//			System.out.println("Inserting flightDetails ... ");
//			conn.commit();
//			conn.setAutoCommit(true);
//			
//		} finally {
//			if(conn != null) conn.close();
//		}



//				statement.executeUpdate("insert into " + tableName1 + " set iataIdent = '" + airport.getIataIdent() + "', city = '" + airport.getCity() + "', name = '" + airport.getName() + "', airportId = '" + airport.getAirportId() + "'");
//				System.out.println("Inserting Airport ... ");
//				conn.commit();
//				conn.setAutoCommit(true);
//				return "Success";
			
//	}
	
			/**************************************************************
					void  insertFlight
	 		****************************************************************/
	
				public int insertFlight(String tableName, Flight flight) throws SQLException, ClassNotFoundException {
					
					Connection conn = null;
					try {
						Class.forName(DRIVER);
						conn = DriverManager.getConnection(URL, USER, PASSWORD);
//						insertFlightDetails("tbl_flight_details", flight.getFlightNumber(), flight.getDepartureAirport(), flight.getArrivalAirport());
						String query = "insert into " + tableName + " set departTime = '" + flight.getDepartTime() + "', seatsAvailable = '" + flight.getSeatsAvailable() + "', price = '" + flight.getPrice() + "', arrivalTime = '" + flight.getArrivalTime() + "', flightNumber = '" + flight.getFlightNumber() +  "'";
						conn.setAutoCommit(false);
//						ResultSet resultSet = statement1.executeQuery("insert into tbl_flight_details set flightNumber = '" + flight.getFlightNumber() + "', departCityId = '" + flight.getDepartCityId() + "', arrivalCityId = '" + flight.getArrivalCityId + "'";
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
				void  updateFlight
	****************************************************************/
				
				public void updateFlight(String tableName, int flightId, Date departTime, int seatsAvailable, double price, Date arrivalTime) throws SQLException, ClassNotFoundException {
					Connection conn = null;
					try {
						Class.forName(DRIVER);
						conn = DriverManager.getConnection(URL, USER, PASSWORD);
						Statement statement = conn.createStatement();
						statement.executeUpdate("update " + tableName + " set departTime = '" + departTime +
					            "', seatsAvailable = '" + seatsAvailable  +
					            "', price = '" + price +
					            "', arrivalTime = '" + arrivalTime +
					            "' where flightId = '" + flightId + "'");
						
						System.out.println("Updating flight... " + flightId);
					} finally {
						if(conn != null) conn.close();
					}
				}
				
				
				
				/**************************************************************
							void  updateSeats
				 ****************************************************************/
				
				public void updateSeats(String tableName, int flightId, int seatsAvailable ) throws SQLException, ClassNotFoundException {
					Connection conn = null;
					try {
						Class.forName(DRIVER);
						conn = DriverManager.getConnection(URL, USER, PASSWORD);
						Statement statement = conn.createStatement();
						statement.executeUpdate("update " + tableName + " set seatsAvailable = '" + seatsAvailable  + "' where flightId = '" + flightId + "'");
						
						System.out.println("Updating seats for flight ... " + flightId);
					} finally {
						if(conn != null) conn.close();
					}
				}
				
				
				
				
				
	/**************************************************************
				void  deleteFlight
	****************************************************************/
			
	public void deleteFlight(String tableName, int flightId) throws SQLException, ClassNotFoundException {
		Connection conn = null;
				try {
						Class.forName(DRIVER);
						conn = DriverManager.getConnection(URL, USER, PASSWORD);
						Statement statement = conn.createStatement();
						statement.executeUpdate("delete from " + tableName + " where flightId = '" + flightId + "'");
						System.out.println("Deleting flight ... " + flightId);
					} finally {
						if(conn != null) conn.close();
					}
				}
	
	
	
	/**************************************************************
	TESTING FUNCTIONS
	 ****************************************************************/



	/**************************************************************
	boolean	tableExistsOnConn
	****************************************************************/
	
	
	public boolean tableExistsOnConn(Connection conn, String tableName) throws SQLException {
		DatabaseMetaData dbmd = conn.getMetaData();
		ResultSet resultSet = dbmd.getTables(null, null, tableName, new String[] {"TABLE"});
		return resultSet.next();
	}



	
	/**************************************************************
	boolean  createTable
	****************************************************************/
	
	public boolean createTable(String tableName) throws SQLException, ClassNotFoundException {
	
		Connection conn = null;
		try {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		boolean tableExists = tableExistsOnConn(conn, tableName);
		if(tableExists) return false;
		
		Statement statement = conn.createStatement();
		statement.executeUpdate("CREATE TABLE `" + tableName + "` (\n" +
		               "            `flightId` INT NOT NULL AUTO_INCREMENT,\n" +
		               "            `departTime` DATETIME Not NULL,\n" +
		               "            `seatsAvailable` INT Not NULL,\n" +
		               "            `price` DECIMAL(13, 2) Not NULL,\n" +
		               "            `arrivalTime` DATETIME Not NULL,\n" +
		               "            `flightNumber` VARCHAR(4) Not NULL,\n" +
		               "            PRIMARY KEY (`flightId`)\n" +
		               "          ) ENGINE=InnoDB AUTO_INCREMENT = 2913637  DEFAULT CHARSET=utf8"
				);
		System.out.println("Creating Table ... " + tableName);
		return true;
		
		} finally {
		if(conn != null) conn.close();
		}	
	}


	/**************************************************************
			void	dropTable
	****************************************************************/
	
	public void dropTable(String tableName) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		boolean tableExists = tableExistsOnConn(conn, tableName);
		if (tableExists) {
		    Statement stmt = conn.createStatement();
		    stmt.executeUpdate("drop table " + tableName);
		    System.out.println("Dropping Table ... " + tableName);
		} else {
			System.out.println("table does not exists");
		}
		} finally {
		if (conn != null) conn.close();
		}
	}
	
	
		
	

}