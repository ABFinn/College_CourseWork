package umf.cs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClockAlgorithm {

	public static void main(String[] args) throws java.io.IOException {
		int pageFault = 0, hits = 0, pointer = 0;
		int j, i;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("Please enter the number of Frames: ");
		int frameCount = Integer.parseInt(br.readLine());
		System.out.println("You entered " + frameCount + " for the frame count");
		
		System.out.println("Please enter the length of the reference string: ");
		int refLength = Integer.parseInt(br.readLine());
		System.out.println("You entered " + refLength + " for the reference length");
		
		System.out.println("Please enter the reference string: ");
		
		int frame [][] = new int [frameCount][2];
		int ref [] = new int [refLength];
		
		//set all frame values to -1
		for(j=0;j<frameCount;j++) {
			frame[j][0] = -1;
		}
		//set all frame use bits to 0
		for(j=0;j<frameCount;j++) {
			frame[j][1] = 0;
		}
		//fill ref[] w/ the reference values
		for(i=0;i<refLength;i++) {
			ref[i] = Integer.parseInt(br.readLine());
		}
		
		//for loop that iterates through all the ref values
		for(i=0;i<refLength;i++) {
			System.out.println("Value of Ref is: " + ref[i]);
			System.out.println("Current Frame Values are:" + frame[0][0] + ":" + frame[1][0] + ":" +frame[2][0] + ":" + frame[3][0] + ":" +frame[4][0]);
			System.out.println("Current Frame Use Bit are:" + frame[0][1] + ":" + frame[1][1] + ":" +frame[2][1] + ":" + frame[3][1] + ":" +frame[4][1]);
			System.out.println("Value of Pointer at top of loop is: " + pointer);	
			//for loop to search through each frame
			for(j=0;j<frameCount;j++) {
				//if a frame already has a matching ref value
				if(frame[j][0] == ref[i]) {
					frame[j][1] = 1;
					hits++;
					System.out.println("HIT!");
					break;
				}
				else {
					pageFault++;	
					//System.out.println("Value of Pointer 2nd Loop " + pointer);
					while(frame[pointer][1] == 1) {	
						frame[pointer][1] = 0;
						if(pointer == frameCount-1) {
							pointer = 0;
						}
						else {
							pointer++;
						}			
					}		
					frame[pointer][0] = ref[i];
					frame[pointer][1] = 1;	
					j = 5;
					if(pointer == frameCount-1) {
							pointer = 0;
					}
					else {
						pointer++;
					}
							
				}
			}
		}
		System.out.println("Page fault count: " + pageFault);
		System.out.println("Num of hits: " + hits);
		System.out.println("Hit Ratio is: " + (float) hits/refLength);

	}
	

}
