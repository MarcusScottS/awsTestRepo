package utopiaAirlines.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class TravelerDao {
		
	
		final String URL = "jdbc:mysql://localhost:3306/utopia";
		final String USER = "root";
		final String PASSWORD = "";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";

		public List<Traveler> getTravelers(String tableName) throws SQLException, ClassNotFoundException {
			List<Traveler> travelers = null;
			Connection conn = null;
			
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = conn.createStatement();
//				ResultSet resultSetKey = statement.getGeneratedKeys();
				ResultSet resultSet = statement.executeQuery("select travelerId, name, address, phone, email, dob from " + tableName + ";");
				while(resultSet.next()) {
					if(travelers == null) travelers = new ArrayList<>();
					int travelerId = resultSet.getInt(1);
					String name = resultSet.getString(2);
					String address = resultSet.getString(3);
					String phone = resultSet.getString(4);
					String email = resultSet.getString(5);
					Timestamp dob = resultSet.getTimestamp(6);
					Traveler traveler = new Traveler(travelerId, name, address, phone, email, dob);
					travelers.add(traveler);
				}

				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				if(conn != null) conn.close();
			}
			
			return travelers;
		}
		
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
