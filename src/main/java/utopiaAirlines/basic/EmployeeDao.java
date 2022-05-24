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

public class EmployeeDao {
				
				final String URL = "jdbc:mysql://localhost:3306/utopia";
				final String USER = "root";
				final String PASSWORD = "";
				final String DRIVER = "com.mysql.cj.jdbc.Driver";

				public List<Employee> getEmployees(String tableName) throws SQLException, ClassNotFoundException {
					List<Employee> employees = null;
					Connection conn = null;
					
					try {
						Class.forName(DRIVER);
						conn = DriverManager.getConnection(URL, USER, PASSWORD);
						Statement statement = conn.createStatement();
//						ResultSet resultSetKey = statement.getGeneratedKeys();
						ResultSet resultSet = statement.executeQuery("select userId, password, email, firstName, lastName, enabled, locked, userRole from " + tableName + ";");
						while(resultSet.next()) {
							if(employees == null) employees = new ArrayList<>();
							int userId = resultSet.getInt(1);
							String password = resultSet.getString(2);
							String email = resultSet.getString(3);
							String firstName = resultSet.getString(4);
							String lastName = resultSet.getString(5);
							int enabled = resultSet.getInt(6);
							int locked = resultSet.getInt(7);
							int userRole = resultSet.getInt(8);
							Employee employee = new Employee(userId, password, email, firstName, lastName, enabled, locked, userRole);
							employees.add(employee);
						}

						
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch(SQLException e) {
						e.printStackTrace();
					}
					finally {
						if(conn != null) conn.close();
					}
					
					return employees;
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
