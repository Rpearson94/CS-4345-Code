/* 
  Ryan Pearson
  Assignment 3
  CS 4345 Operating Systems
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class scheduling_person {

  public static class Process {
    private int id;
    private int priority;
    private int burstLength;

    Process(int id, int priority, int burstLength) {
      this.id = id;
      this.priority = priority;
      this.burstLength = burstLength;
    }

    public int getId() {
      return id;
    }

    public int getPriority() {
      return priority;
    }

    public int getBurstLength() {
      return burstLength;
    }

    public void setBurstLength(int burstLength) {
      this.burstLength = burstLength;
    }

    @Override
    public String toString() {
      return "Process: " + id + "| Priority: " + priority + "| Burst Length: " + burstLength;
    }
  }

  public static void main(String[] args) {
    // Create queue to act as ready Queue, Create list to hold random numbers for
    // processes.
    ArrayList<Process> readyQueue = new ArrayList<Process>();
    ArrayList<Integer> randomInts = new ArrayList<Integer>();
    for (int i = 0; i < 11; i++) {
      randomInts.add(i);
    }
    Collections.shuffle(randomInts);
    for (int i = 0; i < 6; i++) {
      int priority = (int) (Math.random() * 9) + 1;
      int burst = (int) (Math.random() * 80) + 20;
      Process p = new Process(randomInts.get(i), priority, burst);
      readyQueue.add(p);
      // System.out.print(p.toString());
    }
    // Sort queue based on Id Value.
    // Collections.sort(readyQueue);
    readyQueue.sort(Comparator.comparing(Process::getId));

    System.out.println("Initial State.");
    for (int i = 0; i < readyQueue.size(); i++) {
      System.out.println(readyQueue.get(i).toString());
    }

    // Create scaner and decare vars for user input
    Scanner input = new Scanner(System.in);
    int priority;
    int id;
    int burst;
    boolean validId = true;

    // Using Do While loops to check user input to ensure user entered values are
    // correct.
    do {
      System.out.print("Enter an ID between 0 - 10 for your process: ");
      id = input.nextInt();
      for (int i = 0; i < readyQueue.size(); i++) {
        if (readyQueue.get(i).getId() == id) {
          validId = false;
        } else
          validId = true;
      }
    } while (!validId);

    do {
      System.out.print("Enter a priority between 1 - 10 for your process: ");
      priority = input.nextInt();
    } while (priority < 0 || priority > 11);

    do {
      System.out.print("Enter a burst length between 20 - 100 for your process: ");
      burst = input.nextInt();
    } while (burst < 19 || burst > 101);

    input.close();
    // System.out.println(id + " " + priority + " " + burst);

    // Adding new Process to the queue.
    Process p = new Process(id, priority, burst);
    readyQueue.add(p);

    readyQueue.sort(Comparator.comparing(Process::getId));

    System.out.println("State after adding user process.");
    for (int i = 0; i < readyQueue.size(); i++) {
      System.out.println(readyQueue.get(i).toString());
    }

    int SJFwait;
    int PWait;
    int RRWait;

    // Method for SJF.
    // SJFwait = shortestJobFirst(readyQueue);

    // Method for Priority
    // PWait = priorty(readyQueue);

    // Method for Round Robin
    RRWait = roundRobin(readyQueue);

    // for (int i = 0; i < readyQueue.size(); i++) {
    // System.out.println(readyQueue.get(i).toString());
    // }
  }

  private static int roundRobin(ArrayList<Process> readyQueue) {
    // Sorting queue based on priority.
    System.out.println("Sorting Round Robin Queue");
    readyQueue.sort(Comparator.comparing(Process::getId));

    ArrayList<Process> tempQueue = new ArrayList<>();
    tempQueue = readyQueue;

    int wait = 0;
    int count = 0;

    while (tempQueue.size() > 0) {
      if (count >= tempQueue.size()) {
        count = 0;
      }
      if (tempQueue.get(count).getBurstLength() >= 20) {
        int tempBurst = tempQueue.get(count).getBurstLength();
        tempBurst = tempBurst - 20;
        wait = wait + 20;
        System.out.println(tempQueue.get(count).toString() + " | Round Robin | Total waiting Time: " + wait);
        tempQueue.get(count).setBurstLength(tempBurst);
        count++;
      } else {
        wait = wait + tempQueue.get(count).getBurstLength();
        System.out.println(tempQueue.get(count).toString() + " | Round Robin | Total waiting Time: " + wait);
        tempQueue.remove(count);
        count++;
      }

    }
    return wait;
  }

  private static int priorty(ArrayList<Process> readyQueue) {
    // Sorting queue based on priority.

    System.out.println("Sorting Prioriy Queue");
    readyQueue.sort(Comparator.comparing(Process::getPriority));

    int wait = 0;

    for (int i = 0; i < readyQueue.size(); i++) {
      wait += readyQueue.get(i).getBurstLength();
      System.out.println(readyQueue.get(i).toString() + " | Priority | Total waiting Time: " + wait);
    }
    return wait;
  }

  private static int shortestJobFirst(ArrayList<Process> readyQueue) {
    // Sorting queue based on priority.

    System.out.println("Sorting SJF Queue");
    readyQueue.sort(Comparator.comparing(Process::getBurstLength));

    int wait = 0;

    for (int i = 0; i < readyQueue.size(); i++) {
      wait += readyQueue.get(i).getBurstLength();
      System.out.println(readyQueue.get(i).toString() + " | SJF | Total waiting Time: " + wait + "\n");
    }
    return wait;
  }
}