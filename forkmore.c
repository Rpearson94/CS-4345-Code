#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main()
{
  printf("pid of parent: %d\n", getpid());
  int p;
  p = fork();
  if (p > 0)
  {
    printf("Parent process: p = %d\n", p);
  }
  else
  {
    printf("Child process: p = %d\n", p);
    execlp("/bin/ls", "ls -al", NULL);
    printf("Child done!\n");
  }

  return 0;
}
