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

  printf("Assignment 1 Ryan Pearson, James Faber.\n");
  p = fork();
  if (p > 0)
  {
    printf("Parent process id = %d\nParent will wait until child finishes.\n", getpid());
    wait(NULL); // The wait() system call will force parent to wait
    printf("Parent Resumes.\nParent done!");
  }
  else if (p == 0)
  {
    int num;
    printf("Chid process starting, Child process id is: %d\n", getpid());
    printf("Enter a positive Number: ");
    scanf("%d", &num);
    if (num < 1)
    {
      fprintf(stderr, "Number is not positive, exiting\n");
      return 1;
    }
    do
    {
      if (num % 2 == 0)
      {
        printf("%d ", num);
        num = num / 2;
      }
      else
      {
        printf("%d ", num);
        num = 3 * num + 1;
      }
    } while (num != 1);
    printf("%d ", num);
    printf("\nChild Completed Returning to parent.\n");
  }
  else
  {
    fprintf(stderr, "Forking failed.. code terminating");
    return 1;
  }

  return 0;
}