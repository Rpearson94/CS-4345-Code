/* This C-code demonstrates the use of fork() system 
   call to create child process from parent process. 
   After fork() is executed, there are two identical 
   copies of the program on the memory -- one is the 
   parent process and one is the child process. The 
   fork() retuens a positive number to the parent 
   process (the process id of the child) and returns 
   0 to the child process. */

#include <stdio.h>
#include <unistd.h>

int main()
{
  int p; // indicating return value of fork()
  p = fork();
  if (p > 0)
    printf("Parent process: p = %d\n", p);
  else
    printf("Child process: p = %d\n", p);

  /* The follwing is C-program's typical return value; 
should not be confused with the 0 retunred by fork() 
to the child process; Almost all C-code has 'return 0;' 
to end the main() memthod. */

  return 0;
}
