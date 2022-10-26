package umf.cs;

public class Vin {
	//constructor
	public Vin() {
	
	}
	
	public void assignVinEntry(String name, String vin) {
		salesName = name;
		this.vin = vin;
		brand_engine_type = vin.substring(3,8);
		serial_number = vin.substring(11,17);
	}
	
	//getters
	public String getsalesName() {
		return salesName;
	}
	public String getVin() {
		return vin;
	}
	public String getbrand_engine_type() {
		return brand_engine_type;
	}
	public String getserial_number() {
		return serial_number;
	}

	private String salesName;
	private String vin; //auto assigned to sales person to sell
	private String brand_engine_type;
	private String serial_number;
}
