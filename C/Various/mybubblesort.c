#include <stdio.h>
#include <stdlib.h>

void bubbleSort(int * const array, const int size); //prototype

int main(int argc, char * argv[])
{
	int i = 0, total = strtol(argv[3],NULL,10);
	int a[10];
	FILE *fPtrIn; //pointer to an input file
	FILE *fPtrOut; //pointer to an output file
	
	if ((fPtrIn = fopen(argv[1] , "r")) == NULL)
		printf("File cannot be opened.\n");
	else {
			while (!feof(fPtrIn))
				fscanf(fPtrIn, "%d", &a[i++]);
			fclose(fPtrIn);
	}
	bubbleSort(a,total);
	
	//write to an outputfile
	if ((fPtrOut = fopen(argv[2] , "w")) == NULL)
		printf("File cannot be opened.\n");
	else{
			for (i=0; i<total; i++)
				fprintf(fPtrOut, "%d\n", a[i]);
			fclose(fPtrOut);
	}
	
	exit(0);

}

void bubbleSort(int * const array, const int size)
{

	int i,j, temp;
	for(j = 0; j < size-1; j++)
		for(i= 0; i < size-1; i++){
			if(array[i] > array[i+1]){
				temp = array[i+1];
				array[i+1] = array[i];
				array[i] = temp;
			
			}
		
		} 


} //end bubblesort














