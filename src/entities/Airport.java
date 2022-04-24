package entities;

public class Airport implements Comparable <Airport>{
	private int airportCode;
	private String airportName;
	private String country;
	public Airport(String airportName, String country) {
		super();
		
		this.airportName = airportName;
		this.country = country;
	}
	public int getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(int airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public int compareTo(Airport o) {
		// TODO Auto-generated method stub
		 return this.airportName.compareTo(o.airportName);
	}
	public void ajouterAirport(Airport airport) {
		// TODO Auto-generated method stub
		
	}
	

}
