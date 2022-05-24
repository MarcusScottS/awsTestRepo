package utopiaAirlines.basic;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EmployeeUpdateDao {
	
		final String URL = "jdbc:mysql://localhost:3306/utopia";
		final String USER = "root";
		final String PASSWORD = "";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		
		/**************************************************************
					int insertEmployee
		 ****************************************************************/
		
		
		public int insertEmployee(String tableName, Employee employee) throws SQLException, ClassNotFoundException {
			
			Connection conn = null;
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				
				String query = "insert into " + tableName + " set password = '" + employee.getPassword() + "', email = '" + employee.getEmail() + "', firstName = '" + employee.getFirstName() + "', lastName = '" + employee.getLastName() + "', enabled = '" + employee.getEnabled() +  "', locked = '" + employee.getLocked() + "', userRole = '" + employee.getUserRole() +  "'";
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
					void  updateEmployee
		****************************************************************/
		//("tbl_booking",  1, "321CBA",  104);
		public void updateEmployee(String tableName, int userId, String password, String email, String firstName, String lastName, int enabled, int locked , int userRole) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		Statement statement = conn.createStatement();
		statement.executeUpdate("update " + tableName + " set password = '" + password +
		        "', email = '" + email +
		        "', firstName = '" + firstName +
		        "', lastName = '" + lastName +
		        "', enabled = '" + enabled +
		        "', locked = '" + locked +
		        "', userRole = '" + userRole +
		        "' where userId = '" + userId + "'");
		
		System.out.println("Updating userId ... " + userId);
		} finally {
		if(conn != null) conn.close();
		}
}
		
		
		
		
		/**************************************************************
					void  deleteEmployee
		 ****************************************************************/

	public void deleteEmployee(String tableName, int userId) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = conn.createStatement();
			statement.executeUpdate("delete from " + tableName + " where userId = '" + userId + "'");
			System.out.println("Deleting Employee ... " + userId);
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
		               "            `userId` INT NOT NULL AUTO_INCREMENT,\n" +
		               "            `password` varchar(100) Not NULL,\n" +
		               "            `email` varchar(50) Not NULL,\n" +
		               "            `firstName` varchar(45) Not NULL,\n" +
		               "            `lastName` varchar(45) Not NULL,\n" +
		               "            `enabled` TINYINT(1) Not NULL,\n" +
		               "            `locked` TINYINT(1) Not NULL,\n" +
		               "            `userRole` INT NULL DEFAULT NULL,\n" +
		               "            PRIMARY KEY (`userId`)\n" +
		               "          ) ENGINE=InnoDB AUTO_INCREMENT = 103  DEFAULT CHARSET=utf8"
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