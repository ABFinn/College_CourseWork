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

  if(argc != 4) {
    fprintf(stderr,
            "usage: sim <loadfile> <quantum:seconds> <dispatchtime:seconds>\n");
    exit(-1);
  }
  else {
    sscanf(argv[2], "%lf", &quantum);
    sscanf(argv[3], "%lf", &dispatchtime);
  }

  totalWait = 0.0;
  totalTurnaround = 0.0;
  totalTimeBusy = 0.0;

  if((loadfile = fopen(argv[1], "r")) == NULL)
    perror("loadfile");

  jobnum = 0;
  fscanf(loadfile, "%lf %lf", &(job.arrivalTime),
         &(job.serviceTime));

  initialize(&arrivalQ);
  initialize(&readyQ);
  initialize(&completeQ);

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

	Tstart = arrivalQ.array[arrivalQ.head].arrivalTime;
	//printf("arrival time of first process is %8.5lf\n", Tstart);
	
	Tsim = Tstart;
	
	dequeue(&job, &arrivalQ);
	enqueue(&job, &readyQ);
	
	while(completeQ.Qcount != 46){
		//printf("ReadyQ count is %d\n", readyQ.Qcount);
		printf("cpujob serviceQs is: %d & cpujob partialQ is: %lf\n", cpujob.serviceQs, cpujob.partialQ);
		//printf("Tsim is: %lf\n", Tsim);
		printf("ReadyQ count is %d\n", readyQ.Qcount);
		if(readyQ.Qcount > 0){
			dequeue(&cpujob, &readyQ);
			if(cpujob.dispatchedOnce == FALSE){
				cpujob.dispatchedOnce = TRUE;
				cpujob.acquireTime = Tsim;
			}
			if(cpujob.serviceQs > 0){
				Tnext = Tsim + quantum + dispatchtime;
				totalTimeBusy += (Tnext - Tsim);
				Tsim = Tnext;
				//printf("cpujob num is %d and Tsim is: %lf\n", cpujob.number, Tsim);		 
			}
			else{
				Tnext = Tsim + cpujob.partialQ + dispatchtime;
				totalTimeBusy += (Tnext - Tsim);
				Tsim = Tnext;
			}
			cpuIdle = FALSE;
			if(cpujob.serviceQs > 0){
				cpujob.serviceQs--;
				//printf("job serviceQs is: %d\n", cpujob.serviceQs);
			}
			else{
				cpujob.partialQ = 0;
				//printf("2\n");
				//printf("cpujob num is %d\n", cpujob.number);
			}
		}
		else{
			Tnext = Tsim + quantum + dispatchtime;
			Tsim = Tnext;
			cpuIdle = TRUE;
		}
		if(arrivalQ.array[arrivalQ.head].arrivalTime <= Tnext && arrivalQ.Qcount != 0){
			printf("inside second if\n");
			dequeue(&job, &arrivalQ);
			enqueue(&job, &readyQ);			
		}
		if(cpuIdle == FALSE){
			//printf("inside third if\n");
			if(cpujob.partialQ == 0 && cpujob.serviceQs == 0){
				cpujob.completeTime = Tsim;
				totalTurnaround += cpujob.completeTime - cpujob.arrivalTime;
				totalWait += cpujob.acquireTime - cpujob.arrivalTime;
				enqueue(&cpujob, &completeQ);	
				printf("inside if\n");
						
			}
			else{
				enqueue(&cpujob, &readyQ);
				//printf("inside else\n");
				//printf("CompleteQ count is %d\n", completeQ.Qcount);
			}
		
		}
		//printf("cpujob num is %d and Tsim is: %lf\n", cpujob.number, Tsim);
		//printf("ReadyQ count is %d\n", readyQ.Qcount);
		
		i++;
	}
	
	printf("Outside Loop\n");
	printf("ArrivalQ count is %d\n", arrivalQ.Qcount);
	printf("ReadyQ count is %d\n", readyQ.Qcount);
	printf("CompleteQ count is %d\n", completeQ.Qcount);
	totalTurnaround = totalTurnaround/46;
	totalWait= totalWait/46;
	printf("Ave. Turnaround is: %lf\n", totalTurnaround);
	printf("Ave. Wait is: %lf\n", totalWait);
	totalTime = Tsim - Tstart;
	totalTimeBusy = totalTimeBusy/totalTime;
	printf("Total time busy is %lf\n", totalTimeBusy);
	
	
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
	
	
 
	







  return 0;
}










