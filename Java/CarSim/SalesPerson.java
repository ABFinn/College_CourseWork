package umf.cs;

public class SalesPerson {
	
	//constructor
	public SalesPerson() {		
	}
	
	public String getName( ) {
		return name;
	}
	
	public static int getTotalEntries() { //class method so use static
		return totalEntries;
	}
	
	public static void setTotalEntries(int total) { //class method so use static
		totalEntries = total;
	}
	
	public void assignSalesPersonEntry(String name) {
		this.name = name;
	}
	
	private String name; // salesperson
	private static int totalEntries; //class variable so need static
}
