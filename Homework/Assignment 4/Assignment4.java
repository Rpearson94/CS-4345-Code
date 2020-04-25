import java.util.ArrayList;
import java.util.Collections;

/* CS4345
 * Spring 2020
 * Assignment 4
 * Ryan Pearson
 * James Faber
*/

public class Assignment4 {

  static class Common {
    // Create an arraylist of 100 cars.
    static ArrayList<Integer> cars = new ArrayList<>();

    static int tunnel = 0;
  }

  class NewThread extends Thread {

  }

  public static void main(final String[] args) {

    for (int i = 0; i < 101; i++) {
      Common.cars.add(i);
    }

    Collections.shuffle(Common.cars);
  }
}