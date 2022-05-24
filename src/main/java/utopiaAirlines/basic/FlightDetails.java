package utopiaAirlines.basic;

import java.util.Objects;

public class FlightDetails {


			
//			iataIdent - a string
//		    city - a string
//			name - a string
//		    airportId - a foreign int key to id in _____ table

			private String flightNumber;
			private String departCityId;
			private String arriveCityId;
			
			@Override
			public String toString() {
				return "FlightDetails{"  + "flightNumber ='" + flightNumber + '\'' + "departCityId='" + departCityId + '\'' + " arriveCityId ='" + arriveCityId  + '}';
			}
			
			
			@Override
			public boolean equals(Object o) {
				if(this == o) return true;
				if(o == null || getClass() != o.getClass()) return false;
				FlightDetails flightDetails = (FlightDetails) o;
				return  flightNumber.equals(flightDetails.flightNumber) && departCityId.equals(flightDetails.departCityId) && arriveCityId.equals(flightDetails.arriveCityId);
			}
			
			@Override
			public int hashCode() {
				return Objects.hash(flightNumber, departCityId, arriveCityId);
			}
			
			public String getFlightNumber() {
				return flightNumber;
			}
			
			public void setFlightNumber(String flightNumber) {
				this.flightNumber = flightNumber;
			}
			

			
			public String getDepartCityId () {
				return departCityId;
			}
			
			public void setDepartCityId(String departCityId) {
				this.departCityId = departCityId;
			}
			
			public String getArriveCityId () {
				return arriveCityId;
			}
			
			public void setArriveCityId(String arriveCityId) {
				this.arriveCityId = arriveCityId;
			}
			
			
			
			public FlightDetails(String flightNumber, String departCityId, String arriveCityId) {
				this.flightNumber = flightNumber;
				this.departCityId = departCityId;
				this.arriveCityId = arriveCityId;
			}
	}