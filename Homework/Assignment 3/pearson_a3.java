import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class pearson_a3 {

  public static class Process {
    private int id;
    private int priority;
    private int burstLength;

    Process(int id, int priority, int burstLength) {
      this.id = id;
      this.priority = priority;
      this.burstLength = burstLength;
    }

    @Override
    public String toString() {
      return "Process: " + id + "| Priority: " + priority + "| Burst Length: " + burstLength + "\n";
    }
  }

  public static void main(String[] args) {
    // Create queue to act as ready Queue
    Queue<Process> readyQueue = new PriorityQueue<Process>();
    ArrayList<Integer> randomInts = new ArrayList<Integer>();
    for (int i = 0; i < 11; i++) {
      randomInts.add(i);
    }
    Collections.shuffle(randomInts);
    for (int i = 0; i < 6; i++) {
      int priority = (int) (Math.random() * 9) + 1;
      int burst = (int) (Math.random() * 80) + 20;
      Process p = new Process(randomInts.get(i), priority, burst);
      System.out.print(p.toString());
    }

    for (int i = 0; i < readyQueue.size(); i++) {

    }
  }
}