import java.util.concurrent.Semaphore;

/* CS4345
 * Spring 2020
 * Assignment 4
 * Ryan Pearson
 * James Faber
*/

public class Assignment4 {
  public static void main(String[] args) throws InterruptedException {
    int car = 1;
    Semaphore gate = new Semaphore(1);

    while (true) {
      Threads t = new Threads(gate, car);
      Thread t1 = new Thread(t);
      t1.start();
      car++;
      try {
        t1.join(2500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class Common {
    static int tunnel = 0;
  }

  static class Threads extends Thread {
    Semaphore gate;
    int car;

    public Threads(Semaphore gate, int car) {
      this.gate = gate;
      this.car = car;
    }

    @Override
    public void run() {
      if (car % 2 == 0) {
        System.out.println("Left-bound Car " + car + " Wants to enter the tunnel.");
        try {
          gate.acquire();
          System.out.println("Left-bound Car " + car + " is in the tunnel.");
          Common.tunnel++;
          Thread.sleep(3000);
          Common.tunnel--;
          System.out.println("Left-bound Car " + car + " is exiting tunnel.");
        } catch (InterruptedException exc) {
          System.out.println(exc);
        }
        gate.release();
      }

      else {
        System.out.println("Right-bound Car " + car + " Wants to enter the tunnel.");
        try {
          gate.acquire();
          System.out.println("Right-bound Car " + car + " is in the tunnel.");
          Common.tunnel++;
          Thread.sleep(3500);
          Common.tunnel--;
          System.out.println("Right-bound Car " + car + " is exiting tunnel.");
        } catch (InterruptedException exc) {
          System.out.println(exc);
        }
        gate.release();
      }
    }
  }
}