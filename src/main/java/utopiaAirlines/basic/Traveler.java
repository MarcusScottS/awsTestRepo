package utopiaAirlines.basic;



import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Traveler {

			
//			iataIdent - a string
//		    city - a string
//			name - a string
//		    airportId - a foreign int key to id in _____ table

			private int travelerId;
			private String name;
			private String address;
			private String phone;
			private String email;
			private Timestamp dob;
			
			@Override
			public String toString() {
				return "Traveler{"  + "travelerId ='" + travelerId + '\'' + "name='" + name + '\'' + "address ='" + address + '\'' + ", phone ='" + phone + '\'' + ", email ='" + email + ", dob ='" + dob + '\'' + '}';
			}
			
			
			@Override
			public boolean equals(Object o) {
				if(this == o) return true;
				if(o == null || getClass() != o.getClass()) return false;
				Traveler  traveler = (Traveler ) o;
				return  travelerId == traveler.travelerId && name.equals(traveler.name) && address.equals(traveler.address) && phone.equals(traveler.phone) && traveler.equals(traveler.email) && dob.equals(traveler.dob);
			}
			
			@Override
			public int hashCode() {
				return Objects.hash(travelerId, name, address, phone, email, dob);
			}
			
			public int getTravelerId() {
				return travelerId;
			}
			
			public void setTravelerId(int travelerId) {
				this.travelerId = travelerId;
			}
			
			public String getName() {
				return name;
			}
			
			public void setName(String name) {
				this.name = name;
			}
			
			public String getAddress () {
				return address;
			}
			
			public void setAddress(String address) {
				this.address = address;
			}
			
			public String getPhone() {
				return phone;
			}
			
			public void setPhone(String phone) {
				this.phone = phone;
			}
			
			public String getEmail() {
				return email;
			}
			
			public void setEmail(String email) {
				this.email = email;
			}
			
			public Timestamp getDOB() {
				return dob;
			}
			
			public void setDOB(Timestamp dob ) {
				this.dob = dob;
			}
			
			
			// when doing insertTravler manually
			public Traveler( String name, String address, String phone, String email, Timestamp dob) {
				this.name = name;
				this.address = address;
				this.phone = phone;
				this.email = email;
				this.dob = dob;
			}
			
			// when using loop to popular an ArrayList of Traveler(s)
			public Traveler(int travelerId, String name, String address, String phone, String email, Timestamp dob) {
				this.travelerId = travelerId;
				this.name = name;
				this.address = address;
				this.phone = phone;
				this.email = email;
				this.dob = dob;
			}
	}