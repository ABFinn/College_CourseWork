#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include "sim.h"

int main(int argc, char **argv)
{
  FILE *loadfile;
  struct jobQ arrivalQ;
  struct jobQ readyQ;
  struct jobQ completeQ;
  struct sim_job job;
  struct sim_job cpujob;  // used for the job currently running on the cpu
  int jobnum;
  int i = 0;
  double quantum;  // user enters this value and it is in seconds
  double dispatchtime;  // user enter this value and it is in seconds and is the time
                               // for the scheduler and dispatcher to work
  double Tsim, Tnext;
  unsigned short cpuIdle;  // either TRUE or FALSE
  double totalWait;  // waittime = time waited until first get cpu
  double totalTurnaround;
  int jobscomplete;  // total number of jobs completed when the simulation time ends
  double totalTimeBusy;  // total time cpu is busy
  double totalTime;
  double Tstart;  // start time of the simulation
  double evenServiceTime;  // (# of quanta in a job's serviceTime)  *  (time quanta)

	//If it wasn't ran with the proper arguments, exit and send an error	
  if(argc != 4) {
    fprintf(stderr,
            "usage: sim <loadfile> <quantum:seconds> <dispatchtime:seconds>\n");
    exit(-1);
  }
  	//Else set the 2nd argument as the quantum and the 3rd argument as the dispatch
  else {
    sscanf(argv[2], "%lf", &quantum);
    sscanf(argv[3], "%lf", &dispatchtime);
  }
	//Set your totals to 0
  totalWait = 0.0;
  totalTurnaround = 0.0;
  totalTimeBusy = 0.0;
	
	//If it cannot open processinfo, send an error code
  if((loadfile = fopen(argv[1], "r")) == NULL)
    perror("loadfile");
	
	//set jobnum to 0
  jobnum = 0;
  	//scan processinfo and assign arrivalTimes/serviceTimes
  fscanf(loadfile, "%lf %lf", &(job.arrivalTime),
         &(job.serviceTime));
	//start up the 3 queues
  initialize(&arrivalQ);
  initialize(&readyQ);
  initialize(&completeQ);
	
	//for all of process info, initialize the various variables of each job/process and enqueue them
	//into the arrivalQ
  do {
    job.number = jobnum;
    job.serviceQs = job.serviceTime / quantum;
    evenServiceTime = ((double)job.serviceQs) * quantum;
    job.partialQ = job.serviceTime -  evenServiceTime;
    job.completeTime = 0.0;
    job.acquireTime = 0.0;
    job.dispatchedOnce = FALSE;
    enqueue(&job, &arrivalQ);
    fscanf(loadfile, "%lf %lf", &(job.arrivalTime), &(job.serviceTime));
    jobnum++;
  } while(!feof(loadfile));

  // NOW WRITE THE REST!!
  
	//Sets Tstart to the arrival time of the first job in the arrivalQueue
	Tstart = arrivalQ.array[arrivalQ.head].arrivalTime;
	//printf("arrival time of first process is %8.5lf\n", Tstart);
	
	//Sets the current time to Tstart
	Tsim = Tstart;
	
	//Takes the first job out of the arrivalQ and place it in the readyQ
	dequeue(&job, &arrivalQ);
	enqueue(&job, &readyQ);
	
	//while loop that runs until all processes are in the completeQ
	while(completeQ.Qcount != 46){
		//if there is 1 or more jobs in the readyQ this if runs
		if(readyQ.Qcount > 0){
			//dequeues the first job in the readyQ and assigns it to cpujob
			dequeue(&cpujob, &readyQ);
			//if it has never been dispatched, then set dispatchedOnce to true and set the acquireTime
			if(cpujob.dispatchedOnce == FALSE){
				cpujob.dispatchedOnce = TRUE;
				cpujob.acquireTime = Tsim;
				
			}
			//if it still has serviceQs to run, advance time and totalTimeBusy
			if(cpujob.serviceQs > 0){
				Tnext = Tsim + quantum + dispatchtime;
				totalTimeBusy += (Tnext - Tsim);
				Tsim = Tnext;	 
			}
			//else advance time with its partialQ
			else{
				Tnext = Tsim + cpujob.partialQ + dispatchtime;
				totalTimeBusy += (Tnext - Tsim);
				Tsim = Tnext;
			}
			//set cpuIdle to FALSE as there is current a process running
			cpuIdle = FALSE;
			//if cpujob had one or more serviceQs, decrement that number as we've already advanced time
			if(cpujob.serviceQs > 0){
				cpujob.serviceQs--;
			}
			//else set partialQ to 0, as we would've ran the partialQ if serviceQs wasn't > 0.
			else{
				cpujob.partialQ = 0;
			}
		}
		//else, if there is no job(s) in the readyQ, advance time and set cpuIdle to True.
		else{
			Tnext = Tsim + quantum + dispatchtime;
			Tsim = Tnext;
			cpuIdle = TRUE;
		}
		//while there is a job in the arrivalQ thats arrivaltime is less than Tnext,
		//dequeue that job and enqueue it into the readyQ
		while(arrivalQ.array[arrivalQ.head].arrivalTime <= Tnext && arrivalQ.Qcount != 0){
			dequeue(&job, &arrivalQ);
			enqueue(&job, &readyQ);			
		}
		//If a process ran (cpuIdle == False), check to see if it is complete by checking its partialQ and serviceQs
		//If it is complete, set its complete time by setting it to the current time.
		//And increment totalTurnaround and totalWait
		//Finally, enqueue that job into the completeQ
		if(cpuIdle == FALSE){
			if(cpujob.partialQ == 0 && cpujob.serviceQs == 0){
				cpujob.completeTime = Tsim;
				totalTurnaround += cpujob.completeTime - cpujob.arrivalTime;
				totalWait += cpujob.acquireTime - cpujob.arrivalTime;
				enqueue(&cpujob, &completeQ);	
						
			}
			//Else, place the job back into the readyQ
			else{
				enqueue(&cpujob, &readyQ);
			}
		
		}
	}
	
	//Find the average turnaround by dividing the total by the total # of jobs
	totalTurnaround = totalTurnaround/46;
	//Find the average wait by dividing the total by the total # of jobs
	totalWait = totalWait/46;
	//Find the total time ran by subtracting our start time from the current time.
	totalTime = Tsim - Tstart;
	//Find the % time busy by dividing totalTime from totalTimeBusy
	totalTimeBusy = totalTimeBusy/totalTime;
		
	//Formatting for Output File:
	printf("Quantum = %lf Dispatch overhead = %lf\n", quantum, dispatchtime);
	printf("Number of jobs completed is: %d\n", completeQ.Qcount);
	printf("job#	arrivalTime	completeTime	turnaroundTime	acquireTime	waitTime\n");
	
	//For each job, print its number, arrivalTime, completeTime, turnaroundTime, acquireTime, and waitTime and
	//a new line
	for(i=0;i<completeQ.Qcount;i++){
		printf("%d	%lf	%lf	%lf	%lf	%lf\n",
		completeQ.array[i].number,
		completeQ.array[i].arrivalTime,
		completeQ.array[i].completeTime,
		completeQ.array[i].completeTime-completeQ.array[i].arrivalTime,
		completeQ.array[i].acquireTime,
		completeQ.array[i].acquireTime-completeQ.array[i].arrivalTime);
	}
	
	//Print the ave. turnaround, ave. wait, and % cpu busy.
	printf("Ave. Turnaround is: %lf\n", totalTurnaround);
	printf("Ave. Wait is: %lf\n", totalWait);
	printf("%% cpu busy is %lf\n", totalTimeBusy);
	


  return 0;
}


