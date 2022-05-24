package utopiaAirlines.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FlightDetailsDao {
	
		final String URL = "jdbc:mysql://localhost:3306/utopia";
		final String USER = "root";
		final String PASSWORD = "";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		
		/**************************************************************
					List<FlightDetails> getFlightDetails
		 ****************************************************************/

		public List<FlightDetails> getFlightDetails(String tableName) throws SQLException, ClassNotFoundException {
			List<FlightDetails> flightDetails = null;
			Connection conn = null;
			
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("select flightNumber, departCityId, arriveCityId from " + tableName + ";");
				while(resultSet.next()) {
					if(flightDetails == null) flightDetails = new ArrayList<>();
					String flightNumber = resultSet.getString(1);
					String departCityId = resultSet.getString(2);
					String arriveCityId = resultSet.getString(3);
					FlightDetails flightDetail = new FlightDetails(flightNumber, departCityId, arriveCityId);
					flightDetails.add(flightDetail);
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				if(conn != null) conn.close();
			}
			
			return flightDetails;
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