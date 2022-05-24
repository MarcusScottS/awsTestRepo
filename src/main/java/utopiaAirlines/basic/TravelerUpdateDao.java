package utopiaAirlines.basic;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class TravelerUpdateDao {

			final String URL = "jdbc:mysql://localhost:3306/utopia";
			final String USER = "root";
			final String PASSWORD = "";
			final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
			
			public int insertTraveler(String tableName, Traveler traveler) throws SQLException, ClassNotFoundException {
				
				Connection conn = null;
				try {
					Class.forName(DRIVER);
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					
					String query = "insert into " + tableName + " set name = '" + traveler.getName() + "', address = '" + traveler.getAddress() + "', phone = '" + traveler.getPhone() + "', email = '" + traveler.getEmail() + "', dob = '" + traveler.getDOB() +  "'";
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
						void  updateTraveler
			 ****************************************************************/

		public void updateTraveler(String tableName, int travelerId, String name, String address, String phone, String email, Timestamp dob) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = conn.createStatement();
			statement.executeUpdate("update " + tableName + " set name = '" + name +
			        "', address = '" + address +
			        "', phone = '" + phone +
			        "', email = '" + email +
			        "', dob = '" + dob +
			        "' where travelerId = '" + travelerId + "'");
			
			System.out.println("Updating travelerId ... " + travelerId);
			} finally {
			if(conn != null) conn.close();
			}
		}	
			
			
			/**************************************************************
						void  deleteTraveler
			 ****************************************************************/
			
			public void deleteTraveler(String tableName, int travelerId) throws SQLException, ClassNotFoundException {
				Connection conn = null;
				try {
					Class.forName(DRIVER);
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					Statement statement = conn.createStatement();
					statement.executeUpdate("delete from " + tableName + " where travelerId = '" + travelerId + "'");
					System.out.println("Deleting Traveler ... " + travelerId);
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
				               "            `travelerId` INT NOT NULL AUTO_INCREMENT,\n" +
				               "            `name` VARCHAR(45) Not NULL,\n" +
				               "            `address` VARCHAR(45) Not NULL,\n" +
				               "            `phone` VARCHAR(45) Not NULL,\n" +
				               "            `email` VARCHAR(45) Not NULL,\n" +
				               "            `dob` DATETIME Not NULL,\n" +
				               "            PRIMARY KEY (`travelerId`)\n" +
				               "          ) ENGINE=InnoDB AUTO_INCREMENT = 91  DEFAULT CHARSET=utf8"
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