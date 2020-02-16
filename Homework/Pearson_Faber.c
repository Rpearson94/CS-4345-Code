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
  p = fork();
  if (p > 0)
  {

    printf("Parent process id = %d\n", getpid());
    printf("Parent will wait until child finishes.\n");
    wait(NULL); // The wait() system call will force parent to wait
    printf("\n Parent resumes as child completed.\n");
    printf("Patent done!\n\n");
  }
  else if (p == 0)
  {
    printf("Child process id = %d\n", getpid());
    printf("\n Child executing (the ls process)..\n");
  }
  else
  {
    fprintf(stderr, "Forking failed.. code terminating");
    return 1;
  }
  scanf("%d", &num);
  //printf("\nYour Number is: %d", num);
  printf("pid of parent: %d\n", getpid()); //parent's id is printed

  return 0;
}