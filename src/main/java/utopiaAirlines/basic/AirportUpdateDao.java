package utopiaAirlines.basic;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AirportUpdateDao {
	
	final String URL = "jdbc:mysql://localhost:3306/utopia";
	final String USER = "root";
	final String PASSWORD = "";
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
		
	
		/**************************************************************
				String  insertAirport
	 	****************************************************************/
	
		public String insertAirport(String tableName1, Airport airport) throws SQLException, ClassNotFoundException {
			Connection conn = null;
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				conn.setAutoCommit(false);
				Statement statement = conn.createStatement();
				statement.executeUpdate("insert into " + tableName1 + " set iataIdent = '" + airport.getIataIdent() + "', city = '" + airport.getCity() + "', name = '" + airport.getName() + "', airportId = '" + airport.getAirportId() + "'");
				System.out.println("Inserting Airport ... ");
				conn.commit();
				conn.setAutoCommit(true);
				return "Success";
				
			} finally {
				if(conn != null) conn.close();
			}
		}
		
		
		
		/**************************************************************
				void  updateAirport
		 ****************************************************************/
		
		public void updateAirport(String tableName, String iataIdent,  String city, String name, int airportId) throws SQLException, ClassNotFoundException {
			Connection conn = null;
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = conn.createStatement();
				statement.executeUpdate("update " + tableName + " set city = '" + city +
			            "', name = '" + name +
			            "', airportId = '" + airportId +
			            "' where iataIdent = '" + iataIdent + "'");
				
				System.out.println("Updating airport ... " + iataIdent);
			} finally {
				if(conn != null) conn.close();
			}
		}
		
		
		/**************************************************************
				void  deleteAirport
		 ****************************************************************/
	
		public void deleteAirport(String tableName, String iataIdent) throws SQLException, ClassNotFoundException {
			Connection conn = null;
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = conn.createStatement();
				statement.executeUpdate("delete from " + tableName + " where iataIdent = '" + iataIdent + "'");
				System.out.println("Deleting airport ... " + iataIdent);
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
				               "            `iataIdent` varchar(4) NOT NULL,\n" +
				               "            `city` varchar(100) Not NULL,\n" +
				               "            `name` varchar(100) Not NULL,\n" +
				               "            `airportId` INT Not NULL,\n" +
				               "            PRIMARY KEY (`iataIdent`)\n" +
				               "          ) ENGINE=InnoDB DEFAULT CHARSET=utf8"
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