//Old attempt: 
/*
	printf("Outside Loop\n");
	printf("ArrivalQ count is %d\n", arrivalQ.Qcount);
	printf("ReadyQ count is %d\n", readyQ.Qcount);
	printf("CompleteQ count is %d\n", completeQ.Qcount);
	*/
	
	/*while(arrivalQ.Qcount > 0){

		if(arrivalQ.array[arrivalQ.head].arrivalTime < Tnext){
			dequeue(&job, &arrivalQ);
			enqueue(&job, &readyQ);
		}
	
		if(readyQ.Qcount > 0){
			dequeue(&cpujob, &readyQ);
			if(cpujob.dispatchedOnce == FALSE){
				cpujob.dispatchedOnce = TRUE;
				cpujob.acquireTime = Tsim;
				printf("The acquire time of job %d is %f\n", cpujob.number, cpujob.acquireTime);
			}
			printf("current cpujob is %d\n", cpujob.number);
		}
		printf("job serviceQs is %d\n", job.serviceQs);
		
		
		if(job.serviceQs != 0){
			job.serviceQs--;
			Tnext = Tsim + quantum + dispatchtime;
			Tsim = Tnext;
		}
		else{
			Tnext = Tsim + job.partialQ + dispatchtime;
	  		Tsim = Tnext;
	  		job.partialQ = 0;
		}
		enqueue(&cpujob, &readyQ);
		printf("The time is: %f\n", Tsim);
		if(job.partialQ == 0 && job.serviceQs == 0){
			job.completeTime = Tsim;
			printf("arrival time of next process is: %lf\n", arrivalQ.array[arrivalQ.head].arrivalTime);
			dequeue(&job, &readyQ);
			enqueue(&job, &completeQ);
			do{
				Tnext = Tsim + quantum + dispatchtime;
				Tsim = Tnext;
			}while(readyQ.Qcount == 0);
			
			printf("The time is: %f\n", Tsim);
			//break;
		}
	}*/










