/* This C-code demonstrates how the parent process can be 
   made to wait until the child process finishes. */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>

int main()
{
    pid_t procid;

    procid = fork();

    if (procid > 0)
    {
        printf("Parent will wait until child finishes.\n");
        wait(NULL); // The wait() system call will force parent to wait
        printf("\n Parent resumes as child completed.\n");
        printf("Patent done!\n\n");
    }
    else if (procid == 0)
    {
        printf("\n Child executing (the ls process)..\n");
        execlp("/bin/ls", "ls -al", NULL);
    }
    else
    {
        fprintf(stderr, "Forking failed.. code terminating");
        return 1;
    }

    return 0;
}
