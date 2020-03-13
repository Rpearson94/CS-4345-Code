import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class pearson_a3 {

  public class Process {
    process(int id, int priority, int burstLength){
      this.id = id;
      this.priority = priority;
      this.burstLength = burstLength;
    }
  }

  public static void main(String[] args) {
    // Create queue to act as ready Queue
    Queue<Process> readyQueue = new PriorityQueue<Process>();
    ArrayList<Integer> randomInts = new ArrayList<Integer>();
    for (int i = 0; i < 11; i++) {
      randomInts.add(i);
    }
    randomInts.shuffle();
    for (int i = 0; i < 6; i++) {
      int priority = ((int) Math.random * 9) + 1;
      int burst = ((int) Math.random * 80) + 20;
      Process p = new Process(randomInts.get(i), priority, burst);
    }

    for (int i = 0; i < readyQueue.size(); i++) {
      System.out.print(readyQueue.remove(i));
    }
  }
}