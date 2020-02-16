/* 
  Ryan Pearson, James Faber
  CS 4345 - Operating Systems, Spring 2020
  Assignment 1
 */

#include <stdio.h>
#include <sys/types.h>

int main()
{
  int num;
  pid_t p;

  printf("Assignment 1 Ryan Pearson, James Faber.\n Enter a positive Number.\n");
  scanf("%d", &num);
  //printf("\nYour Number is: %d", num);
  printf("pid of parent: %d\n", getpid()); //parent's id is printed

  return 0;
}