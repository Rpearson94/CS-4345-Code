/* 
  Ryan Pearson
  Assignment 3
  CS 4345 Operating Systems
*/

import java.util.ArrayList;
import java.util.Collections;

public class scheduling_person {

  public static class Process implements Comparable<Process> {
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

    @Override
    public String toString() {
      return "Process: " + id + "| Priority: " + priority + "| Burst Length: " + burstLength + "\n";
    }

    @Override
    public int compareTo(Process o) {
      int compareId = ((Process) o).getId();
      return this.id - compareId;
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
    Collections.sort(readyQueue);

    // for (int i = 0; i < readyQueue.size(); i++) {
    // System.out.println(readyQueue.get(i).toString());
    // }
  }
}