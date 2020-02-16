/* This C-code demonstrates purpose and use of the 
   exec() system call after a process invokes fork(). */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main()
{
  /* The child process created using fork() is an exact 
     duplicate of the parent process. There is very few 
     use of having two identical process on the system. 
     Hence, it'd be useful to create a sepaarte process 
     as a child. For that the exec() system call is used.
     An exec() takes 'binary' of a program as argument and 
     run that process. So, if an exec() is invoked after a 
     fork(), then the child process will execute the code 
     of the program that has been passed to exec(). */

  printf("pid of parent: %d\n", getpid()); //parent's id is printed

  pid_t p;

  p = fork();

  if (p < 0)
  {
    printf("Error.. fork failed!\n");
    return 1;
  }

  if (p > 0)
  {
    printf("Parent process id = %d\n", getpid());
  }
  else
  {
    printf("Child process id = %d\n", getpid());
    printf("About to run a new program as a child...\n");
    /*
    When execlp (Exec) is ran, it clears all the other code from with in the process.
    Then runs new code within the exec.
    */
    execlp("/bin/ls", "ls -al", NULL); // a version of exec()
    printf("Child is done!\n");

    /* This is the listing command (which is nothing but a program) 
       in Unix. The child process will now execute that code. Of 
       course, we need to know how to supply exec() the appropriate 
       arguments for the new program. */
  }

  return 0;
}
