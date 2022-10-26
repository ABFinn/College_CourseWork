#define MAX_REQUESTS 1000
#define TRUE 1
#define FALSE 0

struct sim_job {
  int number;
  double serviceTime;
  unsigned int serviceQs;  // total number of quanta in serviceTime
  double partialQ;   // remaining partial quanta in serviceTime in seconds
  double completeTime;
  double arrivalTime;
  double acquireTime; // time job first acquired the cpu   
  unsigned short dispatchedOnce;  // FALSE until the job first gets to run on the cpu
};

struct jobQ {
  int head, tail;
  int Qcount;
  struct sim_job array[MAX_REQUESTS];
};

extern void initialize(struct jobQ *Q);
extern int enqueue(struct sim_job *job, struct jobQ *Q);
extern int dequeue(struct sim_job *job, struct jobQ *Q);

