#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char * argv[])
{
	int i = 0;
	char s[1000];
	FILE *fPtrIn; //pointer to an input file
	//FILE *fPtrOut; //pointer to an output file
	
	//If there is an error in opening the read file this will catch it
	fPtrIn = fopen("/home/aidan/Trials/Project2/students.txt", "r");
	if(fPtrIn == NULL){
		printf("File cannot be opened\n");
		exit(0);
	}	
	while(!feof(fPtrIn)){
			fscanf(fPtrIn, "%s\n", s);
		}			
		
	
	printf("%s\n", s);
	
	
	//If there is an error in opening the write file this will catch it
	/*if ((fPtrOut = fopen("Project2Output.txt" , "w")) == NULL)
		printf("File cannot be opened.\n");
	else {
		for (i=0; i<10; i++){
				fprintf(fPtrOut, "%s", s);
				fclose(fPtrOut);
			}	
	}
	*/
	fclose(fPtrIn);
	exit(0);



}
