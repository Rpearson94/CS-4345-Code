/*
 * Assignment 2
 * CS 4345 Spring 2020
 * Ryan Pearson
 * James Faber
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class a2_RyanPearson_JamesFaber {
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
    int[][] matrixA = new int[matrixARow][matrixAColumn];
    int[][] matrixB = new int[matrixBRow][matrixBColumn];

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

    // Creating threads to perform math calculations.

  }

  public static Queue<Integer> getFileData(String arg1, Queue<Integer> mxQueue) throws FileNotFoundException {
    final File input = new File(arg1);
    final Scanner fileReader = new Scanner(input);
    while (fileReader.hasNextInt()) {
      final int data = fileReader.nextInt();
      // System.out.println(data);
      mxQueue.add(data);
    }
    fileReader.close();
    return mxQueue;
  }
}