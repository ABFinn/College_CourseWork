#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct student {
	char * name; //name is a type of a pointer to char
	float grades[4];
	float gpa;
};
	
int main(){
	int n, i;
	float sum = 0;
	struct student s;
	int len; //see the length of string for the student name
	
	s.name = (char *) malloc(50 *sizeof(char));
	//allocate memory 50 characters 
	
printf("Enter the name of the student\n");
scanf("%[^\n]s", s.name);
printf("Name is %s\n", s.name);
printf("Length of s.name is %ld\n", strlen(s.name));

printf("Enter the total numer of grades for the semester, no more than 4\n");
scanf("%d", &n);

for(i = 0; i < n; i++){
printf("Enter a grade and then press enter\n");
scanf("%f", &s.grades[i]);
sum += s.grades[i];
}

s.gpa = sum/n;
printf("%s has a semester GPA of %6.3f\n", s.name, s.gpa);

free(s.name);

exit(0);
}
