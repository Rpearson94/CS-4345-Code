/* 
  Ryan Pearson
  Assignment 3
  CS 4345 Operating Systems
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Scanner;

public class scheduling_person {

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
    }
    // Sort queue based on Id Value.
    // Collections.sort(readyQueue);
    readyQueue.sort(Comparator.comparing(Process::getId));

    System.out.println("Initial State.\n");
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
      System.out.print("\nEnter an ID between 0 - 10 for your process: ");
      id = input.nextInt();
      for (int i = 0; i < readyQueue.size(); i++) {
        if (readyQueue.get(i).getId() == id) {
          validId = false;
        } else
          validId = true;
      }
    } while (!validId);

    do {
      System.out.print("\nEnter a priority between 1 - 10 for your process: ");
      priority = input.nextInt();
      if (readyQueue.contains(priority)) {
        priority = -1;
      }
    } while (priority < 0 || priority > 11);

    do {
      System.out.print("\nEnter a burst length between 20 - 100 for your process: ");
      burst = input.nextInt();
    } while (burst < 19 || burst > 101);

    input.close();

    // Adding new Process to the queue.
    Process p = new Process(id, priority, burst);
    readyQueue.add(p);

    readyQueue.sort(Comparator.comparing(Process::getId));

    System.out.println("\nState after adding user process.\n");
    for (int i = 0; i < readyQueue.size(); i++) {
      System.out.println(readyQueue.get(i).toString());
    }

    int sjfWait = 0;
    int pWait = 0;
    int rrWait = 0;

    // Method for SJF.
    sjfWait = shortestJobFirst(readyQueue);

    // Method for Priority
    pWait = priorty(readyQueue);

    // Method for Round Robin
    rrWait = roundRobin(readyQueue);

    int sjfAvg = sjfWait / 7;
    int pAvg = pWait / 7;
    int rrAvg = rrWait / 7;

    System.out.println("\nShortest Job First Average Wait Time: " + sjfAvg + "\n");
    System.out.println("Priority Average Wait Time: " + pAvg + "\n");
    System.out.println("Round Robin Average Wait Time: " + rrAvg + "\n");

    Hashtable<Integer, String> order = new Hashtable<>();
    order.put(sjfAvg, "Shortest Job First");
    order.put(pAvg, "Priority");
    order.put(rrAvg, "Round Robin");

    ArrayList<Integer> averages = new ArrayList<>();
    averages.add(sjfAvg);
    averages.add(pAvg);
    averages.add(rrAvg);

    Collections.sort(averages);

    System.out.print("Optimal Order is: ");

    for (int i = 0; i < averages.size(); i++) {
      System.out.print(order.get(averages.get(i)) + ", ");
    }
  }

  private static int roundRobin(ArrayList<Process> readyQueue) {
    // Sorting queue based on priority.
    System.out.println("\nSorting Round Robin Queue\n");
    readyQueue.sort(Comparator.comparing(Process::getId));

    ArrayList<Process> tempQueue;
    tempQueue = readyQueue;

    int rwait = 0;
    int count = 1;

    System.out.println(readyQueue.get(0).toString() + " | Round Robin | Total waiting Time: " + rwait + "\n");

    while (tempQueue.size() > 0) {
      if (count >= tempQueue.size()) {
        count = 0;
      }
      if (tempQueue.get(count).getBurstLength() >= 20) {
        int tempBurst = tempQueue.get(count).getBurstLength();
        tempBurst = tempBurst - 20;
        rwait = rwait + 20;
        System.out.println(tempQueue.get(count).toString() + " | Round Robin | Total waiting Time: " + rwait + "\n");
        tempQueue.get(count).setBurstLength(tempBurst);
        count++;
      } else {
        rwait = rwait + tempQueue.get(count).getBurstLength();
        System.out.println(tempQueue.get(count).toString() + " | Round Robin | Total waiting Time: " + rwait + "\n");
        tempQueue.remove(count);
        count++;
      }
    }
    return rwait;
  }

  private static int priorty(ArrayList<Process> readyQueue) {
    // Sorting queue based on priority.

    System.out.println("\nSorting Prioriy Queue\n");
    readyQueue.sort(Comparator.comparing(Process::getPriority));

    int pwait = 0;

    System.out.println(readyQueue.get(0).toString() + " | Priority | Total waiting Time: " + pwait + "\n");
    for (int i = 1; i < readyQueue.size(); i++) {
      pwait += readyQueue.get(i).getBurstLength();
      System.out.println(readyQueue.get(i).toString() + " | Priority | Total waiting Time: " + pwait + "\n");
    }
    return pwait;
  }

  private static int shortestJobFirst(ArrayList<Process> readyQueue) {
    // Sorting queue based on priority.

    System.out.println("\nSorting SJF Queue\n");
    readyQueue.sort(Comparator.comparing(Process::getBurstLength));

    int swait = 0;

    System.out.println(readyQueue.get(0).toString() + " | SJF | Total waiting Time: " + swait + "\n");

    for (int i = 1; i < readyQueue.size(); i++) {
      swait += readyQueue.get(i).getBurstLength();
      System.out.println(readyQueue.get(i).toString() + " | SJF | Total waiting Time: " + swait + "\n");
    }
    return swait;
  }

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
      return "Process ID: " + id + "| Priority: " + priority + "| Burst Length: " + burstLength;
    }
  }

}