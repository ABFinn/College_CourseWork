//run as ./strTokex fun=sports?Weather=sunny

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

#define DELIMITER        "=?"

int parseString(char *);

int main(int argc, char *argv[])
{
	char * s;

	if (argc != 2){
		fprintf(stderr, "Usage: ./strTokex <string_to_parse>\n");
		exit(0);
	}
	
	s = (char *) malloc(strlen(argv[1])+1);
	strncpy(s, argv[1], strlen(argv[1])+1);
	parseString(s);
	
	free(s);
	return 0;
}

int parseString(char * s){
	char * tokenPtr;
	
	tokenPtr = strtok(s, DELIMITER);
	while (tokenPtr != NULL){
		printf("Token is %s\n", tokenPtr);
		tokenPtr = strtok(NULL, DELIMITER);
	}
	return 0;

}
