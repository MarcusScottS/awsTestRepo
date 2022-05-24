package utopiaAirlines.basic;

import java.sql.Date;
import java.util.Objects;

public class Employee {





				private int userId;
				private String password;
				private String email;
				private String firstName;
				private String lastName;
				private int enabled;
				private int locked;
				private int userRole;
				
				@Override
				public String toString() {
					return "Employee{"  + "userId ='" + userId + '\'' + "password ='" + password + '\'' + "email ='" + email + '\'' + "firstName ='" + firstName + '\'' + ", lastName ='" + lastName + '\'' + ", enabled = '" + enabled + '\'' + ", locked = '" + locked + '\'' + ", userRole = '" + userRole + '}';
				}

				
				@Override
				public boolean equals(Object o) {
					if(this == o) return true;
					if(o == null || getClass() != o.getClass()) return false;
					Employee  employee = (Employee ) o;
					return  userId == employee.userId && password.equals(employee.password) && email.equals(employee.email) && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && enabled == employee.enabled && locked == employee.locked && userRole == employee.userRole;

				}
				
				@Override
				public int hashCode() {
					return Objects.hash(userId, password, email, firstName, lastName, enabled, locked, userRole);
				}
				
				public int getUserId() {
					return userId;
				}
				
				public void setUserId(int userId) {
					this.userId = userId;
				}
				
				public String getPassword() {
					return password;
				}
				
				public void setPassword (String password) {
					this.password = password;
				}
				
				public String getEmail() {
					return email;
				}
				
				public void setEmail (String email) {
					this.email = email;
				}
				
				public String getFirstName() {
					return firstName;
				}
				
				public void setFirstName (String firstName) {
					this.firstName = firstName;
				}
				
				public String getLastName() {
					return lastName;
				}
				
				public void setLastName (String lastName) {
					this.lastName = lastName;
				}
				
				
				
				public int getEnabled() {
					return enabled;
				}
				
				public void setEnabled(int enabled) {
					this.enabled = enabled;
				}
				
				public int getLocked() {
					return locked;
				}
				
				public void setLocked(int locked) {
					this.locked = locked;
				}
				public int getUserRole() {
					return userRole;
				}
				
				public void setUserRole(int userRole) {
					this.userRole = userRole;
				}
				
				
				
				// when doing insertTravler manually
				public Employee ( String password, String email, String firstName, String lastName, int enabled, int locked, int userRole) {
					this.password = password;
					this.email = email;
					this.firstName = firstName;
					this.lastName = lastName;
					this.enabled = enabled;
					this.locked = locked;
					this.userRole = userRole;
				}
				
				// when using loop to popular an ArrayList of Traveler(s)
				public Employee (int userId, String password, String email, String firstName, String lastName, int enabled, int locked, int userRole) {
					this.userId = userId;
					this.password = password;
					this.email = email;
					this.firstName = firstName;
					this.lastName = lastName;
					this.enabled = enabled;
					this.locked = locked;
					this.userRole = userRole;
				}
	
}