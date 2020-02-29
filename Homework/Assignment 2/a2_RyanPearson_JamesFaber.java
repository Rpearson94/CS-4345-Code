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
    Queue<Integer> matrixQueue = new LinkedList<Integer>();
    boolean validSize;

    matrixQueue = getFileData(args[0], matrixQueue);

    int matrixARow = matrixQueue.remove();
    int matrixAColumn = matrixQueue.remove();
    int matrixBRow = matrixQueue.remove();
    int matrixBColumn = matrixQueue.remove();

    int[][] matrixA = new int[matrixARow][matrixAColumn];
    int[][] matrixB = new int[matrixBRow][matrixBColumn];

    validSize = checkValidColumn(matrixAColumn, matrixBColumn);

    if (validSize) {
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
      throw new Exception("Martices columns are not equal, please adjust the colum size to be equal.");
    }

    // Testing print statements (Remove before submission.)

    // System.out.printf("%d,%d,%d,%d", matrixARow, matrixAColumn, matrixBRow,
    // matrixBColumn);
    // for (int i = matrixQueue.size() - 1; i >= 0; i--) {
    // System.out.println(matrixQueue.remove());
    // }
    System.out.println("Test Print.\n Matrix A");
    for (int i = 0; i < matrixA.length; i++) {
      for (int j = 0; j < matrixA[i].length; j++) {
        System.out.println(matrixA[i][j]);
      }
    }
    System.out.println("Matrix B");
    for (int i = 0; i < matrixB.length; i++) {
      for (int j = 0; j < matrixB[i].length; j++) {
        System.out.println(matrixB[i][j]);

      }
    }
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

  private static boolean checkValidColumn(int matrixAColumn, int matrixBColumn) {
    boolean status = false;
    if (matrixAColumn == matrixBColumn)
      status = true;
    return status;
  }
}