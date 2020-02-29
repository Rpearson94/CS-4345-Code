/* This C-code demonstrates multiple fork() scenario */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main()
{
  pid_t p;
  p = fork();
  printf("First fork returns = %d\n", p);
  if (p < 0)
  {
    printf("Fork error!\n");
    return 1;
  }
  else if (p == 0)
    printf("Child process id = %d\n", getpid());
  else
    printf("Parent process id = %d\n", getpid());

  printf("Running process' id before 2nd fork(): %d\n", getpid());

  /* The above displays current process's id. This display will 
     appear twice -- once for parent process, once for child process. */

  p = fork(); // a second fork()

  /* Here, each of the parent and child will create two more processes; 
     'parent' creates a parent-newchild and the 'child' creates 
     'child-itschild'. The new parents and children will execute the 
     following part of the code independently. */

  printf("Second fork returns = %d\n", p);
  if (p > 0)
    printf("After second fork, parent id = %d\n", getpid());
  else
    printf("After second fork, child id = %d\n", getpid());

  return 0;
}
