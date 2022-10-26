package umf.cs;

import java.io.*;
import java.util.Arrays;

public class SIMVIRTMEM {

	private static final int PAGETABLESIZE = 256;
	private static final int NUMFRAMES = 256;
	private static final int PAGESIZE = 256;
	private static final int TLBSIZE = 16;
	
	private File fileName; //file representing the hard drive called Data.txt
	private RandomAccessFile ranAccessFname = null;
	private BufferedReader rdr = null; //for addresses.txt file of virtual/logical addresses
		
	private int virtualAddress;
	private int frameNumber; //physical frame number
	private int physicalAddress; //256 * framenumber + offset
	private int offset; //offset in page as well as the frame
	private int pageNumber;
	
	private byte value; //the value stored at the physical address
	
	private int nextFrameNumber; //the next available frame in memory
	private int nextTLBEntry; //next available entry in the TLB
	
	private PageTableEntry [] pageTable;
	private TLBEntry [] TLB;
	private Frame [] physicalMemory; //RAM organized into frames
	
	
	
	private byte[] buffer; //the buffer for storing the page from the hard drive, store all bytes of a page, grab the offset
	
	private int pageFaults; // not in the page table
	private int TLBHits;
	private int numberOfAddresses;
	private int i;
	
	
	//Constructor
	public SIMVIRTMEM() {
		//Creating an empty array of PageTableEntry's of size 256
		pageTable = new PageTableEntry[PAGETABLESIZE];
		for(int i = 0; i < PAGETABLESIZE; i++) {
			pageTable[i] = new PageTableEntry();
		}
		
		//Creating an empty array of TLBEntry's of size 16
		TLB = new TLBEntry[TLBSIZE];
		for(int i = 0; i < TLBSIZE; i++) {
			TLB[i] = new TLBEntry();
		}
		
		//Creating an empty array of PageTableEntry's of size 256
		physicalMemory = new Frame[NUMFRAMES];
		for(int i = 0; i < NUMFRAMES; i++) {
			physicalMemory[i] = new Frame();
		}
		
		//Creating an empty array to store the full byte of a page
		buffer = new byte[PAGESIZE];
		
		pageFaults = 0;
		TLBHits = 0;
		numberOfAddresses = 0;
		nextFrameNumber = 0;
		nextTLBEntry = 0;
		
	}
	
	//Bit shifting  to get page number
	public int getPageNumber(int virtualAddress) {
		return virtualAddress >> 8;
	}
	
	//masking to get offset 
	public int getOffset(int virtualAddress) {
		return virtualAddress & 0x000000ff;
	}
	
	//get the next available frame
	public int getNextFrame() {
		return frameNumber + 1;
	}
	
	
	public int searchTLB(int pageNumber) {
		//variable to track if it found a match
		boolean found = false;
		
		//searches the TLB array one by one to see if it finds a corresponding page,
		//if found the variable "found" is marked true. 
		for(i = 0; i < TLBSIZE-1; i++) {
			if(TLB[i].pageFound(pageNumber) == true) {
				found = true;
			}
		}
		
		//if found is true, increment TLBHits and return the matching FrameNumbr
		if(found == true) {
			TLBHits++;
			return TLB[i].getFrameNumber();
		}
		//else return false/-1
		else {
			return -1;
		}
	}
	//Retrieves the relevant byte using the frameNumber and offset from our physical memory array. Uses integer division to access the frameNumber
	//from the physical address, and uses the variable offset to access the offset
	public byte getData(int physicalAddress) throws java.io.IOException {
		return physicalMemory[physicalAddress/256].readWord(offset);
	}
	
	public void assignTLBEntry(int pageNumber, int frameNumber) {
		//If/Else to keep the TLB Array within its size 16, if it reaches 16 it starts over at 0.
		//Assigns an entry in the TLB Table using a given page and frame.
		if(nextTLBEntry < 16) {
			TLB[nextTLBEntry].assignEntry(pageNumber, frameNumber);
			nextTLBEntry++;
		}
		else {
			nextTLBEntry = 0;
			TLB[nextTLBEntry].assignEntry(pageNumber, frameNumber);
		}
	}
	
	public int getPhysicalAddress(int virtualAddress) throws java.io.IOException {
		//determine the page number
		pageNumber = getPageNumber(virtualAddress);
		//determine the offset
		offset = getOffset(virtualAddress);
		
		if(searchTLB(pageNumber) == -1) { //searchTLB and get hit you will have frameNumber nut otherwise -1 TLB miss
			if(pageTable[pageNumber].getValidBit() == true) { //check pageTable
				frameNumber = pageTable[pageNumber].getFrameNumber();	
				//if found in page table, get frameNumber
			}
			else { //pageFault
				//get a free frame, assign frameNumber
				frameNumber = nextFrameNumber;
				nextFrameNumber++;
				//seek to the page in Data.txt
				ranAccessFname.seek(pageNumber * PAGESIZE);
				//read in a page size chunk into a temporary buffer
				ranAccessFname.readFully(buffer);
				// copy the contents of buffer to the appropriate physical frame
				physicalMemory[frameNumber].setFrame(buffer);
				
				//map for the page table
				pageTable[pageNumber].assignPageTableEntry(frameNumber);		
				//increment pageFaults
				pageFaults++;
			}
			assignTLBEntry(pageNumber, frameNumber);
			//update TLB
		} //end if searchTLB
		//construct the physicalAddress using the frameNumber and the offset
		physicalAddress = 256 * frameNumber + offset;
		//return the physicalAddress
		return physicalAddress;
	}
	
	//End print
	public void outputStats() {
		System.out.println("Number of Translated Addresses: " + numberOfAddresses);
		System.out.println("Page Faults: " + pageFaults);
		System.out.println("Page Faults Rate: " + (float) pageFaults/numberOfAddresses);
		System.out.println("TLB Hits: " + TLBHits);
		System.out.println("TLB Hits Rate: " + (float) TLBHits/numberOfAddresses);
	}
	
	public void translate(String inputFile) throws java.io.IOException {
		//All within a try/catch loop 
		try {
			//Initializes a new BufferedReader rdr
			rdr = new BufferedReader(new FileReader(inputFile));
			//Sets Filename to our Data file
			fileName = new File("Data.txt");
			//Initializes RandomAccessFile so we can search through Data.txt by bytes
			ranAccessFname = new RandomAccessFile(fileName, "r");
			//sets up stringValue for our buffered rdr
			String stringValue;
			
			//while the BufferedReader still has lines to read, do while loop
			while((stringValue = rdr.readLine()) != null) {
				//transform a line (string) of LogicalAddresses to an int and assign it to virtualAddress
				virtualAddress = Integer.parseInt(stringValue);
				//sends the int virtualAddress to our function getPhysicalAddress and assigns it to the variable physicalAddress
				physicalAddress = getPhysicalAddress(virtualAddress);
				//increment number of addresses
				numberOfAddresses++;
				//calls the function getData using a physical address
				value = getData(physicalAddress);
				
				//prints out virtual/physical address and its value
				System.out.println("Virtual address " + virtualAddress + " Physical Address: " + 
				physicalAddress + " Value: " + value);
				
				//get the value stored at the physical address
		}
		
			//call outputStats after its gone through all the addresses
		outputStats();	
		
		} //end try
		catch(java.io.IOException ioe) {
			System.err.println(ioe);
		}
		finally {
			ranAccessFname.close();
			rdr.close();
		}
	}
	
	//initialize and run
	public static void main(String[] args) throws java.io.IOException {
		SIMVIRTMEM vm = new SIMVIRTMEM();
		vm.translate("LogicalAddresses.txt");
	}

}
