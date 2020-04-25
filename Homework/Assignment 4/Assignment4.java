import java.util.ArrayList;
import java.util.Collections;

/* CS4345
 * Spring 2020
 * Assignment 4
 * Ryan Pearson
 * James Faber
*/

public class Assignment4 {
  public static void main(String[] args) {
    // Create an arraylist of 100 cars.
    ArrayList<Integer> cars = new ArrayList<Integer>();

    for (int i = 0; i <= 100; i++) {
      cars.add(i);
    }

    // Shuffle Cars in to random order.
    Collections.shuffle(cars);

    // for (int car : cars) {
    // System.out.print(car);
    // }
  }
}