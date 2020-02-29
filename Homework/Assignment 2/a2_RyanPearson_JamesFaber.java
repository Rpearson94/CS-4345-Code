/*
  Assignment 2
  CS 4345 Spring 2020
  Ryan Pearson
  James Faber
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class a2_RyanPearson_JamesFaber {
  public static void main(final String[] args) throws Exception {
    Queue<Integer> matrixQueue = new LinkedList<Integer>();
    matrixQueue = getFileData(args[0], matrixQueue);
    // for (int i = matrixQueue.size() - 1; i >= 0; i--) {
    // System.out.println(matrixQueue.remove());
    // }
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