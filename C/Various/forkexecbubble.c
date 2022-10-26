#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
	int status;
	pid_t childpid, mywaitpid;
	
	char * my_code = "/home/aidan/Trials/mybubblesort";
	char * my_argv[] = {"/home/aidan/Trials/mybubblesort", 
	"/home/aidan/Trials/unsortedvalues.txt", 
	"/home/aidan/Trials/sortedvalues.txt", "10", NULL};

	childpid = fork();
	
	if(childpid > 0){
		while((mywaitpid = waitpid(-1, &status, 0))){
			printf("The child is finished.\n");
			fflush(stdout);
			if(mywaitpid < 0){
				break;
			}
		}
	}
	else{
		execvp(my_code, my_argv);
	}
	
	exit(0);

}
