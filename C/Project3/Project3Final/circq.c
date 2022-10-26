#include "sim.h"

void initialize(struct jobQ *Q)
{
  Q->head = 0;
  Q->tail = 0;
  Q->Qcount = 0;
}

int enqueue(struct sim_job *job, struct jobQ *Q)
{
  if(Q->Qcount == MAX_REQUESTS)
    return 0;

  Q->array[Q->tail].number = job->number;
  Q->array[Q->tail].serviceTime = job->serviceTime;
  Q->array[Q->tail].serviceQs = job->serviceQs;
  Q->array[Q->tail].partialQ = job->partialQ;
  Q->array[Q->tail].completeTime = job->completeTime;
  Q->array[Q->tail].arrivalTime = job->arrivalTime;
  Q->array[Q->tail].acquireTime = job->acquireTime;
  Q->array[Q->tail].dispatchedOnce = job->dispatchedOnce;

  Q->Qcount++;

  if(Q->tail < (MAX_REQUESTS - 1))
    Q->tail++;
  else
    Q->tail = 0;

  return 1;
}


int dequeue(struct sim_job *job, struct jobQ *Q)
{

  /* check to see if queue is empty */
  if(Q->Qcount == 0)
    return 0;

  job->number = Q->array[Q->head].number;
  job->serviceTime = Q->array[Q->head].serviceTime;
  job->serviceQs = Q->array[Q->head].serviceQs;
  job->partialQ = Q->array[Q->head].partialQ;
  job->completeTime = Q->array[Q->head].completeTime;
  job->arrivalTime = Q->array[Q->head].arrivalTime;
  job->acquireTime = Q->array[Q->head].acquireTime;
  job->dispatchedOnce = Q->array[Q->head].dispatchedOnce;

  Q->Qcount--;
  
  if(Q->head < (MAX_REQUESTS - 1))
    Q->head++;
  else
    Q->head = 0;

  if(Q->Qcount == 0) {
    Q->head = 0;
    Q->tail = 0;
  }

  return 1;
}

