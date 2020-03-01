/*
 * Assignment 2
 * CS 4345 Spring 2020
 * Ryan Pearson
 * James Faber
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class a2_RyanPearson_JamesFaber {

  // Global arrays used to store data and perform calculations.
  public static int[][] matrixA;
  public static int[][] matrixB;
  public static int[][] matrixC;

  public static void main(final String[] args) throws Exception {

    // Temporary queue used to store data read from file.
    Queue<Integer> matrixQueue = new LinkedList<Integer>();

    // Funciton to safely check for valid file and store data in queue.
    matrixQueue = getFileData(args[0], matrixQueue);

    // Storing the demensions of the 2 arrays in varables for later use.
    int matrixARow = matrixQueue.remove();
    int matrixAColumn = matrixQueue.remove();
    int matrixBRow = matrixQueue.remove();
    int matrixBColumn = matrixQueue.remove();

    // Gerating the two matrices that will store the values.
    matrixA = new int[matrixARow][matrixAColumn];
    matrixB = new int[matrixBRow][matrixBColumn];
    matrixC = new int[matrixARow][matrixBRow];

    // Checking to see if matrices columns are correct size, if so store in matrix
    // if not throw and exception and end the program.
    if (matrixAColumn == matrixBColumn) {
      for (int i = 0; i < matrixA.length; i++) {
        for (int j = 0; j < matrixA[i].length; j++) {
          matrixA[i][j] = matrixQueue.remove();
        }
      }
      for (int i = 0; i < matrixB.length; i++) {
        for (int j = 0; j < matrixB[i].length; j++) {
          matrixB[i][j] = matrixQueue.remove();
        }
      }
    } else {
      System.out
          .println("Matrices do not have the same number of columns. Cannot perform calculations. \nExiting program.");
      System.exit(1);
    }

    // Create threads to perform math calculations.
    for (int a = 0; a < matrixC.length; a++) {
      for (int b = 0; b < matrixC[a].length; b++) {
        ThreadMath tm = new ThreadMath(a, b);
        Thread t = new Thread(tm);
        t.start();
        Thread.yield();
      }
    }
    // Printing the final matrix and end of program line.
    for (int[] row : matrixC) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println("End of program.");
  }

  // Method used to ensure valid file and loop through the file into a queue
  public static Queue<Integer> getFileData(String arg1, Queue<Integer> mxQueue) throws FileNotFoundException {

    final File input = new File(arg1);
    final Scanner fileReader = new Scanner(input);
    while (fileReader.hasNextInt()) {
      final int data = fileReader.nextInt();
      mxQueue.add(data);
    }
    fileReader.close();
    return mxQueue;
  }
}

// Thread class that allows multiple threads and math logic.
class ThreadMath implements Runnable {
  int a, b;

  int[][] matA, matB, matC;

  public ThreadMath(int a, int b) {
    this.a = a;
    this.b = b;
  }

  // Run method that performs calculations and adds value to the new matrix.
  public void run() {
    int value = 0;

    System.out.printf("Thread <%d,%d> starts calculation.\n", a + 1, b + 1);

    for (int i = 0; i <= a2_RyanPearson_JamesFaber.matrixA[a].length; i++) {
      value = value + (a2_RyanPearson_JamesFaber.matrixA[a][i] * a2_RyanPearson_JamesFaber.matrixB[b][i]);
      a2_RyanPearson_JamesFaber.matrixC[a][b] = value;
    }

    System.out.printf("Thread <%d,%d> returns <%d>.\n", a + 1, b + 1, value);
  }
}