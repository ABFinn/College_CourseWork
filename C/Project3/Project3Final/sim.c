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
  int i, jobnum;
  double quantum;  // user enters this value and it is in seconds
  double dispatchtime;  // user enter this value and it is in seconds and is the time
                               // for the scheduler and dispatcher to work
  double Tsim, Tnext;
  unsigned short cpuidle;  // either TRUE or FALSE
  double totalWait;  // waittime = time waited until first get cpu
  double totalTurnaround; //complete - arrival
  int jobscomplete;  // total number of jobs completed when the simulation time ends
  double totalTimeBusy;  // total time cpu is busy
  double Tstart;  // start time of the simulation
  double evenServiceTime;  // (# of quanta in a job's serviceTime)  *  (time quanta)

  if(argc != 4) {
    fprintf(stderr,
            "usage: sim <loadfile> <quantum:sec> <dispatchtime:sec>\n");
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
    job.partialQ = job.serviceTime - evenServiceTime;
    job.completeTime = 0.0;
    job.acquireTime = 0.0;
    job.dispatchedOnce = FALSE;
    enqueue(&job, &arrivalQ);
    fscanf(loadfile, "%lf %lf", &(job.arrivalTime), &(job.serviceTime));
    jobnum++;
  } while(!feof(loadfile));

  // NOW WRITE THE REST!!
  
  Tstart = Tsim = 30;
  
  
  //printf("%lf\n", arrivalQ.array[arrivalQ.head].arrivalTime);
  printf("%d\n", arrivalQ.array[arrivalQ.head].serviceQs);
  
  
  
  if(arrivalQ.array[arrivalQ.head].arrivalTime <= Tsim){
  	enqueue(&arrivalQ.array[arrivalQ.head], &readyQ);
  	dequeue(&arrivalQ.array[arrivalQ.head], &arrivalQ);
  }
  
  for(i=0;i<20;i++){
  	printf("ServiceQs:%d\n", readyQ.array[readyQ.head].serviceQs);
  	printf("%lf\n",Tnext);
  	dequeue(&readyQ.array[readyQ.head], &readyQ);
  	Tnext = Tsim + quantum + dispatchtime;
  	Tsim = Tnext;
  	enqueue(&readyQ.array[readyQ.tail], &readyQ);
  	readyQ.array[readyQ.head].serviceQs--; 	
  		/*if(readyQ.array[readyQ.head].serviceQs == 0){
  			Tnext = Tsim + readyQ.array[readyQ.head].partialQ + dispatchtime;
  			Tsim = Tnext;
  			readyQ.array[readyQ.head].partialQ = 0;
  			break;
  		}*/
  }
  printf("Tnext is:%lf seconds\n", Tnext);
  
  
  //printf("%lf\n", Tsim);
  //printf("%d\n", arrivalQ.array[arrivalQ.head].serviceQs);
  printf("Number 5 of arrival queue is: Arrival Time: %lf Jobnum: %d\n", arrivalQ.array[5].arrivalTime, arrivalQ.array[5].number);
  printf("The head of arrival queue is: Arrival Time: %lf Jobnum: %d\n", arrivalQ.array[arrivalQ.head].arrivalTime, arrivalQ.array[arrivalQ.head].number);
  printf("The head of ready queue is: Arrival Time: %lf Jobnum: %d\n", readyQ.array[readyQ.head].arrivalTime, readyQ.array[readyQ.head].number);

  return 0;
} 
 
