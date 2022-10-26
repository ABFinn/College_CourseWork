package umf.cs;

import java.io.*;

public class SimCarCompany {

	private static final int SALESPERSONTABLESIZE = 20;
	private static final int VINTABLESIZE = 20;
	
	private BufferedReader rdr = null; //use for both files
	private int nextVinEntry; //next available spot in vin table
	private int nextSalesPersonEntry; //next available spot in salesPerson table
	
	private SalesPerson[] salesTable;
	private Vin[] vinTable;
	
	public SimCarCompany( ){
		salesTable = new SalesPerson[SALESPERSONTABLESIZE];
		for(int i = 0; i < SALESPERSONTABLESIZE; i++) {
			salesTable[i] = new SalesPerson();
		}
		
		vinTable = new Vin[VINTABLESIZE];
		for(int i = 0; i < VINTABLESIZE; i++) {
			vinTable[i] = new Vin();
		}
		
		nextVinEntry = 0;
		nextSalesPersonEntry = 0;
		
	}
	
	void runAutoCompany(String filename1, String filename2) throws java.io.IOException {
		String nameValue, vinValue;
		//fill in sales table
		try {
			rdr = new BufferedReader(new FileReader(filename1));
			
			while ((nameValue = rdr.readLine()) != null) {
				salesTable[nextSalesPersonEntry].assignSalesPersonEntry(nameValue);
				nextSalesPersonEntry++;
			}
			nextSalesPersonEntry--;
			SalesPerson.setTotalEntries(nextSalesPersonEntry);
		} // end of try
		catch(java.io.IOException ioe) {
			System.err.println(ioe);
		} //end catch
		finally {
			rdr.close();
		} //end finally
		
		//fill in vinTable
		try {
			rdr = new BufferedReader(new FileReader(filename2));
			int j = 0; //index into SalesPerson table
			
			while ((vinValue = rdr.readLine()) != null) {
				nameValue = salesTable[j].getName();
				vinTable[nextVinEntry].assignVinEntry(nameValue,vinValue);
				nextVinEntry++;
				j++;
				if(j > SalesPerson.getTotalEntries()) {
					j = 0;
				}
			}
		} // end of try
		catch(java.io.IOException ioe) {
			System.err.println(ioe);
		} //end catch
		finally {
			rdr.close();
		} //end finally
		
		checkResults();
	}
	
	public void checkResults() {
		System.out.printf("%s\n\n", "sales person table");
		for(int i = 0; i <= SalesPerson.getTotalEntries(); i++) {
			System.out.printf("%-20s\n", salesTable[i].getName());			
		}
		
		System.out.printf("\n\n");
		
		System.out.printf("%s\n\n", "vin table");
		//TO DO print the names of the 4 columns
		System.out.printf("%-20s%13s%34s%18s\n\n", "Sales Person Name", "vin", "brand_engine_type","serial_number");
		for(int i = 0;i < nextVinEntry; i++) {
			System.out.printf("%-20s%20s%20s%20s\n", 
					vinTable[i].getsalesName(),
					vinTable[i].getVin(),
					vinTable[i].getbrand_engine_type(),
					vinTable[i].getserial_number());
		}
				
		System.out.printf("\n\n");
	}
	
	public static void main(String[] args) throws java.io.IOException{
		
		SimCarCompany sc = new SimCarCompany();
		sc.runAutoCompany("sales.txt", "NewVins.txt");

	}

}
