package utopiaAirlines.basic;

import java.util.Objects;

public class Airport {


		
//		iataIdent - a string
//	    city - a string
//		name - a string
//	    airportId - a foreign int key to id in _____ table

		private String iataIdent;
		private String city;
		private String name;
		private int airportId;
		
		@Override
		public String toString() {
			return "Airport{"  + "iataIdent ='" + iataIdent + '\'' + "city='" + city + '\'' + "name='" + name + '\'' + ", airportId='" + airportId + '\'' + '}';
		}
		
		
		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;
			Airport airport = (Airport) o;
			return  iataIdent.equals(airport.iataIdent) && city.equals(airport.city) && name.equals(airport.name) && airportId == airport.airportId;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(iataIdent, city, name, airportId);
		}
		
		public String getIataIdent() {
			return iataIdent;
		}
		
		public void setIataIdent(String iataIdent) {
			this.iataIdent = iataIdent;
		}
		
		public String getCity() {
			return city;
		}
		
		public void setCity(String city) {
			this.city = city;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getAirportId() {
			return airportId;
		}
		
		public void setAirportId(int airportId) {
			this.airportId = airportId;
		}
		
		
		public Airport(String iataIdent, String city, String name, int airportId) {
			this.iataIdent = iataIdent;
			this.city = city;
			this.name = name;
			this.airportId = airportId;
		}
}
