package umf.cs;
import java.io.*;

public class PageReplacement {
	
	public static void main(String[] args) throws java.io.IOException {
		int pageFault = 0, hits = 0, frameNum = 0;
		int j, i;
		boolean found = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("Please enter the number of Frames: ");
		int frameCount = Integer.parseInt(br.readLine());
		System.out.println("You entered " + frameCount + " for the frame count");
		
		System.out.println("Please enter the length of the reference string: ");
		int refLength = Integer.parseInt(br.readLine());
		System.out.println("You entered " + refLength + " for the reference length");
		
		int frame [][] = new int [frameCount][2];
		int ref [] = new int [refLength];
		
		System.out.println("Please enter the reference string: ");
		for(j=0;j<frameCount;j++) {
			frame[j][0] = -1;
		}
		for(i=0;i<refLength;i++) {
			ref[i] = Integer.parseInt(br.readLine());
		}
		
		for(i=0;i<refLength;i++) {
			found = false;
			int value = ref[i];
			
			System.out.println("Ref Value is: " + ref[i]);
			System.out.println("Value of frame 1 is" + frame[0][0]);
			System.out.println("Value of frame 2 is" + frame[1][0]);
			System.out.println("Value of frame 3 is" + frame[2][0]);
			System.out.println("Num of hits: " + hits);
			
			for(j=0;j<frameCount;j++) {
				if(frame[j][0] == value) {
					frame[j][1] = 1;
					found = true;
					System.out.println("Found ref: " + ref[i] + " Hits++");
					hits++;
					break;
				}
			
			}
			if (frameNum == frameCount) {
				frameNum = 0;
			}
			if(found == false) {
				pageFault++;
				frame[frameNum][0] = value;
				frameNum++;
			}
			

			
		}
		
		System.out.println("Page fault count: " + pageFault);
		System.out.println("Num of hits: " + hits);
		System.out.println("Hit Ratio is: " + (float) hits/refLength);

	}

}


