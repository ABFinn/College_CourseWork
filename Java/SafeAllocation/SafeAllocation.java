package umf.cs;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class SafeAllocation {
	static int processSafeSequence[]; //sequence of processes representing a safe state
	
	static boolean checkSafety(int need[][], int allocated[][], int currentlyAvailable[], int numResources, int numProcesses) {
		int position = 0;
		boolean isSafe = true;
		//setup local variable avail array and fill it w/ currentlyAvail
		int avail[] = new int [numResources];
		for(int i=0;i<numResources;i++) {
			avail[i] = currentlyAvailable[i];
		}
		//setup local variable marked and fill it with false
		boolean marked[] = new boolean [numProcesses];
		for(int i=0;i<numProcesses;i++) {
			marked[i] = false;
		}
		
		//while position isn't 5 and if its still safe
		while(position < numProcesses && isSafe) {
			//for each process
			for(int i = 0; i < numProcesses; i ++) {
				//if this process hasn't been marked as complete
				if(marked[i] == false) {
					//set the counter to 0 at the top
					int counter = 0;
					
					//for each resource
					for(int j = 0; j < numResources; j++) {
						
						//System.out.println("j is: " +j);
						//System.out.println("i is: " + i);
						//check if the process needs are less than whats available, if they are, increment counter
						if(need[j][i] <= avail[j]) {
							//System.out.println("Proccess is: " + i + " Counter is: " + counter);
							counter++;
						}
					}
					//if counter is incremented 3 times, and it hasn't already been marked as completed
					if(counter == numResources && marked[i] == false) {
						//for each resource in the safe process, add it to our local array avail
						for(int j = 0; j < numResources; j++) {
							avail[j] += allocated[j][i];
						}
						//this process is now complete, so we set marked to true
						marked[i] = true;
						//set its position in our safeSequence array
						processSafeSequence[position] = i;
						//increment position, so next process will be after
						position++;
						break;
					}
					//if i reaches this point, then it can't go any further and is marked as not safe
					if(i == numProcesses-1) {
						isSafe = false;
					}
				}
			}
		}
			
		//return value of isSafe
		return isSafe;
	}
	
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader rdr = null;
		String fileName = "ProcessesInfo.txt";
		int numResources = 0;
		int numProcesses = 0;
		int resources[ ];
		int currentlyAvailable[ ] = null;
		int max[ ][ ] = null;
		int allocated[ ][ ] = null;
		int need[ ][ ] = null;
		boolean isSafe;
		int numRequested = 0;
		int requestedResources[ ];
		int needCount = 0; // when a process asks for more resources
		int availCount = 0; // when a process asks for more resources
		
	
		rdr = new BufferedReader(new FileReader(fileName));
		numResources = Integer.parseInt(rdr.readLine());
		
		//initialize resources
		resources = new int [numResources];
		for(int i = 0; i < numResources; i++) {
			resources[i] = Integer.parseInt(rdr.readLine());
		}
		
		numProcesses = 	Integer.parseInt(rdr.readLine());
		
		//initialize max array
		max = new int [numResources][numProcesses];
		for(int i =0;i<numProcesses;i++) {
			for(int j = 0; j<numResources;j++) {
				max[j][i] = Integer.parseInt(rdr.readLine());
			}
		}
		
		//initialize allocated
		allocated = new int [numResources][numProcesses];
		for(int i =0;i<numProcesses;i++) {
			for(int j = 0; j<numResources;j++) {
				allocated[j][i] = Integer.parseInt(rdr.readLine());
			}
		}
		
		//initialize currently avail
		currentlyAvailable = new int [numResources];
		//copy resources into currentAvail
		for(int i =0;i<numResources;i++) {
			currentlyAvailable[i] = resources[i];
		}
		//subtract to find right amounts
		for(int i=0;i<numResources;i++) {
			for(int j=0;j<numProcesses;j++) {
				currentlyAvailable[i] -= allocated[i][j];
			}
		}
		
		//initialize safeSequence array 
		processSafeSequence = new int [numProcesses];
		
		//initialize need array
		need = new int [numResources][numProcesses];
		//fill in need array w/ max
		for(int i=0;i<numResources;i++) {
			for(int j=0;j<numProcesses;j++) {
				need[i][j] = max[i][j];
			}
		}
		//find proper amounts for need array by subtracting allocated from max
		for(int i=0;i<numResources;i++) {
			for(int j=0;j<numProcesses;j++) {
				need[i][j] -= allocated[i][j];
			}
		}
		
		
		//test prints
		/*
		System.out.println("Num Resources is: " + numResources);
		System.out.println("Num Processes is: " + numProcesses);
		System.out.println("Resource Array: " + resources[0] + ":" + resources[1] + ":" + resources[2]);
		System.out.println("Current Avail is: " + currentlyAvailable[0] + ":" + currentlyAvailable[1] + ":" + currentlyAvailable[2]);
		
		System.out.println("Max Array is: " + max[0][0] + ":" + max[0][1] + ":" + max[0][2] + ":" + max[0][3] + ":" + max[0][4]);
		System.out.println("Max Array is: " + max[1][0] + ":" + max[1][1] + ":" + max[1][2] + ":" + max[1][3] + ":" + max[1][4]);
		System.out.println("Max Array is: " + max[2][0] + ":" + max[2][1] + ":" + max[2][2] + ":" + max[2][3] + ":" + max[2][4]);
		
		System.out.println("Allo Array is: " + allocated[0][0] + ":" + allocated[0][1] + ":" + allocated[0][2] + ":" + allocated[0][3] + ":" + allocated[0][4]);
		System.out.println("Allo Array is: " + allocated[1][0] + ":" + allocated[1][1] + ":" + allocated[1][2] + ":" + allocated[1][3] + ":" + allocated[1][4]);
		System.out.println("Allo Array is: " + allocated[2][0] + ":" + allocated[2][1] + ":" + allocated[2][2] + ":" + allocated[2][3] + ":" + allocated[2][4]);
		
		System.out.println("Need Array is: " + need[0][0] + ":" + need[0][1] + ":" + need[0][2] + ":" + need[0][3] + ":" + need[0][4]);
		System.out.println("Need Array is: " + need[1][0] + ":" + need[1][1] + ":" + need[1][2] + ":" + need[1][3] + ":" + need[1][4]);
		System.out.println("Need Array is: " + need[2][0] + ":" + need[2][1] + ":" + need[2][2] + ":" + need[2][3] + ":" + need[2][4]);
		*/
		
		isSafe = checkSafety(need, allocated, currentlyAvailable, numResources, numProcesses);
		
		System.out.println("Is system is safe? " + isSafe);
		System.out.println("Safe Sequence is: " + processSafeSequence[0] + ":" + processSafeSequence[1] + ":" + processSafeSequence[2] + ":" + processSafeSequence[3]+ ":" + processSafeSequence[4]);
		
		rdr.close();
		
		if(isSafe) {
			//set up new reader for system in
			rdr = new BufferedReader(new InputStreamReader(System.in));
			//set up an array to grab the requested resources input
			requestedResources = new int [numResources];
			//variables
			int processNumber = 0;
			boolean valid = false;
			needCount = 0;
			availCount = 0;
			
			//recieve input from user
			System.out.println("Input Proccess Number: ");
			processNumber = Integer.parseInt(rdr.readLine());
			
			System.out.println("Enter requested number for resource 0");
			requestedResources[0] = Integer.parseInt(rdr.readLine());
			
			System.out.println("Enter requested number for resource 1");
			requestedResources[1] = Integer.parseInt(rdr.readLine());
			
			System.out.println("Enter requested number for resource 2");
			requestedResources[2] = Integer.parseInt(rdr.readLine());
			
			//for each resource
			for(int j = 0; j < numResources;j++) {
				//if the resource requested is less than the need of that process, increment needcount
				if(requestedResources[j] <= need[j][processNumber]) {
					needCount++;
				}
				//if the resource requested is less than current avail, increment availcount
				if(requestedResources[j] <= currentlyAvailable[j]) {
					availCount++;
				}
			}
			
			//if the check above passes and both needcount and availcount are 3
			if(needCount == numResources && availCount == numResources) {
				//for each resource, update allocated, need, and current avail to match new numbers
				for(int j = 0; j < numResources; j++) {
					allocated[j][processNumber] += requestedResources[j];
					need[j][processNumber] -= requestedResources[j];
					currentlyAvailable[j] -= requestedResources[j];
 				}
				//set valid to true, as the inputs were valid
				valid = true;
				
			}
			
			//if inputs were valid
			if(valid == true) {
				//run checkSafety on new arrays
				isSafe = checkSafety(need, allocated, currentlyAvailable, numResources, numProcesses);
				System.out.println("Post user input: is the system is safe? " + isSafe);
				System.out.println("Post user input: Safe Sequence is: " + processSafeSequence[0] + ":" + processSafeSequence[1] + ":" + processSafeSequence[2] + ":" + processSafeSequence[3]+ ":" + processSafeSequence[4]);
			}
			else {
				System.out.println("Inputted numbers were invalid");
			}
			
			//System.out.println("Current Avail is: " + currentlyAvailable[0] + ":" + currentlyAvailable[1] + ":" + currentlyAvailable[2]);
			
			
			//test prints
			/*
			System.out.println("Allo Array is: " + allocated[0][0] + ":" + allocated[0][1] + ":" + allocated[0][2] + ":" + allocated[0][3] + ":" + allocated[0][4]);
			System.out.println("Allo Array is: " + allocated[1][0] + ":" + allocated[1][1] + ":" + allocated[1][2] + ":" + allocated[1][3] + ":" + allocated[1][4]);
			System.out.println("Allo Array is: " + allocated[2][0] + ":" + allocated[2][1] + ":" + allocated[2][2] + ":" + allocated[2][3] + ":" + allocated[2][4]);
			
			System.out.println("Need Array is: " + need[0][0] + ":" + need[0][1] + ":" + need[0][2] + ":" + need[0][3] + ":" + need[0][4]);
			System.out.println("Need Array is: " + need[1][0] + ":" + need[1][1] + ":" + need[1][2] + ":" + need[1][3] + ":" + need[1][4]);
			System.out.println("Need Array is: " + need[2][0] + ":" + need[2][1] + ":" + need[2][2] + ":" + need[2][3] + ":" + need[2][4]);
			*/
			
			//System.out.println("needCount is: " + needCount);
			//System.out.println("availCount is: " + availCount);
		}
		rdr.close();
		
			
	}

}
