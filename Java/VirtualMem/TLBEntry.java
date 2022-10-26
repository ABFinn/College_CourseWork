package umf.cs;

public class TLBEntry {
	private int pageNumber; //virtual page number
	private int frameNumber; //physical frame number
	private boolean isValid; //flag that indicates if the mapping is valid
	
	public TLBEntry() {
		isValid = false;
		frameNumber = 0; 
		pageNumber = 0;
	}
	
	public boolean assignEntry(int pageNumber, int frameNumber) {
		this.frameNumber = frameNumber;
		this.pageNumber = pageNumber;
		return isValid = true;
	}
	
	public boolean pageFound(int pageNumber) {
		if(this.pageNumber == pageNumber) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getFrameNumber() {
		return frameNumber;
	}
}
