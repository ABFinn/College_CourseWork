package umf.cs;

public class PageTableEntry {
	//Constructor
	public PageTableEntry() {
		valid = false;
		frameNumber = -1; 
	}
	
	public boolean getValidBit() {
		return valid;
	}
	
	public int getFrameNumber() {
		return frameNumber;
	}
	
	private int frameNumber;
	private boolean valid;
	
	public void assignPageTableEntry(int frameNumber) {
		this.frameNumber = frameNumber;
		valid = true;
	}
	
}
