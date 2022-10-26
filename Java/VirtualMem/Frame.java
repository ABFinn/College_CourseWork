package umf.cs;

public class Frame {
	public static final int FRAME_SIZE = 256;
	private byte[] frameValue;
	
	public Frame() {
		frameValue = new byte[FRAME_SIZE];
	}
	
	public void setFrame(byte[] bytes) { //fill in object's frame value w/ bytes, read from data.txt
		System.arraycopy(bytes, 0, frameValue, 0, FRAME_SIZE);
		// src, srcposition, destination, dstpostion, length
	}
	
	public byte readWord(int offset) { //reads a byte from frameValue
		return frameValue[offset];
	}
}
