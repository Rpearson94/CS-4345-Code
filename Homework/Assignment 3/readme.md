# Assignment 3

Operating Systems
Spring 2020

This is the markdown file created to explain assignment 3.

## Files

There are 2 files,

1. scheduling_pearson.java - Main java program.
2. readme.md - This document explaining design choices.

## Main

### Declrations

All functions start from the main method. I created the ready queue to hold the processes as they are created. I also created and array list of random numbers and then shuffled them to get the random Process ID.

### Processes

I created the first 6 processes by grabbing a random number from the randomInts list. Once the first 6 processes are created
I then sorted the processes via ID and print them using the overridden toString() method.

### User Input

User input is accepted via scanner. I first check to see if the entered ID is a valid id if not I prompt the user for a new ID. Once I have a valid ID I then get input from the user for the priority and burst, also ensuring they fall within the acceptable range. Once I have a valid input create a new process based on the inputs and then sort the queue based on ID with the new process. Finally I declare return parables to accept the waiting times.

### shortestJobFirst

The first method call takes the ready queue, sorts it based on burst length in ascending order. I then print the first process as it has no waiting time then loop through the rest of the processes to complete total waiting time. Returning the final waiting time.

### priority

The priority method takes the ready queue sorts it by priority ascending and then prints the first process as it does not have to wait then it adds the resulting waiting times to the total and returns the total.

### roundRobin

The round robin method takes the ready queue sorts it by ID and then prints the first process. Then it loops through each process giving each process 20 time units and removing that from the burst length. If the process needs less time then the reamaining time is added to the waiting time and the process is removed from the queue. This process completes until there are no processes in the queue.

### Main Continued

Once I have the returned waiting time I calculate the average by dividing the total time by the number of processes. I then print the total time taken by each process. I then add the processes to a hash map with the key being the average time taken. I also add the averages to an array list. I sort the list based on average time taken in ascending order. Then use a loop to fetch the value from the hash map to print the optimal run for that process.

### Class Process

This class contains the constructor, getters and setters of the process object.
